<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>题目编辑</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/inc/style.css"/>">
    <script type="text/javascript" src="<s:url value="/js/jquery.js"/>"></script>
</head>
<body>
<center>
    <s:action name="header" executeResult="true" namespace="/"/>
    <table width="900">
        <tr>
            <td height="30">当前位置>>题目编辑</td>
        </tr>
    </table>
    <table width="900" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC" bordercolordark="#FFFFFF"  bordercolorlight="#888888">
        <tr>
            <td align="center">
                <s:actionmessage cssStyle="color:red"/>
                <table width="100%">
                    <form id="J_form" action="<s:url value="/qamanager_doedit.action"/>" method="post">
                        <input type="hidden" name="qid" value="<s:property value="model.qid"/>">
                        <tr>
                            <th height="40" align="right" width="40%">所属试题：</th>
                            <td width="60%"><select name="eid" style="width:120px">
                                <s:iterator value="elist" id="f">
                                    <option value="<s:property value="#f.eid"/>" <s:if test="model.eid==#f.eid">selected="selected" </s:if>><s:property value="#f.etitle"/></option>
                                </s:iterator>
                            </select>
                            </td>
                        </tr>
                        <tr>
                            <th height="40" align="right">题目：</th>
                            <td><input type="text" name="qtitle" id="J_qtitle" value="<s:property value="model.qtitle"/>"/></td>
                        </tr>
                        <tr>
                            <th height="40" align="right">选项A：</th>
                            <td><input type="text" name="a1" id="J_a1" value="<s:property value="model.a1"/>"/></td>
                        </tr>
                        <tr>
                            <th height="40" align="right">选项B：</th>
                            <td><input type="text" name="a2" id="J_a2" value="<s:property value="model.a2"/>"/></td>
                        </tr>
                        <tr>
                            <th height="40" align="right">选项C：</th>
                            <td><input type="text" name="a3" id="J_a3" value="<s:property value="model.a3"/>"/></td>
                        </tr>
                        <tr>
                            <th height="40" align="right">选项D：</th>
                            <td><input type="text" name="a4" id="J_a4" value="<s:property value="model.a4"/>"/></td>
                        </tr>
                        <tr>
                            <th height="40" align="right">参考答案：</th>
                            <td><input type="text" name="answer" id="J_answer" value="<s:property value="model.answer"/>"/></td>
                        </tr>
                        <tr>
                            <th height="40" align="right">分值：</th>
                            <td><input type="text" name="score" id="J_score" value="<s:property value="model.score"/>"/></td>
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
            if($("#J_qtitle").val()==""){
                alert("试题名称不能为空！");
                return false;
            }
            if($("#J_a1").val()==""){
                alert("选项A不能为空！");
                return false;
            }
             if($("#J_a2").val()==""){
                alert("选项B不能为空！");
                return false;
            }
             if($("#J_a3").val()==""){
                alert("选项C不能为空！");
                return false;
            }
             if($("#J_a4").val()==""){
                alert("选项D不能为空！");
                return false;
            }
            return true;
        })
    })
</script>
</html>
