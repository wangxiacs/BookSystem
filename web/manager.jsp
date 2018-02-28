<%--
  Created by IntelliJ IDEA.
  User: ozc
  Date: 2017/4/12
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理</title>
</head>

<frameset rows="25%,*">
    <frame src="${pageContext.request.contextPath}/background/head.jsp"/>

    <frameset cols="15%,*">
        <frame src="${pageContext.request.contextPath}/background/left.jsp"/>
        <frame src="${pageContext.request.contextPath}/background/body.jsp" name="body"/>
    </frameset>
</frameset>

</html>
