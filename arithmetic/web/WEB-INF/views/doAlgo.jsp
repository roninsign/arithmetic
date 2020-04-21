<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>做题页面,一次性全部出题</title>
    <style type="text/css">
        body{
            background-image: url("image/1.png");
            background-size: cover;
        }

        .font{font-size:20px}
    </style>

</head>
<body onload="startTime()">
<center>
    <form action="${pageContext.request.contextPath}/upTitle?state=calculate" method="post">
        <div style="margin-top: 50px">
            <c:if test="${language==2}">
                <font size="5">count time ： </font> <input type="text"  id="startShow" name="allTime" value="0" style="text-align: center;width: 110px;width: 70px">
            </c:if>

            <c:if test="${language==1}">
                <font size="5"> 计时： </font> <input type="text"  id="startShow" name="allTime" value="0" style="text-align: center;width: 110px;width: 70px">
            </c:if>

        </div>
        <%--做题数量在小于10--%>
        <table border="1" style="margin-top: 30px; text-align: right" class="font">
            <c:if test="${count<=10}">
                <c:forEach items="${list}"  var="algo" varStatus="status">
                    <tr>
                        <td style="align-content: center">
                                ${status.index+1}
                        </td>
                        <td >
                                ${algo}= <input type="text" value="" name="${status.index+1}.2" style="width:50px;" required="required" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();">
                        </td>
                        <td hidden><input type="text" value="${algo}" name="${status.index+1}.1" style="width:50px;" ></td>
                    </tr>
                </c:forEach>
                <input type="text" value="${count}" name="count" hidden>
                <input type="text" value="${list}" name="list" hidden>
                <tr>
                    <td colspan="3" style="text-align: center" >
                        <c:if test="${language==1}">
                            <input type="submit" value="提交" name="submit" >
                        </c:if>
                        <c:if test="${language==2}">
                            <input type="submit" value="submit" name="submit" >
                        </c:if>
                    </td>
                </tr>
            </c:if>
        </table>
        <%--&lt;%&ndash;做题数量在10-40-%>--%>
        <c:if test="${count>10&&count<=40}">
            <div id="1" style="display:inline-block;margin-left: 20px;margin-top: 20px; vertical-align: top">
                <table border="1" style="text-align: right">
                    <c:forEach items="${list}"  var="algo" varStatus="status">
                        <c:if test="${status.index<=(count/2)}">
                            <tr>
                                <td>
                                        ${status.index+1}
                                </td>
                                <td>
                                        ${algo}= <input type="text" value="" name="${status.index+1}.2" style="width:50px;" required="required" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();">
                                </td>
                                <td hidden><input type="text" value="${algo}" name="${status.index+1}.1" style="width:50px;" ></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
            <div id="1"  style="display:inline-block;margin-left: 20px;margin-top: 20px;vertical-align: top">
                <table border="1" style="text-align: right">

                    <c:forEach items="${list}"  var="algo" varStatus="status">
                        <c:if test="${status.index>(count/2)}">
                            <tr>
                                <td>
                                        ${status.index+1}
                                </td>
                                <td>
                                        ${algo}= <input type="text" value="" name="${status.index+1}.2" style="width:50px;" required="required" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();">
                                </td>
                                <td hidden><input type="text" value="${algo}" name="${status.index+1}.1" style="width:50px;" ></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <input type="text" value="${count}" name="count" hidden>
                    <input type="text" value="${list}" name="list" hidden>
                    <tr>
                        <td colspan="3" style="text-align: center" >
                            <c:if test="${language==1}">
                                <input type="submit" value="提交" name="submit" >
                            </c:if>
                            <c:if test="${language==2}">
                                <input type="submit" value="submit" name="submit" >
                            </c:if>
                        </td>
                    </tr>
                </table>
            </div>
        </c:if>

        <%--做题数量在40-60--%>
        <c:if test="${count>40&&count<=60}">
            <div id="1" style="display:inline-block;margin-left: 20px;margin-top: 20px;vertical-align: top">
                <table border="1" style="text-align: right">
                    <c:forEach items="${list}"  var="algo" varStatus="status">
                        <c:if test="${status.index<=(count/3)}">
                            <tr>
                                <td>
                                        ${status.index+1}
                                </td>
                                <td>
                                        ${algo}= <input type="text" value="" name="${status.index+1}.2" style="width:50px;" required="required" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();">
                                </td>
                                <td hidden><input type="text" value="${algo}" name="${status.index+1}.1" style="width:50px;" ></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
            <div id="2"  style="display:inline-block;margin-left: 20px;margin-top: 20px;vertical-align: top">
                <table border="1" style="text-align: right" >

                    <c:forEach items="${list}"  var="algo" varStatus="status">
                        <c:if test="${(status.index<=(count/3)*2)&&status.index>(count/3)}">
                            <tr>
                                <td>
                                        ${status.index+1}
                                </td>
                                <td>
                                        ${algo}= <input type="text" value="" name="${status.index+1}.2" style="width:50px;" required="required" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();">
                                </td>
                                <td hidden><input type="text" value="${algo}" name="${status.index+1}.1" style="width:50px;" ></td>
                            </tr>
                        </c:if>
                    </c:forEach>

                </table>
            </div>
            <div id="3" style="display:inline-block;margin-left: 20px;margin-top: 20px;vertical-align: top">
                <table border="1" style="text-align: right">
                    <c:forEach items="${list}"  var="algo" varStatus="status">
                        <c:if test="${(status.index>(count/3)*2)}">
                            <tr>
                                <td>
                                        ${status.index+1}
                                </td>
                                <td>
                                        ${algo}= <input type="text" value="" name="${status.index+1}.2" style="width:50px;" required="required" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();">
                                </td>
                                <td hidden><input type="text" value="${algo}" name="${status.index+1}.1" style="width:50px;" ></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <input type="text" value="${count}" name="count" hidden>
                    <input type="text" value="${list}" name="list" hidden>
                    <tr>
                        <td colspan="3" style="text-align: center" >
                            <c:if test="${language==1}">
                                <input type="submit" value="提交" name="submit" >
                            </c:if>
                            <c:if test="${language==2}">
                                <input type="submit" value="submit" name="submit" >
                            </c:if>
                        </td>
                    </tr>
                </table>
            </div>
        </c:if>

        <%--做题数量在60-80--%>
        <c:if test="${count>60&&count<=80}">
            <div id="1" style="display:inline-block;margin-left: 20px;margin-top: 20px;vertical-align: top">
                <table border="1" style="text-align: right">
                    <c:forEach items="${list}"  var="algo" varStatus="status">
                        <c:if test="${status.index<=(count/4)}">
                            <tr>
                                <td>
                                        ${status.index+1}
                                </td>
                                <td>
                                        ${algo}= <input type="text" value="" name="${status.index+1}.2" style="width:50px;" required="required" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();">
                                </td>
                                <td hidden><input type="text" value="${algo}" name="${status.index+1}.1" style="width:50px;" ></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
            <div id="2"  style="display:inline-block;margin-left: 20px;margin-top: 20px;vertical-align: top">
                <table border="1"  style="text-align: right">

                    <c:forEach items="${list}"  var="algo" varStatus="status">
                        <c:if test="${(status.index<=(count/4)*2)&&status.index>(count/4)}">
                            <tr>
                                <td>
                                        ${status.index+1}
                                </td>
                                <td>
                                        ${algo}= <input type="text" value="" name="${status.index+1}.2" style="width:50px;" required="required" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();">
                                </td>
                                <td hidden><input type="text" value="${algo}" name="${status.index+1}.1" style="width:50px;" ></td>
                            </tr>
                        </c:if>
                    </c:forEach>

                </table>
            </div>
            <div id="3" style="display:inline-block;margin-left: 20px;margin-top: 20px; vertical-align: top">
                <table border="1" style="text-align: right">
                    <c:forEach items="${list}"  var="algo" varStatus="status">
                        <c:if test="${(status.index>(count/4)*2)&&status.index<(count/4)*3}">
                            <tr>
                                <td>
                                        ${status.index+1}
                                </td>
                                <td>
                                        ${algo}= <input type="text" value="" name="${status.index+1}.2" style="width:50px;" required="required" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();">
                                </td>
                                <td hidden><input type="text" value="${algo}" name="${status.index+1}.1" style="width:50px;" ></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
            <div id="4" style="display:inline-block;margin-left: 20px;margin-top: 20px;vertical-align: top">
                <table border="1" style="text-align: right">
                    <c:forEach items="${list}"  var="algo" varStatus="status">
                        <c:if test="${(status.index>(count/4)*3)}">
                            <tr>
                                <td>
                                        ${status.index+1}
                                </td>
                                <td>
                                        ${algo}= <input type="text" value="" name="${status.index+1}.2" style="width:50px;" required="required" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();">
                                </td>
                                <td hidden><input type="text" value="${algo}" name="${status.index+1}.1" style="width:50px;" ></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <input type="text" value="${count}" name="count" hidden>
                    <input type="text" value="${list}" name="list" hidden>
                    <tr>
                        <td colspan="3" style="text-align: center" >
                            <c:if test="${language==1}">
                                <input type="submit" value="提交" name="submit" >
                            </c:if>
                            <c:if test="${language==2}">
                                <input type="submit" value="submit" name="submit" >
                            </c:if>
                        </td>
                    </tr>
                </table>
            </div>
        </c:if>

        <%--做题数量大于80--%>
        <c:if test="${count>80}">
            <div id="1" style="display:inline-block;margin-left: 20px;margin-top: 20px;vertical-align: top">
                <table border="1" style="text-align: right">
                    <c:forEach items="${list}"  var="algo" varStatus="status">
                        <c:if test="${status.index<=(count/5)}">
                            <tr>
                                <td>
                                        ${status.index+1}
                                </td>
                                <td>
                                        ${algo}= <input type="text" value="" name="${status.index+1}.2" style="width:50px;" required="required" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();">
                                </td>
                                <td hidden><input type="text" value="${algo}" name="${status.index+1}.1" style="width:50px;" ></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
            <div id="2"  style="display:inline-block;margin-left: 20px;margin-top: 20px;vertical-align: top">
                <table border="1" style="text-align: right" >

                    <c:forEach items="${list}"  var="algo" varStatus="status">
                        <c:if test="${(status.index<=(count/5)*2)&&status.index>(count/5)}">
                            <tr>
                                <td>
                                        ${status.index+1}
                                </td>
                                <td>
                                        ${algo}= <input type="text" value="" name="${status.index+1}.2" style="width:50px;" required="required" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();">
                                </td>
                                <td hidden><input type="text" value="${algo}" name="${status.index+1}.1" style="width:50px;" ></td>
                            </tr>
                        </c:if>
                    </c:forEach>

                </table>
            </div>
            <div id="3" style="display:inline-block;margin-left: 20px;margin-top: 20px;vertical-align: top">
                <table border="1" style="text-align: right">
                    <c:forEach items="${list}"  var="algo" varStatus="status">
                        <c:if test="${(status.index>(count/5)*2)&&status.index<(count/5)*3}">
                            <tr>
                                <td>
                                        ${status.index+1}
                                </td>
                                <td>
                                        ${algo}= <input type="text" value="" name="${status.index+1}.2" style="width:50px;" required="required" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();">
                                </td>
                                <td hidden><input type="text" value="${algo}" name="${status.index+1}.1" style="width:50px;" ></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
            <div id="4" style="display:inline-block;margin-left: 20px;margin-top: 20px;vertical-align: top">
                <table border="1" style="text-align: right">
                    <c:forEach items="${list}"  var="algo" varStatus="status">
                        <c:if test="${(status.index>(count/5)*3)&&status.index<(count/5)*4}">
                            <tr>
                                <td>
                                        ${status.index+1}
                                </td>
                                <td>
                                        ${algo}= <input type="text" value="" name="${status.index+1}.2" style="width:50px;" required="required" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();">
                                </td>
                                <td hidden><input type="text" value="${algo}" name="${status.index+1}.1" style="width:50px;" ></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
            <div id="4" style="float: left;margin-left: 20px;margin-top: 20px;vertical-align: top">
                <table border="1" style="text-align: right">
                    <c:forEach items="${list}"  var="algo" varStatus="status">
                        <c:if test="${(status.index>(count/5)*4)}">
                            <tr>
                                <td>
                                        ${status.index+1}
                                </td>
                                <td>
                                        ${algo}= <input type="text" value="" name="${status.index+1}.2" style="width:50px;" required="required" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();">
                                </td>
                                <td hidden><input type="text" value="${algo}" name="${status.index+1}.1" style="width:50px;" ></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <input type="text" value="${count}" name="count" hidden>
                    <input type="text" value="${list}" name="list" hidden>
                    <tr>
                        <td colspan="3" style="text-align: center" >
                            <c:if test="${language==1}">
                                <input type="submit" value="提交" name="submit" >
                            </c:if>
                            <c:if test="${language==2}">
                                <input type="submit" value="submit" name="submit" >
                            </c:if>
                        </td>
                    </tr>
                </table>
            </div>
        </c:if>

    </form>
    <div id="txt"></div>
</center>
<script src="js/text.js"></script>
<%--、、计时--%>
<script>
    function start(){
        var today=new Date()
        var h=today.getHours()
        var m=today.getMinutes()
        var s=today.getSeconds()
        m=checkTime(m)
        s=checkTime(s)
        document.getElementById('txt').innerHTML=h+":"+m+":"+s;
        t=setTimeout('start()',500)
    }

    function checkTime(a){
        if(a<10){
            a="0" + a
        }
        return a
    }
</script>

</body>
</html>
