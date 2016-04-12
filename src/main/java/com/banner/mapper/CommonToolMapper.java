package com.banner.mapper;

import com.banner.model.Resources;
import com.banner.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface CommonToolMapper extends MyMapper<Resources>{
    public List<Map<String,String>> getColumns(String tableName);
}