package com.ycz.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface RoleMapper {
    Set<String> queryRoleByName(@Param("username") String username);

    void insertUser(@Param("userId") Integer id,@Param("roleId") int roleId);
}
