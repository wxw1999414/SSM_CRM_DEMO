package com.yc137.controller;

import com.yc137.domain.TAuthority;
import com.yc137.service.TAuthorityService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@Scope("prototype")
@SessionAttributes("th")
public class AuthorityController {

    private final TAuthorityService tAuthor;

    public AuthorityController(TAuthorityService tAuthor) {
        this.tAuthor = tAuthor;
    }


    @RequestMapping("Author_one")
    public String showAuthority(Long parentId,HttpSession session){
        System.out.println("进入查询方法......");
        List<TAuthority> list=   tAuthor.selectByParentId(parentId);
        session.setAttribute("parentId",parentId);
        System.out.println(list.toString());
        session.setAttribute("list", list);

        return "pages/authorityList";
    }
    @RequestMapping("Author_two")
    public String showAuthorityTwo(Long parentId,HttpSession session){
        List<TAuthority> list=   tAuthor.selectByParentId(parentId);
        session.setAttribute("parentId",parentId);
        session.setAttribute("list", list);
        return "pages/twoLevelAuthorityList";
    }
    @RequestMapping("Author_three")
    public String showAuthorityThree(Long parentId,HttpSession session){
        List<TAuthority> list=   tAuthor.selectByParentId(parentId);
        session.setAttribute("parentId",parentId);
        session.setAttribute("list", list);
        return "pages/threeLevelAuthorityList";
    }
    @RequestMapping("Author_update")
    public String updateAuthor(Long roleId,HttpSession session){
      List  list=  tAuthor.selectAuthorities(1L);
      session.setAttribute("menuList", list);
      return "pages/rollList";
    }

    /**
     * 添加一级菜单
     */
    @RequestMapping("addAuthority")
    public String addAuthority(Long num, String title, Integer cid, Integer isMenu, String path){
        System.out.println("进入增加菜单的方法.......");
        TAuthority tr=new TAuthority();
        tr.setId(num);
        tr.setIsMenu(isMenu);
        tr.setName(title);
        tr.setUrl(path);
        tr.setParentId(1L);
        tr.setMenuType(cid);
        System.out.println(tr.toString());
        int number=tAuthor.insert(tr);
        if(number>0){
            return "pages/authorityList";
        }
        return "pages/add";
    }

    /**
     * 删除一级菜单
     */
    @RequestMapping("deleteAuthorityOne")
    public String deleteAuthorityOne(String id,HttpSession session){
        System.out.println(id);
        String authid=id;
        authid.substring(0,3);
        Long aid=Long.valueOf(authid);
        tAuthor.deleteByPrimaryKey(aid);
        this.showAuthority(Long.valueOf(id),session);
        return "pages/authorityList";
    }

    /**
     * 删除二级菜单
     */
    @RequestMapping("deleteAuthorityTwo")
    public String deleteAuthorityTwo(String id,HttpSession session){
        System.out.println(id);
        tAuthor.deleteByPrimaryKey(Long.valueOf(id));
        this.showAuthorityTwo(Long.valueOf(id),session);
        return "pages/twoLevelAuthorityList";
    }

    /**
     * 删除三级菜单
     */
    @RequestMapping("deleteAuthorityThree")
    public String deleteAuthorityThree(String id,HttpSession session){
        System.out.println(id);
        String authid=id;
        authid.substring(0,3);
        Long aid=Long.valueOf(authid);
        tAuthor.deleteByPrimaryKey(aid);
        this.showAuthorityThree(Long.valueOf(id),session);
        return "pages/threeLevelAuthorityList";
    }

    /**
     * 通过id查找
     */

    @RequestMapping(value = "parentId")
    @ResponseBody
    public void selectById(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String kid=request.getParameter("keywords");
        System.out.println("进入selectD方法。。。。。。。。");
        Long id= Long.valueOf(kid.substring(0,1));
        List<TAuthority> th=tAuthor.selectConditonById(id);
        System.out.println(th);
        model.addAttribute("th",th);
        response.getWriter().print("res");
    }

    /**
     * 添加子菜单
     */
    @RequestMapping(value="add")
    public String addMenus(Long num, String title, Integer type, Integer isMenu, String path,HttpSession session){
        System.out.println("进入添加子菜单。。。。。。。。。");
        TAuthority th=new TAuthority();
        th.setMenuType(type);
        th.setUrl(path);
        th.setName(title);
        Long parentID= (Long) session.getAttribute("parentId");
        th.setParentId(parentID);
        th.setId(num);
        th.setIsMenu(isMenu);
        tAuthor.insert(th);
        System.out.println(th.toString());
        this.showAuthorityTwo(parentID,session);
        return "pages/twoLevelAuthorityList";
    }


    /**
     * 修改信息
     */
    @RequestMapping("updateAuthority")
    public String updateAuthority(Long numId, String title, Integer menuType, Integer isMenu, String path,HttpSession session){
//        System.out.println("进入修改信息方法。。。。。。");
//        List<TAuthority> list=tAuthor.selectById(numId);
//        System.out.println(list.toString());
//        TAuthority authority=list.get(0);
//        session.setAttribute("authority",authority);
        TAuthority th=new TAuthority();
        th.setId(numId);
        th.setName(title);
        th.setMenuType(menuType);
        th.setIsMenu(isMenu);
        th.setUrl(path);
        int upnum=tAuthor.updateByPrimaryKey(th);
        if(upnum!=0){
            return "pages/authorityList";
        }
        this.showAuthority(numId,session);
        return "pages/authorityUpdate";
    }
}
