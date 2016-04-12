package  com.banner.model;

import java.io.Serializable;
import java.util.Date;
import com.banner.model.BaseEntity;

import javax.persistence.Table;

@Table(name = "ly_res_role")
public class ResRole extends BaseEntity implements Serializable {

    /**
      *null
    */
    private Integer  roleid;
    /**
      *null
    */
    private Integer  resid;






    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }


    public Integer getResid() {
        return resid;
    }

    public void setResid(Integer resid) {
        this.resid = resid;
    }


}