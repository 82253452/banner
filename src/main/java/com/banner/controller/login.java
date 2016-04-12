package com.banner.controller;

import com.banner.model.Person;
import com.banner.thirdServer.quartz.Test;
import org.apache.ibatis.io.ResolverUtil;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2016/2/24 0024.
 */
@Controller
public class login {
    @RequestMapping("/login")
    public String userLogin(Model model,String username,String password){
        return "login";
    }
    //@PreAuthorize("hasAnyRole('admin')")
    public String index(Model mode){

        return "index";
    }
    @RequestMapping("/secTest")
    public String test(Model mode){
        return "index";
    }
    @RequestMapping("/logout")
    public String userLogout(){
        return "login";
    }

}
