<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/30/2020
  Time: 8:47 AM
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
    <title>Create New Customer</title>
</head>

<body>

<div class="container">
    <div class="row main">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h1 class="title">Create New Customer</h1>
                <hr/>
            </div>
        </div>
        <p class="list">
            <a href="/customer?actionFurama=customerList">Back to Customer List</a>
        </p>
        <p class="message">${message}</p>
        <div class="main-login main-center">
            <form class="form-horizontal" method="post" action="/customer">
                <input type="hidden" name="actionFurama" value="createNewCustomer"/>

                <div class="form-group">
                    <label for="id" class="cols-sm-2 control-label">ID:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="id" id="id" placeholder="Enter your ID here"
                                   required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="name" class="cols-sm-2 control-label">Name:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="name" id="name"
                                   placeholder="Enter your name here" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="type" class="cols-sm-2 control-label">Type Customer : </label>
                    <select name="type" id="type">
                        <c:forEach var="typeCustomer" items="${typeCustomers}">
                            <option value="${typeCustomer.id}">${typeCustomer.name}</option>
                        </c:forEach>
                    </select>
<%--                    <div class="cols-sm-10">--%>
<%--                        <div class="input-group">--%>
<%--                            <select name="type" id="type">--%>
<%--                                <c:forEach var="typeCustomer" items="${typeCustomers}">--%>
<%--                                    <option value="${typeCustomer.id}">${typeCustomer.name}</option>--%>
<%--                                </c:forEach>--%>
<%--                            </select>--%>
<%--                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>--%>
<%--                            <input type="text" class="form-control" name="type" id="type"--%>
<%--                                   placeholder="Enter your type customer here" required/>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </div>

                <div class="form-group">
                    <label for="birthDay" class="cols-sm-2 control-label">Birth Day:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="date" class="form-control" name="birthDay" id="birthDay" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="gender" class="cols-sm-2 control-label">Gender : </label>
                    <select name="gender" id="gender">
                        <option>Male</option>
                        <option>Female</option>
                        <option>Unknown</option>
                    </select>
                    <%--                    <div class="cols-sm-10">--%>
                    <%--                        <div class="input-group">--%>
                    <%--                            <select name="gender" id="gender">--%>
                    <%--                                <option>Male</option>--%>
                    <%--                                <option>Female</option>--%>
                    <%--                                <option>Unknown</option>--%>
                    <%--                           </select>--%>
                    <%--                           <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>--%>
                    <%--                           <input type="text" class="form-control" name="gender" id="gender"--%>
                    <%--                                   placeholder="Enter your gender here"/>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                </div>

                <div class="form-group">
                    <label for="idCard" class="cols-sm-2 control-label">ID Card:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="idCard" id="idCard"
                                   placeholder="Enter your ID card here" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="phone" class="cols-sm-2 control-label">Phone:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="phone" id="phone"
                                   placeholder="Enter your phone here" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="email" class="cols-sm-2 control-label">Email:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-envelope-o fa"
                                                                      aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="email" id="email"
                                   placeholder="Enter your email here" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="address" class="cols-sm-2 control-label">Address:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="address" id="address"
                                   placeholder="Enter your address here" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-danger btn-lg btn-block login-button">Create New</button>
                </div>
                <%--                <div class="login-register">--%>
                <%--                    <a href="#">Already have an account?</a>--%>
                <%--                </div>--%>
            </form>
            <p style="text-align: center">
                <a href="/furama">Home</a>
            </p>
        </div>
    </div>
</div>

<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>