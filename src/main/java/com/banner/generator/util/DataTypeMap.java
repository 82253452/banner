package com.banner.generator.util;

import java.util.HashMap;
import java.util.Map;

public class DataTypeMap {
	public static final  Map<String,String> dataTypeMap = new HashMap<String,String>();  
	static{
		dataTypeMap.put("varchar","String");
		dataTypeMap.put("bigint","Long");
		dataTypeMap.put("longtext","String");
		dataTypeMap.put("datetime","Date");
		dataTypeMap.put("int","Integer");
		dataTypeMap.put("decimal","Double");
		dataTypeMap.put("longblob","String");
		dataTypeMap.put("tinyint","Integer");
		dataTypeMap.put("double","Double");
		dataTypeMap.put("timestamp","Date");
		dataTypeMap.put("tinyblob","String");
		dataTypeMap.put("blob","String");
		dataTypeMap.put("float","Float");
		dataTypeMap.put("smallint","Integer");
		dataTypeMap.put("date","Date");
		dataTypeMap.put("char","String");
		dataTypeMap.put("set","Set");
		dataTypeMap.put("enum","String");
		dataTypeMap.put("mediumtext","String");
		dataTypeMap.put("text","String");
		dataTypeMap.put("time","String");
		
		//ORACLE
		dataTypeMap.put("VARCHAR2","String");
		dataTypeMap.put("NVARCHAR2","String");
		dataTypeMap.put("NUMBER","Double");
		dataTypeMap.put("DATE","Date");
		
	}
	
	public static final  Map<String,String> jdbcTypeMap = new HashMap<String,String>();  
	static{
		jdbcTypeMap.put("String","VARCHAR");
		jdbcTypeMap.put("Long","BIGINT");
		jdbcTypeMap.put("Date","DATE");
		jdbcTypeMap.put("Timestamp","TIMESTAMP");
		jdbcTypeMap.put("Integer","INTEGER");
		jdbcTypeMap.put("Double","NUMERIC");
		jdbcTypeMap.put("Float","NUMERIC");
		
	}
	 
}
