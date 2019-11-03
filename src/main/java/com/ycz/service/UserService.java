package com.ycz.service;

import com.ycz.pojo.User;

import java.util.List;

public interface UserService {
    List<User> queryAll();

    Integer addUser(User user);

    User queryUserByUsername(String username);

    List<User> queryAllNoClaz();

    void updateUser(Integer stuId, Integer clazid);

    User queryUserByUserId(Integer id);
}
