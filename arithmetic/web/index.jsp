
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>出题页面</title>

  <style type="text/css">
    body{
      background-image: url("image/img1.png");
      background-size: cover;
    }
  </style>
</head>
<body >
<center>
  <div style="margin-top: 40px" >
    <font size="6" color=""><strong>你喜欢的数学</strong></font><br>
    <font size="4" color=""><strong>math as you like.</strong></font>
  </div>

  <form action="${pageContext.request.contextPath}/Algo?state=langu" method="post">
    <font size="3" color="" style="margin-top: 20px">请选择支持的语言</font>
    <font size="3" >（Please select the supported language）</font>
    <select style="height:20px;width:60px;margin-top:35px" name="language">
      <option value="1" selected="selected">中文</option>
      <option value="2">English</option>
    </select><br>
    <input type="submit" value="确定（confirm）" style="width:100px;height:25px;margin-top:20px">
  </form>


</center>
</body>

</html>
