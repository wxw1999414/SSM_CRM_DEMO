package com.yc137.controller;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Iterator;

@Controller
@Scope("prototype")
@SessionAttributes(value = {"fname","filePath"})
@RequestMapping(value = "/upload")
public class Upload {
        //上传文件
        @RequestMapping(value = "/uploadFile")
        public void uploadFileM(@RequestParam(value = "fileName") MultipartFile file,
                                HttpServletRequest request, Model model){
            String filepath=request.getServletContext().getRealPath("/")+"up_file";
            File fibak=new File(filepath);
            if (!fibak.exists()){
                fibak.mkdir();
            }
            //将文件名存入session
            model.addAttribute("fname",file.getOriginalFilename());
            System.out.println(file.getOriginalFilename());
            //获取上传文件的存放路径
            String path=filepath+"/"+file.getOriginalFilename();
            //将保存文件的路径存入session中
            model.addAttribute("filePath",path);
            //创建目标文件
            File targetFile = new File(path);
            //保存
            try {
                file.transferTo(targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //页面显示文件
//           File[] files= targetFile.listFiles();
//            request.setAttribute("files",files);
//
//            return new ModelAndView("pages/upload");
        }


    /**
     * 上传多个文件
     */
    @RequestMapping(value = "/uploadFiles")
    public ModelAndView uploadFiles(HttpServletRequest request){
        //将 请求转换为文件接收请求类
        MultipartHttpServletRequest mrequest =(MultipartHttpServletRequest)request;
        //获取请求中的 文件 名称
        Iterator<String> its = mrequest.getFileNames();
        while(its.hasNext()){
            MultipartFile mf = mrequest.getFile(its.next());
            //判断 文件是否为空
            if(mf!=null){
                //上传文件
                String savePath = request.getServletContext().getRealPath("/up_file/")+mf.getOriginalFilename();
                //创建文件 写
                File targetFile = null;
                targetFile = new File(savePath);
                try {
                    mf.transferTo(targetFile);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        //页面显示文件列表
        String appPath = request.getServletContext().getRealPath("/up_file");
        File f=new File(appPath);
        File[] fs = f.listFiles();
        request.getSession().setAttribute("files", fs);

        return  new ModelAndView("pages/upload");
    }

    /**
     * 下载文件
     */
    @RequestMapping("/download")
    public void downloadFile(String fileName,String filePathName,
                                     HttpServletResponse response) throws Exception {
        fileName = new String(fileName.getBytes("ISO-8859-1"),"utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
        //文件存放的路径
      //  String path = request.getServletContext().getRealPath("/up_file/")+fileName;
        String path=filePathName;
        //将路径指向的文件 转换为 File对象；
        FileInputStream inputStream = new FileInputStream(path);
        //将file 已 文件流的形式输出给请求端
        OutputStream os = response.getOutputStream();
        //读写 读写 读写....
        int length = 0;
        byte[] bt =new byte[1024];
        while((length=inputStream.read(bt))>0){
            os.write(bt,0,length);
        }
        os.close();
        inputStream.close();
    }


    //异步请求的方法
    @RequestMapping(value = "/checking")
    @ResponseBody
    public void checkName(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //获取名称
        String name =request.getParameter("checkName");
        //输出文件流
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/text");
        response.setCharacterEncoding("utf-8");

        if (name!=null&&!("").equals(name)&&name.matches("[a-z0-9A-Z]{3,}")){
            response.getWriter().print("用户名【"+name+"】可用....");
        }else{
            response.getWriter().print("用户名【"+name+"】不合法....");
        }



    }
}
