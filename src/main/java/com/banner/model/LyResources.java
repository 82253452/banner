package com.banner.model;

import javax.persistence.*;
import java.io.Serializable;

/**
* 基础信息
*
* @author yp
* @since 2016-05-15
*/
@Table(name = "ly_resources")
public class LyResources implements Serializable{

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

    @Column(name="parentId")
    private Integer parentId;

    @Column(name="resKey")
    private String resKey;

    @Column(name="type")
    private String type;

    @Column(name="resUrl")
    private String resUrl;

    @Column(name="level")
    private Integer level;

    @Column(name="icon")
    private String icon;

    @Column(name="ishide")
    private Integer ishide;

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

    public Integer getParentId(){
        return parentId;
    }

    public void setParentId(Integer parentId){
        this.parentId=parentId;
    }

    public String getResKey(){
        return resKey;
    }

    public void setResKey(String resKey){
        this.resKey=resKey;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type=type;
    }

    public String getResUrl(){
        return resUrl;
    }

    public void setResUrl(String resUrl){
        this.resUrl=resUrl;
    }

    public Integer getLevel(){
        return level;
    }

    public void setLevel(Integer level){
        this.level=level;
    }

    public String getIcon(){
        return icon;
    }

    public void setIcon(String icon){
        this.icon=icon;
    }

    public Integer getIshide(){
        return ishide;
    }

    public void setIshide(Integer ishide){
        this.ishide=ishide;
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
