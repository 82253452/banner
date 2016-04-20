package com.banner.controller;

import com.banner.mapper.${entityName}Mapper;
import com.banner.model.${entityName};
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by yp on${createDate}
*/
@Controller
@RequestMapping("/${entityName2}")
public class ${entityName}Controller {
@Resource
private ${entityName}Mapper ${entityName2}Mapper;

@RequestMapping("/list")
@ResponseBody
private List show(){
PageHelper.startPage(1, 10);
List<${entityName}> list=${entityName2}Mapper.selectAll();
    return list;
    }
    @RequestMapping("/add")
    @ResponseBody
    private int add(${entityName} wechat){
    return ${entityName2}Mapper.insert(wechat);
    }
    @RequestMapping("/del")
    @ResponseBody
    private int del(String id){
    return ${entityName2}Mapper.deleteByPrimaryKey(id);
    }
    @RequestMapping("/update")
    @ResponseBody
    private int update(${entityName} wechat){
    return ${entityName2}Mapper.updateByPrimaryKey(wechat);
    }
    @RequestMapping("/getById")
    @ResponseBody
    private ${entityName} getById(String id){
    return ${entityName2}Mapper.selectByPrimaryKey(id);
    }

    }
