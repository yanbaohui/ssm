package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: heima_ssm
 * @description
 * @author: yanbaohui
 * @create: 2021-05-16 21:08
 **/

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        List<Role> roles = null;
        try {
            userInfo = userDao.findByUserName(username);
            roles = userInfo.getRoles();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<SimpleGrantedAuthority> authoritys = getAuthority(roles);

        //处理自己的用户对象封装成UserDetails
//        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),userInfo.getStatus() == 0 ? false : true, true, true, true, authoritys);
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus() == 0 ? false : true, true, true, true, authoritys);
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> authoritys = new ArrayList();
        for (Role role : roles) {
            authoritys.add(new SimpleGrantedAuthority("ROLE_"+ role.getRoleName()));
        }
        return authoritys;
    }

    @Override
    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }

    @Override
    public void save(UserInfo user) throws Exception{
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public UserInfo findById(String id) throws Exception{
        return userDao.findById(id);
    }

    @Override
    public List<Role> findUserByIdAndAllRole(String userId) throws Exception {
        return userDao.findUserByIdAndAllRole(userId);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleId) throws Exception {
        for (String id : roleId) {
            userDao.addRoleToUser(userId,id);
        }

    }
}
