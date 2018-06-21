<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
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
    <h1 align="center">Spring-整合Hibernate,三层架构练习： 用户注册页面</h1> <br>
<div align="center">
    <form action="user_add.action" method="post" >
          用户姓名：<input type="text" name="username"><br>
         用户密码：<input type="text" name="password"><br>
         确认密码：<input type="text" name="password2"><br>
<input type="submit" value="注册"> <input type="reset" value="重置">
    </form>
</div>
  </body>
</html>
