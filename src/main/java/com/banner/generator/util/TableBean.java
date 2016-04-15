package com.banner.generator.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class TableBean {
	private String tableName; //表名
	private String entityName; //实体名
	private String entityName2; //实体名（首字母小写）用于属性名表示时
	private String entityDesc; //实体功能描述
	private String author;//创建人
	private String createDate; //创建时间
	private String keySqlStyle; //创建时间  #{id}
	private String tableKeyStyle; //创建时间 ${entityName2.id}
	private String fnStyle; //"fn:length(${entityName2}Query.list)>0"
	private List<ColumnBean>   columnList; //字段列表
	private  String modelName;
	
	public TableBean(String tableName, String entityName, String entityDesc, String author, String modelName){
		this.modelName = modelName;
		this.tableName = tableName;
		this.entityName = entityName;
		this.entityDesc = entityDesc;
		this.author = author;
		this.entityName2 = new StringBuilder().append(Character.toLowerCase(entityName.charAt(0))).append(entityName.substring(1)).toString();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.createDate = format.format(new Date());
		this.keySqlStyle = "#{id}";
		this.tableKeyStyle =  "${"+this.entityName2+".id}";
		this.fnStyle = "${fn:length("+this.entityName2+"Query.list)>0}";
	}

	public String getModelName() {
		return modelName;
	}

	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getEntityDesc() {
		return entityDesc;
	}
	public void setEntityDesc(String entityDesc) {
		this.entityDesc = entityDesc;
	}
	public List<ColumnBean> getColumnList() {
		return columnList;
	}
	public void setColumnList(List<ColumnBean> columnList) {
		this.columnList = columnList;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getEntityName2() {
		return entityName2;
	}
	public void setEntityName2(String entityName2) {
		this.entityName2 = entityName2;
	}
	public String getKeySqlStyle() {
		return keySqlStyle;
	}
	public void setKeySqlStyle(String keySqlStyle) {
		this.keySqlStyle = keySqlStyle;
	}
	public String getTableKeyStyle() {
		return tableKeyStyle;
	}
	public void setTableKeyStyle(String tableKeyStyle) {
		this.tableKeyStyle = tableKeyStyle;
	}
	public String getFnStyle() {
		return fnStyle;
	}
	public void setFnStyle(String fnStyle) {
		this.fnStyle = fnStyle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	
	
}
