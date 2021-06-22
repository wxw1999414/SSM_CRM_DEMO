package com.yc137.controller;

import cn.hutool.core.convert.ConverterRegistry;
import com.yc137.domain.FollowsRecord;
import com.yc137.service.FollowsRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("follows")
@SessionAttributes(value = {"map","followsRecord"})
public class FollowsRecordController {

    @Autowired
    FollowsRecordService follows;

    @RequestMapping("followSession")
    public String followSession(Integer id, Model model, HttpSession session){
        List list= (List) session.getAttribute("mc");
        Map map= (Map) list.get(id-1);
        System.out.println("map===>"+map);
        model.addAttribute("map",map);
        return "pages/follow_process";
    }


    /**
     * 跟进过程
     * @return
     */
    @RequestMapping("addRecord")
    public String addRecord(Integer customerId,String recordContent,String recordTime,Integer FOLLOW_PERSON,String nextFollow){
        FollowsRecord fr=new FollowsRecord();
        fr.setCustomerId(customerId);
        fr.setRecordContent(recordContent);
        fr.setRecordId(FOLLOW_PERSON);
        ConverterRegistry converterRegistry=ConverterRegistry.getInstance();
        LocalDateTime record=converterRegistry.convert(LocalDateTime.class,recordTime);
        LocalDate nexttime=converterRegistry.convert(LocalDate.class,nextFollow);
        fr.setRecordTime(record);
        fr.setNextFollow(nexttime);
        int num=follows.insert(fr);
        if(num!=0){
            return "pages/my_Customer";
        }
        return "pages/follow_process";
    }

    /**
     * 跟进记录
     */

    @RequestMapping("findRecord")
    public String findRecord(Integer id,Model model){
        List<Map<String, Object>> followsRecord=follows.selectByPrimaryKey(id);
        model.addAttribute("followsRecord",followsRecord);
        System.out.println("followsRecord===>"+followsRecord);
        return "pages/FollowsRecordInfo";
    }

    /**
     * 根据ID删除跟进记录
     */
    @RequestMapping("deleteById")
    public String deleteById(Integer rid,Model model,Integer CUSTOMER_ID){
        follows.deleteByPrimaryKey(rid);
        this.findRecord(CUSTOMER_ID,model);
        return "pages/FollowsRecordInfo";
    }
}


