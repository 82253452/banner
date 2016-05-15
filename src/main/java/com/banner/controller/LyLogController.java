package com.banner.controller;

import com.banner.mapper.LyLogMapper;
import com.banner.model.LyLog;
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
@RequestMapping("/lyLog")
public class LyLogController {
@Resource
private LyLogMapper lyLogMapper;

@RequestMapping("/list")
@ResponseBody
private List show(){
PageHelper.startPage(1, 10);
List<LyLog> list=lyLogMapper.selectAll();
    return list;
    }
    @RequestMapping("/add")
    @ResponseBody
    private int add(LyLog wechat){
    return lyLogMapper.insert(wechat);
    }
    @RequestMapping("/del")
    @ResponseBody
    private int del(String id){
    return lyLogMapper.deleteByPrimaryKey(id);
    }
    @RequestMapping("/update")
    @ResponseBody
    private int update(LyLog wechat){
    return lyLogMapper.updateByPrimaryKey(wechat);
    }
    @RequestMapping("/getById")
    @ResponseBody
    private LyLog getById(String id){
    return lyLogMapper.selectByPrimaryKey(id);
    }

    }
