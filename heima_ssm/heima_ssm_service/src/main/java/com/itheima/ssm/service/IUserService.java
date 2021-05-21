package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @program: heima_ssm
 * @description
 * @author: yanbaohui
 * @create: 2021-05-16 21:08
 **/

public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll() throws Exception;

    void save(UserInfo user) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findUserByIdAndAllRole(String userId)throws Exception;

    void addRoleToUser(String userId, String[] roleId)throws Exception;
}
