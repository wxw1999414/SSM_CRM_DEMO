package com.yc137.controller;

import com.yc137.domain.Goods;
import com.yc137.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@SessionAttributes(value={"list","goodsInfo","goods"})
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    


    /**
     * 查找所有商品
     */

    @RequestMapping("selectAll")
    public String goodsAll(Model model){
        List<Goods> list=goodsService.selectAll();
        System.out.println(list);
        model.addAttribute("list", list);

        return "pages/goods";
    }

    /**
     * 添加商品
     */

    @RequestMapping("goodsAdd")
    public String goodsAdd(Model model,Goods goods){
        int num=goodsService.insert(goods);
        if(num!=0){
            this.goodsAll(model);
            return "pages/goods";
        }
        return "pages/goods_add";
    }

    /**
     * 修改商品信息
     */
    @RequestMapping("sessionUpdate")
    public String sessionUpdate(Integer id,Model model){
        Goods goods=goodsService.selectByPrimaryKey(id);
        model.addAttribute("goodsInfo",goods);
        return "pages/goods_update";
    }
    @RequestMapping("goodsUpdate")
    public String goodsUpdate(Goods goods,Model model){
        System.out.println(goods.getGoodsName());
        int num=goodsService.updateByPrimaryKey(goods);
        if(num!=0){
            this.goodsAll(model);
        }
        return "pages/goods";
    }

    /**
     * 删除商品
     */
    @RequestMapping("goodsDelete")
    public void goodsDelete(Integer id,Model model){
        System.out.println(id);
        goodsService.deleteByPrimaryKey(id);
        this.goodsAll(model);
//        return "pages/goods";
    }

    /**
     * 通过关键字查找商品
     */
    @ResponseBody
    @RequestMapping("goodsSelectByKey")
    public Goods goodsSelectByKey(String keywords, HttpServletResponse response,Model model) throws IOException {
        System.out.println(keywords);
        Goods goods=goodsService.selectByKey(keywords);
        response.getWriter().print("res");
        return goods;
    }

    /**
     * 购买商品
     */
    @RequestMapping("ByGoods")
    public String ByGoods(Model model){
        this.goodsAll(model);
        return "pages/ByGoods";
    }

    /**
     * 购买商品信息
     */
    @RequestMapping("byGoodsInfo")
    public String goodsInfo(){
        return "";
    }
}