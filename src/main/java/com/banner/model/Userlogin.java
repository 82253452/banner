package  com.banner.model;

import java.io.Serializable;
import java.util.Date;
import com.banner.model.BaseEntity;

public class Userlogin extends BaseEntity implements Serializable {

    /**
      *null
    */
    private Integer  userid;
    /**
      *null
    */
    private String  accountname;
    /**
      *null
    */
    private Date  logintime;
    /**
      *null
    */
    private String  loginip;






    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }


    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }


    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }


    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }


}