package com.banner.util;

import com.banner.thirdServer.wechat.lang.HttpUtils;
import com.banner.thirdServer.wechat.utils.source;
import com.banner.thirdServer.wechat.wechat4j.common.*;
import net.sf.json.JSONObject;
import org.apache.http.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/4/8.
 */
public class NetSpider {
    public static String BaseURL = "http://www.36634.com";
    public static String OWURL = "http://www.36634.com/jkcs/";

    public static String getHtmlContent() {
        return HttpClientUtil.sendGetRequest("http://www.36634.com/jkcs/", "GBK");
    }

    public static List<source> parseHTMLHrefs(String html, Integer total,String appId) throws ParseException, IOException {
        List<source> list = new ArrayList<source>();
        //System.out.println(html);
        Document doc = Jsoup.parse(html);
        Element body = doc.body();
        Elements lis = body.getElementsByClass("excerpt");
        for (Element link : lis) {
            String linkHref = link.getElementsByTag("img").attr("src");
            if (!linkHref.substring(0, 4).toLowerCase().equals("http")) {
                linkHref = BaseURL + linkHref;
            }
            String h2 = link.getElementsByTag("h2").get(0).getElementsByTag("a").html();
            String conLink = link.getElementsByTag("h2").get(0).getElementsByTag("a").get(0).attr("href");
            String author = link.getElementsByClass("muted").get(0).text();
            String content = getContent(conLink,appId);
            source sour = new source();
            sour.setImgUrl(linkHref);
            sour.setTitle(h2);
            sour.setAuthor(author);
            sour.setContent(content);
            sour.setContent_source_url(BaseURL + conLink);
            if (content != null && !content.equals("") && linkHref != null && !"".equals(linkHref)) {
                list.add(sour);
            } else {
            }
            total--;
            if (total == 0) {
                break;
            }
        }

        return list;
    }

    public static String getContent(String link,String appId) throws ParseException, IOException {
        if (link != null) {
            String contentHtml= HttpClientUtil.sendGetRequest(BaseURL + link, "gbk");
            return paseContentHTML(contentHtml,"",appId);
        }
        return null;
    }

    public static String paseContentHTML(String html, String URL,String appId) throws ParseException, IOException {
        Document doc = Jsoup.parse(html);
        Element body = doc.body();
        Elements lis = body.getElementsByClass("article-content");
        Elements lisImg = lis.get(0).getElementsByTag("img");
        Element element = lis.get(0);
        for (int i = 0; i < lisImg.size(); i++) {
            Element elementImg = lisImg.get(i);
            if (!elementImg.attr("src").toString().substring(0, 4).toLowerCase().equals("http")) {
                elementImg.attr("src", BaseURL + elementImg.attr("src"));
            }
            MediaContentFile mediaContentFile = new MediaContentFile(appId);

            return element.html().replaceAll("&raquo;", "");
        }
        return null;
    }
    public static void main(String args[]){
       /* try {
            List<source> list=  parseHTMLHrefs(getHtmlContent(),4);
            System.out.print("2133");
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
