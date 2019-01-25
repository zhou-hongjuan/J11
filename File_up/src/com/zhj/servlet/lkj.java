package com.zhj.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zhj.Service.Service;
import com.zhj.dao.Filelog;
import com.zhj.pojo.ImpService;

public class lkj extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Filelog file = new Filelog();
		int bRet = 0;
		boolean bUpload = false;
		String fieldName = "";
		String uploadFileName = "";
		Service service = new ImpService();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String newtime = format.format(time);
		file.setFcreatetime(newtime);
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
		File saveDir = new File(uploadFilePath);
		// 如果目录不存在，就创建目录
		if (!saveDir.exists()) {
			saveDir.mkdir();
		}
		if (isMultipart) {
			// 创建文件上传核心类
			FileItemFactory factory = new DiskFileItemFactory();// 实例化一个硬盘文件工厂,用来配置上传组件ServletFileUpload
			ServletFileUpload upload = new ServletFileUpload(factory); // 用以上工厂实例化上传组件
			// 处理表单请求
			try {
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (item.isFormField()) {// 如果是普通表单控件
						fieldName = item.getFieldName();// 获得该字段名称
						if (fieldName.equals("username")) {
							file.setFusername(item.getString("UTF-8"));
						}
					} else {// 如果为文件域
						String fileName = item.getName();// 获得文件名(全路径)
						if (fileName != null && !fileName.equals("")) {
							File fullFile = new File(fileName);
							File saveFile = new File(uploadFilePath, fullFile.getName());// 将文件保存到指定的路径
							item.write(saveFile);
							uploadFileName = fullFile.getName();
							file.setFname(uploadFileName);
							file.setFpath(uploadFilePath + fullFile.getName());
							bUpload = true;

						}
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 调用后台的方法，将新闻信息插入数据库中
		bRet = service.addFile(file);
		if (bRet == 0) {
			response.sendRedirect("/File_up/fileup.jsp");
		} else {
			response.sendRedirect("/File_up/table.jsp");
		}
	}
		
	}



