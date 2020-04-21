<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>登录页面</title>

    <style type="text/css">
        body{
            background-image: url("image/img1.png");
            background-size: cover;
        }
    </style>
</head>
<body>
<div>
    <a href="${pageContext.request.contextPath}/user?state=register" >

        <c:if test="${language==1}">
            <input type="submit" value="注册用户" style="width: auto;height: 35px;margin-top: 25px; margin-left: 75%">
        </c:if>
        <c:if test="${language==2}">
            <input type="submit" value="Register" style="width: auto;height: 35px;margin-top: 25px; margin-left: 75%">
        </c:if>
    </a>
    <c:if test="${language==1}">
        <h3 style="margin-top: 20px;" align="center"><font color="red">${msg1}</font></h3>
    </c:if>
    <c:if test="${language==2}">
        <h3 style="margin-top: 20px;" align="center"><font color="red">${msg2}</font></h3>
    </c:if>


</div>
<center>

    <form action="${pageContext.request.contextPath}/user?state=login" method="post">

        <c:if test="${language==1}">
            <strong>学号：</strong> <input  type="text" name="studentNumber" style="height: 35px;width: 300px;margin-top:30px "  required="required" placeholder="2017011000"><br>
            <strong> 密&nbsp;&nbsp;码:</strong><input type="password" name="password"style="height: 35px;width: 300px;margin-top: 25px" required="required" ><br>
            <input type="submit" value="登录" style="width: 100px;height: 35px;margin-top: 25px">
        </c:if>
        <c:if test="${language==2}">
            <strong>Student number：</strong> <input  type="text" name="studentNumber" style="height: 35px;width: 300px;margin-top:30px "  required="required" placeholder="2017011000"><br>
            <strong> &nbsp;&nbsp;&nbsp;password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;</strong><input type="password" name="password"style="height: 35px;width: 300px;margin-top: 25px" required="required" ><br>
            <input type="submit" value="login" style="width: 100px;height: 35px;margin-top: 25px">
        </c:if>


    </form>


</center>



</body>
</html>
