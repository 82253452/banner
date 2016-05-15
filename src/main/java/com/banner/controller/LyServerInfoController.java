package com.banner.controller;

import com.banner.mapper.LyServerInfoMapper;
import com.banner.model.LyServerInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by yp on2016-05-15
*/
@Controller
@RequestMapping("/lyServerInfo")
public class LyServerInfoController {
@Resource
private LyServerInfoMapper lyServerInfoMapper;

@RequestMapping("/list")
@ResponseBody
private List show(){
PageHelper.startPage(1, 10);
List<LyServerInfo> list=lyServerInfoMapper.selectAll();
    return list;
    }
    @RequestMapping("/add")
    @ResponseBody
    private int add(LyServerInfo wechat){
    return lyServerInfoMapper.insert(wechat);
    }
    @RequestMapping("/del")
    @ResponseBody
    private int del(String id){
    return lyServerInfoMapper.deleteByPrimaryKey(id);
    }
    @RequestMapping("/update")
    @ResponseBody
    private int update(LyServerInfo wechat){
    return lyServerInfoMapper.updateByPrimaryKey(wechat);
    }
    @RequestMapping("/getById")
    @ResponseBody
    private LyServerInfo getById(String id){
    return lyServerInfoMapper.selectByPrimaryKey(id);
    }

    }
