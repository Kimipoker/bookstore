<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
  <head>
    
    <title>用户登录</title>
    
    <link rel="stylesheet" type="text/css" href="<s:url value="/inc/style.css"/>">
  </head>
  <body>
  <center>
  	<s:action name="header" executeResult="true" namespace="/"/>
  	<table width="900">
  		<tr>
	  		<td height="30">当前位置>>用户注册</td>
  		</tr>
  	</table>
  	<table width="900" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC" bordercolordark="#FFFFFF"  bordercolorlight="#888888">
  	   <tr>
  	     <td align="center">
  	       <table width="100%">	
	  		    <tr>
			  		<td align="center" height="200" style="font-size: 12pt">
			  		 <p>&nbsp;</p>
					 <p>恭喜,注册成功!</p>
					 <p><a href="<s:url value="/user_login.action"/>">点击登录系统</a></p>
			  		</td>
		  		</tr>
	  	   </table>	
  		 </td>
  	  </tr>	 
  	</table>
  </center>
  </body>
</html>
