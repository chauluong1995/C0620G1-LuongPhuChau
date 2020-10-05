<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/2/2020
  Time: 8:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Lato&subset=latin,latin-ext' rel='stylesheet' type='text/css'>


    <style>
        body, html {
            height: 100%;
            background-repeat: no-repeat;
            font-family: 'Lato', Verdana;
        }

        .main {
            margin-top: 70px;
        }

        .form-group {
            margin-bottom: 15px;
        }


        input,
        input::-webkit-input-placeholder {
            font-size: 11px;
            padding-top: 3px;
        }

        .main-login {
            background-color: #9fcdff;
            /* shadows and rounded borders */
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);

        }

        label {
            margin-bottom: 15px;
            font-size: 18px;
        }

        .main-center {
            margin-top: 30px;
            margin: 0 auto;
            max-width: 750px;
            padding: 40px 40px;

        }

        .login-button {
            margin-top: 5px;
        }

        .login-register {
            font-size: 12px;
            text-align: center;
            text-decoration: underline;
            color: #5CB85C;
            font-weight: bold;
        }

        .iconbk {
            background-color: #D9534F;
        }

        .list {
            text-align: center;
        }

        .list a {
            color: red;
        }

        .message {
            text-align: center;
            color: orangered;
        }
    </style>
    <title>Edit Information Customer</title>
</head>

<body>

<div class="container">
    <div class="row main">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h1 class="title">Edit Information Customer</h1>
                <hr/>
            </div>
        </div>
        <p class="list">
            <a href="/customer?actionFurama=customerList">Back to Customer List</a>
        </p>
        <h3 class="message">${message}</h3>
        <div class="main-login main-center">
            <form class="form-horizontal" method="post" action="/customer">
                <input type="hidden" name="actionFurama" value="editCustomer"/>

                <div class="form-group">
                    <label for="id" class="cols-sm-2 control-label">ID:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="id" id="id" value="${customer.id}" readonly/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="name" class="cols-sm-2 control-label">Name:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="name" id="name" value="${customer.name}"
                                   required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="type" class="cols-sm-2 control-label">Type Customer : </label>
                    <select name="type" id="type" required>
                        <option>${customer.typeCustomer}</option>
                        <c:forEach var="typeCustomer" items="${typeCustomers}">
                            <option value="${typeCustomer.id}">${typeCustomer.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="birthDay" class="cols-sm-2 control-label">Birth Day:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="date" class="form-control" name="birthDay" id="birthDay"
                                   value="${customer.birthDay}" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="gender" class="cols-sm-2 control-label">Gender : </label>
                    <select name="gender" id="gender" required>
                        <option>${customer.gender}</option>
                        <option>Male</option>
                        <option>Female</option>
                        <option>Unknown</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="idCard" class="cols-sm-2 control-label">ID Card:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="idCard" id="idCard" value="${customer.idCard}"
                                   required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="phone" class="cols-sm-2 control-label">Phone:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="phone" id="phone"
                                   value="${customer.phoneNumber}" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="email" class="cols-sm-2 control-label">Email:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-envelope-o fa"
                                                                      aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="email" id="email" value="${customer.email}"
                                   required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="address" class="cols-sm-2 control-label">Address:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="address" id="address"
                                   value="${customer.address}" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-danger btn-lg btn-block login-button">Update Information
                        Customer
                    </button>
                </div>
                <%--                <div class="login-register">--%>
                <%--                    <a href="#">Already have an account?</a>--%>
                <%--                </div>--%>
            </form>
        </div>
    </div>
</div>

<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>