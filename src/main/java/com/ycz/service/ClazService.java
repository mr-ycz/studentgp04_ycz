package com.ycz.service;

import com.github.pagehelper.PageInfo;
import com.ycz.pojo.Claz;
import com.ycz.pojo.User;

import java.util.List;

public interface ClazService {
    List<Claz> queryAll();

    PageInfo<User> queryStudentByClazId(Integer id, Integer pageNum, Integer pageSize);

    void addClaz(Claz claz);
}
