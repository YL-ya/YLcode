package frank.controller;

import frank.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/1")
public class LoginController {

    /**
     * 两个页面，login.html和index.html，哪些url能够访问，每个url访问的时候，是否是转发的？
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(){
        return "/login.html";
    }

    @RequestMapping(value = "/login2", method = RequestMethod.POST)
    @ResponseBody
    public Object login2(@RequestParam("username") String username1,
                         String password,
                         String password2){
        System.out.println(username1+"="+password+", "+password2);
        User user = new User();
        user.setUsername("烤鸭");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping(value = "/login3", method = RequestMethod.POST)
    @ResponseBody
    public Object login3(User u){
        System.out.println(u);
        User user = new User();
        user.setUsername("烤鸭");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }
}
