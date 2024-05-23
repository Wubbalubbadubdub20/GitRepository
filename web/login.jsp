<%--
  Created by IntelliJ IDEA.
  User: HuXuanHao
  Date: 2024/5/17
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<a href="CheckUserServlet">直接访问</a>
<p>${sessionScope.message}</p>
<h4>请输入用户名和口令</h4>
<form action="CheckUserServlet" method="post">
    用户名：<input type="text" name="username" size="15" autofocus> <br>
    口&nbsp;&nbsp;&nbsp;令：<input type="password" name="password" size="15"> <br>
    <input type="checkbox" name="check" value="check">自动登录 <br>
    <input type="submit" value="提交"> <input type="reset" value="重置">
</form>
</body>
</html>

