package com.ycz.dao;

import com.ycz.pojo.Claz;
import com.ycz.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClazMapper {
    List<Claz> selectAll();

    List<User> selectStudentByClazId(@Param("id") Integer id);

    void insertClaz(Claz claz);
}
