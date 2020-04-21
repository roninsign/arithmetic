<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生成绩列表</title>
</head>
<style type="text/css">
    body{
        background-image: url("image/1.png");
        background-size: cover;
    }

    .font{font-size:20px}
</style>

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


    <table border="1" style="text-align: center" class="font" align="center">

        <c:if test="${language==1}">
            <tr>
                <th>
                    次数
                </th>
                <th>
                    成绩(作对*题/共*题)
                </th>
                <th>
                    正确率
                </th>
                <th>
                    用时
                </th>
                <th>
                    做题时间
                </th>
            </tr>
        </c:if>
        <c:if test="${language==2}">
            <tr>
                <th>
                    No
                </th>
                <th>
                    Score(Do * questions/A total of * questions
                </th>
                <th>
                    The correct rate
                </th>
                <th>
                    Time to do the problem.
                </th>
                <th>
                    The current time
                </th>
            </tr>
        </c:if>

        <c:forEach items="${list}"  var="user" varStatus="status">

            <tr>
                <td>${status.index+1}</td>
                <td>${user.score}</td>
                <td>${user.accuracy}%</td>
                <td>${user.allTime}</td>
                <td>${user.currentDate}</td>
            </tr>
        </c:forEach>


        <c:if test="${list== null || fn:length(list) == 0}">
            <h1 style="margin-top: 50px;color: red">暂无个人成绩!!!</h1>
        </c:if>
    </table>
</center>

</body>
</html>
