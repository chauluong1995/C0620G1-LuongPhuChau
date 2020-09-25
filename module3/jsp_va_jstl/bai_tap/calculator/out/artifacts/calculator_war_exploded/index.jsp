<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/25/2020
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>

<form action="/calculator" method="post">
    <fieldset>
        <legend>Calculator :</legend>

        <label for="firstOperand">First operand :</label>
        <input type="text" id="firstOperand" name="firstOperand" style="margin-left: 13px"><br><br>

        <label>Operator :</label>
        <select name="operator" style="margin-left: 42px">
            <option value="+">Addition</option>
            <option value="-">Subtraction</option>
            <option value="*">Multiplication</option>
            <option value="/">Division</option>
        </select><br><br>

        <label for="secondOperand">Second operand:</label>
        <input type="text" id="secondOperand" name="secondOperand"><br><br>

        <input type="submit" value="Calculate">
    </fieldset>
</form>
</body>
</html>
