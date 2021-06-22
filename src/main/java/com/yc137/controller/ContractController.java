package com.yc137.controller;

import cn.hutool.core.date.DateUtil;
import com.yc137.domain.Contract;
import com.yc137.domain.ContractReject;
import com.yc137.service.ContractRejectService;
import com.yc137.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author William
 */
@Controller
@RequestMapping("contract")
@SessionAttributes(value = {"contracts","map"})
public class ContractController {

    @Autowired
    ContractService contractService;
    @Autowired
    ContractRejectService crs;
    /**
     * 查询所有合同
     */
    @RequestMapping("selectAll")
    public String selectAll(Model model,Contract contract){
        List<Map<String, Object>> list=contractService.selectAll(contract);
//        System.out.println(list);
        model.addAttribute("contracts",list);
        return "pages/contractInfo";
    }

    /**
     * 根据id删除合同
     */
    @RequestMapping("deleteById")
    public String deleteById(Model model,Integer id,Contract contract){
        contractService.deleteByPrimaryKey(id);
        this.selectAll(model,contract);
        return "pages/contractInfo";
    }


    @RequestMapping("checkContractById")
    public String checkContractById(Integer id, Model model){
        List<Map<String,Object>> map=  contractService.checkcontractById(id);
        System.out.println(map);
        model.addAttribute("map",map.get(0));
        return "pages/contractInfo_check";
    }

    /**
     * 合同状态
     */
    @RequestMapping("checkContract")
    public String checkContract(Model model,String reason,String state,String remake,HttpSession session,Contract contract){
        ContractReject reject=new ContractReject();
        Map<String,Object> map= (Map<String, Object>) session.getAttribute("map");
        Integer id= (Integer) map.get("RID");
        String num= (String) map.get("number");
        if(state.equals("未通过")){
            reject.setContractNumber(num);
            reject.setReason(reason);
            String time= DateUtil.today();
            System.out.println(time);
            reject.setTime(time);
            System.out.println(reject);
            ContractReject contractReject=crs.selectNumber(num);
            if(contractReject!=null){
                System.out.println(contractReject.getRid());
                crs.deleteByPrimaryKey(contractReject.getRid());
            }
            crs.insert(reject);
        }

        int cnum=contractService.updateById(id,state,remake);
        if(cnum!=0){
            this.selectAll(model,contract);
            return "pages/contractInfo";
        }
        return "pages/contractInfo_check";
    }

    /**
     * 合同完成
     */
    @RequestMapping("stopContract")
    public String stopContract(Contract contract,Model model){
        contractService.updateByPrimaryKeySelective(contract);
        System.out.println("contract=========>"+contract.getState()+contract.getRid());
        this.selectAll(model,contract);
        return "pages/contractInfo";
    }

    /**
     * 根据条件查询合同合同
     */
    @RequestMapping("contractIng")
    public String contractIng(Contract contract,Model model){
        List<Map<String,Object>> list=contractService.selectAll(contract);
        System.out.println("执行中的合同=====》"+list);
        model.addAttribute("contracting",list);
        return "pages/contracting";
    }


}
