package com.banner.controller;

import com.banner.mapper.LyResUserMapper;
import com.banner.model.LyResUser;
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
@RequestMapping("/lyResUser")
public class LyResUserController {
@Resource
private LyResUserMapper lyResUserMapper;

@RequestMapping("/list")
@ResponseBody
private List show(){
PageHelper.startPage(1, 10);
List<LyResUser> list=lyResUserMapper.selectAll();
    return list;
    }
    @RequestMapping("/add")
    @ResponseBody
    private int add(LyResUser wechat){
    return lyResUserMapper.insert(wechat);
    }
    @RequestMapping("/del")
    @ResponseBody
    private int del(String id){
    return lyResUserMapper.deleteByPrimaryKey(id);
    }
    @RequestMapping("/update")
    @ResponseBody
    private int update(LyResUser wechat){
    return lyResUserMapper.updateByPrimaryKey(wechat);
    }
    @RequestMapping("/getById")
    @ResponseBody
    private LyResUser getById(String id){
    return lyResUserMapper.selectByPrimaryKey(id);
    }

    }
