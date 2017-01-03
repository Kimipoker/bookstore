<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>试题编辑</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/inc/style.css"/>">
    <script type="text/javascript" src="<s:url value="/js/jquery.js"/>"></script>
</head>
<body>
<center>
    <s:action name="header" executeResult="true" namespace="/"/>
    <table width="900">
        <tr>
            <td height="30">当前位置>>试题编辑</td>
        </tr>
    </table>
    <table width="900" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC" bordercolordark="#FFFFFF"  bordercolorlight="#888888">
        <tr>
            <td align="center">
                <s:actionmessage cssStyle="color:red"/>
                <table width="100%">
                    <form id="J_form" action="<s:url value="/etitlemanager_doedit.action"/>" method="post">
                        <input type="hidden" name="eid" value="<s:property value="model.eid"/>">
                        <tr>
                            <th height="40" align="right" width="40%">试题名称：</th>
                            <td width="60%"><input type="text" id="J_etitle" name="etitle" value="<s:property value="model.etitle"/>"/></td>
                        </tr>
                        <tr>
                            <th height="40" align="right">出题人：</th>
                            <td><input type="text" name="author" id="J_author" value="<s:property value="model.author"/>"/></td>
                        </tr>
                        <tr>
                            <th height="40" align="right">创建时间：</th>
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
    <jsp:include page="/footer.jsp"/>
</center>
</body>
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
</html>
