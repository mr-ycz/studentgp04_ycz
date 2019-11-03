package com.ycz.dao;

import com.ycz.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();

    Integer insertUser(User user);

    User selectuserByName(String username);

    List<User> selectAllNoClaz();

    void updateUser(@Param("stuId") Integer stuId,@Param("clazId") Integer clazId);

    User selectUserById(Integer id);
}
