package com.banner.service;

import com.banner.mapper.UserMapper;
import com.banner.mapper.UserRoleMapper;
import com.banner.model.User;
import com.banner.model.UserRole;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/2/23 0023.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    public List<User> getAll (){
        return userMapper.selectAll();
    }
    public User getUserInfo (String userName){
        User user = new User();
        user.setAccountname(userName);
        return userMapper.selectOne(user);
    }
    public List<UserRole> getRole (String userName){
        User user = new User();
        user.setAccountname(userName);
        user=userMapper.selectOne(user);
        if(user!=null){
            UserRole userRole=new UserRole();
            userRole.setUserid(user.getId());
            List<UserRole> userRoleList= userRoleMapper.select(userRole);
                if(userRoleList!=null){
                    return userRoleList;
                }
        }
        return null;
    }
}
