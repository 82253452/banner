package com.banner.controller;

import com.banner.mapper.LyGoodsTypeMapper;
import com.banner.model.LyGoodsType;
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
@RequestMapping("/lyGoodsType")
public class LyGoodsTypeController {
@Resource
private LyGoodsTypeMapper lyGoodsTypeMapper;

@RequestMapping("/list")
@ResponseBody
private List show(){
PageHelper.startPage(1, 10);
List<LyGoodsType> list=lyGoodsTypeMapper.selectAll();
    return list;
    }
    @RequestMapping("/add")
    @ResponseBody
    private int add(LyGoodsType wechat){
    return lyGoodsTypeMapper.insert(wechat);
    }
    @RequestMapping("/del")
    @ResponseBody
    private int del(String id){
    return lyGoodsTypeMapper.deleteByPrimaryKey(id);
    }
    @RequestMapping("/update")
    @ResponseBody
    private int update(LyGoodsType wechat){
    return lyGoodsTypeMapper.updateByPrimaryKey(wechat);
    }
    @RequestMapping("/getById")
    @ResponseBody
    private LyGoodsType getById(String id){
    return lyGoodsTypeMapper.selectByPrimaryKey(id);
    }

    }
