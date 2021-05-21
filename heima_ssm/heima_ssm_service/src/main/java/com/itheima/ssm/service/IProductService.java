package com.itheima.ssm.service;

import com.itheima.ssm.domain.Product;

import java.util.List;

/**
 * @program: heima_ssm
 * @description
 * @author: yanbaohui
 * @create: 2021-05-14 19:37
 **/
public interface IProductService {
    public List<Product> findAll(int page, int size) throws Exception;

    void save(Product product) throws Exception;
}
