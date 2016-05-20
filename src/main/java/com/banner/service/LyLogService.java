package com.banner.service;

import com.banner.mapper.LyLogMapper;
import com.banner.model.LyLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Created by yp on 2016-05-15
*/
@Service
public class LyLogService {
@Autowired
private LyLogMapper lyLogMapper;

    }
