<%--
  Created by IntelliJ IDEA.
  User: ozc
  Date: 2017/4/12
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加分类</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/CategoryServlet?method=add" method="post">

    分类名称：<input type="text" name="name"><br>
    分类描述：<textarea name="description"></textarea><br>
    <input type="submit" value="提交">

</form>

</body>
</html>
