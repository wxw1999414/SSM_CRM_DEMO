package com.yc137.controller;

import com.yc137.domain.CompanyCustomer;
import com.yc137.domain.PotentialCustomer;

import com.yc137.service.CompanyCustomerService;
import com.yc137.service.PotentialCustomerService;
import com.yc137.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

/**
 * @author William
 */
@Controller
@SessionAttributes(value = {"list","lcr","fp","pc","ulist","mc","customer"})
public class PotentialCustomerController {
    @Autowired
    PotentialCustomerService ps;
    @Autowired
    CompanyCustomerService ccs;
    @Autowired
    TUserService user;

    /**
     * 查询所有潜在客户
     *
     */
    @RequestMapping("selectAll")
    public String selectCustomer(Model model){
        List<Map<String,Object>> lcr=ps.selectAll();
        System.out.println("lcr===>"+lcr);
        model.addAttribute("lcr",lcr);
        return "pages/potential_customer";
    }

    /**
     * 修改潜在客户信息
     */

    @RequestMapping("updateCustomer")
    public String updateCustomer(Model model,Integer sid,String name,String tel,String address, Integer followPerson,String signed,String follow_up){
        PotentialCustomer pc=new PotentialCustomer();
        pc.setRid(sid);
        pc.setAddress(address);
        pc.setCompanyName(name);
        pc.setFollowUp(follow_up);
        pc.setTel(tel);
        pc.setSigned(signed);
        pc.setFollowPerson(followPerson);
        int num=ps.updateByPrimaryKey(pc);
        if(num!=0){
            this.selectCustomer(model);
            return "pages/potential_customer";
        }
        return "pages/potential_customerUpdate";
    }

    /**
     * 修改我的客户信息
     */

    @RequestMapping("updateMyCustomer")
    public String updateMyCustomer(Model model,Integer sid,String name,String tel,String address, Integer followPerson,String signed,String follow_up){
        PotentialCustomer pc=new PotentialCustomer();
        pc.setRid(sid);
        pc.setAddress(address);
        pc.setCompanyName(name);
        pc.setFollowUp(follow_up);
        pc.setTel(tel);
        pc.setSigned(signed);
        pc.setFollowPerson(followPerson);
        int num=ps.updateByPrimaryKey(pc);
        if(num!=0){
            this.selectCustomer(model);
            return "pages/my_Customer";
        }
        return "pages/my_customerUpdate";
    }






        @RequestMapping("sessionSave")
        public String sessionSave(Model model, Integer id){
        Map<String, Object> pc=ps.selectById(id);
        model.addAttribute("pc",pc);
        List<Map<String,Object>> list= user.selectAll();
        model.addAttribute("ulist",list);
        System.out.println("***************************"+pc);
        return "pages/potential_customerUpdate";
    }



    @RequestMapping("sessionSaveCustomer")
    public String sessionSaveCustomer(HttpSession session,Integer id){
        PotentialCustomer pl=ps.selectByPrimaryKey(id);
        session.setAttribute("pl",pl);
        return "pages/newCustomer";
    }


    /**
     *
     * @param model
     * @return
     */
    @RequestMapping("selectAllFollowPeople")
    public String FollowPeople(Model model){
        List<Map<String,Object>> list= user.selectAll();
        System.out.println(list);
        model.addAttribute("fp",list);
        return "pages/potential_customerAdd";
    }


    /**
     * 添加潜在客户
     */
    @RequestMapping("addCustomer")
    public String addCustomer(Model model,String name,String tel,String address, Integer Pid,String signed,String follow_up){
        PotentialCustomer pc=new PotentialCustomer();
        pc.setAddress(address);
        pc.setCompanyName(name);
        pc.setFollowUp(follow_up);
        pc.setTel(tel);
        pc.setSigned(signed);
        pc.setFollowPerson(Pid);
        int num=ps.insert(pc);
        if(num!=0){
            this.selectCustomer(model);
            return "pages/potential_customer";
        }
        return "pages/potential_customerAdd";
    }

    /**
     * 删除潜在客户
     */
    @RequestMapping("deleteCustomerById")
    public String deleteCustomerById(Model model,@RequestParam("id") Integer[] id){
        for (Integer integer : id) {
            ps.deleteByPrimaryKey(integer);
        }
        this.selectCustomer(model);
        return "pages/potential_customer";
    }

    /**
     * 跟进客户方法
     */
    @RequestMapping("newCoustomer")
    public String newCoustomer(HttpSession session,Model model,String name ,String type,String illName,String tel,String email,String address,Integer followPeople,String remake){
        CompanyCustomer cct=new CompanyCustomer();
        cct.setAddress(address);
        cct.setCustomerName(name);
        cct.setCustomerType(type);
        cct.setFollowPerson(followPeople);
        cct.setLegalPerson(illName);
        cct.setTel(tel);
        cct.setEmail(email);
        PotentialCustomer pc= (PotentialCustomer) session.getAttribute("pl");
        Integer rid=pc.getRid();
        cct.setRemarks(remake);
        int num=ccs.insert(cct);
        if(num!=0){

            ps.deleteByPrimaryKey(rid);
            this.selectCustomer(model);
            return "pages/potential_customer";
        }
        return "pages/newCustomer";
    }

    /**
     * 查询跟进人员
     */

    @RequestMapping("selectFollowPeople")
    public String selectFollowPeople( Model model,Integer id){
        Map<String, Object> customer=ps.selectById(id);
        System.out.println("customer---->"+customer);
        model.addAttribute("customer",customer);
        List<Map<String,Object>> list= user.selectAll();
        System.out.println("list=====>>"+list);
        model.addAttribute("list",list);
        return "pages/customerTo";
    }

    /**
     * 划转潜在客户方法
     */
    @RequestMapping("customerTo")
    public String customerTo(Integer rid,Integer followPerson,Model model){
        int num=ps.updatePerson(followPerson,rid);
        if(num!=0){
            this.selectCustomer(model);
            return "pages/potential_customer";
        }
        return "pages/customerTo";
    }

    /**
     * 划转我的客户方法
     */
    @RequestMapping("MycustomerTo")
    public String MycustomerTo(Integer rid,Integer followPerson,Model model){
        int num=ps.updatePerson(followPerson,rid);
        if(num!=0){
            this.selectCustomer(model);
            Map<String,Object> map=ps.selectById(rid);
            if(map.get("SIGNED").equals("是")){
                this.myCustomer(model);
                return "pages/my_Customer";
            }
            return "pages/potential_customer";
        }
        return "pages/customerTo";
    }


    /**
     * 查询我的客户
     */

    @RequestMapping("myCustomer")
    public String myCustomer(Model model){
        List list=ps.pc();
        model.addAttribute("mc",list);
        System.out.println("mc=====>"+list);
        return "pages/my_Customer";
    }




}
