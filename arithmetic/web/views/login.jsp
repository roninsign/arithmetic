<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>登录页面</title>

    <style type="text/css">
        body{
            background-image: url("image/2.png");
            background-size: cover;
        }
    </style>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        //切换验证码
        function refreshCode(){
            //1,获取验证码图片对象
            var vcode=document.getElementById("vcode");
            //2,设置其src属性，加时间戳
            vcode.src="${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
        }
    </script>
</head>
<body>

<center>

    <form action="${pageContext.request.contextPath}/user?state=login" method="post">

        <c:if test="${language==1}">
            <strong>学&nbsp;&nbsp;号:</strong><input  type="text" name="studentNumber" style="height: 35px;width: 300px;margin-top:30px "  required="required" placeholder="2018146397"><br>
            <strong>密&nbsp;&nbsp;码:</strong><input type="password" name="password"style="height: 35px;width: 300px;margin-top: 25px" required="required" ><br>
            <div class="form-inline">
                <strong style="height: 35px;width: 150px;position: relative;right: 52px;bottom:5px;margin-top:30px ">验证码:</strong ><input  type="text" name="verifycode" style="height: 35px;width: 200px;position: relative;right: 52px;bottom: 5px;margin-top:30px "  required="required" placeholder="请输入验证码"><br>
                <a href="javascript:refreshCode()">
                    <img src="${pageContext.request.contextPath}/checkCodeServlet" style="height: 35px;width: 100px;position: relative;left: 121px;bottom:70px;margin-top:30px "  title="看不清点击刷新" id="vcode"/>
                </a>
            </div>
            <input type="submit" value="登录" required="required" style="width: 100px;height: 35px;position: relative;left:10px;bottom:70px;margin-top: 25px">
        </c:if>
        <c:if test="${language==2}">
            <strong>Student number：</strong> <input  type="text" name="studentNumber" style="height: 35px;width: 300px;margin-top:30px "  required="required" placeholder="2018146397"><br>
            <strong> &nbsp;&nbsp;&nbsp;password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;</strong><input type="password" name="password"style="height: 35px;width: 300px;margin-top: 25px" required="required" ><br>
            <input type="submit" value="login" style="width: 100px;height: 35px;margin-top: 25px">
        </c:if>



    </form>
    <div>
        <a href="${pageContext.request.contextPath}/user?state=register" >

            <c:if test="${language==1}">
                <input type="submit" value="注册用户" style="width: 100px;height: 35px;position:relative;left: 120px;bottom: 146px;margin-top: 25px ">
            </c:if>
            <c:if test="${language==2}">
                <input type="submit" value="Register" style="width: 100px;height: 35px;margin-top: 25px">
            </c:if>
        </a>
        <c:if test="${language==1}">
            <h3 style="margin-top: 20px;" align="center"><font color="red">${msg1}</font></h3>
        </c:if>
        <c:if test="${language==2}">
            <h3 style="margin-top: 20px;" align="center"><font color="red">${msg2}</font></h3>
        </c:if>


    </div>

    <div class="alert alert-warning alert-dismissible" role="alert">
        <strong style="color:red ;height: 35px;width: 150px;position: relative;right: 40px;bottom:150px;margin-top:30px">${login_msg}</strong>
    </div>
</center>



</body>
</html>
