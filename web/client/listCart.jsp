<%--
  Created by IntelliJ IDEA.
  User: ozc
  Date: 2017/4/16
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示购物车页面</title>
</head>
<body>
<c:if test="${empty(cart.map)}">

    您还没有购买过任何商品哦！！！
</c:if>


<table border="1px">
    <c:if test="${!empty(cart.map)}">
        <h1>您购物车下有如下的商品：</h1><br>

        <tr>
            <td>书名：</td>
            <td>作者：</td>
            <td>数量：</td>
            <td>价钱：</td>
        </tr>
        <c:forEach items="${cart.map}" var="cartItme">


            <tr>
                <td>${cartItme.value.book.name}</td>
                <td>${cartItme.value.book.author}</td>
                <td>${cartItme.value.quantity}</td>
                <td>${cartItme.value.price}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="2">总价：</td>
            <td colspan="2">${cart.price}</td>
        </tr>
    </c:if>
    <tr>
        <td colspan="2">
            <a href="">清空购物车</a>
        </td>
        <td colspan="2">
            <a href="${pageContext.request.contextPath}/CreateOrderServlet">生成订单</a>
        </td>
    </tr>
</table>


</body>
</html>
