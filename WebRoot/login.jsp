<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
  <head>
    <title>用户登录</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/inc/style.css"/>">
    <script type="text/javascript" src="<s:url value="/js/jquery.js"/>"></script>
  </head>
  <body>
  <center>
  	<s:action name="header" executeResult="true" namespace="/"/>
  	<table width="900">
  		<tr>
	  		<td height="30">当前位置>>用户登录</td>
  		</tr>
  	</table>
  	<table width="900" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC" bordercolordark="#FFFFFF"  bordercolorlight="#888888">
  	   <tr>
  	     <td align="center">
             <s:actionmessage cssStyle="color:red"/>
  	       <table width="100%">
	  		<form id="J_form" action="<s:url value="/user_dologin.action"/>" method="post">
	  		    <tr>
			  		<th align="center" height="50" colspan="2" style="font-size: 12pt">用户登录</th>
		  		</tr>
		  		<tr>
			  		<th height="50" align="right" width="40%">账号：</th>
			  		<td width="60%"><input type="text" id="J_userId" name="userId"/></td>
		  		</tr>
	  		    <tr>
			  		<th height="50" align="right">密码：</th>
			  		<td><input type="password" id="J_password" name="password"/></td>
		  		</tr>
                <tr>
                    <th height="50" align="right">用户类型：</th>
                    <td><select name="role" style="width:150px">
                        <option value="0">学生</option>
                        <option value="1">老师</option>
                    </select> </td>
                </tr>
		  		<tr>
			  		<td height="50" colspan="2" align="center">&nbsp;&nbsp;<input type="submit" value="登录"/>&nbsp;<a href="<s:url value="/user_reg.action"/>">没有账号？现在去注册</a></td>
		  		</tr>
	  		</form> 
	  	   </table>	
  		 </td>
  	  </tr>	 
  	</table>
    <jsp:include page="footer.jsp"/>
  </center>
<script type="text/javascript">
   $(function(){
      $("#J_form").submit(function(){
         if($("#J_userId").val()==""){
            alert("请输入登录账号！");
            return false;
         }
         if($("#J_password").val()==""){
            alert("请输入密码！");
            return false;
         } 
         return true;
      })
   })
</script>
  </body>
</html>
