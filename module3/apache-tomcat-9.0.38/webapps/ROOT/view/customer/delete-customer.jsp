<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/1/2020
  Time: 9:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Customer</title>
</head>
<body>
<h1>Delete Customer</h1>
<p>
    <a href="/customer?actionFurama=customerList">Back to Customer List</a>
</p>
<form method="post" action="/customer">
    <input type="hidden" name="actionFurama" value="deleteCustomer">
    <input type="hidden" name="idCustomer" value="${customer.getId()}">
    <h3>Do you really want to delete this Customer ?</h3>
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>ID :</td>
                <td>${customer.getId()}</td>
            </tr>
            <tr>
                <td>Name :</td>
                <td>${customer.getName()}</td>
            </tr>
            <tr>
                <td>Type of Customer :</td>
                <td>${customer.getTypeCustomer()}</td>
            </tr>
            <tr>
                <td>BirthDay :</td>
                <td>${customer.getBirthDay()}</td>
            </tr>
            <tr>
                <td>Gender :</td>
                <td>${customer.getGender()}</td>
            </tr>
            <tr>
                <td>ID Card :</td>
                <td>${customer.getIdCard()}</td>
            </tr>
            <tr>
                <td>Phone Number :</td>
                <td>${customer.getPhoneNumber()}</td>
            </tr>
            <tr>
                <td>Email :</td>
                <td>${customer.getEmail()}</td>
            </tr>
            <tr>
                <td>Address :</td>
                <td>${customer.getAddress()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete Customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
