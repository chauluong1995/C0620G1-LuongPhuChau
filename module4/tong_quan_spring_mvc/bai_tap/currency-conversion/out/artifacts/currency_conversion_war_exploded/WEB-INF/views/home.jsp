<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/13/2020
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Conversion</title>

    <style>
        form {
            text-align: center;
        }

        h1 {
            color: red;
        }

        label {
            color: blue;
        }

        h2 {
            color: darkviolet;
        }

        .submit {
            color: blue;
        }
    </style>
</head>
<body>
    <form action="/convert" method="post">
        <h1>App Currency Conversion</h1>

        <label> Exchange Rate :
            <input type="text" name="rate" placeholder="Input Exchange Rate" />
        </label><br><br>

        <label> USD :
            <input type="text" name="usd" placeholder="Input USD" />
        </label><br><br>

        <input class="submit" type="submit" value="Convert" /><br><br>

        <h2>${result}</h2>
    </form>
</body>
</html>
