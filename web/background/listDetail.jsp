<%--
  Created by IntelliJ IDEA.
  User: ozc
  Date: 2017/4/17
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>详细信息</title>
</head>
<body>

<table border="1px">

   <tr>
       <td>书籍的编号</td>
       <td>价钱</td>
       <td>数量</td>
       <td>操作</td>
   </tr>
    <c:forEach items="${order.items}" var="item">
        <tr>
            <td>${item.book_id}</td>
            <td>${item.price}</td>
            <td>${item.quantity}</td>
            <td><a href="">修改</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
