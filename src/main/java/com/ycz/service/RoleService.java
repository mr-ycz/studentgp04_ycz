package com.ycz.service;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface RoleService {
    public Set<String> queryAllRolenameByUsername(@Param("username") String username);
}
