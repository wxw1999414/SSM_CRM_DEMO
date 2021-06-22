package com.yc137.controller;

import com.yc137.domain.TAuthority;
import com.yc137.domain.TRole;
import com.yc137.domain.TUser;
import com.yc137.service.TAuthorityService;
import com.yc137.service.TRoleService;
import com.yc137.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaun
 */
@Controller
@Scope("prototype")
public class RoleAuthorController {
    @Autowired
    private TRoleService tRoleService;
    @Autowired
    private TUserService tUserService;
    @Autowired
    private TAuthorityService tAuthorityService;

    @RequestMapping("/roleAuthor_user")
    public String UserAuthor(HttpSession session){
        TUser tUser= (TUser) session.getAttribute("loginUser");
        //获取登录用户角色
        TRole userRole=  tUser.gettRole().get(0);
        Long roleId=userRole.getId();
        //获取当前角色权限
        List<TAuthority> userMenu=  tRoleService.selectRoleAuthById(roleId);

        List  list=  tAuthorityService.selectAuthorities(1L);
        session.setAttribute("menuList", list);

        session.setAttribute("roleId",roleId);
        session.setAttribute("userMenu",userMenu);
        return "pages/rollList";
    }

    @RequestMapping("/roleAuthor_role")
    public String roleAuthor(HttpServletRequest req,HttpSession session){
        Long roleId=Long.parseLong(req.getParameter("roleId"));

        //获取当前角色权限
        List<TAuthority> userMenu= tRoleService.selectRoleAuthById(roleId);

        List  list=  tAuthorityService.selectAuthorities(1L);


        session.setAttribute("menuList", list);
        session.setAttribute("roleId",roleId);
        session.setAttribute("userMenu",userMenu);

        return "pages/rollList";
    }

}
