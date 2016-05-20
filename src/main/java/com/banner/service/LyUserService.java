package com.banner.service;

import com.banner.mapper.LyUserMapper;
import com.banner.model.LyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Created by yp on 2016-05-15
*/
@Service
public class LyUserService {
@Autowired
private LyUserMapper lyUserMapper;

    }
