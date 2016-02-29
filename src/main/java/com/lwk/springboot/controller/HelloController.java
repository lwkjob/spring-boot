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


@Controller
public class HelloController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LwkProperties mamadan;  //自定义属性文件

    @RequestMapping("/hello")
    public ModelAndView hello(ModelAndView model) {
        User user = userDao.getOneUser("1");
        user.setName("数据库数据="+user.getName()+",属性文件取到的数据="+mamadan.getName());
        model.addObject("user", user);
        model.setViewName("hello");
        return model;
    }

    @RequestMapping("/mm")
    @ResponseBody
    public Object mamadan(){
        User user=new User();
        user.setName("李文科json数据");
        user.setAge(2311);
        return user;
    }
}