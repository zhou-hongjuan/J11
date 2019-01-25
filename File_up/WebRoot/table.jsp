<%@page import="com.zhj.pojo.ImpService"%>
<%@page import="com.zhj.Service.Service"%>
<%@page import="com.zhj.dao.Filelog"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'table.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
		<% 
			Filelog file=new Filelog();
			Service service=new ImpService();
			List<Filelog> files=service.geList(file);
			request.setAttribute("files", files);
		 %>
		<a herf="fileup.jsp">添加</a>
		<table>
		<tr>
		<td>姓名</td>
		<td>文件名</td>
		<td>文件路径</td>
		<td>上传时间</td>
		<td>操作</td>
		</tr>
		<c:forEach  items="${files}"  var="file" varStatus="status">
		<tr>
    				<td>${file.fusername  }</td>
    				<td>${file.fname }</td>
    				<td>${file.fpath }</td>
    				<td>${file.fcreatetime }</td>
    				<td>
    					<a href="#">下载</a>
    					<a href="#">删除</a>
    				</td>
    			</tr>
	
		</c:forEach>
		</table>
		

  </body>
</html>
