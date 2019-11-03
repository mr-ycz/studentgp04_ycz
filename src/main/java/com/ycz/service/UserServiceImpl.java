package com.ycz.service;

import com.ycz.dao.UserMapper;
import com.ycz.pojo.User;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> queryAll() {
        return userMapper.selectAll();
    }

    @Override
    public Integer addUser(User user) {
        String salt = UUID.randomUUID().toString();
        String newPwd = new Sha256Hash(user.getPassword(), salt, 10000).toBase64();
        user.setSalt(salt);
        user.setPassword(newPwd);

        return userMapper.insertUser(user);
    }

    @Override
    public User queryUserByUsername(String username) {
        return userMapper.selectuserByName(username);
    }

    @Override
    public List<User> queryAllNoClaz() {
        return userMapper.selectAllNoClaz();
    }

    @Override
    public void updateUser(Integer stuId, Integer clazid) {
        userMapper.updateUser(stuId,clazid);
    }

    @Override
    public User queryUserByUserId(Integer id) {
        return userMapper.selectUserById(id);
    }
}
