package com.banner.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
* 基础信息
*
* @author yp
* @since ${createDate}
*/
@Table(name = "${tableName}")
public class ${entityName} implements Serializable{

@Transient
private Integer page = 1;

@Transient
private Integer rows = 10;

<#list columnList as item>
    <#if item.javaName = "id">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    </#if>
    @Column(name="${item.dbName}")
    private ${item.javaType} ${item.javaName};

</#list>


<#list columnList as item>
    public ${item.javaType} get${item.javaName2}(){
        return ${item.javaName};
    }

    public void set${item.javaName2}(${item.javaType} ${item.javaName}){
        this.${item.javaName}=${item.javaName};
    }

</#list>


    public Integer getPage() {
    return page;
    }

    public void setPage(Integer page) {
    this.page = page;
    }

    public Integer getRows() {
    return rows;
    }

    public void setRows(Integer rows) {
    this.rows = rows;
    }
}
