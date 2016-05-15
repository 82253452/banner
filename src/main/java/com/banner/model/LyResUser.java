package com.banner.model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
* 基础信息
*
* @author yp
* @since 2016-05-15
*/
@Table(name = "ly_res_user")
public class LyResUser implements Serializable{

@Transient
private Integer page = 1;

@Transient
private Integer rows = 10;

    @Column(name="resId")
    private Integer resId;

    @Column(name="userId")
    private Integer userId;



    public Integer getResId(){
        return resId;
    }

    public void setResId(Integer resId){
        this.resId=resId;
    }

    public Integer getUserId(){
        return userId;
    }

    public void setUserId(Integer userId){
        this.userId=userId;
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
