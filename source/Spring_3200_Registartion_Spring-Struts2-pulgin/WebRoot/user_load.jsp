<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_load.jsp' starting page</title>
    
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
    <h1 align="center">用户注册信息修改页面</h1>
    <form action="user_update.action" method="post">
           用户ID:   <input type="text" name="id" value="<s:property value="userDto.id"/>"/><br/>"
           用户名：      <input type="text" name="username" value="<s:property value="userDto.username"/>"/><br/>
           用户密码： <input type="text" name="password" value="<s:property value="userDto.password"/>"/><br/>
            确认密码: <input type="text" name="password" value="" disabled="disabled"/><br/>
    </form>
  </body>
</html>
