package com.banner.model;

import javax.persistence.*;
import java.io.Serializable;

/**
* 基础信息
*
* @author yp
* @since 2016-05-15
*/
@Table(name = "ly_goods")
public class LyGoods implements Serializable{

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

    @Column(name="goodsPrice")
    private Double goodsPrice;



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

    public Double getGoodsPrice(){
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice){
        this.goodsPrice=goodsPrice;
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
