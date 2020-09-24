<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/24/2020
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Discount Calculator</title>
</head>
<body>
<h2 style="color: red">Product Discount Calculator</h2>
<form action="/display-discount" method="post">
    <label style="color: blue">Product Description :</label><br/>
    <input type="text" name="description" style="width: 15%; height: 75px"/><br/><br/>

    <label style="color: blue">List Price :</label><br/>
    <input type="text" name="listPrice"/><br/><br/>

    <label style="color: blue">Discount Percent :</label><br/>
    <input type="text" name="discountPercent"/><br/><br/>

    <input type="submit" id="submit" value="Calculate Discount" style="color: blue; background-color: violet"/>
</form>
</body>
</html>
