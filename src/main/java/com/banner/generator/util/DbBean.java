package com.banner.generator.util;

/**
 * Created by Administrator on 2016/4/15 0015.
 */
public class DbBean {
    //���ݿ�����
    String tableName;
    //�ֶ�����
    String columnName;
    //����
    String dataType;
    //����
    String columnComment;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }
}
