package com.sliansoft.slianOA.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sliansoft.slianOA.dataaccess.model.OaAttachment;
import com.sliansoft.slianOA.service.OaAttachmentService;


@Controller
@RequestMapping(value = "/uploader")
public class UploaderController{
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private OaAttachmentService oaAttachmentService;
	
	
	@RequestMapping(value = "/uploader.do")
	public void upload(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("UTF-8");
		BufferedOutputStream outputStream=null; 
			
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setHeaderEncoding("UTF-8");//解决中文文件名乱码
				List<FileItem> items = upload.parseRequest(request);
				
				//设置保存文件的路径
//				String basePath=servletContext.getRealPath("/")+"/upload/";
//				String basePath=servletContext.getRealPath("/").substring(0, servletContext.getRealPath("/").lastIndexOf("\\"))+"/upload/news/";
				
				System.out.println(servletContext.getRealPath("/").lastIndexOf("slianOA-pc-web"));
				String basePath=servletContext.getRealPath("/").substring(0, servletContext.getRealPath("/").lastIndexOf("slianOA-pc-web"))+"/slianOA-upload/news/";

				File file =new File(basePath);
				if(!file.exists())
					file.mkdirs();
				//新文件名
				String newFileName = null;
				//根据路径保存文件，并获取新文件名称
				newFileName = writeImage(items, newFileName, basePath);
				
				//下面结果如http://localhost:8080/slianOA-upload
				String outPath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/slianOA-upload";
//				String outPath=request.getScheme()+"://"+request.getServerName()+request.getContextPath();//由于在服务器上，使用80端口，因此无需使用端口号
				
				String callback =request.getParameter("CKEditorFuncNum");// CKEditorFuncNum是CKEditor插件回调时显示的位置，这个参数必须有 

				response.getWriter().println("<script type=\"text/javascript\">");

				response.getWriter().println("window.parent.CKEDITOR.tools.callFunction("+ callback + ",'" + "/slianOA-upload"+"/news/"+ newFileName + "','')"); 

				response.getWriter().println("</script>");
				
			} catch (FileUploadException e) {
				e.printStackTrace();
				response.getWriter().write("上传失败，请重试！");
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("上传失败，请重试！");
			}finally{  
	            try {  
	            	if(outputStream!=null)
	            		outputStream.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }   
		}
	}
	
		
	private String writeImage(List<FileItem> items, String newFileName,
			String path) throws Exception {
		
		//路径不存在则创建
				File fl=new File(path);
				if(!fl.exists()){
					fl.mkdirs();
				}
				for (FileItem item : items) {
					if (!item.isFormField()) {// 如果是文件类型
						String name = item.getName();// 获得文件名
//						SimpleDateFormat dfs = new SimpleDateFormat("yyyyMMddhhmmss");
						
						//产生新的文件名
//						newFileName = name.substring(0, name.length()-(FilenameUtils.getExtension(name)).length()-1)+"_"+dfs.format(new Date())+"."+FilenameUtils.getExtension(name);
//						newFileName = dfs.format(new Date())+"."+FilenameUtils.getExtension(name);
						newFileName = UUID.randomUUID().toString().replace("-","")+"."+FilenameUtils.getExtension(name);
						
						if (name != null) {
							String nFname = newFileName;
							//写入图片到相应路径
							File savedFile = new File(path, name);//nFname
							int i = 1;
							newFileName = name;
							while(savedFile.exists()){
								if(name.indexOf(".") != -1){
									newFileName = name.substring(0, name.indexOf(".")) +"-"+i+name.substring(name.indexOf("."));
								}else{
									newFileName = name +"-"+i;
								}
								i++;
								savedFile = new File(path, newFileName);
							}
							item.write(savedFile);
						}
					}
				}
				return newFileName;
	}
	
	
	@RequestMapping(value = "/uploadFile.do")
	public String uploadFile(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("UTF-8");
		BufferedOutputStream outputStream=null; 
			
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setHeaderEncoding("UTF-8");//解决中文文件名乱码
			    request.setCharacterEncoding("UTF-8"); 

				
				String businessTable = request.getParameter("businessTable");
				
				String businessId = request.getParameter("businessId");
				//显示上传信息的ID
				String showUploadedFileLabelId =  request.getParameter("showUploadedFileLabelId");
				
				String uploadedFileName =  java.net.URLDecoder.decode(request.getParameter("fileName"), "UTF-8");
				String fileType =   java.net.URLDecoder.decode(request.getParameter("fileType"), "UTF-8");
				
				List<FileItem> items = upload.parseRequest(request);
				
				//设置保存文件的路径
//				String basePath=servletContext.getRealPath("/")+"/upload/";
				String basePath=servletContext.getRealPath("/").substring(0, servletContext.getRealPath("/").lastIndexOf("slianOA-pc-web"))+"/slianOA-upload/document/";;
				File file =new File(basePath);
				if(!file.exists())
					file.mkdirs();
				//新文件名
				String newFileName = null;
				//根据路径保存文件，并获取新文件名称
				newFileName = writeImage(items, newFileName, basePath);
				
				//下面结果如http://localhost:8080/csmp-merchant
				String outPath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
//				String outPath=request.getScheme()+"://"+request.getServerName()+request.getContextPath();//由于在服务器上，使用80端口，因此无需使用端口号
				
				String fileUrl=outPath +"/slianOA-upload/document/"+ newFileName;//newFileName
				String delDotFileName = newFileName.replace(".","");//去除文件名中的.
				//插入上传文件记录到oa_attachment
//				this.insertOaAttachment(fileUrl, uploadedFileName, businessTable, businessId, fileType,delDotFileName);
				
				System.out.println(delDotFileName);				
				response.setCharacterEncoding("utf-8");        
				response.setContentType("text/html; charset=utf-8");
				PrintWriter pr = response.getWriter();
				
				pr.println("<script type=\"text/javascript\">");
				
				//在前端显示已上传的信息
				pr.println("var tt = parent.document.getElementById('"+showUploadedFileLabelId+"').innerHTML");
				
//				System.out.println("parent.document.getElementById('"+showUploadedFileLabelId+"').innerHTML   = "
//						+ " tt+ ' &nbsp;&nbsp;<a class=\""+newFileName +"\" target=\"_blank\" href=\""+fileUrl+"\">"+uploadedFileName+"</a>[<label id=\""+newFileName +"\" onclick=\"deleteUploadFile(\\'"+newFileName+"\\')\">delete</label>]'");
				pr.println("parent.document.getElementById('"+showUploadedFileLabelId+"').innerHTML   = "
						+ " '<a class=\""+delDotFileName +"\" target=\"_blank\" href=\""+fileUrl+"\"> "+uploadedFileName+"</a>"
								+ "<label class=\""+delDotFileName +"\"onclick=\"deleteUploadFile(\\'"+businessTable+"\\',\\'"+businessId+"\\',\\'"+delDotFileName+"\\')\">[删除] </label>' +tt"); 
				
				pr.println("</script>");
				
//				this.addUploadedFilesToSession(businessTable, delDotFileName);
				
				if("oa_attachment".equals(businessTable)){
					OaAttachment oa = new OaAttachment();					
					oa.setAttachmentPath(fileUrl);
					oa.setTitle(delDotFileName);
					oa.setAttachmentName(uploadedFileName);
					oa.setBusinessTable(businessTable);
					oa.setType(fileType);
					oaAttachmentService.insert(oa);
					return null;
				}
				this.addUploadedFileAttributesToSession(fileUrl, uploadedFileName, businessTable, businessId, fileType, delDotFileName);
				
			} catch (FileUploadException e) {
				e.printStackTrace();
				response.getWriter().write("上传失败，请重试！");
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("上传失败，请重试！");
			}finally{  
	            try {  
	            	if(outputStream!=null)
	            		outputStream.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }   
		}
		return null;
	}

	/**
	 * 将上传文件的信息保存到session中，附件所属的记录保存或修改时，再从session中取出保存到数据库中
	 * @param fileUrl
	 * @param fileName
	 * @param businessTable
	 * @param businessId
	 * @param fileType
	 * @param delDotFileName
	 */
	private void addUploadedFileAttributesToSession(String fileUrl,String fileName,String businessTable,String businessId,String fileType,String delDotFileName){
		

		List<OaAttachment> oaAttachments = session.getAttribute(businessTable) ==null?null :(List<OaAttachment> )session.getAttribute(businessTable);
		
		if(oaAttachments == null){
			
			oaAttachments = new ArrayList<OaAttachment>();
			
		}
		
		OaAttachment oa = new OaAttachment();
		
		oa.setAttachmentPath(fileUrl);
		oa.setTitle(delDotFileName);
		oa.setAttachmentName(fileName);
		oa.setBusinessTable(businessTable);
		if(!StringUtils.isEmpty(businessId)){
			oa.setBusinessId(Integer.parseInt(businessId));
		}
		
		
		//业务表记录保存后添加 businessId
		//oa.setBusinessId(Integer.parseInt(businessId));
		oa.setType(fileType);
		
		oaAttachments.add(oa);
		
		session.setAttribute(businessTable, oaAttachments);
		
		
	}


}
