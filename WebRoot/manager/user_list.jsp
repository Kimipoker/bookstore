<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>后台用户管理</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/inc/style.css"/>">
</head>
<body>
<center>
    <s:action name="header" executeResult="true" namespace="/"/>
    <table width="900">
        <tr>
            <td height="30">当前位置>>后台用户管理</td>
        </tr>
    </table>
    <form action="<s:url value="/usermanager_list.action"/>" method="post">
        <table width="900">
            <tr>
                <td>学号：<input type="text" name="userId" value="<s:property value="userId"/>">&nbsp;&nbsp;<input type="submit" value="查询"/></td>
            </tr>
        </table>
    </form>
    <table width="900" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC" bordercolordark="#FFFFFF"  bordercolorlight="#888888">
        <tr bgcolor="#DDDDEE">
            <td height="35" width="20%"><s:if test='model.role=="0"'>学号</s:if><s:else>账号</s:else></td>
            <td width="20%">姓名</td>
            <td width="10%">性别</td>
            <td width="10%">班级</td>
            <td width="15%">角色</td>
            <td width="15%">注册时间</td>
            <td width="10%">操作</td>
        </tr>
        <s:iterator value="userlist" id="f">
          <tr>
            <td height="35"><s:property value="#f.userId"/></td>
            <td><s:property value="#f.userName"/></td>
            <td><s:property value="#f.sex"/></td>
            <td>&nbsp;<s:property value="#f.cname"/></td>
            <td><s:if test='#f.role=="1"'><font color="red">老师</font></s:if><s:else>学生</s:else> </td>
            <td><s:date name="#f.createTime" format="yyyy-MM-dd HH:mm:ss" /></td>
            <td><a href="<s:url value="/user_edit.action"/>?userId=<s:property value="#f.userId"/>">编辑</a></td>
           </tr>
        </s:iterator>
    </table>
    <jsp:include page="/footer.jsp"/>
</center>
</body>
</html>
