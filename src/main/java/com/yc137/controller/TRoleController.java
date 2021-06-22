package com.yc137.controller;

import com.yc137.domain.TRole;
import com.yc137.service.TRoleService;
import com.yc137.util.PageModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("tr")
public class TRoleController {
    @Autowired
    private TRoleService tRoleService;

    @Test
    public void testTRole(){
        TRole tRole=new TRole();
        tRole.setId(1L);
        TRole role=   tRoleService.selectByRole(tRole);
        System.out.println(role);
    }


    @RequestMapping("/role_show")
    public String showRoles(HttpSession session){
        List<TRole> list =tRoleService.findAll();
        PageModel pm=new PageModel();
        pm.setList(list);
        session.setAttribute("pm", pm);
        return "pages/list";
    }


    @RequestMapping("sessionRole")
    public String sessionRole(Long roleId, Model model){
        TRole role=tRoleService.selectByPrimaryKey(roleId);
        model.addAttribute("tr",role);
        System.out.println("role===>"+role.toString());
        return "pages/t_role_update";
    }

    /**
     * 角色修改
     */
    @RequestMapping("updateRoles")
    public String updateRoles(TRole role,HttpSession session){
        int num=tRoleService.updateByPrimaryKey(role);
        if(num!=0){
            this.showRoles(session);
            return "pages/list";
        }
        return "pages/t_role_update";
    }

}
