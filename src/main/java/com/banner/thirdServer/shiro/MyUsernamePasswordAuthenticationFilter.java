/*
package com.banner.thirdServer.security;

import com.banner.model.User;
import com.banner.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

*/
/**
 * Created by Administrator on 2016/2/26 0026.
 *//*

public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    public static final String VALIDATE_CODE = "validateCode";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    @Autowired
    UserService userService;
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        //检测验证码
        //checkValidateCode(request);

        String username = obtainUsername(request);
        String password = obtainPassword(request);
        //验证用户账号与密码是否对应
        username = username.trim();
        User user=userService.getUserInfo(username);
        if(user == null || !user.getPassword().equals(password)) {
            throw new AuthenticationServiceException("用户名或者密码错误！");
        }
        //UsernamePasswordAuthenticationToken实现 Authentication
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username,password);
        // 允许子类设置详细属性
        setDetails(request, authRequest);
        // 运行UserDetailsService的loadUserByUsername 再次封装Authentication
        return this.getAuthenticationManager().authenticate(authRequest);
    }
    protected void checkValidateCode(HttpServletRequest request) {
        HttpSession session = request.getSession();

        String sessionValidateCode = obtainSessionValidateCode(session);
        //让上一次的验证码失效
        session.setAttribute(VALIDATE_CODE, null);
        String validateCodeParameter = obtainValidateCodeParameter(request);
        if (StringUtils.isEmpty(validateCodeParameter) || !sessionValidateCode.equalsIgnoreCase(validateCodeParameter)) {
            throw new AuthenticationServiceException("验证码错误！");
        }
    }
    private String obtainValidateCodeParameter(HttpServletRequest request) {
        Object obj = request.getParameter(VALIDATE_CODE);
        return null == obj ? "" : obj.toString();
    }
    protected String obtainSessionValidateCode(HttpSession session) {
        Object obj = session.getAttribute(VALIDATE_CODE);
        return null == obj ? "" : obj.toString();
    }
}
*/
