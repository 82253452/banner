package com.banner.generator.util;

public class ColumnBean {
	private String tableName; //数据库表名称
	private String dbName; //数据库字段名称
	private String javaName; //java属性名称
	private String javaName2; //java属性名称2 ： 首字母大写   用于 set/get方法拼接
	private String dbType; //数据库字段类型
	private String javaType; //java属性类型
	private String desc ; //字段描述
	private String sqlStyle ; //字段描述     示例： #{javaName}
	private String tableColStyle ; //字段描述     示例： ${table.javaName}
	private String jdbcType; //JDBCTYPE类型

	public ColumnBean(String tableName,String dbName,String dbType,String desc) {
		this.tableName=tableName;
		this.dbName = dbName;
		this.desc = desc;
		this.dbType = dbType;
		this.javaName=CommonUtil.getJavaName(dbName);
		this.javaName2=CommonUtil.getJavaName2(dbName);
		this.javaType=DataTypeMap.dataTypeMap.get(dbType);
		this.jdbcType=DataTypeMap.jdbcTypeMap.get(this.javaType);
		this.sqlStyle="#{"+dbName+"}";
		this.tableColStyle="${" +dbName + "." + this.javaName + "}";

	}

	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getJavaName() {
		return javaName;
	}
	public void setJavaName(String javaName) {
		this.javaName = javaName;
	}
	public String getJavaName2() {
		return javaName2;
	}
	public void setJavaName2(String javaName2) {
		this.javaName2 = javaName2;
	}
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	public String getJavaType() {
		return javaType;
	}
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getSqlStyle() {
		return sqlStyle;
	}
	public void setSqlStyle(String sqlStyle) {
		this.sqlStyle = sqlStyle;
	}
	public String getTableColStyle() {
		return tableColStyle;
	}
	public void setTableColStyle(String tableColStyle) {
		this.tableColStyle = tableColStyle;
	}
	public String getJdbcType() {
		return jdbcType;
	}
	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
