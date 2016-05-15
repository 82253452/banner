package com.banner.controller;

import com.banner.mapper.LyUserRoleMapper;
import com.banner.model.LyUserRole;
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
@RequestMapping("/lyUserRole")
public class LyUserRoleController {
@Resource
private LyUserRoleMapper lyUserRoleMapper;

@RequestMapping("/list")
@ResponseBody
private List show(){
PageHelper.startPage(1, 10);
List<LyUserRole> list=lyUserRoleMapper.selectAll();
    return list;
    }
    @RequestMapping("/add")
    @ResponseBody
    private int add(LyUserRole wechat){
    return lyUserRoleMapper.insert(wechat);
    }
    @RequestMapping("/del")
    @ResponseBody
    private int del(String id){
    return lyUserRoleMapper.deleteByPrimaryKey(id);
    }
    @RequestMapping("/update")
    @ResponseBody
    private int update(LyUserRole wechat){
    return lyUserRoleMapper.updateByPrimaryKey(wechat);
    }
    @RequestMapping("/getById")
    @ResponseBody
    private LyUserRole getById(String id){
    return lyUserRoleMapper.selectByPrimaryKey(id);
    }

    }
