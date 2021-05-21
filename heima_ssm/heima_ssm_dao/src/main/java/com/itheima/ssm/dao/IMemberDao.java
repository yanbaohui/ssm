package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @program: heima_ssm
 * @description
 * @author: yanbaohui
 * @create: 2021-05-16 17:55
 **/
@Repository
public interface IMemberDao {

    @Select("select * from member where id = #{id}")
    public Member findById(String id)throws Exception;
}
