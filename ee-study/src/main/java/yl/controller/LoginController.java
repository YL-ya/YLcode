package yl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yl.model.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "/login3",method = RequestMethod.POST)
    @ResponseBody
    public Object login3(@RequestBody User u){
        System.out.println(u);
        User user=new User();
        user.setUsername("烤鸭");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping(value = "/login4",method = RequestMethod.POST)
    @ResponseBody
    public Object login4(HttpServletRequest request, HttpServletResponse response,
                          User u){
        if("abc".equals(u.getUsername())&&"123".equals(u.getPassword())){
            HttpSession session=request.getSession();
            session.setAttribute("user",u);
        }
        User user=new User();
        user.setUsername("烤鸭");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }
}
