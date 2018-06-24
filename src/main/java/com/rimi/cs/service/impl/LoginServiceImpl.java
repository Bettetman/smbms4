package com.rimi.cs.service.impl;

import com.rimi.cs.dao.UserMapper;
import com.rimi.cs.pojo.User;
import com.rimi.cs.service.ILoginService;
import com.rimi.cs.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String userCode, String userPassword, HttpServletRequest request) {

        //根据userCode调用userMapper中的方法，获得用户
        User user=userMapper.selectByUserCode(userCode);
        boolean b = (user!=null) &&(user.getUserpassword().equals(userPassword));
        if(b){
            request.getSession().setAttribute(Constant.USER_INFO,user.getUsername());
        }
        return b;
    }
}
