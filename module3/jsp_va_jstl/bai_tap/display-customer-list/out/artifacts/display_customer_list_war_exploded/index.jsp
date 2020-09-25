<%@ page import="java.util.List" %>
<%@ page import="customer.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/25/2020
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    List<Customer> data = new ArrayList<>();
    data.add(new Customer("Nguyễn Quang Nhật Lành", "1997-02-02", "Đà Nẵng", "conan.jpg"));
    data.add(new Customer("Đoàn Ngọc Lĩnh", "2020-09-25", "Đà Nẵng", "doraemon.jpg"));
    data.add(new Customer("Lương Vũ Quang Đin", "1996-06-06", "Quãng Ngãi", "vui.jpg"));
    data.add(new Customer("Nguyễn Quốc Khánh", "1994-09-02", "Đà Nẵng", "one-punch-man.jpeg"));
    data.add(new Customer("Hồ Quỳnh Mai", "1995-05-15", "Đà Nẵng", "kiem-hiep.jpg"));

    pageContext.setAttribute("myCustomer", data);
%>
<html>
<head>
    <title>List of Customer</title>
    <style>
        table {
            border: 5px aqua solid;
            width: 750px;
            height: 550px;
        }

        tr td{
            border: 1px solid;
        }

        #caption{
            text-align: center;
            color: red;
        }

        body {
            margin-left: 385px;
        }

        img{
            width: 150px;
            height: 100px;
        }
    </style>
</head>
<body>

<table>
    <tr id="caption">
        <td colspan="4"><h1>List of Customer</h1></td>
    </tr>

    <tr>
        <td><h3>Name</h3></td>
        <td><h3>Birth Day</h3></td>
        <td><h3>Address</h3></td>
        <td><h3>Image</h3></td>
    </tr>

    <c:forEach var="customer" items="${myCustomer}">

        <tr>
            <td>${customer.name}</td>
            <td>${customer.birthDay}</td>
            <td>${customer.address}</td>
            <td><img src=${customer.image}></td>
        </tr>

    </c:forEach>

</table>

</body>
</html>
