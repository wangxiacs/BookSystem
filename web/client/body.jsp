<%--
  Created by IntelliJ IDEA.
  User: ozc
  Date: 2017/4/12
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/client/body.css" type="text/css">
</head>
<body>

<div id="body">
    <div id="category">
        书籍分类 :
        <br>
        <c:forEach items="${categories}" var="categories">
            <li>
                <a href="${pageContext.request.contextPath}/ListBookServlet?category_id=${categories.id}">${categories.name}</a>
            </li>
        </c:forEach>
    </div>

    <div id="bookandpages">
        <c:forEach items="${page.list}" var="book">
        <div id="books">

                <div id="image">
                    <img src="${pageContext.request.contextPath}/image/${book.image}" width="83px" height="118px">
                </div>
                <div id="bookinfo">
                    <li>
                        书名：${book.name}
                    </li>
                    <li>价格：${book.price}</li>
                    <li>作者：${book.author}</li>
                    <li><a href="${pageContext.request.contextPath}/BuyServlet?book_id=${book.id}">购买</a></li>

                </div>


        </div>
            <%--这里要清除浮动，十分重要！--%>
            <div style="clear: both"></div>
        </c:forEach>

    </div>
    <div id="page">
        <jsp:include page="/client/page.jsp"/>
    </div>
</div>
</body>
</html>
