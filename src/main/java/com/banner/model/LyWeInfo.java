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
@Table(name = "ly_we_info")
public class LyWeInfo implements Serializable{

@Transient
private Integer page = 1;

@Transient
private Integer rows = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="url")
    private String url;

    @Column(name="appId")
    private String appId;

    @Column(name="Secret")
    private String Secret;

    @Column(name="BaseURL")
    private String BaseURL;

    @Column(name="createTime")
    private Date createTime;

    @Column(name="timer")
    private String timer;

    @Column(name="startime")
    private String startime;

    @Column(name="num")
    private Integer num;

    @Column(name="state")
    private String state;

    @Column(name="insteadImg")
    private String insteadImg;

    @Column(name="orgConn")
    private String orgConn;



    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url=url;
    }

    public String getAppId(){
        return appId;
    }

    public void setAppId(String appId){
        this.appId=appId;
    }

    public String getSecret(){
        return Secret;
    }

    public void setSecret(String Secret){
        this.Secret=Secret;
    }

    public String getBaseURL(){
        return BaseURL;
    }

    public void setBaseURL(String BaseURL){
        this.BaseURL=BaseURL;
    }

    public Date getCreateTime(){
        return createTime;
    }

    public void setCreateTime(Date createTime){
        this.createTime=createTime;
    }

    public String getTimer(){
        return timer;
    }

    public void setTimer(String timer){
        this.timer=timer;
    }

    public String getStartime(){
        return startime;
    }

    public void setStartime(String startime){
        this.startime=startime;
    }

    public Integer getNum(){
        return num;
    }

    public void setNum(Integer num){
        this.num=num;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state=state;
    }

    public String getInsteadImg(){
        return insteadImg;
    }

    public void setInsteadImg(String insteadImg){
        this.insteadImg=insteadImg;
    }

    public String getOrgConn(){
        return orgConn;
    }

    public void setOrgConn(String orgConn){
        this.orgConn=orgConn;
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
