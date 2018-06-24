package com.rimi.cs.service.impl;

import com.rimi.cs.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class UserServiceImplTest {
    ApplicationContext context;
      @Before
  public void setUp() throws Exception {
        context=new ClassPathXmlApplicationContext("/spring/spring-dao.xml");
    }
    @Autowired
    private UserServiceImpl  userServiceImpl;
    @Test
    public void selectAll(){
        List<User> userList= userServiceImpl.findAll();
        for (User user:userList){
            System.out.println(user);
        }
    }
}