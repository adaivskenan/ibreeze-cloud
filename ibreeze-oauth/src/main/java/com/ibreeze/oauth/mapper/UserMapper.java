package com.ibreeze.oauth.mapper;

import com.ibreeze.oauth.domain.SysUser;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by adaivskenan on 2020/5/29.
 */
public interface UserMapper extends Mapper<SysUser>{

    @Select("Select * from sys_user where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roles", column = "id", javaType = List.class,
            many = @Many(select = "com.ibreeze.oauth.mapper.RoleMapper.findByUid"))
    })
    SysUser findByName(String username);
}
