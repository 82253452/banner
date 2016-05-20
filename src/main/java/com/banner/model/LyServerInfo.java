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
@Table(name = "ly_server_info")
public class LyServerInfo implements Serializable{

@Transient
private Integer page = 1;

@Transient
private Integer rows = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="cpuUsage")
    private String cpuUsage;

    @Column(name="setCpuUsage")
    private String setCpuUsage;

    @Column(name="jvmUsage")
    private String jvmUsage;

    @Column(name="setJvmUsage")
    private String setJvmUsage;

    @Column(name="ramUsage")
    private String ramUsage;

    @Column(name="setRamUsage")
    private String setRamUsage;

    @Column(name="email")
    private String email;

    @Column(name="operTime")
    private Date operTime;

    @Column(name="mark")
    private String mark;



    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public String getCpuUsage(){
        return cpuUsage;
    }

    public void setCpuUsage(String cpuUsage){
        this.cpuUsage=cpuUsage;
    }

    public String getSetCpuUsage(){
        return setCpuUsage;
    }

    public void setSetCpuUsage(String setCpuUsage){
        this.setCpuUsage=setCpuUsage;
    }

    public String getJvmUsage(){
        return jvmUsage;
    }

    public void setJvmUsage(String jvmUsage){
        this.jvmUsage=jvmUsage;
    }

    public String getSetJvmUsage(){
        return setJvmUsage;
    }

    public void setSetJvmUsage(String setJvmUsage){
        this.setJvmUsage=setJvmUsage;
    }

    public String getRamUsage(){
        return ramUsage;
    }

    public void setRamUsage(String ramUsage){
        this.ramUsage=ramUsage;
    }

    public String getSetRamUsage(){
        return setRamUsage;
    }

    public void setSetRamUsage(String setRamUsage){
        this.setRamUsage=setRamUsage;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public Date getOperTime(){
        return operTime;
    }

    public void setOperTime(Date operTime){
        this.operTime=operTime;
    }

    public String getMark(){
        return mark;
    }

    public void setMark(String mark){
        this.mark=mark;
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
