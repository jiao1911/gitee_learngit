<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Amanda
  Date: 2019/7/31
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/userLogin" method="get">
    用户名：
    <input type="text" name="username">
    <br>
    密  码：
    <input type="test" name="password">
    <br>
    <input type="submit" value="登录" />
    <input type="reset" value="重置" />
</form>
</body>
</html>
