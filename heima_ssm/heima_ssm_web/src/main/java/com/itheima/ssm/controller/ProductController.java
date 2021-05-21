package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @program: heima_ssm
 * @description
 * @author: yanbaohui
 * @create: 2021-05-14 20:10
 **/
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    //未分页
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception{
//        ModelAndView mv = new ModelAndView();
//        List<Product> products = productService.findAll();
//        mv.addObject("productList",products);
//        mv.setViewName("product-list");
//        return mv;
//    }

    @RequestMapping("/save.do")
    public String save(Product product) throws Exception{
        productService.save(product);
        return "redirect:findAll.do";

    }

    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "5") Integer size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(productList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-page-list");
        return mv;
    }
}
