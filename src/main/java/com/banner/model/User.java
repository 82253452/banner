package  com.banner.model;

import java.io.Serializable;
import java.util.Date;
import com.banner.model.BaseEntity;

import javax.persistence.Table;

@Table(name = "ly_user")
public class User extends BaseEntity implements Serializable {

    /**
      *null
    */
    private String  username;
    /**
      *null
    */
    private String  accountname;
    /**
      *null
    */
    private String  password;
    /**
      *null
    */
    private String  credentialssalt;
    /**
      *null
    */
    private String  description;
    /**
      *null
    */
    private String  locked;
    /**
      *null
    */
    private Date  createtime;
    /**
      *逻辑删除状态0:存在1:删除
    */
    private Integer  deletestatus;






    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getCredentialssalt() {
        return credentialssalt;
    }

    public void setCredentialssalt(String credentialssalt) {
        this.credentialssalt = credentialssalt;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }


    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }


    public Integer getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(Integer deletestatus) {
        this.deletestatus = deletestatus;
    }


}