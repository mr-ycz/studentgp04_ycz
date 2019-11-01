package com.ycz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ycz.dao.ClazMapper;
import com.ycz.pojo.Claz;
import com.ycz.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazServiceImpl implements ClazService {

    @Autowired
    private ClazMapper clazMapper;

    @Override
    public List<Claz> queryAll() {
        return clazMapper.selectAll();
    }

    @Override
    public PageInfo<User> queryStudentByClazId(Integer id, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<User> users=clazMapper.selectStudentByClazId(id);
        PageInfo<User> userPageInfo = new PageInfo<>(users);

        return userPageInfo;
    }

    @Override
    public void addClaz(Claz claz) {
        clazMapper.insertClaz(claz);
    }

}
