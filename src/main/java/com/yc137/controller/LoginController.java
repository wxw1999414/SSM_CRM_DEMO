package com.yc137.controller;

import com.yc137.domain.TUser;
import com.yc137.service.TUserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


/**
 * @author William
 */
@Controller
@Scope("prototype")
public class LoginController {
    private final TUserService tUserService;

    public LoginController(TUserService tUserService) {
        this.tUserService = tUserService;
    }

    @RequestMapping(value ="login")
    public String login(TUser tUser, HttpSession session){
        System.out.println("进入此方法......");
        TUser user=  tUserService.selectByUser(tUser);
        if(user!=null){
            session.setAttribute("loginUser", user);
            return "pages/success";
        }
      return "pages/login";
    }


}
