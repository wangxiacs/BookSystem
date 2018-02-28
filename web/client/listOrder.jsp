<%--
  Created by IntelliJ IDEA.
  User: ozc
  Date: 2017/4/17
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>列出订单</title>
</head>
<body>

<c:if test="${empty(orders)}">
    您还没有下过任何订单！！111111
</c:if>

<c:if test="${!empty(orders)}">

    <table border="1px">

        <tr>
            <td>下单人：</td>
            <td>订单时间</td>
            <td>订单状态</td>
            <td>订单价钱</td>
        </tr>

        <c:forEach items="${orders}" var="order">

            <tr>
                <td>${user.username}</td>
                <td>${order.ordertime}</td>
                <td>${order.state==false?"未发货":"已发货"}</td>
                <td>${order.price}</td>
            </tr>

        </c:forEach>

    </table>

</c:if>
</body>
</html>
