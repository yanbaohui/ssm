package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IPermissionDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: heima_ssm
 * @description
 * @author: yanbaohui
 * @create: 2021-05-18 12:41
 **/
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission p) throws Exception {
        permissionDao.save(p);
    }

    @Override
    public Permission findById(String permissionId) throws Exception{
        return permissionDao.findById(permissionId);
    }

    @Override
    public void deletePermissionById(String permissionId) throws Exception {
        permissionDao.deleteFromRole_Permission(permissionId);
        permissionDao.deletePermissionById(permissionId);
    }
}
