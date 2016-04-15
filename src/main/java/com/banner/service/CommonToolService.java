package com.banner.service;

import com.banner.generator.util.ColumnBean;
import com.banner.generator.util.CommonUtil;
import com.banner.generator.util.DbBean;
import com.banner.generator.util.TableBean;
import com.banner.mapper.CommonToolMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("commonToolService")
public class CommonToolService{
	@Resource
	private CommonToolMapper commonToolMapper;
	
	public List<Map<String,String>> getColumns(String tableName){
		return commonToolMapper.getColumns(tableName);
	}
	public List<TableBean> getAllTables(String dbName){
		Map<String,List<ColumnBean>> result=new HashMap<>();
		List<DbBean> dbBeans=commonToolMapper.getAllTables(dbName);
		List<TableBean> render=new ArrayList<>();
		for(DbBean dbBean:dbBeans){
			ColumnBean columnBean=new ColumnBean(dbBean.getTableName(),dbBean.getColumnName(),dbBean.getDataType(),dbBean.getColumnComment());
			if(result.containsKey(columnBean.getTableName())){
				result.get(columnBean.getTableName()).add(columnBean);
			}else{
				List<ColumnBean> tableList=new ArrayList<>();
				tableList.add(columnBean);
				result.put(columnBean.getTableName(),tableList);
			}
		}
		for(Map.Entry entry:result.entrySet()){
			TableBean tableBean=new TableBean(entry.getKey().toString(),CommonUtil.getJavaName2(entry.getKey().toString()),"generator","yp","");
			tableBean.setColumnList((List<ColumnBean>) entry.getValue());
			render.add(tableBean);
		}
		return render;
	}


}
