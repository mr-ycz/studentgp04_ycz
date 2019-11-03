package com.ycz.service;

import com.ycz.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface RoleService {
    Set<String> queryAllRolenameByUsername(@Param("username") String username);

    void addRoleUser(User user);

}
