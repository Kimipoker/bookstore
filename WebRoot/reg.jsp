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
  		   <td height="30">当前位置>>用户注册</td>
 		</tr>
  	</table>
  	<table width="900" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC" bordercolordark="#FFFFFF"  bordercolorlight="#888888">
  	   <tr>
  	     <td align="center">
  	       <table width="100%">	
	  		<form id="J_form" action="<s:url value="/user_doreg.action"/>" method="post">
	  		    <tr>
			  		<th align="center" height="50" colspan="2" style="font-size: 12pt">用户注册</th>
		  		</tr>
		  		<tr>
			  		<th height="50" align="right" width="40%">学号：</th>
			  		<td width="60%"><input id="J_userId" type="text" name="userId"/><font color="red">&nbsp;&nbsp;*</font></td>
		  		</tr>
	  		    <tr>
			  		<th height="50" align="right">密码：</th>
			  		<td><input type="password" id="J_password" name="password"/><font color="red">&nbsp;&nbsp;*</font></td>
		  		</tr>
		  		<tr>
			  		<th height="50" align="right">密码确认：</th>
			  		<td><input type="password" id="J_repassword" name="repassword"/><font color="red">&nbsp;&nbsp;*</font></td>
		  		</tr>
                <tr>
                    <th height="50" align="right" width="40%">班级：</th>
                    <td width="60%"><input type="text" id="J_cname" name="cname"/>&nbsp;&nbsp;</td>
                </tr>
		  		<tr>
			  		<th height="50" align="right" width="40%">真实姓名：</th>
			  		<td width="60%"><input type="text" id="J_userName" name="userName"/><font color="red">&nbsp;&nbsp;*</font></td>
		  		</tr>
		  		<tr>
			  		<th height="50" align="right" width="40%">性别：</th>
			  		<td width="60%"><select name="sex" style="width:120px">
			  		   <option value="男">男</option>
			  		   <option value="女">女</option>
			  		</select>&nbsp;&nbsp;(<font color="red">注册后不可再修改</font>)
                    </td>
		  		</tr>
		  		<tr>
			  		<td height="50" colspan="2" align="center">&nbsp;&nbsp;<input type="submit" value="注册"/>&nbsp;<a href="<s:url value="/user_login.action"/>">已有账号？现在去登录</a></td>
		  		</tr>
	  		</form> 
	  	   </table>	
  		 </td>
  	  </tr>	 
  	</table>
      <jsp:include page="footer.jsp"/>
  </center>
  </body>
  <script type="text/javascript">
   $(function(){
      $("#J_form").submit(function(){
         if($("#J_userId").val()==""){
            alert("账号不能为空！");
            return false;
         }
         if($("#J_password").val()==""){
            alert("密码不能为空！");
            return false;
         } 
         if($("#J_password").val()!=$("#J_repassword").val()){
             alert("两次密码输入不一致！");
             return false;
          } 
         if($("#J_userName").val()==""){
             alert("真实姓名不能为空！");
             return false;
         }
         return true;
      })
   })
</script>
</html>
