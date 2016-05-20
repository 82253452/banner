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
@Table(name = "ly_log")
public class LyLog implements Serializable{

@Transient
private Integer page = 1;

@Transient
private Integer rows = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="accountName")
    private String accountName;

    @Column(name="module")
    private String module;

    @Column(name="methods")
    private String methods;

    @Column(name="actionTime")
    private String actionTime;

    @Column(name="userIP")
    private String userIP;

    @Column(name="operTime")
    private Date operTime;

    @Column(name="description")
    private String description;



    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public String getAccountName(){
        return accountName;
    }

    public void setAccountName(String accountName){
        this.accountName=accountName;
    }

    public String getModule(){
        return module;
    }

    public void setModule(String module){
        this.module=module;
    }

    public String getMethods(){
        return methods;
    }

    public void setMethods(String methods){
        this.methods=methods;
    }

    public String getActionTime(){
        return actionTime;
    }

    public void setActionTime(String actionTime){
        this.actionTime=actionTime;
    }

    public String getUserIP(){
        return userIP;
    }

    public void setUserIP(String userIP){
        this.userIP=userIP;
    }

    public Date getOperTime(){
        return operTime;
    }

    public void setOperTime(Date operTime){
        this.operTime=operTime;
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
