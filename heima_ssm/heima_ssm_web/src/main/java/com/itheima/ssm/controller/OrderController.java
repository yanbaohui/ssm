package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: heima_ssm
 * @description
 * @author: yanbaohui
 * @create: 2021-05-15 21:30
 **/
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrdersService orderService;
    //查询全部订单 - 未分页
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll()throws Exception{
//        ModelAndView mv = new ModelAndView();
//        List<Orders> ordersList = orderService.findAll();
//        mv.addObject("ordersList",ordersList);
//        mv.setViewName("orders-list");
//
//        return mv;
//    }

    @RequestMapping("/findAll.do")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "size",required = true,defaultValue = "5")Integer size)throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = orderService.findAll(page, size);
        //PageInfo 就是一个分页的bean
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String ordersId) throws Exception {
        Orders orders = orderService.findById(ordersId);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders-show");
        mv.addObject("orders", orders);
        return mv;
    }
}
