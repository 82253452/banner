package  com.banner.model;

import java.io.Serializable;
import java.util.Date;
import com.banner.model.BaseEntity;

import javax.persistence.Table;

@Table(name = "ly_user_role")
public class UserRole extends BaseEntity implements Serializable {

    /**
      *null
    */
    private Integer  userid;
    /**
      *null
    */
    private Integer  roleid;






    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }


    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }


}