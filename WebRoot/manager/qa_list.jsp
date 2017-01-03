<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>后台试题管理</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/inc/style.css"/>">
    <script type="text/javascript" src="<s:url value="/js/jquery.js"/>"></script>
</head>
<body>
<center>
    <s:action name="header" executeResult="true" namespace="/"/>
    <table width="900">
        <tr>
            <td height="30">当前位置>>后台试题管理</td>
        </tr>
    </table>
    <form id="J_form" action="<s:url value="/qamanager_list.action"/>" method="post">
        <table width="900">
            <tr>
                <td>试题：<select name="eid" style="width:120px">
                      <option value="0">请选择</option>
                      <s:iterator value="elist" id="f">
                           <option value="<s:property value="#f.eid"/>" <s:if test="model.eid==#f.eid">selected="selected" </s:if>><s:property value="#f.etitle"/></option>
                      </s:iterator>
                </select>
                    <input type="submit" value="查询"/></td>
            </tr>
        </table>
    </form>
    <table width="900" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC" bordercolordark="#FFFFFF"  bordercolorlight="#888888">
        <tr bgcolor="#DDDDEE">
            <td height="35" width="10%">编号</td>
            <td width="20%">题目</td>
            <td width="50%">选项</td>
            <td width="10%">分值</td>
            <td width="10%">操作</td>
        </tr>
        <s:iterator value="list" id="f">
            <tr>
                <td height="35"><s:property value="#f.qid"/></td>
                <td><s:property value="#f.qtitle"/></td>
                <td>
                    A：<s:property value="#f.a1"/><br>
                    B：<s:property value="#f.a2"/><br>
                    C：<s:property value="#f.a3"/><br>
                    D：<s:property value="#f.a4"/><br>
                </td>
                <td><s:property value="#f.score"/></td>
                <td><a href="<s:url value="/qamanager_edit.action"/>?qid=<s:property value="#f.qid"/>">编辑</a>&nbsp;&nbsp;<a href="<s:url value="/qamanager_delete.action"/>?eid=<s:property value="#f.eid"/>&qid=<s:property value="#f.qid"/>">删除</a></td>
            </tr>
        </s:iterator>
    </table>
    <jsp:include page="/footer.jsp"/>
</center>
</body>
</html>
