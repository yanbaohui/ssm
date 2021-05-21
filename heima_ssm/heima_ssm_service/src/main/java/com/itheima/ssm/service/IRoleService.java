package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;

import java.util.List;

/**
 * @program: heima_ssm
 * @description
 * @author: yanbaohui
 * @create: 2021-05-18 12:22
 **/
public interface IRoleService {
    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId)throws Exception;

    void deleteRoleById(String roleId)throws Exception;

    List<Permission> findRoleByIdAndAllPermission(String roleId)throws Exception;

    void savePermission(String roleId, String[] ids);
}
