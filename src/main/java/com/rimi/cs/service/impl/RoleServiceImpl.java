package com.rimi.cs.service.impl;

import com.rimi.cs.dao.RoleMapper;
import com.rimi.cs.pojo.Role;
import com.rimi.cs.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther Ming []
 * @Date 2018/6/23  22:49
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectAll() {
        return  roleMapper.selectAll();
    }
}
