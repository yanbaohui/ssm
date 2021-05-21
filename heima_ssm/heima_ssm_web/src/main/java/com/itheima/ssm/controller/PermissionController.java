package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: heima_ssm
 * @description
 * @author: yanbaohui
 * @create: 2021-05-18 12:39
 **/
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        List<Permission> permissionList = permissionService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("permissionList", permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Permission p) throws Exception {
        permissionService.save(p);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String permissionId)throws Exception{
        ModelAndView mv = new ModelAndView();
        Permission permission = permissionService.findById(permissionId);
        mv.addObject("permission",permission);
        mv.setViewName("permission-show");
        return mv;
    }

    @RequestMapping("/deletePermissionById.do")
    public String deletePermissionById(@RequestParam(name = "id",required = true) String permissionId) throws Exception {
        permissionService.deletePermissionById(permissionId);
        return "redirect:findAll.do";
    }
}
