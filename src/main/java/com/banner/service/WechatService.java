package com.banner.service;

import com.banner.mapper.WechatMapper;
import com.banner.model.Wechat;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2016/4/19.
 */
@Service
public class WechatService {
    @Resource
    private WechatMapper wechatMapper;
    public List<Wechat> getAll(Wechat wechat) {
        if (wechat.getPage() != null && wechat.getRows() != null) {
            PageHelper.startPage(wechat.getPage(), wechat.getRows(), "id");
        }
        return wechatMapper.selectAll();
    }
}
