<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/14/2020
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <style>
        h1 {
            color: red;
        }

        label {
            font-weight: bolder;
            color: blue;
        }

        h2 {
            font-weight: bold;
            color: darkviolet;
        }
    </style>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="save" method="post">

    <input type="checkbox" id="lettuce" name="condiment" value="lettuce">
    <label for="lettuce">Lettuce</label>

    <input type="checkbox" id="tomato" name="condiment" value="tomato">
    <label for="tomato">Tomato</label>

    <input type="checkbox" id="mustard" name="condiment" value="mustard">
    <label for="mustard">Mustard</label>

    <input type="checkbox" id="sprouts" name="condiment" value="sprouts">
    <label for="sprouts">Sprouts</label>

    <input type="hidden" name="condiment">

    <br><br>

    <input type="submit" value="Save">
</form>

<h2>${result}</h2>
</body>
</html>
