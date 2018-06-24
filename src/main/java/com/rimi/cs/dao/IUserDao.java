package com.rimi.cs.dao;

import com.rimi.cs.pojo.User;

import java.util.List;

/**
 * @author szf
 */
public interface IUserDao {

    /**
     * 查询所有
     *
     * @return
     */
    List<User> selectAll();
}
