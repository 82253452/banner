package com.banner.controller;

import com.banner.mapper.LyGoodsMapper;
import com.banner.model.LyGoods;
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
@RequestMapping("/lyGoods")
public class LyGoodsController {
@Resource
private LyGoodsMapper lyGoodsMapper;

@RequestMapping("/list")
@ResponseBody
private List show(){
PageHelper.startPage(1, 10);
List<LyGoods> list=lyGoodsMapper.selectAll();
    return list;
    }
    @RequestMapping("/add")
    @ResponseBody
    private int add(LyGoods wechat){
    return lyGoodsMapper.insert(wechat);
    }
    @RequestMapping("/del")
    @ResponseBody
    private int del(String id){
    return lyGoodsMapper.deleteByPrimaryKey(id);
    }
    @RequestMapping("/update")
    @ResponseBody
    private int update(LyGoods wechat){
    return lyGoodsMapper.updateByPrimaryKey(wechat);
    }
    @RequestMapping("/getById")
    @ResponseBody
    private LyGoods getById(String id){
    return lyGoodsMapper.selectByPrimaryKey(id);
    }

    }
