package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: heima_ssm
 * @description
 * @author: yanbaohui
 * @create: 2021-05-15 21:41
 **/
@Repository
public interface IOrdersDao {

    @Select("select * from orders")
    //true表示主键
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class,one = @One(select = "com.itheima.ssm.dao.IProductDao.findById"))

    })
    public List<Orders> findAll() throws Exception;

    @Select("select * from orders where id=#{ordersId}")
    //true表示主键
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class,one = @One(select = "com.itheima.ssm.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select ="com.itheima.ssm.dao.IMemberDao.findById")),
            @Result(column = "id",property = "travellers",javaType = java.util.List.class,many = @Many(select = "com.itheima.ssm.dao.ITravellerDao.findByOrdersId"))
    })
    Orders findById(String ordersId) throws Exception;
}
