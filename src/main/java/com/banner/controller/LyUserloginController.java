package com.banner.controller;

import com.banner.mapper.LyUserloginMapper;
import com.banner.model.LyUserlogin;
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
@RequestMapping("/lyUserlogin")
public class LyUserloginController {
@Resource
private LyUserloginMapper lyUserloginMapper;

@RequestMapping("/list")
@ResponseBody
private List show(){
PageHelper.startPage(1, 10);
List<LyUserlogin> list=lyUserloginMapper.selectAll();
    return list;
    }
    @RequestMapping("/add")
    @ResponseBody
    private int add(LyUserlogin wechat){
    return lyUserloginMapper.insert(wechat);
    }
    @RequestMapping("/del")
    @ResponseBody
    private int del(String id){
    return lyUserloginMapper.deleteByPrimaryKey(id);
    }
    @RequestMapping("/update")
    @ResponseBody
    private int update(LyUserlogin wechat){
    return lyUserloginMapper.updateByPrimaryKey(wechat);
    }
    @RequestMapping("/getById")
    @ResponseBody
    private LyUserlogin getById(String id){
    return lyUserloginMapper.selectByPrimaryKey(id);
    }

    }
