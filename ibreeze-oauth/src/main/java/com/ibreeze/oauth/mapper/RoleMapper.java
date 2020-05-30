package com.ibreeze.oauth.mapper;

import com.ibreeze.oauth.domain.SysRole;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by adaivskenan on 2020/5/29.
 */
public interface RoleMapper extends Mapper<SysRole>{


    @Select("Select r.id, r.role_name roleName, r.role_desc roleDesc " +
            "From sys_role r, sys_user_role ur " +
            "Where r.id=ur.rid AND ur.uid=#{uid}")
    List<SysRole> findByUid(Integer id);


}
