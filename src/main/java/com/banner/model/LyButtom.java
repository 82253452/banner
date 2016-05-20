package com.banner.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
* 基础信息
*
* @author yp
* @since 2016-05-15
*/
@Table(name = "ly_buttom")
public class LyButtom implements Serializable{

@Transient
private Integer page = 1;

@Transient
private Integer rows = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="buttom")
    private String buttom;

    @Column(name="description")
    private String description;



    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getButtom(){
        return buttom;
    }

    public void setButtom(String buttom){
        this.buttom=buttom;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }



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
