<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>

    <title>操作提示</title>

    <link rel="stylesheet" type="text/css" href="<s:url value="/inc/style.css"/>">
</head>
<body>
<center>
    <s:action name="header" executeResult="true" namespace="/"/>
    <table width="900">
        <tr>
            <td height="30">当前位置>>操作提示</td>
        </tr>
    </table>
    <table width="900" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC" bordercolordark="#FFFFFF"  bordercolorlight="#888888">
        <tr>
            <td align="center">
                <table width="100%">
                    <tr>
                        <td align="center" height="200" style="font-size: 12pt">
                            <s:actionmessage cssStyle="color:red"/>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</center>
</body>
</html>
