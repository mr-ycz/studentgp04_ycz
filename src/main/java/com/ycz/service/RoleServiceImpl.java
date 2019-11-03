package com.ycz.service;

import com.ycz.dao.RoleMapper;
import com.ycz.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    public Set<String> queryAllRolenameByUsername(String username) {
        return roleMapper.queryRoleByName(username);
    }

    @Override
    public void addRoleUser(User user) {
        if (user.getStatus()==1){
            roleMapper.insertUser(user.getId(),1);
        }else {
            roleMapper.insertUser(user.getId(), 2);
        }
    }
}
