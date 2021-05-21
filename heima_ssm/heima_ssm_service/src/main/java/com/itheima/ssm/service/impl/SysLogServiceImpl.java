package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.ISysLogDao;
import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: heima_ssm
 * @description
 * @author: yanbaohui
 * @create: 2021-05-21 13:21
 **/

@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;


    @Override
    public void save(SysLog log) throws Exception {
        sysLogDao.save(log);
    }


    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }


}
