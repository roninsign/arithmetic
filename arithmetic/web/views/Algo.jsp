<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>生成题目</title>
    <style type="text/css">
        body{
            background-image: url("image/tim77777g.jpg");
            background-size: cover;
        }
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
<%--中文--%>
<div style="margin-left: 100px;margin-top: 50px">
    <c:if test="${language==1}">
        <form  action="${pageContext.request.contextPath}/Algo?state=AlgoTest" method="post" >
            <font color="red">*</font>生成的题目数：<input type="text" name="n" style="height:35px;width:60px;margin-top:25px" required="required" placeholder="1-10000" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"> <br>
            <font color="red">*</font>
            题目的上下限：<input type="text" name="m1" style="height:35px;width:60px;margin-top:25px" required="required" placeholder="1-100" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();">——<input type="text" name="m2" style="height:35px;width:60px;margin-top:25px" required="required" placeholder="50-1000" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"><br>
            符号的数量：<select style="height:20px;width:50px;margin-top:25px" name="o">
            <option value="1" selected="selected">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
        </select><br><br>
            是否有乘除法：
            否<input type="radio" name="c" value="2"checked="checked"/>
            是<input type="radio" name="c" value="1" /><br><br>
            是否含有括号：
            否<input type="radio" name="b" value="2"  checked="checked"  />
            是<input type="radio" name="b" value="1"/><br><br>
            <font color="red" size="2">（*为必填，且为正整数）</font><br>
            <input type="submit" value="生成题目" style="width:100px;height:35px;margin-top:25px"><br><br>
                ${msg}
        </form>
        <form  action="${pageContext.request.contextPath}/Algo?state=downFile" method="post">
            <input type="text" name="filename" value="${filename}" hidden>
            <c:if test="${not empty filename}">
                <button>点击下载文件</button>
            </c:if>
        </form>
    </c:if>
</div>
<%--英文--%>
<div style="margin-left: 100px;margin-top: 50px">
    <c:if test="${language==2}">
        <form  action="${pageContext.request.contextPath}/Algo?state=AlgoTest" method="post" >
            <font color="red">*</font>Number of questions generated.：<input type="text" name="n" style="height:35px;width:60px;margin-top:25px" required="required" placeholder="1-10000" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"> <br>
            <font color="red">*</font>
            The upper and lower limits of Numbers：<input type="text" name="m1" style="height:35px;width:60px;margin-top:25px" required="required" placeholder="1-100" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();">——<input type="text" name="m2" style="height:35px;width:60px;margin-top:25px" required="required" placeholder="50-1000" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"><br>

            The number of operational symbols：<select style="height:20px;width:50px;margin-top:25px" name="o">
            <option value="1"  selected="selected">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
        </select><br><br>
            Whether they include multiplication and division：
            NO<input type="radio" name="c" value="2"checked="checked"/>
            YES<input type="radio" name="c" value="1" /><br><br>

            Whether or not they contain parentheses：
            NO<input type="radio" name="b" value="2"  checked="checked"  />
            YES<input type="radio" name="b" value="1"/><br><br>

            <font color="red" size="2">（* Must fill in，and should be Positive integer）</font><br>

            <input type="submit" value="Subject generated" style="width:100px;height:35px;margin-top:25px"><br><br>

                ${msg1}
        </form>
        <form  action="${pageContext.request.contextPath}/Algo?state=downFile" method="post">
            <input type="text" name="filename" value="${filename}" hidden>
            <c:if test="${not empty filename}">
                <button>download the file</button>
            </c:if>
        </form>

    </c:if>
</div>

</body>
</html>
