<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s"  uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>userlist</title>
    
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
   <h2 align="center">用户列表</h2>
   <hr>
   
   <table width="68%" height="75%" border="0" bgcolor="#5a5a5a" align="center" cellpadding="2" cellspacing="2"> 
     <tr height="10" bgcolor="#ffffff">
       <td>用户ID</td>
       <td>用户名</td>
       <td>密码</td>
       <td>操作</td>
     </tr>
     <s:iterator var="user" value="users">
       <tr height="10" bgcolor="#ffffff">
       <td> <s:property value="#user.id"/> </td>
       <td> <s:property value="#user.username"/></td>
       <td><s:property value="#user.password"/></td>
        <td><a href="user_load?id=<s:property value="#user.id"/>">修改</a></td>
       </tr>
     </s:iterator> 
   </table>
   <s:debug></s:debug>
  </body>
</html>
