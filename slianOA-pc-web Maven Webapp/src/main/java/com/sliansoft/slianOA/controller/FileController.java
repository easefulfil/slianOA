package com.sliansoft.slianOA.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.io.FileInputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.sliansoft.slianOA.service.OaAttachmentService;
import com.sliansoft.slianOA.dataaccess.model.OaAttachment;

@Controller
@RequestMapping("file")    
public class FileController {  
    /**  
     * 文件上传功能  
     * @param file  
     * @return  
     * @throws IOException   
     */  	
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private OaAttachmentService attachmentService;
	
    @RequestMapping(value="/upload",method=RequestMethod.POST)  
    @ResponseBody  
    public String upload(MultipartFile file,HttpServletRequest request) throws IOException{  
    	String path=servletContext.getRealPath("/").substring(0, servletContext.getRealPath("/").lastIndexOf("slianOA-pc-web"))+"/slianOA-pc-web/document/";
//        String path = request.getSession().getServletContext().getRealPath("upload");  
        String fileName = file.getOriginalFilename();    
        File dir = new File(path,fileName);          
        if(!dir.exists()){  
            dir.mkdirs();  
        }  
        //MultipartFile自带的解析方法  
        file.transferTo(dir);  
        return "ok!";  
    }  
      
    /**  
     * 文件下载功能  
     * @param request  
     * @param response  
     * @throws Exception  
     */  
    @RequestMapping("/down")  
    public String down(HttpServletRequest request,HttpServletResponse response) throws Exception{  
        //模拟文件，myfile.txt为需要下载的文件  
    	String attachmentId =request.getParameter("attachmentId");
    	String businessTable=request.getParameter("businessTable");
    	String businessId=request.getParameter("businessId");
    	OaAttachment oaAttachment = null;
    	System.out.println(attachmentId);
    	System.out.println(businessId);
    	System.out.println(businessTable);
    	if(attachmentId!=null&&attachmentId!=""){
    	    oaAttachment = attachmentService.getById(attachmentId);
    	}else{
    		oaAttachment = attachmentService.getByBusiness(businessTable,Integer.parseInt(businessId)).get(0);
    	}
    	System.out.println(oaAttachment.getAttachmentPath());
    	System.out.println(oaAttachment.getAttachmentName());
        String fileName = servletContext.getRealPath("/").substring(0, servletContext.getRealPath("/").lastIndexOf("slianOA-pc-web"))+"/slianOA-upload/document/"+oaAttachment.getAttachmentName();  
        //获取输入流  
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));  
        //假如以中文名下载的话  
        String filename = oaAttachment.getAttachmentName();  
        //转码，免得文件名中文乱码  
        filename = URLEncoder.encode(filename,"UTF-8");  
        //设置文件下载头  
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);    
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型    
        response.setContentType("multipart/form-data");   
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());  
        int len = 0;  
        while((len = bis.read()) != -1){  
            out.write(len);  
            out.flush();  
        }  
        out.close();  
        return "success";
     //   delete();
    }  
    
//    @RequestMapping("/delete")  
//    public void delete(HttpServletRequest request,HttpServletResponse response){
//    	String fileName = request
//    	String filePath = servletContext.getRealPath("/").substring(0, servletContext.getRealPath("/").lastIndexOf("slianOA-pc-web"))+"/slianOA-pc-web/document/mountain-1.jpg"; 
//    	System.out.println(fileName);
//        File mydelfile1 = new File(fileName);
//        if(mydelfile1.delete()){
//        	System.out.println("mydelfile1删除成功");
//        
//        }
//        File mydelfile2 = new File("http://localhost:8080/slianOA-pc-web/document/小女孩-8.jpeg");
//        if(mydelfile1.delete()){
//        	System.out.println("mydelfile2删除成功");
//        
//        }else{
//        	System.out.println("mydelfile2删除失败");
//        }
//    }
}  