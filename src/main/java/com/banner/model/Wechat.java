package com.banner.model;

import com.fasterxml.jackson.databind.deser.Deserializers;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by admin on 2016/4/9.
 */
@Table(name = "ly_we_info")
public class Wechat extends BaseEntity{
    @Column(name="appId")
    private String appId;
    @Column(name="Secret")
    private String Secret;
    private String url;
    private String startime;
    private String state;
    private String num;


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return Secret;
    }

    public void setSecret(String secret) {
        Secret = secret;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStartime() {
        return startime;
    }

    public void setStartime(String startime) {
        this.startime = startime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
