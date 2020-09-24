<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/24/2020
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Discount Calculator</title>
</head>
<body>

<h3 style="color: red">Product Description : <span style="color: blue"><%=request.getAttribute("description")%></span>
</h3>

<h3 style="color: red">List Price : <span style="color: blue"><%=request.getAttribute("listPrice")%></span> USD</h3>

<h3 style="color: red">Discount Percent : <span style="color: blue"><%=request.getAttribute("discountPercent")%></span>
    USD</h3>

<h3 style="color: red">Discount Amount : <span style="color: blue"><%=request.getAttribute("discountAmount")%></span>
    USD</h3>

<h3 style="color: red">Discount Percent : <span style="color: blue"><%=request.getAttribute("iscountPrice")%></span> USD
</h3>

</body>
</html>
