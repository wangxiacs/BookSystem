<%--
  Created by IntelliJ IDEA.
  User: ozc
  Date: 2017/3/29
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>前台页面</title>
  </head>

  <frameset rows="25%,*">
    <frame src="${pageContext.request.contextPath}/client/head.jsp" name="head"/>
    <frame src="${pageContext.request.contextPath}/IndexServlet" name="body"/>
  </frameset>


<%
  request

%>

</html>
