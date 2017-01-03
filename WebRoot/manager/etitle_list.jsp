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
    <form id="J_form" action="<s:url value="/etitlemanager_doadd.action"/>" method="post">
        <table width="900">
            <tr>
                <td>新增试题   标题：<input type="text" id="J_etitle" name="etitle">&nbsp;&nbsp;
                    出题人:<input type="text" id="J_author" name="author" value="<s:property value="#session.manager.userName"/>"/>
                    <input type="submit" value="新增"/></td>
            </tr>
        </table>
    </form>

    <table width="900" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC" bordercolordark="#FFFFFF"  bordercolorlight="#888888">
        <tr bgcolor="#DDDDEE">
            <td height="35" width="10%">试题编号</td>
            <td width="35%">标题</td>
            <td width="20%">出题人</td>
            <td width="20%">注册时间</td>
            <td width="15%">操作</td>
        </tr>
        <s:iterator value="list" id="f">
            <tr>
                <td height="35"><s:property value="#f.eid"/></td>
                <td><s:property value="#f.etitle"/></td>
                <td><s:property value="#f.author"/></td>
                <td><s:date name="#f.createTime" format="yyyy-MM-dd HH:mm:ss" /></td>
                <td><a href="<s:url value="/etitlemanager_edit.action"/>?eid=<s:property value="#f.eid"/>">编辑</a>&nbsp;&nbsp;<a href="<s:url value="/qamanager_list.action"/>?eid=<s:property value="#f.eid"/>">题库</a></td>
            </tr>
        </s:iterator>
    </table>
    <jsp:include page="/footer.jsp"/>
</center>
<script type="text/javascript">
    $(function(){
        $("#J_form").submit(function(){
            if($("#J_etitle").val()==""){
                alert("试题名称不能为空！");
                return false;
            }
            if($("#J_author").val()==""){
                alert("出题人不能为空！");
                return false;
            }
            return true;
        })
    })
</script>
</body>
</html>
