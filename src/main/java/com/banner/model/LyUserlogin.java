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
@Table(name = "ly_userlogin")
public class LyUserlogin implements Serializable{

@Transient
private Integer page = 1;

@Transient
private Integer rows = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="userId")
    private Integer userId;

    @Column(name="accountName")
    private String accountName;

    @Column(name="loginTime")
    private Date loginTime;

    @Column(name="loginIP")
    private String loginIP;



    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public Integer getUserId(){
        return userId;
    }

    public void setUserId(Integer userId){
        this.userId=userId;
    }

    public String getAccountName(){
        return accountName;
    }

    public void setAccountName(String accountName){
        this.accountName=accountName;
    }

    public Date getLoginTime(){
        return loginTime;
    }

    public void setLoginTime(Date loginTime){
        this.loginTime=loginTime;
    }

    public String getLoginIP(){
        return loginIP;
    }

    public void setLoginIP(String loginIP){
        this.loginIP=loginIP;
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
