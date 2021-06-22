package com.yc137.controller;

import com.yc137.util.PageModel;
import com.yc137.domain.TUser;
import com.yc137.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
/**
 * @author Chaun
 */
@Controller
@Scope("prototype")
public class UserController {
    @Autowired
    private TUserService tUserService;

    @RequestMapping("user/TUsers")
    public String hello(PageModel pm,HttpSession session){
        List<TUser> list=   tUserService.findAll();
        pm.setList(list);
        session.setAttribute("pm", pm);
        return "pages/TUser";
        //重定向：redirect:定向文件
    }
    /**页面显示所有跟进人员信息*/
    @RequestMapping("user/userList")
    @ResponseBody
    public void showAllUser(HttpSession session){
        List<TUser> list=   tUserService.findAll();
        session.setAttribute("userList",list);

    }

    //对象传递参数，以user.开头
    @InitBinder(value = "user")
    public void initBinder(WebDataBinder binder){
        binder.setFieldDefaultPrefix("user.");
    }
    //查询单个实体
    public ModelAndView queryUser(@RequestParam("userid") int id){
        TUser user=tUserService.selectByPrimaryKey(id);

        ModelAndView mav=new ModelAndView();
        mav.addObject("loginUser", user);
        mav.setViewName("pages/success");
        return mav;
    }
    //查询 分页 文件流数据（execl 图形报表） 返回json格式数据 xml数据
}
