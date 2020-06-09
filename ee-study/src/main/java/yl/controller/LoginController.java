package yl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import yl.model.User;

import java.util.Date;

@Controller//这个注解就是将该类直接编号才能Bean对象
public class LoginController {
    @RequestMapping("/login1")//返回一个页面
    public String login1(){
        return "/login.html";
    }

    @RequestMapping(value = "/login2",method = RequestMethod.POST)
    @ResponseBody//该注解使用后，会自动转变成json格式
    public Object login2(@RequestParam("username") String username1,String password){
        //用RequestParam注解是不接受application/json的格式的
        User user=new User();
        user.setUsername("zhangsan");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }
}
