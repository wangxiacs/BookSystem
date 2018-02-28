<%--
  Created by IntelliJ IDEA.
  User: ozc
  Date: 2017/4/12
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查看所有的分类</title>
</head>
<body>
<c:if test="${empty(list)}">

    暂时还没有分类数据哦，请你添加把
</c:if>
<c:if test="${!empty(list)}">

    <table border="1px">
        <tr>
            <td>分类名字</td>
            <td>分类描述</td>
            <td>操作</td>
        </tr>

    <c:forEach items="${list}" var="category">

        <tr>
            <td>${category.name}</td>
            <td>${category.description}</td>
            <td>
                <a href="#">删除</a>
                <a href="#">修改</a>
            </td>
        </tr>


    </c:forEach>

    </table>
</c:if>



</body>
</html>
