package com.banner.controller;

import com.banner.mapper.LyProGoodsMapper;
import com.banner.model.LyProGoods;
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
@RequestMapping("/lyProGoods")
public class LyProGoodsController {
@Resource
private LyProGoodsMapper lyProGoodsMapper;

@RequestMapping("/list")
@ResponseBody
private List show(){
PageHelper.startPage(1, 10);
List<LyProGoods> list=lyProGoodsMapper.selectAll();
    return list;
    }
    @RequestMapping("/add")
    @ResponseBody
    private int add(LyProGoods wechat){
    return lyProGoodsMapper.insert(wechat);
    }
    @RequestMapping("/del")
    @ResponseBody
    private int del(String id){
    return lyProGoodsMapper.deleteByPrimaryKey(id);
    }
    @RequestMapping("/update")
    @ResponseBody
    private int update(LyProGoods wechat){
    return lyProGoodsMapper.updateByPrimaryKey(wechat);
    }
    @RequestMapping("/getById")
    @ResponseBody
    private LyProGoods getById(String id){
    return lyProGoodsMapper.selectByPrimaryKey(id);
    }

    }
