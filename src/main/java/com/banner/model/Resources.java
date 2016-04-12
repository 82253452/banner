package  com.banner.model;

import java.io.Serializable;
import java.util.Date;
import com.banner.model.BaseEntity;

import javax.persistence.Table;


public class Resources extends BaseEntity implements Serializable {

    /**
      *null
    */
    private String  name;
    /**
      *null
    */
    private Integer  parentid;
    /**
      *null
    */
    private String  reskey;
    /**
      *null
    */
    private String  type;
    /**
      *null
    */
    private String  resurl;
    /**
      *null
    */
    private Integer  level;
    /**
      *null
    */
    private String  icon;
    /**
      *null
    */
    private Integer  ishide;
    /**
      *null
    */
    private String  description;






    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }


    public String getReskey() {
        return reskey;
    }

    public void setReskey(String reskey) {
        this.reskey = reskey;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getResurl() {
        return resurl;
    }

    public void setResurl(String resurl) {
        this.resurl = resurl;
    }


    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }


    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


    public Integer getIshide() {
        return ishide;
    }

    public void setIshide(Integer ishide) {
        this.ishide = ishide;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}