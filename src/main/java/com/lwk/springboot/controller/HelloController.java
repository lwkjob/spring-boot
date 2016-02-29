package com.lwk.springboot.controller;

import com.lwk.springboot.configurationProperties.LwkProperties;
import com.lwk.springboot.domain.User;
import com.lwk.springboot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


// 声明为controller控制器，捕获请求并处理请求
@Controller
public class HelloController {

//    注入UserDao
    @Autowired
    private UserDao userDao;

    @Autowired
    private LwkProperties mamadan;

//    捕获 /hello 请求，利用hello(Model model) 处理请求，并返回‘hello’，交给Thymeleaf 处理
//    hello 对应html文件名。model 作为信息的载体，封装各类变量、对象
    @RequestMapping("/hello")
    public ModelAndView hello(ModelAndView model) {
//      获取XiaoMing的相关信息
        User user = userDao.getOneUser("1");
        user.setName(user.getName()+"---"+mamadan.getName());

        model.addObject("user", user);
        model.setViewName("hello");
        return model;
    }

    @RequestMapping("/mm")
    @ResponseBody
    public Object mamadan(){
        User user=new User();
        user.setName("sfsf");
        user.setAge(2323);
        return user;
    }
}