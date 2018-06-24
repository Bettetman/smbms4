package com.rimi.cs.dao;

import com.rimi.cs.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectByUserCode(String userCode);

    List<User> select();


    List<User> selectByNameAndRoleId(@Param("queryname") String queryname,@Param("queryUserRole") String queryUserRole);
}