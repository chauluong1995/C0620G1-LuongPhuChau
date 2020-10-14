<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/14/2020
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="calculate" method="post">
    <input type="text" name="num1" placeholder="Enter number 1"/>
    <input type="text" name="num2" placeholder="Enter number 2"/>
    <br><br>
    <input type="submit" value="Addition(+)" name="calculator"/>
    <input type="submit" value="Subtraction(-)" name="calculator"/>
    <input type="submit" value="Multiplication(X)" name="calculator"/>
    <input type="submit" value="Division(/)" name="calculator"/>
</form>
<a href="/">Reset</a>
<h3>${result}</h3>
</body>
</html>
