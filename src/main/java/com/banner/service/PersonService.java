package com.banner.service;

import com.banner.mapper.UserMapper;
import com.banner.model.Person;
import com.banner.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/2/23 0023.
 */
@Service
public class PersonService {
    @Autowired
    private UserMapper userMapper;
    public List<User> getAll(){
        return userMapper.selectAll();
    }
}
