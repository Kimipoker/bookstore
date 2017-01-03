<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>用户资料修改</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/inc/style.css"/>">
</head>
<body>
<center>
    <s:action name="header" executeResult="true" namespace="/"/>
    <table width="900">
        <tr>
            <td height="30">当前位置>>用户资料修改</td>
        </tr>
    </table>
    <table width="900" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC" bordercolordark="#FFFFFF"  bordercolorlight="#888888">
        <tr>
            <td align="center">
                <s:actionmessage cssStyle="color:red"/>
                <table width="100%">
                    <form id="J_form" action="<s:url value="/user_doedit.action"/>" method="post">
                        <input type="hidden" name="userId" value="<s:property value="model.userId"/>">
                        <tr>
                            <th height="40" align="right" width="40%">姓名：</th>
                            <td width="60%"><s:property value="model.userName"/></td>
                        </tr>
                        <tr>
                            <th height="40" align="right">性别：</th>
                            <td><s:property value="model.sex"/></td>
                        </tr>
                        <tr>
                            <th height="40" align="right">班级：</th>
                            <td><input type="text" name="cname" value="<s:property value="model.cname"/>"/></td>
                        </tr>
                        <tr>
                            <th height="40" align="right">注册时间：</th>
                            <td><s:date name="model.createTime" format="yyyy-MM-dd HH:mm:ss" /></td>
                        </tr>
                        <tr>
                            <td height="40" colspan="2" align="center">&nbsp;&nbsp;<input type="submit" value="修改"/>
                            &nbsp;&nbsp;<input type="button" onclick="javascript:history.back(-1)" value="返回"/>
                            </td>
                        </tr>
                    </form>
                </table>
            </td>
        </tr>
    </table>
    <jsp:include page="footer.jsp"/>
</center>
</body>
</html>
