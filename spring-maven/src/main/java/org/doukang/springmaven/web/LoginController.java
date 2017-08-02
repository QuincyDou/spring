package org.doukang.springmaven.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.doukang.springmaven.domain.User;
import org.doukang.springmaven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login/")
public class LoginController
{
    @Autowired
    private UserService userService;
    
    @RequestMapping("index.html")
    public String loginPage()
    {
        return "login";
    }
    
    @RequestMapping("check.html")
    public ModelAndView loginCheck(HttpServletRequest request, User user)
    {
        boolean isValidUser =
                userService.hasMatchUser(user.getUserName(), user.getPassword());
        if (!isValidUser)
        {
            return new ModelAndView("login", "error", "用户名或密码错误！");
        }
        else
        {
            user = userService.getUserByUserName(user.getUserName());
            user.setLastVisit(new Date());
            user.setLastIP(request.getRemoteAddr());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user", user);
            return new ModelAndView("main");
        }
        
    }
}
