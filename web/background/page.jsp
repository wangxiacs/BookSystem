<%--
  Created by IntelliJ IDEA.
  User: ozc
  Date: 2017/3/1
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--显示当前页数--%>
当前页数是：[${page.currentPageCount}]&nbsp;&nbsp;&nbsp;

<%--如果当前的页码大于1，才显示上一步--%>
<c:if test="${page.currentPageCount>1}">

    <%--把传递过去的页码-1就行了--%>
    <a href="${page.url}?currentPageCount=${page.currentPageCount-1}&method=look">
        上一步
    </a>
</c:if>


<%--提供页数的界面--%>
<c:forEach var="pageNum" begin="${page.startPage}" end="${page.endPage}">
    <a href="${page.url}?currentPageCount=${pageNum}&method=look">
        [${pageNum}]&nbsp;
    </a>
</c:forEach>

<%--如果当前的页码小于总页数，才显示下一步--%>
<c:if test="${page.currentPageCount<page.totalPageCount}">

    <%--把传递过去的页码-1就行了--%>
    <a href="${page.url}?currentPageCount=${page.currentPageCount+1}&method=look">
        下一步
    </a>&nbsp;&nbsp;
</c:if>

<input type="text" id="currentPageCount">
<input type="button" value="跳转" onclick="goPage()">

总页数是：${page.totalPageCount}&nbsp;&nbsp;

总记录数是：${page.totalRecord}


<script type="text/javascript">

    /*既然写上了JavaScript代码了，就顺便验证输入框输入的数据是否合法吧*/
    function goPage() {

        /*获取输入框控件*/
        var input = document.getElementById("currentPageCount");

        /*获取输入框的数据*/
        var value = input.value;

        if(value==null || value==""){
            alert("请输入页码");
            return false;
        }

        if(!value.match("\\d+")){
            alert("请输入数字");
            return false;
        }

        if(value<1 || value>${page.totalPageCount}){
            alert("请输入合法数据");
            return false ;
        }

        window.location.href="${page.url}?currentPageCount="+value+"&method=look";
    }

</script>