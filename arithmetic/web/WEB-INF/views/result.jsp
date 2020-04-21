<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>做题结果</title>
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
            <input type="submit" value="返回页面" style="width: 150px;height:45px">
        </c:if>
        <c:if test="${language==2}">
            <input type="submit" value="Return" style="width: 200px;height:45px">
        </c:if>
    </div>
</form>
<form  action="${pageContext.request.contextPath}/user?state=all" method="post">
    <div style="margin-top: 10px;margin-left: 80%">
        <c:if test="${language==1}">
            <input type="submit" value="查看个人历史成绩" style="width: 150px;height:45px">
        </c:if>
        <c:if test="${language==2}">
            <input type="submit" value="View historical results" style="width: 200px;height:45px">
        </c:if>
    </div>
</form>

<form  action="${pageContext.request.contextPath}/user?state=allUser" method="post">
    <div style="margin-top: 10px;margin-left: 80%">
        <c:if test="${language==1}">
            <input type="submit" value="查看全部用户成绩" style="width:150px;height:45px">
        </c:if>
        <c:if test="${language==2}">
            <input type="submit" value="View all member scores" style="width: 200px;height:45px">
        </c:if>
    </div>
</form>

<center>
    <form action="${pageContext.request.contextPath}/upTitle?state=calculate" method="post">
        <%--题目数量小于十--%>
        <c:if test="${count<=10}">
            <table class="font" border="1" style="margin-top: 10px;margin-left: 100px;text-align: right" >
                <c:forEach items="${list}" var="algo" varStatus="status">
                    <tr>
                        <td>${status.index+1}</td>
                        <td>${algo}=
                            <c:forEach items="${titleResult}"  var="titleResult" varStatus="status1">
                                <c:if test="${status1.index==status.index}">
                                    <input type="text" value="${titleResult}"  style="width:50px;">
                                </c:if>
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <%--题目数量在10-40？--%>
        <div >

            <c:if test="${count>10&&count<=40}">
                <div id="1" style="display:inline-block;margin-left: 70px;margin-top: 50px;">
                    <table border="1" style="text-align: right" class="font">
                        <c:forEach items="${list}" var="algo" varStatus="status">
                            <c:if test="${status.index<=(count/2)}">
                                <tr>
                                    <td>${status.index+1}</td>
                                    <td>${algo}=
                                        <c:forEach items="${titleResult}"  var="titleResult" varStatus="status1">
                                            <c:if test="${status1.index==status.index}">
                                                <input type="text" value="${titleResult}"  style="width:50px;">
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>`
                <div id="1"  style="display:inline-block;margin-left: 30px;margin-top: 50px;vertical-align: top;">
                    <table border="1"  style="text-align: right" class="font" >
                        <c:forEach items="${list}"  var="algo" varStatus="status">
                            <c:if test="${status.index>(count/2)}">
                                <tr>
                                    <td>${status.index+1}</td>
                                    <td>${algo}=
                                        <c:forEach items="${titleResult}"  var="titleResult" varStatus="status1">
                                            <c:if test="${status1.index==status.index}">
                                                <input type="text" value="${titleResult}"  style="width:50px;">
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>
            </c:if>
        </div>
        <%--题目数量在40-60？--%>
        <div>
            <c:if test="${count>40&&count<=60}">
                <div id="2" style="display:inline-block;margin-left: 20px;margin-top: 20px;">
                    <table border="1"  style="text-align: right" class="font">
                        <c:forEach items="${list}"  var="algo" varStatus="status">
                            <c:if test="${status.index<=(count/3)}">
                                <tr>
                                    <td>${status.index+1}</td>
                                    <td>${algo}=
                                        <c:forEach items="${titleResult}"  var="titleResult" varStatus="status1">
                                            <c:if test="${status1.index==status.index}">
                                                <input type="text" value="${titleResult}"  style="width:50px;">
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>
                <div id="2"  style="display:inline-block;margin-left: 20px;margin-top: 20px;">
                    <table border="1"  style="text-align: right" class="font">
                        <c:forEach items="${list}"  var="algo" varStatus="status">
                            <c:if test="${(status.index<=(count/3)*2)&&status.index>(count/3)}">
                                <tr>
                                    <td>${status.index+1}</td>
                                    <td>${algo}=
                                        <c:forEach items="${titleResult}"  var="titleResult" varStatus="status1">
                                            <c:if test="${status1.index==status.index}">
                                                <input type="text" value="${titleResult}"  style="width:50px;">
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>
                <div id="2" style="display:inline-block;margin-left: 20px;margin-top: 20px;">
                    <table border="1"  style="text-align: right" class="font">
                        <c:forEach items="${list}"  var="algo" varStatus="status">
                            <c:if test="${(status.index>(count/3)*2)}">
                                <tr>
                                    <td>${status.index+1}</td>
                                    <td>${algo}=
                                        <c:forEach items="${titleResult}"  var="titleResult" varStatus="status1">
                                            <c:if test="${status1.index==status.index}">
                                                <input type="text" value="${titleResult}"  style="width:50px;">
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>
            </c:if>
        </div>
        <%--题目数量在60-80？--%>
        <div>
            <c:if test="${count>60&&count<=80}">
                <div id="3" style="display:inline-block;margin-left: 20px;margin-top: 20px;">
                    <table border="1"  style="text-align: right" class="font">
                        <c:forEach items="${list}"  var="algo" varStatus="status">
                            <c:if test="${status.index<=(count/4)}">
                                <tr>
                                    <td>${status.index+1}</td>
                                    <td>${algo}=
                                        <c:forEach items="${titleResult}"  var="titleResult" varStatus="status1">
                                            <c:if test="${status1.index==status.index}">
                                                <input type="text" value="${titleResult}"  style="width:50px;">
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>
                <div id="3"  style="display:inline-block;margin-left: 20px;margin-top: 20px;">
                    <table border="1"  style="text-align: right"  class="font">
                        <c:forEach items="${list}"  var="algo" varStatus="status">
                            <c:if test="${(status.index<=(count/4)*2)&&status.index>(count/4)}">
                                <tr>
                                    <td>${status.index+1}</td>
                                    <td>${algo}=
                                        <c:forEach items="${titleResult}"  var="titleResult" varStatus="status1">
                                            <c:if test="${status1.index==status.index}">
                                                <input type="text" value="${titleResult}"  style="width:50px;">
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>

                    </table>
                </div>
                <div id="3" style="display:inline-block;margin-left: 20px;margin-top: 20px;">
                    <table border="1"  style="text-align: right" class="font">
                        <c:forEach items="${list}"  var="algo" varStatus="status">
                            <c:if test="${(status.index>(count/4)*2)&&status.index<(count/4)*3}">
                                <tr>
                                    <td>${status.index+1}</td>
                                    <td>${algo}=
                                        <c:forEach items="${titleResult}"  var="titleResult" varStatus="status1">
                                            <c:if test="${status1.index==status.index}">
                                                <input type="text" value="${titleResult}"  style="width:50px;">
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>
                <div id="3" style="display:inline-block;margin-left: 20px;margin-top: 20px;">
                    <table border="1"  style="text-align: right" class="font">
                        <c:forEach items="${list}"  var="algo" varStatus="status">
                            <c:if test="${(status.index>(count/4)*3)}">
                                <tr>
                                    <td>${status.index+1}</td>
                                    <td>${algo}=
                                        <c:forEach items="${titleResult}"  var="titleResult" varStatus="status1">
                                            <c:if test="${status1.index==status.index}">
                                                <input type="text" value="${titleResult}"  style="width:50px;">
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>
            </c:if>
        </div>
        <%--题目数量在大于80？--%>
        <div>
            <c:if test="${count>80}">
                <div id="4" style="display:inline-block;margin-left: 20px;margin-top: 20px;">
                    <table border="1"  style="text-align: right" class="font">
                        <c:forEach items="${list}"  var="algo" varStatus="status">
                            <c:if test="${status.index<=(count/5)}">
                                <tr>
                                    <td>${status.index+1}</td>
                                    <td>${algo}=
                                        <c:forEach items="${titleResult}"  var="titleResult" varStatus="status1">
                                            <c:if test="${status1.index==status.index}">
                                                <input type="text" value="${titleResult}"  style="width:50px;">
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>
                <div id="4"  style="display:inline-block;margin-left: 20px;margin-top: 20px;">
                    <table border="1"  style="text-align: right" class="font">
                        <c:forEach items="${list}"  var="algo" varStatus="status">
                            <c:if test="${(status.index<=(count/5)*2)&&status.index>(count/5)}">
                                <tr>
                                    <td>${status.index+1}</td>
                                    <td>${algo}=
                                        <c:forEach items="${titleResult}"  var="titleResult" varStatus="status1">
                                            <c:if test="${status1.index==status.index}">
                                                <input type="text" value="${titleResult}"  style="width:50px;">
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>

                    </table>
                </div>
                <div id="4" style="display:inline-block;margin-left: 20px;margin-top: 20px;">
                    <table border="1"  style="text-align: right" class="font">
                        <c:forEach items="${list}"  var="algo" varStatus="status">
                            <c:if test="${(status.index>(count/5)*2)&&status.index<(count/5)*3}">
                                <tr>
                                    <td>${status.index+1}</td>
                                    <td>${algo}=
                                        <c:forEach items="${titleResult}"  var="titleResult" varStatus="status1">
                                            <c:if test="${status1.index==status.index}">
                                                <input type="text" value="${titleResult}"  style="width:50px;">
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>
                <div id="4" style="display:inline-block;margin-left: 20px;margin-top: 20px;">
                    <table border="1"  style="text-align: right" class="font" >
                        <c:forEach items="${list}"  var="algo" varStatus="status">
                            <c:if test="${(status.index>(count/5)*3)&&status.index<(count/5)*4}">
                                <tr>
                                    <td>${status.index+1}</td>
                                    <td>${algo}=
                                        <c:forEach items="${titleResult}"  var="titleResult" varStatus="status1">
                                            <c:if test="${status1.index==status.index}">
                                                <input type="text" value="${titleResult}"  style="width:50px;">
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>
                <div id="4" style="display:inline-block;margin-left: 20px;margin-top: 20px;">
                    <table border="1"  style="text-align: right" class="font" >
                        <c:forEach items="${list}"  var="algo" varStatus="status">
                            <c:if test="${(status.index>(count/5)*4)}">
                                <tr>
                                    <td>${status.index+1}</td>
                                    <td>${algo}=
                                        <c:forEach items="${titleResult}"  var="titleResult" varStatus="status1">
                                            <c:if test="${status1.index==status.index}">
                                                <input type="text" value="${titleResult}"  style="width:50px;">
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>
            </c:if>
        </div>

        <%--显示结果--%>
        <div style="margin-top: 30px;" >




            <%--语言为英语--%>
            <c:if test="${language==2}">

                Altogether <strong>${count}</strong>  questions，The number of correct questions is <strong>${right}</strong>,<br>
                The number of incorrect answers is <strong>${count-right}</strong>
                ,total time <strong>${allTime2}</strong>
                <br>
                The wrong number is：


            </c:if>
            <%--语言为中文--%>
            <c:if test="${language==1}">
                一共<strong>${count}</strong>  道题 ， 作对 <strong>${right}</strong>道 ，<br>
                做错<strong>${count-right}</strong> 道 ,共用时 <strong>${allTime1}</strong>
                <br> 做错的题号是：

            </c:if>
            <c:forEach items="${rightNum}"  var="rightNum" varStatus="status">

                <c:if test="${rightNum!=0}">

                    <font color="red"><strong> ${rightNum} </strong></font>


                </c:if>

            </c:forEach>

        </div>
    </form>


</center>
</body>
</html>
