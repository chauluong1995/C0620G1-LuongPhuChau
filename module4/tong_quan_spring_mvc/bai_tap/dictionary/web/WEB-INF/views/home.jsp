<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/13/2020
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
    <style>
        form {
            text-align: center;
        }

        h1 {
            color: red;
        }

        h2 {
            color: deeppink;
        }

        .submit {
            background-color: black;
            color: yellow;
        }

        label {
            font-weight: bold;
            color: blue;
        }
    </style>
</head>
<body>
<form method="post" action="/translate">
    <h1>Dictionary</h1>
    <label> Enter the word to look up :
        <input type="text" placeholder="Input the word to look up" name="english"/>
    </label><br><br>
    <input class="submit" type="submit" value="Translate"/><br><br>
    <h2>${result}</h2>
</form>
</body>
</html>
