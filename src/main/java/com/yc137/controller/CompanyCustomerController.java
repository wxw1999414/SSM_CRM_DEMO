package com.yc137.controller;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.yc137.domain.CompanyCustomer;
import com.yc137.domain.CompanyCustomerAccessories;
import com.yc137.service.CompanyCustomerAccessoriesService;
import com.yc137.service.CompanyCustomerService;
import com.yc137.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("companyCustomer")
@SessionAttributes(value = {"customerInfo","tuser","customer"})
public class CompanyCustomerController {

    @Autowired
    CompanyCustomerService customerService;
    @Autowired
    TUserService tuser;
    @Autowired
    CompanyCustomerAccessoriesService ccas;
    /**
     * 查询所有客户资料
     * @param model
     * @return
     */
    @RequestMapping("selectAll")
    public String selectAll(Model model){
        List<Map<String, Object>> list=customerService.selectAll();
//        PageHelper.startPage(1,5);
//        PageInfo<List<Map<String, Object>>> pageInfo=new PageInfo(list);
//        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("customerInfo",list);
        List<Map<String,Object>> map=  tuser.selectAll();
        model.addAttribute("tuser",map);
//        System.out.println(map);
        System.out.println(list.toString());
        return "pages/companyCustomerInfo";
    }

    /**
     * 添加客户资料
     * @param customer
     * @param model
     * @return
     */
    @RequestMapping("companyCustomerAdd")
    public String companyCustomerAdd(Model model,CompanyCustomer customer){
        int num=customerService.insert(customer);
        if(num!=0){
            this.selectAll(model);
        }
        return "pages/companyCustomerInfo";
    }

    /**
     * 修改客户资料
     */

    @RequestMapping("sessionCompanyCustomerById")
    public String sessionCompanyCustomerById(Model model,Integer id){
        CompanyCustomer customer=customerService.selectByPrimaryKey(id);
        model.addAttribute("customer",customer);
        System.out.println(customer.toString());
        return "pages/companyCustomerUpdate";
    }

    @RequestMapping("companyCustomerUpdate")
    public String companyCustomerUpdate(CompanyCustomer customer,Model model){
        int num=customerService.updateByPrimaryKey(customer);
        System.out.println(customer.toString());
        if(num!=0){
            this.selectAll(model);
        }
        return "pages/companyCustomerInfo";
    }

    /**
     * 根据ID删除
     */
    @RequestMapping("companyCustomerDelete")
    public String companyCustomerDelete(Model model,Integer id){
        customerService.deleteByPrimaryKey(id);
        this.selectAll(model);
        return "pages/companyCustomerInfo";
    }

    /**
     * 将客户资料导出为excel文件
     */

    @RequestMapping("downCustomerInfo")
    public String downCustomerInfo(HttpServletResponse response) {
//        response.reset();
//        response.setHeader("Content-disposition", "attachment; filename=customer.xlsx");
//        response.setContentType("application/excel");
        ExcelWriter writer= ExcelUtil.getWriter("D:\\customer.xlsx");
        List<Map<String,Object>> list=customerService.selectAll();
//        writer.merge(list.size()-1,"客户资料");
        writer.write(list,true);
        writer.close();
        return "pages/companyCustomerInfo";
    }

    /**
     * 上传客户附件
     */
    @RequestMapping("customerInfo")
    public String customerInfo(Integer rid,Model model){
        model.addAttribute("rid",rid);
        return "pages/UploadCompanyCustomerInfo";
    }
    @RequestMapping("uploadCustomerInfo")
    public String uploadCustomerInfo(@RequestParam(value = "fileName")MultipartFile file, Integer rid, HttpServletRequest request, Model model) {
        CompanyCustomerAccessories accessories=new CompanyCustomerAccessories();
        Upload upload=new Upload();
        upload.uploadFileM(file,request,model);
        accessories.setCustomerId(rid);
        String fname= (String) model.getAttribute("fname");
        String savePath=(String) model.getAttribute("filePath");
        LocalDateTime localDateTime = LocalDateTimeUtil.now();
        accessories.setAccessoriesTime(localDateTime);
        accessories.setAccessoriesName(fname);
        accessories.setSavePath(savePath);
        CompanyCustomerAccessories accessories1=ccas.selectByPrimaryKey(rid);
        if(accessories1!=null){
            ccas.deleteCustomerID(rid);
        }
        int num=ccas.insert(accessories);
        if(num!=0){
            return "pages/companyCustomerInfo";
        }
        return "pages/UploadCompanyCustomerInfo";
    }

    /**
     * 下载客户附件
     */
@RequestMapping("downLoadCustomerInfo")
    public void downLoadCustomerInfo(Integer rid,HttpServletResponse response) throws Exception {
        CompanyCustomerAccessories accessories=ccas.selectByPrimaryKey(rid);
        System.out.println(accessories.toString());
        Upload upload=new Upload();
        String fileName=accessories.getAccessoriesName();
        String path=accessories.getSavePath();
        upload.downloadFile(fileName,path,response);
    }

}
