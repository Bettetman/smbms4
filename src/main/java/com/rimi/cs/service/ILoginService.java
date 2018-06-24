package com.rimi.cs.service;

import javax.servlet.http.HttpServletRequest;

public interface ILoginService {
    /**
     * 登录方法
     * @param userCode
     * @param password
     * @param request
     * @return是否登录成功
     */
        boolean login(String userCode, String password, HttpServletRequest request);
}
