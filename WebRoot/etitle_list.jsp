<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>试卷列表</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/inc/style.css"/>">
</head>
<body>
<center>
    <s:action name="header" executeResult="true" namespace="/"/>
    <table width="900">
        <tr>
            <td height="30">当前位置>>试卷列表</td>
        </tr>
    </table>
    <table width="900" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC" bordercolordark="#FFFFFF"  bordercolorlight="#888888">
        <tr bgcolor="#DDDDEE">
            <td height="35" width="10%">试题编号</td>
            <td width="35%">标题</td>
            <td width="20%">出题人</td>
            <td width="20%">注册时间</td>
            <td width="15%">操作</td>
        </tr>
        <s:iterator value="etitlelist" id="f">
            <tr>
                <td height="35"><s:property value="#f.eid"/></td>
                <td><s:property value="#f.etitle"/></td>
                <td><s:property value="#f.author"/></td>
                <td><s:date name="#f.createTime" format="yyyy-MM-dd HH:mm:ss" /></td>
                <td><a href="<s:url value="/kaoshi_qalist.action"/>?eid=<s:property value="#f.eid"/>">进入考试</a></td>
            </tr>
        </s:iterator>
    </table>
    <jsp:include page="/footer.jsp"/>
</center>
</body>
</html>
