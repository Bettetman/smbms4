package com.rimi.cs.intercept;

import com.rimi.cs.utils.Constant;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginIntercept extends HandlerInterceptorAdapter {
    /**
     * 在请求开始之前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request,
    HttpServletResponse response,Object handler)throws Exception{
      Object user =request.getSession().getAttribute(Constant.USER_INFO);
      if(user!=null){
          return true;
      }else {
          response.sendRedirect("/");
          return false;
      }
    }
}
