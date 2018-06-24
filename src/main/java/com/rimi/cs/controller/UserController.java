package com.rimi.cs.controller;

import com.github.pagehelper.Constant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rimi.cs.dao.RoleMapper;
import com.rimi.cs.pojo.Role;
import com.rimi.cs.pojo.User;
import com.rimi.cs.service.IRoleService;
import com.rimi.cs.service.IUserService;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yy
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll")
    public String findAll(String queryname, String queryUserRole, @RequestParam(required = false,defaultValue = "1") int pageIndex, Model model) {
        //分页
        PageHelper.startPage(pageIndex, com.rimi.cs.utils.Constant.PAGE_SIZE);
        // 调用业务层的方法
        List<User> userList = userService.find(queryname,queryUserRole);
        // 返回结果数据
        model.addAttribute("pageInfo", new PageInfo<User>(userList));
        List<Role> roleList = roleService.selectAll();

        model.addAttribute("roleList", roleList);
        return "user/list";
    }
    @ResponseBody
    @RequestMapping(value = "/del",method = RequestMethod.GET)
    public Map delete(Long uid)
    {
        Map<String ,String> map = new HashMap<>();

        //调用业务层的方法，获得删除结果
        String result = userService.delete(uid);
        map.put("delResult",result);
        return map;
    }


    @RequestMapping(value = "/user/{uid}",method = RequestMethod.GET)
    public String  view(Long uid,Model model)
    {
        User user= userService.findById(uid);
        model.addAttribute("user", user);
        return "user/view";
    }
    @RequestMapping(value = "/add",method  = RequestMethod.GET)
    public  String add()
    {
        return "user/add";
    }


    @RequestMapping(value = "/roles",method = RequestMethod.GET)
    public List<Role> getRoleList()
    {
       return  roleService.selectAll();
    }
}
