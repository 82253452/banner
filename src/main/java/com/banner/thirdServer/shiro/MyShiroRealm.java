/*
package com.banner.thirdServer.security;

import com.banner.mapper.ResourcesMapper;
import com.banner.mapper.UserMapper;
import com.banner.model.User;
import com.banner.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

*/
/**
 * Created by Administrator on 2016/3/19 0019.
 *//*

@Service("myShiroRealm")
public class MyShiroRealm  extends AuthorizingRealm {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        String userName=token.getUsername();
        User user = new User();
        List<User> userList=userMapper.select(user);
        if(userList.size()>0){

        }else{
            throw new UnknownAccountException();// 没找到帐号
        }
        return null;
    }
}
*/
