<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎页面</title>

    <style type="text/css">
        body{
            background-image: url("image/ti432mg.png");
            background-size: cover;
        }
    </style>
</head>
<body>

<form  action="${pageContext.request.contextPath}/user?state=all" method="post">
    <div style="margin-top: 50px;margin-left: 65%">
        <c:if test="${language==1}">
            <input type="submit" value="查看个人历史成绩" style="width: 200px;height:45px">
        </c:if>
        <c:if test="${language==2}">
            <input type="submit" value="View historical results" style="width: 200px;height:45px">
        </c:if>
    </div>
</form>

<form  action="${pageContext.request.contextPath}/user?state=allUser" method="post">
    <div style="margin-top: 30px;margin-left: 65%">
        <c:if test="${language==1}">
            <input type="submit" value="查看全部用户成绩" style="width: 200px;height:45px">
        </c:if>
        <c:if test="${language==2}">
            <input type="submit" value="View all member scores" style="width: 200px;height:45px">
        </c:if>
    </div>
</form>
<form  action="${pageContext.request.contextPath}/user?state=logout" method="post">
    <div style="margin-top: 30px;margin-left: 65%">
        <c:if test="${language==1}">
            <input type="submit" value="退出登录" style="width: 200px;height:45px">
        </c:if>
        <c:if test="${language==2}">
            <input type="submit" value="Log out" style="width: 200px;height:45px">
        </c:if>
    </div>
</form>
<div style="margin-top: 30px;margin-left: 300px">
    <c:if test="${language==1}">
        <a href="${pageContext.request.contextPath}/Algo?state=Algo1" ><button><font size="4" >题目生成</font></button> </a>
        <br><br>
        <font size="5" ><strong>OR</strong></font><br><br>
        <table border="1" >
            <tr>
                <td>
                    <font size="4" >上传文件</font>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/upTitle?state=up" enctype="multipart/form-data" method="post">
                        <input type="file" name="file2" value="选择文件" required="required"/><br/><br>
                        <input type="submit"  size="3"/>
                    </form>
                </td>
            </tr>
        </table><br>  <br>
        <font color="red">${msg1}</font>
    </c:if>

</div>
<%--英文--%>
<div style="margin-top: 30px;margin-left: 300px">
    <c:if test="${language==2}">
        <a href="${pageContext.request.contextPath}/Algo?state=Algo1"><button><font size="4" >Subject generated</font></button> </a>
        <br><br>
        <font size="5" ><strong>OR</strong></font><br><br>
        <table border="1" >
            <tr>
                <td>
                    <button><font size="4" >Files Upload</font></button>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/upTitle?state=up" enctype="multipart/form-data" method="post">
                        <input  type="file" id="browsefile" style="visibility:hidden"  name="file"  required="required" onchange=filepath.value=this.value   ><br>
                        <input type="textfield" id="filepath">
                        <input type="button" id="filebutton" value="Select a File" onclick="browsefile.click()"><br/><br>
                        <input type="submit" value="submit" />
                    </form>
                </td>
            </tr>
        </table>
        <br>  <br>
        <font color="red">${msg2}</font>
    </c:if>

</div>

</body>
</html>
