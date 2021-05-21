package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.apache.ibatis.annotations.One;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: heima_ssm
 * @description
 * @author: yanbaohui
 * @create: 2021-05-18 12:22
 **/
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll()throws Exception{
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(String roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    @Override
    public void deleteRoleById(String roleId) throws Exception {
        //从user_role表删除
        roleDao.deleteFromUser_RoleByRoleId(roleId);
        //从role_permission表删除
        roleDao.deleteFromRole_PermissionByRoleId(roleId);
        //从role表删除
        roleDao.deleteRoleById(roleId);
    }

    @Override
    public List<Permission> findRoleByIdAndAllPermission(String roleId) throws Exception {
        return roleDao.findRoleByIdAndAllPermission(roleId);
    }

    @Override
    public void savePermission(String roleId, String[] ids) {
        for (String id : ids) {
            roleDao.savePermission(roleId,id);
        }

    }

}
