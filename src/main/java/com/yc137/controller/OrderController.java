package com.yc137.controller;

import cn.hutool.core.convert.ConverterRegistry;
import cn.hutool.core.date.DateUtil;
import com.yc137.domain.OrderProcess;
import com.yc137.service.OrderProcessService;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Order")
@SessionAttributes(value = {"list","orderInfo","listInfo"})
public class OrderController {
    @Autowired
    OrderProcessService ops;

    /**
     * 查询所有订单列表
     */
    @RequestMapping("selectAll")
    public String selectAll(Model model){
        List<Map<String, Object>> list=ops.selectAll();
        System.out.println(list);
        model.addAttribute("list",list);
        return "pages/order_goods";
    };

    /**
     * 修改订单信息
     *
     */
    @RequestMapping("updateInfo")
    public String updateInfo(Model model,Integer id){
       Map<String, Object> orderList=  ops.selectById(id);
        model.addAttribute("orderInfo",orderList);
        System.out.println(orderList.toString());
        return "pages/order_update";
    }

    /**
     * @param model
     * @return
     */
    @RequestMapping("updateCustom")
    public String updateCustom(String orderGoodsTime,String customerGetTime, String state, String remarks,Integer rid,Model model){
        //String转化成LocalDateTime类型
        ConverterRegistry converterRegistry=ConverterRegistry.getInstance();
        LocalDateTime sendTime=converterRegistry.convert(LocalDateTime.class,orderGoodsTime);
        LocalDateTime getTime=converterRegistry.convert(LocalDateTime.class,customerGetTime);
        int num=ops.updateOrder( sendTime, getTime,  state,  remarks,rid);
        if(num!=0){
            this.selectAll(model);
            return "pages/order_goods";
        }
        return "pages/order_update";
    }


    /**
     * 删除订单
     */
    @RequestMapping("deleteById")
    public String deleteById(Integer id,Model model){
        ops.deleteByPrimaryKey(id);
        this.selectAll(model);
        return "pages/order_goods";
    }

    /**
     * 根据用户名查找该用户订单信息
     */
    @RequestMapping("selectByName")
    public void selectByName(String keywords, Model model, HttpServletResponse response) throws IOException {
        List listInfo=ops.selectByName(keywords);
        System.out.println(listInfo);
        model.addAttribute("listInfo",listInfo);
        response.getWriter().print("res");
    }

}
