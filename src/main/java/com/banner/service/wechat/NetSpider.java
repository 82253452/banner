package com.banner.service.wechat;

import com.banner.model.LyWeInfo;
import com.banner.thirdServer.wechat.utils.source;
import com.banner.thirdServer.wechat.wechat4j.common.*;
import com.banner.util.HttpClientUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by admin on 2016/4/8.
 */
public class NetSpider {
    public static String BaseURL = Config.instance().getBaseWebUrl();
    public static String OWURL = "http://www.36634.com/jkcs/";

    public static String getHtmlContent() {
        return HttpClientUtil.sendGetRequest("http://www.36634.com/jkcs/", "GBK");
    }

    //获取文章列表
    public static List<GraMaterialEntity> parseHTMLHrefs(LyWeInfo lyWeInfo) throws ParseException, IOException {
        String html = HttpClientUtil.sendGetRequest(lyWeInfo.getUrl(), "GBK");
        List<GraMaterialEntity> list = new ArrayList<GraMaterialEntity>();
        Document doc = Jsoup.parse(html);
        Element body = doc.body();
        Elements lis = body.getElementsByClass("excerpt");

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ParseArticleListTask parseArticleListTask = new ParseArticleListTask(lis, lyWeInfo.getNum(), lyWeInfo.getAppId(), lyWeInfo.getSecret());
        list = (List<GraMaterialEntity>) forkJoinPool.invoke(parseArticleListTask);

        GetHrefContentTask getHrefContentTask = new GetHrefContentTask(list, lyWeInfo.getAppId(),lyWeInfo.getSecret());
        List<GraMaterialEntity> result = (List<GraMaterialEntity>) forkJoinPool.invoke(getHrefContentTask);//多线程解析文章内容
        return result;
    }

    //解析文章内容
    public static String paseContentHTML(String html, String URL, String appId, String secret) throws ParseException, IOException {
        Document doc = Jsoup.parse(html);
        Element body = doc.body();
        Elements lis = body.getElementsByClass("article-content");
        Elements lisImg = lis.get(0).getElementsByTag("img");
        Element element = lis.get(0);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        UploadMediaTask uploadMediaTask = new UploadMediaTask(lisImg, appId, secret);//多线程上传图片
        lisImg = forkJoinPool.invoke(uploadMediaTask);
        return element.html().replaceAll("&raquo;", "");
    }

    public static String parseImgUrl(String url) {
        if (url.substring(0, 4).equals("http")) {
            return url;
        } else if (url.substring(0, 1).equals("/")) {
            return BaseURL + url;
        }
        return url;
    }

    public static void main(String args[]) {
       /* try {
            List<GraMaterialEntity> list= parseHTMLHrefs("http://www.36634.com/jkcs/",2);
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("articles", JSONArray.fromObject(list));
            MediaTextPic mediaTextPic=new MediaTextPic();
            String result=mediaTextPic.upload(jsonObject.toString());
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
