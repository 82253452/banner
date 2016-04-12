package com.banner.controller;

import com.banner.mapper.UserMapper;
import com.banner.mapper.WechatMapper;
import com.banner.model.Wechat;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/2/19 0019.
 */
@Controller
@RequestMapping("/wechat")
public class WechatController {
    @Autowired
    private WechatMapper wechatMapper;
    @RequestMapping("/list")
    @ResponseBody
    public List show(){
        PageHelper.startPage(1, 10);
        return wechatMapper.selectAll();
    }
}
