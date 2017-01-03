<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>在线考试</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/inc/style.css"/>">
    <script type="text/javascript" src="<s:url value="/js/jquery.js"/>"></script>
</head>
<body>
<center>
    <s:action name="header" executeResult="true" namespace="/"/>
    <table width="900">
        <tr>
            <td height="30">当前位置>>在线考试>><s:property value="emodel.etitle"/></td>
        </tr>
    </table>
    <table width="900" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC" bordercolordark="#FFFFFF"  bordercolorlight="#888888">
        <tr>
            <td align="center">
                <table width="100%">
                    <form id="J_form" action="<s:url value="/kaoshi_jiaojuan.action"/>" method="post">
                       <input type="hidden" name="eid" value="<s:property value="model.eid"/>">
                       <s:iterator value="qalist" id="q">
                            <tr>
                                <th height="50" align="left">题目：<s:property value="#q.qtitle"/></th>
                            </tr>
                           <tr>
                               <td><input type="radio" name="qa<s:property value="#q.qid"/>" value="A"/>A:<s:property value="#q.a1"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                   <input type="radio" name="qa<s:property value="#q.qid"/>" value="B"/>B:<s:property value="#q.a2"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                   <input type="radio" name="qa<s:property value="#q.qid"/>" value="C"/>C:<s:property value="#q.a3"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                   <input type="radio" name="qa<s:property value="#q.qid"/>" value="D"/>D:<s:property value="#q.a4"/>
                               </td>
                           </tr>
                       </s:iterator>
                        <tr>
                            <td height="50" colspan="2" align="center">&nbsp;&nbsp;<input type="submit" value="交卷"/></td>
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
            if(!confirm("确定要交卷吗？")){
                return false;
            }
            return true;
        })
    })
</script>
</body>
</html>
