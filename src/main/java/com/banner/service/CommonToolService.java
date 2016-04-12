package com.banner.service;

import com.banner.mapper.CommonToolMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("commonToolService")
public class CommonToolService{
	@Resource
	private CommonToolMapper commonToolMapper;
	
	public List<Map<String,String>> getColumns(String tableName){
		return commonToolMapper.getColumns(tableName);
	}

	
}
