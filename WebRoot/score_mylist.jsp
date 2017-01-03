<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>我的成绩</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/inc/style.css"/>">
    <script type="text/javascript" src="<s:url value="/js/jquery.js"/>"></script>
</head>
<body>
<center>
    <s:action name="header" executeResult="true" namespace="/"/>
    <table width="900">
        <tr>
            <td height="30">当前位置>>我的成绩</td>
        </tr>
    </table>
    <table width="900" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC" bordercolordark="#FFFFFF"  bordercolorlight="#888888">
        <tr bgcolor="#DDDDEE">
            <td height="35" width="10%">试题编号</td>
            <td width="30%">试题名称</td>
            <td width="15%">试题总分</td>
            <td width="15%">我的得分</td>
            <td width="30%">考试时间</td>
        </tr>
        <s:iterator value="list" id="f">
            <tr>
                <td height="35"><s:property value="#f.eid"/></td>
                <td><s:property value="#f.etitle"/></td>
                <td><s:property value="#f.totalscore"/></td>
                <td><s:property value="#f.score"/></td>
                <td><s:date name="#f.createTime" format="yyyy-MM-dd HH:mm:ss" /></td>
            </tr>
        </s:iterator>
    </table>
    <jsp:include page="/footer.jsp"/>
</center>
</body>
</html>
