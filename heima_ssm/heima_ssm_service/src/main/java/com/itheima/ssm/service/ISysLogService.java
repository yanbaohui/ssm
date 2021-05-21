package com.itheima.ssm.service;

import com.itheima.ssm.domain.SysLog;

import java.util.List;

/**
 * @program: heima_ssm
 * @description
 * @author: yanbaohui
 * @create: 2021-05-21 13:20
 **/
public interface ISysLogService {

   List<SysLog> findAll() throws Exception;

   void save(SysLog log) throws Exception;
}
