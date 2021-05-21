package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: heima_ssm
 * @description
 * @author: yanbaohui
 * @create: 2021-05-16 17:59
 **/

@Repository
public interface ITravellerDao {
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
