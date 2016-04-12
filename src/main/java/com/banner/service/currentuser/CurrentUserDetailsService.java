/*

package com.banner.service.currentuser;

import com.banner.model.CurrentUser;
import com.banner.model.Role;
import com.banner.model.User;
import com.banner.model.UserRole;
import com.banner.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


*/
/**
 * Created by Administrator on 2016/2/24 0024.
 *//*


@Service
public class CurrentUserDetailsService implements UserDetailsService{
    @Autowired
    private  UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("user-------------"+username);
        CurrentUser currentUser=null;
        if(StringUtils.isNotEmpty(username)){
            User user=userService.getUserInfo(username);
            if(user == null){
                throw new UsernameNotFoundException("not found user");
            }
            List<UserRole> userRoleList= userService.getRole(username);
            List<String> auth=new ArrayList<>();
            Iterator iterator=userRoleList.iterator();
            while(iterator.hasNext()){
                UserRole userRole= (UserRole) iterator.next();
                auth.add(userRole.getRoleid().toString());
            }
            if(userRoleList!=null){
                 currentUser=new CurrentUser(user, auth);
                return  currentUser;
            }
        }
         return null;
    }
}

*/
