package com.ycz.service;

import com.ycz.dao.RoleMapper;
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
}
