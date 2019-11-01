package com.ycz.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface PermissionMapper {

    Set<String> queryPermissionByName(@Param("username") String username);

}
