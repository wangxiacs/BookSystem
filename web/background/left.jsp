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
    <title>Title</title>
</head>
<body>

<a href="#">分类管理</a>
<br>
<a href="${pageContext.request.contextPath}/background/addCategory.jsp" target="body">添加分类</a>
<br>
<a href="${pageContext.request.contextPath}/CategoryServlet?method=look" target="body">查看分类</a>


<br>
<br>
<a href="#">图书管理</a><br>
<a href="${pageContext.request.contextPath}/BookServlet?method=addUI" target="body">添加图书</a><br>
<a href="${pageContext.request.contextPath}/BookServlet?method=look" target="body">查看图书</a><br>

<br>
<br>

<a href="#">订单管理</a><br>
<a href="${pageContext.request.contextPath}/OrderServlet?state=false" target="body">待处理订单</a><br>
<a href="${pageContext.request.contextPath}/OrderServlet?state=true" target="body">已发货订单</a><br>

<br>
<br>

</body>
</html>
