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
@Table(name = "ly_user")
public class LyUser implements Serializable{

@Transient
private Integer page = 1;

@Transient
private Integer rows = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="userName")
    private String userName;

    @Column(name="accountName")
    private String accountName;

    @Column(name="password")
    private String password;

    @Column(name="credentialsSalt")
    private String credentialsSalt;

    @Column(name="description")
    private String description;

    @Column(name="locked")
    private String locked;

    @Column(name="createTime")
    private Date createTime;

    @Column(name="deletestatus")
    private Integer deletestatus;



    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName=userName;
    }

    public String getAccountName(){
        return accountName;
    }

    public void setAccountName(String accountName){
        this.accountName=accountName;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getCredentialsSalt(){
        return credentialsSalt;
    }

    public void setCredentialsSalt(String credentialsSalt){
        this.credentialsSalt=credentialsSalt;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getLocked(){
        return locked;
    }

    public void setLocked(String locked){
        this.locked=locked;
    }

    public Date getCreateTime(){
        return createTime;
    }

    public void setCreateTime(Date createTime){
        this.createTime=createTime;
    }

    public Integer getDeletestatus(){
        return deletestatus;
    }

    public void setDeletestatus(Integer deletestatus){
        this.deletestatus=deletestatus;
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
