package com.yc137.controller;


import com.yc137.service.ContractRejectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes(value = {"conAll"})
@RequestMapping("contractReject")
public class ContractRejectController {
    @Autowired
    ContractRejectService contractRejectService;

    /**
     * 查询所有合同
     */
    @RequestMapping("selectAll")
    public String selectAll(Model model){
        List list=contractRejectService.selectAll();
        model.addAttribute("conAll",list);
        return "pages/contractInfo_failed";
    }

    /**
     * 根据ID删除合同
     */
    @RequestMapping("deleteById")
    public String deleteById(Integer id,Model model) {
        contractRejectService.deleteByPrimaryKey(id);
        this.selectAll(model);
        return "pages/contractInfo_failed";
    }
}
