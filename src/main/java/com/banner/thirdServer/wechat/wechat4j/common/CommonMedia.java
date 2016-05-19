package com.banner.thirdServer.wechat.wechat4j.common;

import com.banner.thirdServer.wechat.lang.HttpUtils;
import com.banner.thirdServer.wechat.wechat4j.token.RedisToken;
import com.banner.thirdServer.wechat.wechat4j.token.TokenProxy;
import com.banner.thirdServer.wechat.wechat4j.token.Tokens;
import com.banner.util.RedisUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import java.io.*;

/**
 * Created by admin on 2016/4/9.
 */
public abstract class CommonMedia {
    public final Logger logger = Logger.getLogger(CommonMedia.class);
    public    String UPLOAD = "";//临时素材
    public   String DOWNLOAD = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=";
    public   String PARAM_FILE = "media";
    public   String PARAM_MEDIA_ID = "media_id";
    public   String PARAM_TYPE = "type";
    public   String PARAM_CREATE_TIME = "created_at";
    public   String PARAM_URL = "url";

    public MediaType type;
    public File file;
    public String mediaId;  //3天失效
    public String createdTimestamp;//文件创建时间戳，上传之后返回
    public String url;//文件路径，上传永久素材之后返回
    public String appId;
    public String secret;
    abstract  String upload(File file,MediaType type);
    /**
     * 文件上传url
     * @return
     */
    protected String uploadUrl(){
        String url = UPLOAD + getToken() + "&"
                + PARAM_TYPE + "=" + this.type.name();
        return url;
    }
    /**
     * 文件下载url
     * @return
     */
    protected String downloadUrl(){
        String url = DOWNLOAD + getToken() + "&"
                + PARAM_MEDIA_ID + "=" + this.mediaId;
        return url;
    }
    public static File getUrlFile(String fileUrl,String fileName){
        File file= new File(fileName);
        try {
            FileOutputStream out = new FileOutputStream(file);
            byte[] outByte=HttpUtils.getFile(fileUrl);
            if(outByte!=null){
                out.write(outByte);
            }else{
                return null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
    protected void parseUploadResult(String result){
        JSONObject jsonObject = JSONObject.fromObject(result);
        if(jsonObject.containsKey(PARAM_MEDIA_ID)){
            this.mediaId = jsonObject.getString(PARAM_MEDIA_ID);
            this.createdTimestamp = jsonObject.get(PARAM_CREATE_TIME)==null?"":jsonObject.get(PARAM_CREATE_TIME).toString();
            this.url = jsonObject.get(PARAM_URL)==null?"":jsonObject.get(PARAM_URL).toString();
        }
        else{
            this.mediaId = null;
        }
    }
    public String getToken(){
         String tocken=new RedisToken(appId,secret).getToken(appId);
        return tocken;
    }
    /**
     * 文件下载
     * @return  byte[]
     */
    protected byte[] download(String mediaId){
        this.mediaId = mediaId;
        String url = downloadUrl();
        byte[] fb = HttpUtils.getFile(url);
        if(fb == null || fb.length == 0)
            return null;
        return fb;
    }
    protected  byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        //创建一个Buffer字符串
        byte[] buffer = new byte[1024];
        //每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        //使用一个输入流从buffer里把数据读取出来
        while( (len=inStream.read(buffer)) != -1 ){
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        //关闭输入流
        inStream.close();
        //把outStream里的数据写入内存
        return outStream.toByteArray();
    }
    public MediaType getType() {
        return type;
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getCreatedTimestamp() {
        return createdTimestamp;
    }

    public String getUrl() {
        return url;
    }
}
