package com.banner.service.wechat;

import com.banner.mapper.LyWeInfoMapper;
import com.banner.model.LyWeInfo;
import com.banner.thirdServer.wechat.wechat4j.common.MediaTextPic;
import com.banner.thirdServer.wechat.wechat4j.message.MassMsg;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;


/**
 * Created by admin on 2016/4/13.
 */

public class WechatTaskFactory implements Job {
    public final Logger logger = Logger.getLogger(WechatTaskFactory.class);
    @Resource
    private LyWeInfoMapper lyWeInfoMapper;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String appId = context.getJobDetail().getKey().getName();
        String secret = context.getJobDetail().getKey().getGroup();
        //获取当前微信信息
        LyWeInfo wechat = new LyWeInfo();
        wechat.setAppId(appId);
        LyWeInfo wechatEntity = lyWeInfoMapper.selectOne(wechat);
        String url = wechatEntity.getUrl();
        Integer num = wechatEntity.getNum();
        logger.info("wechatTask start");
        if (!"".equals(secret) && !"".equals(appId)) {
            logger.info("appId:" + appId);
            try {
                List list = NetSpider.parseHTMLHrefs(wechatEntity);
                MediaTextPic mediaTextPic = new MediaTextPic(appId, secret);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("articles", JSONArray.fromObject(list).toString());
                String mediaId = mediaTextPic.upload(jsonObject.toString());
                if (mediaId != null) {
                    logger.info("上传图文素材成功 mediaId:" + mediaId);
                    MassMsg massMsg=new MassMsg(mediaId,appId);
                    String result=massMsg.send();
                    logger.info("群发："+result);
                } else {
                    logger.info("上传图文素材失败");
                }
            } catch (IOException e) {
                e.printStackTrace();
             }
            logger.info("url :" + url + "article num :" + num.toString());
        }
    }
}

