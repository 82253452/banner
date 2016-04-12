package  com.banner.model;

import java.io.Serializable;
import java.util.Date;
import com.banner.model.BaseEntity;

import javax.persistence.Table;

@Table(name = "ly_role")
public class Role extends BaseEntity implements Serializable {

    /**
      *null
    */
    private String  state;
    /**
      *null
    */
    private String  name;
    /**
      *null
    */
    private String  rolekey;
    /**
      *null
    */
    private String  description;






    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getRolekey() {
        return rolekey;
    }

    public void setRolekey(String rolekey) {
        this.rolekey = rolekey;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}