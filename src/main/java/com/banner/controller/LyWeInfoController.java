package com.banner.controller;

import com.banner.mapper.LyWeInfoMapper;
import com.banner.model.LyWeInfo;
import com.banner.service.wechat.WechatJobService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* Created by yp on2016-04-21
*/
@Controller
@RequestMapping("/lyWeInfo")
public class LyWeInfoController {
@Resource
private LyWeInfoMapper lyWeInfoMapper;
    @Resource
    private WechatJobService wechatJobService;

    @RequestMapping("/list")
    @ResponseBody
    private List list(){
        List<LyWeInfo> list=lyWeInfoMapper.selectAll();
        return list;
    }
    @RequestMapping("/pageList")
    @ResponseBody
    private PageInfo pageList(@RequestBody Map map){
        Integer pageNum=1;
        Integer pageSize=10;
        if(map.get("pageNum")!=null){
            pageNum=Integer.valueOf(map.get("pageNum").toString());
        }
        if(map.get("pageSize")!=null){
            pageSize=Integer.valueOf(map.get("pageSize").toString());
        }
        PageHelper.startPage(pageNum, pageSize);
        Page list= (Page) lyWeInfoMapper.selectAll();
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }
    @RequestMapping("/add")
    @ResponseBody
    private int add(@RequestBody LyWeInfo wechat){
        if(StringUtils.isBlank(wechat.getId().toString())){
            lyWeInfoMapper.insert(wechat);
        }else{
            lyWeInfoMapper.updateByPrimaryKey(wechat);
        }
        wechatJobService.addOrUpdateJob(wechat);
        return 1;
    }
    @RequestMapping("/del")
    @ResponseBody
    private int del(@RequestBody LyWeInfo wechat){
        lyWeInfoMapper.delete(wechat);
        wechatJobService.delete(wechat);
        return 1;
    }
    @RequestMapping("/update")
    @ResponseBody
    private int update(LyWeInfo wechat){
        lyWeInfoMapper.updateByPrimaryKey(wechat);
        wechatJobService.addOrUpdateJob(wechat);
        return 1;
    }
    @RequestMapping("/getById")
    @ResponseBody
    private LyWeInfo getById(String id){
    return lyWeInfoMapper.selectByPrimaryKey(id);
    }


}

