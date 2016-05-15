package com.banner.controller;

import com.banner.mapper.LyResourcesMapper;
import com.banner.model.LyResources;
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
@RequestMapping("/lyResources")
public class LyResourcesController {
@Resource
private LyResourcesMapper lyResourcesMapper;

@RequestMapping("/list")
@ResponseBody
private List show(){
PageHelper.startPage(1, 10);
List<LyResources> list=lyResourcesMapper.selectAll();
    return list;
    }
    @RequestMapping("/add")
    @ResponseBody
    private int add(LyResources wechat){
    return lyResourcesMapper.insert(wechat);
    }
    @RequestMapping("/del")
    @ResponseBody
    private int del(String id){
    return lyResourcesMapper.deleteByPrimaryKey(id);
    }
    @RequestMapping("/update")
    @ResponseBody
    private int update(LyResources wechat){
    return lyResourcesMapper.updateByPrimaryKey(wechat);
    }
    @RequestMapping("/getById")
    @ResponseBody
    private LyResources getById(String id){
    return lyResourcesMapper.selectByPrimaryKey(id);
    }

    }
