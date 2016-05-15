package com.banner.controller;

import com.alibaba.fastjson.JSONObject;
import com.banner.mapper.LyResourcesMapper;
import com.banner.model.LyResources;
import com.banner.model.LyUser;
import com.banner.util.TreeObject;
import com.banner.util.TreeUtil;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/2/24 0024.
 */
@RestController
public class login{
    @Resource
    private LyResourcesMapper lyResourcesMapper;
    @RequestMapping("/login")
    public String userLogin(LyUser user, HttpServletRequest request){
        JSONObject render=new JSONObject();
        render.put("state","0");
        try {
            if (!request.getMethod().equals("POST")) {
                render.put("msg","支持POST方法提交！");
            }
            if (user.getAccountName()==null|| user.getPassword()==null) {
                render.put("msg","用户名或密码不能为空！");
            }
            Subject userSub = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getAccountName(), user.getPassword());
            try {
                userSub.login(token);
                render.put("state","1");
            } catch (LockedAccountException lae) {
                token.clear();
                render.put("msg","用户已经被锁定不能登录，请与管理员联系！");
            } catch (ExcessiveAttemptsException e) {
                render.put("msg","账号：" + user.getAccountName() + " 登录失败次数过多,锁定10分钟!");
            } catch (AuthenticationException e) {
                token.clear();
                render.put("msg","用户名密码不正确！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            render.put("msg","登录异常，请联系管理员！");
        }
        return render.toString();
    }
    /**
     * @return
     * @throws Exception
     */
    @RequestMapping("getMenu")
    public String getMenu()
            throws Exception {
        List<LyResources> rs = lyResourcesMapper.selectAll();
        List<TreeObject> treeObjects = new ArrayList<TreeObject>();
        for (LyResources res : rs) {// 转换为树对象
            TreeObject t = new TreeObject();
            PropertyUtils.copyProperties(t, res);
            treeObjects.add(t);
        }
        TreeUtil treeUtil = new TreeUtil();
        List<TreeObject> ns = treeUtil.getChildTreeObjects(treeObjects, 0);
        return "";
    }
    public String index(Model mode){

        return "index";
    }
    @RequestMapping("/test")
    public String test(Model mode){
        return "index";
    }
    @RequestMapping("/logout")
    public String userLogout(){
        return "login";
    }

}
