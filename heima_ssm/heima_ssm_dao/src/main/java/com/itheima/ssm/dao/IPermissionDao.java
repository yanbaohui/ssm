package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: heima_ssm
 * @description
 * @author: yanbaohui
 * @create: 2021-05-17 21:08
 **/
@Repository
public interface IPermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findByRoleId(String roleId)throws Exception;

    @Select("select * from permission")
    List<Permission> findAll() throws Exception;


    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission p)throws Exception;

    @Select("select * from permission where id = #{permissionId}")
    Permission findById(String permissionId)throws Exception;

    @Delete("delete from permission where id = #{permissionId}")
    void deletePermissionById(String permissionId)throws Exception;

    @Delete("delete from role_permission where permissionId = #{permissionId}")
    void deleteFromRole_Permission(String permissionId);
}
