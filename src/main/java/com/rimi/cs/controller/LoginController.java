package com.rimi.cs.controller;

import com.rimi.cs.service.ILoginService;
import com.rimi.cs.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录相关操作
 * @author yy
 */
@Controller
public class LoginController {

    @Autowired
    private ILoginService iLoginService;
    /**
     * 跳转到登录界面
     * @return
     */
    @RequestMapping(value = "/login",method=RequestMethod.GET)
    public String login(){
        return "login";
    }

    /**
     * 登录
     * @param userCode
     * @param userPassword
     * @return 成功或者失败页面
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String userCode, String userPassword, Model model,
                        HttpServletRequest request){
        //调用登录操作
        boolean isLogin=iLoginService.login(userCode,userPassword,request);
        if(isLogin){
            return "redirect:/welcome";
        }else{
            model.addAttribute("error","登录失败，请重新登录");
            return "login";
        }
    }

    /**
     * 欢迎页面
     * @return
     */
    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String welcome(){
        return "frame";
    }



    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        //删除session中的数据
       request.getSession().removeAttribute(Constant.USER_INFO);
       //session失效
       request.getSession().invalidate();
        //退出跳转到登陆界面
        return "login";
    }
}
