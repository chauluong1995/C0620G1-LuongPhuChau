<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/4/2020
  Time: 9:32 PM
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
            background-color: #d3d3d3;
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
            background-color: #F4CFCE;
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
    <title>Create New Contract</title>
</head>

<body>

<div class="container">
    <div class="row main">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h1 class="title">Create New Contract</h1>
                <hr/>
            </div>
        </div>
        <p class="list">
            <a href="/furama">Back to Home</a>
        </p>
        <p class="message">${message}</p>
        <div class="main-login main-center">
            <form class="form-horizontal" method="post" action="/contract">
                <input type="hidden" name="actionFurama" value="createNewContract"/>

                <div class="form-group">
                    <label for="startDate" class="cols-sm-2 control-label">Start Date : </label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="date" class="form-control" name="startDate" id="startDate" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="endDate" class="cols-sm-2 control-label">End Date : </label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="date" class="form-control" name="endDate" id="endDate" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="deposit" class="cols-sm-2 control-label">Deposit : </label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="deposit" id="deposit"
                                   placeholder="Enter deposit here" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="totalMoney" class="cols-sm-2 control-label">Total Money : </label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="totalMoney" id="totalMoney"
                                   placeholder="Enter total money here" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="employee" class="cols-sm-2 control-label">Employee : </label>
                    <select name="employee" id="employee">
                        <c:forEach var="employee" items="${employees}">
                            <option value="${employee.id}">${employee.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="customer" class="cols-sm-2 control-label">Customer : </label>
                    <select name="customer" id="customer">
                        <c:forEach var="customer" items="${customers}">
                            <option value="${customer.id}">${customer.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="service" class="cols-sm-2 control-label">Service : </label>
                    <select name="service" id="service">
                        <c:forEach var="service" items="${services}">
                            <option value="${service.id}">${service.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-danger btn-lg btn-block login-button">Create New</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>