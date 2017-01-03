<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>密码修改</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/inc/style.css"/>">
    <script type="text/javascript" src="<s:url value="/js/jquery.js"/>"></script>
</head>
<body>
<center>
    <s:action name="header" executeResult="true" namespace="/"/>
    <table width="900">
        <tr>
            <td height="30">当前位置>>密码修改</td>
        </tr>
    </table>
    <table width="900" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC" bordercolordark="#FFFFFF"  bordercolorlight="#888888">
        <tr>
            <td align="center">
                <s:actionmessage cssStyle="color:red"/>
                <table width="100%">
                    <form id="J_form" action="<s:url value="/user_doModifyPass.action"/>" method="post">
                        <tr>
                            <th height="50" align="right" width="40%">旧密码：</th>
                            <td width="60%"><input type="password" id="J_oldPass" name="oldPass"/></td>
                        </tr>
                        <tr>
                            <th height="50" align="right">新密码：</th>
                            <td><input type="password" id="J_newPass" name="newPass"/></td>
                        </tr>
                        <tr>
                            <th height="50" align="right">重复新密码：</th>
                            <td><input type="password" id="J_reNewPass" name="reNewPass"/></td>
                        </tr>
                        <tr>
                            <td height="50" colspan="2" align="center">&nbsp;&nbsp;<input type="submit" value="修改"/></td>
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
            if($("#J_oldPass").val()==""){
                alert("请输入旧密码！");
                return false;
            }
            if($("#J_newPass").val()==""){
                alert("请输入新密码！");
                return false;
            }
            if($("#J_newPass").val()!=$("#J_reNewPass").val()) {
                alert("两次新密码输入不一致！");
                return false;
            }
            return true;
        })
    })
</script>
</body>
</html>
