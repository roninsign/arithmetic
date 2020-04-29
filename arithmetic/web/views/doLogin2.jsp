<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>做题,一次出一道题</title>
    <style type="text/css">
        body{
            background-image: url("image/3.png");
            background-size: cover;
        }
        .font{font-size:30px}
    </style>
</head>
<body>
<center>

    <table border="1" style="margin-top: 200px" class="font">
        <form action="${pageContext.request.contextPath}/upTitle?state=begin2" method="post">
            <c:forEach items="${list}"  var="algo" varStatus="status">
                <c:if test="${status.index+1==i}">
                    <tr>
                        <td>
                                ${i} / ${count}
                        </td>
                        <td>
                                ${algo} = <input type="text" value="" name="${i}.2" style="width:50px;height:40px;" required="required" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();">
                        </td>
                        <td hidden><input type="text" value="${algo}" name="${i}.1" style="width:50px;" ></td>
                        <td hidden><input type="text" value="${i}" name="i" style="width:50px;" ></td>
                        <td hidden><input type="text" value="${right}" name="right" style="width:50px;" ></td>
                        <td>
                            <c:if test="${i==count}">
                                <c:if test="${language==1}">
                                    <input type="submit" style="width:100px;height:40px" value="结束做题">
                                </c:if>
                                <c:if test="${language==2}">
                                    <input type="submit" value="The end of the problem">
                                </c:if>
                            </c:if>
                            <c:if test="${i<count}">
                                <c:if test="${language==1}">
                                    <input type="submit" style="width:100px;height:40px" value="下一题">
                                </c:if>
                                <c:if test="${language==2}">
                                    <input type="submit" value="Next question">
                                </c:if>
                            </c:if>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>

            <c:forEach items="${titleResult}"  var="Tresult" varStatus="status">
                <tr hidden >
                    <td hidden><input type="text" value="${Tresult}" name="${status.index}.5" style="width:50px;" ></td>
                </tr>
            </c:forEach>
            <c:forEach items="${rightNum}"  var="algo" varStatus="status">
                <tr hidden >
                    <td hidden><input type="text" value="${algo}" name="${status.index}.6" style="width:50px;" ></td>
                </tr>
            </c:forEach>



        </form>
    </table>




</center>
</body>
</html>
