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
@Table(name = "ly_pro_goods")
public class LyProGoods implements Serializable{

@Transient
private Integer page = 1;

@Transient
private Integer rows = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="goodsName")
    private String goodsName;

    @Column(name="goodsNum")
    private Integer goodsNum;

    @Column(name="goodsDes")
    private String goodsDes;

    @Column(name="createTime")
    private Date createTime;



    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public String getGoodsName(){
        return goodsName;
    }

    public void setGoodsName(String goodsName){
        this.goodsName=goodsName;
    }

    public Integer getGoodsNum(){
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum){
        this.goodsNum=goodsNum;
    }

    public String getGoodsDes(){
        return goodsDes;
    }

    public void setGoodsDes(String goodsDes){
        this.goodsDes=goodsDes;
    }

    public Date getCreateTime(){
        return createTime;
    }

    public void setCreateTime(Date createTime){
        this.createTime=createTime;
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
