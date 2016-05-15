package com.banner.thirdServer.shiro;

import com.banner.mapper.LyUserMapper;
import com.banner.model.LyUser;
import com.banner.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Administrator on 2016/3/19 0019.
 */

@Service("myShiroRealm")
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private LyUserMapper lyUserMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        String userName=token.getUsername();
        LyUser user = new LyUser();
        user.setAccountName(userName);
        List<LyUser> userList=lyUserMapper.select(user);
        if(userList.size()>0){
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName, // 用户名
                    userList.get(0).getPassword(), // 密码
                    ByteSource.Util.bytes(userName + userList.get(0).getCredentialsSalt()),// salt=username+salt
                    getName() // realm name
            );
// 当验证都通过后，把用户信息放在session里
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("userSession", userList.get(0));
            session.setAttribute("userSessionId", userList.get(0).getId());
            return authenticationInfo;
        }else{
            throw new UnknownAccountException();// 没找到帐号
        }
    }
}

