package com.banner.mapper;

import com.banner.generator.util.DbBean;
import com.banner.model.Resources;
import com.banner.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface CommonToolMapper{
    public List<Map<String,String>> getColumns(String tableName);
    public List<DbBean> getAllTables(String dbName);
}