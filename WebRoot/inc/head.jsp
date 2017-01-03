<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<table width="900">
   <tr>
       <td height="120" background="<s:url value="/inc/header.jpg"/>"></td>
   </tr>
    <s:if test="#session.user!=null || #session.manager!=null">
   <tr>
		<td height="30">
            <s:if test="#session.user!=null">
                <s:property value="#session.user.userName"/>，欢迎回来！&nbsp;&nbsp;
                <a href="<s:url value="/kaoshi_etitlelist.action"/>">试题库</a>|
                <a href="<s:url value="/score_mylist.action"/>">我的成绩</a>|
                <a href="<s:url value="/user_modifyPass.action"/>">密码修改</a>|
                <a href="<s:url value="/user_logout.action"/>">退出</a>&nbsp;
            </s:if>
            <s:elseif test="#session.manager!=null">
                <s:property value="#session.manager.userName"/>，欢迎回来！
                <a href="<s:url value="/usermanager_list.action"/>?role=0">学生管理</a>|
                <a href="<s:url value="/usermanager_list.action"/>?role=1">老师管理</a>|
                <a href="<s:url value="/etitlemanager_list.action"/>">试卷管理</a>|
                <a href="<s:url value="/qamanager_list.action"/>?eid=1">题库管理</a>|
                <a href="<s:url value="/qamanager_add.action"/>">新增试题</a>|
                <a href="<s:url value="/score_list.action"/>">成绩管理</a>|
                <a href="<s:url value="/user_modifyPass.action"/>">密码修改</a>|
                <a href="<s:url value="/user_logout.action"/>">退出</a>&nbsp;
            </s:elseif>
		</td>
   </tr>
  </s:if>
</table>


