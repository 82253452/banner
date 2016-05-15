package com.banner.controller;

import com.banner.mapper.LyUserMapper;
import com.banner.model.LyUser;
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
@RequestMapping("/lyUser")
public class LyUserController {
@Resource
private LyUserMapper lyUserMapper;

@RequestMapping("/list")
@ResponseBody
private List show(){
PageHelper.startPage(1, 10);
List<LyUser> list=lyUserMapper.selectAll();
    return list;
    }
    @RequestMapping("/add")
    @ResponseBody
    private int add(LyUser wechat){
    return lyUserMapper.insert(wechat);
    }
    @RequestMapping("/del")
    @ResponseBody
    private int del(String id){
    return lyUserMapper.deleteByPrimaryKey(id);
    }
    @RequestMapping("/update")
    @ResponseBody
    private int update(LyUser wechat){
    return lyUserMapper.updateByPrimaryKey(wechat);
    }
    @RequestMapping("/getById")
    @ResponseBody
    private LyUser getById(String id){
    return lyUserMapper.selectByPrimaryKey(id);
    }

    }
