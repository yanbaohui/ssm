package com.itheima.ssm.service;

import com.itheima.ssm.domain.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: heima_ssm
 * @description
 * @author: yanbaohui
 * @create: 2021-05-15 21:33
 **/

public interface IOrdersService {

    List<Orders> findAll(int page,int size) throws Exception;

    Orders findById(String ordersId) throws Exception;
}
