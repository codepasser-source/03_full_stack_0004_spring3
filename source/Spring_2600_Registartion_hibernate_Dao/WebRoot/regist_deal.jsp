<%@ page language="java" import="java.util.*,com.baishui.service.*,com.baishui.model.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String username = request.getParameter("username");
String password = request.getParameter("password");
String password2 = request.getParameter("password2");

System.out.println("password:"+password);
User user = new User();
user.setUsername(username);
user.setPassword(password);

UserManager userMG = new UserManager();
boolean b =userMG.exists(user);

if(b){
	userMG.addUser(user);
	response.sendRedirect("regist_success.jsp");
}else{
	response.sendRedirect("regist_fail.jsp");
} 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist_deal.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	--> 
  </head> 
</html>
