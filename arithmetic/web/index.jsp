
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>出题页面</title>

  <style type="text/css">
    body{
      background-image: url("image/2.png");
      background-size: cover;
    }
  </style>
</head>
<body >
<center>
  <div style="margin-top: 40px" >
    <font size="6" color=""><strong>四则运算做题网站</strong></font><br>
    <font size="4" color=""><strong>The website of four operations </strong></font>
  </div>

  <form action="${pageContext.request.contextPath}/Algo?state=langu" method="post">
    <font size="3" color="" style="margin-top: 20px">请选择使用语言</font>
    <font size="3" >（Please select the language for using）</font>
    <select style="height:20px;width:60px;margin-top:35px" name="language">
      <option value="1" selected="selected">中文</option>
      <option value="2">English</option>
    </select><br>
    <input type="submit" value="确定（confirm）" style="width:100px;height:25px;margin-top:20px">
  </form>


</center>
</body>

</html>
