<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功上传文件</title>
    <style type="text/css">
        body{
            background-image: url("image/tii55mg.jpeg");
            background-size: cover;
        }
    </style>
</head>
<body>
<center>
    <div style="margin-top: 200px">
        <%--题目一个一个的出现--%>
        <form action="${pageContext.request.contextPath}/upTitle?state=begin" method="post">
            <%--中文--%>
            <c:if test="${language==1}">
                <input type="submit" value="题目一个接一个显示">
            </c:if>
            <%--yingwen --%>
            <c:if test="${language==2}">
                <input type="submit" value="One by one">
            </c:if>
        </form>
        <%--题目全部出现--%>
        <form action="${pageContext.request.contextPath}/upTitle?state=begin3" method="post">
            <c:if test="${language==1}">
                <input type="submit" value="题目全部显示">
            </c:if>
            <c:if test="${language==2}">
                <input type="submit" value="show all">
            </c:if>
        </form>
        <%--中文--%>
        <c:if test="${language==1}">
            已成功上传文件，点击做题即开始计时
        </c:if>
        <%--英文--%>
        <c:if test="${language==2}">
            The file has been uploaded successfully. Click to start the timer.
        </c:if>
    </div>
</center>
</body>
</html>
