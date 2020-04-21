<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>全部成绩</title>
    <style type="text/css">
        body{
            background-image: url("image/1.png");
            background-size: cover;
        }
        .font{font-size:20px}
    </style>

</head>
<body>
<form  action="${pageContext.request.contextPath}/Algo?state=return" method="post">
    <div style="margin-top: 50px;margin-left: 80%">
        <c:if test="${language==1}">
            <input type="submit" value="返回页面" style="width: 100px;height:45px">
        </c:if>
        <c:if test="${language==2}">
            <input type="submit" value="Return" style="width: 100px;height:45px">
        </c:if>
    </div>
</form>
<center>
    <table border="1" align="center" style="margin-top: 50px;text-align: center" class="font" >
        <tr align="center">
            <c:if test="${language==1}">
                <td>
                    姓名
                </td>
                <td>
                    学号
                </td>
                <td>
                    成绩(作对*题/共*题)
                </td>
                <td>
                    正确率
                </td>
                <td>
                    用时
                </td>
                <td>
                    做题时间
                </td>
            </c:if>
            <c:if test="${language==2}">
                <td>
                    username
                </td>
                <td>
                    studentNumber
                </td>
                <td>
                    Score(Do * questions/A total of * questions
                </td>
                <td>
                    The correct rate
                </td>
                <td>
                    Time to do the problem.
                </td>
                <td>
                    The current time
                </td>
            </c:if>

        </tr>
        <c:forEach items="${list}"  var="user" varStatus="status">
            <tr  align="center">
                <td>${user.username}</td>
                <td>${user.studentNumber}</td>
                <td>${user.score}</td>
                <td>${user.accuracy}%</td>
                <td>${user.allTime}</td>
                <td>${user.currentDate}</td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
