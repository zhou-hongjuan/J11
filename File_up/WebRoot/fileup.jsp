<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'uplog.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  	<%	String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
  		System.out.print(uploadFilePath);
  	 %>
  <body>
    <form action="<%=basePath %>servlet/upFiles" method="post" enctype="multipart/form-data">
    	姓名:<input type="text" name="username"><br>
    	文件：<input type="file" name="myfile"><br>
		<input type="submit" value="上传"> 
    </form>
  </body>
</html>
