package com.rimi.cs.service.impl;

import com.rimi.cs.dao.UserMapper;
import com.rimi.cs.pojo.User;
import com.rimi.cs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shyl
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.select();
    }

    @Override
    public List<User> find(String queryname, String queryUserRole) {
        return userMapper.selectByNameAndRoleId(queryname,"0".equals(queryUserRole)?null:queryUserRole);
    }

    @Override
    public String delete(Long uid) {
        //删除成功 ture  失败false 没用户返回notexist
        User user =userMapper.selectByPrimaryKey(uid);
        if (user==null)
        {
            return "notexist";
        }
       int result = userMapper.deleteByPrimaryKey(uid);
        return result>0?"ture":"false";
    }

    @Override
    public User findById(Long uid) {
        //调用dao层方法
        User user = userMapper.selectByPrimaryKey(uid);

        return user;
    }
}
