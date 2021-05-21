package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;

import java.util.List;

/**
 * @program: heima_ssm
 * @description
 * @author: yanbaohui
 * @create: 2021-05-18 12:41
 **/
public interface IPermissionService {
    List<Permission> findAll() throws Exception;

    void save(Permission p) throws Exception;

    Permission findById(String permissionId)throws Exception;

    void deletePermissionById(String permissionId) throws Exception;
}
