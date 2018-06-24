package com.rimi.cs.service;

import com.rimi.cs.pojo.User;

import java.util.List;

/**
 * @author szf
 */
public interface IUserService {

    /**
     * 查询所有
     *
     * @return
     */
    List<User> findAll();

    /**
      *  @Auther Ming
      *  @Description 更据用户名和角色id搜索
      *  @Date 2018/6/23  11:27
      *
    */

    List<User> find(String queryname, String queryUserRole);

    String delete(Long uid);

    User findById(Long uid);
}
