package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: heima_ssm
 * @description
 * @author: yanbaohui
 * @create: 2021-05-17 12:57
 **/
@Repository
public interface IRoleDao {

    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(column="roleName",property="roleName"),
            @Result(column="roleDesc",property="roleDesc"),
            @Result(column="id",property="permissions",javaType=List.class,many=@Many(select="com.itheima.ssm.dao.IPermissionDao.findByRoleId"))

    })
    List<Role> findRoleByUserId(String userId) throws Exception;

    @Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    @Select("select * from role where id = #{roleId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = List.class,many = @Many(select = "com.itheima.ssm.dao.IPermissionDao.findByRoleId"))
    })
    Role findById(String roleId)throws Exception;

    @Delete("delete from users_role where roleId=#{roleId}")
    void deleteFromUser_RoleByRoleId(String roleId);

    @Delete("delete from role_permission where roleId = #{roleId}")
    void deleteFromRole_PermissionByRoleId(String roleId);

    @Delete("delete from role where id = #{roleId}")
    void deleteRoleById(String roleId)throws Exception;

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findRoleByIdAndAllPermission(String roleId);

    @Insert("insert into role_permission(roleId, permissionId) values(#{roleId},#{permissionId})")
    void savePermission(@Param("roleId") String roleId, @Param("permissionId") String id);
}
