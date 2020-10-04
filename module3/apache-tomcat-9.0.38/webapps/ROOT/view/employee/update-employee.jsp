<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/4/2020
  Time: 3:56 PM
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
    <title>Edit Information Employee</title>
</head>

<body>

<div class="container">
    <div class="row main">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h1 class="title">Edit Information Employee</h1>
                <hr/>
            </div>
        </div>
        <p class="list">
            <a href="/furama?actionFurama=employeeList">Back to Employee List</a>
        </p>
        <p class="message">${message}</p>
        <div class="main-login main-center">
            <form class="form-horizontal" method="post" action="/furama">
                <input type="hidden" name="actionFurama" value="editEmployee"/>

                <div class="form-group">
                    <label for="id" class="cols-sm-2 control-label">ID:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="id" id="id" value="${employee.id}" readonly/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="name" class="cols-sm-2 control-label">Name:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="name" id="name"
                                   value="${employee.name}" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="birthDay" class="cols-sm-2 control-label">Birth Day:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="date" class="form-control" name="birthDay" id="birthDay" value="${employee.birthDay}" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="idCard" class="cols-sm-2 control-label">ID Card:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="idCard" id="idCard"
                                   value="${employee.idCard}" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="salary" class="cols-sm-2 control-label">Salary:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="salary" id="salary"
                                   value="${employee.salary}" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="phone" class="cols-sm-2 control-label">Phone Number:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="phone" id="phone"
                                   value="${employee.phone}" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="email" class="cols-sm-2 control-label">Email:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="email" id="email"
                                   value="${employee.email}" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="address" class="cols-sm-2 control-label">Address:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-envelope-o fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="address" id="address"
                                   value="${employee.address}" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="position" class="cols-sm-2 control-label">Position : </label>
                    <select name="position" id="position">
                        <c:forEach var="position" items="${positions}">
                            <option value="${position.id}">${position.name}</option>
                        </c:forEach>
                    </select>
                    <%--                    <div class="cols-sm-10">--%>
                    <%--                        <div class="input-group">--%>
                    <%--                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>--%>
                    <%--                            <input type="text" class="form-control" name="position" id="position"--%>
                    <%--                                   placeholder="Enter position here" required/>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                </div>

                <div class="form-group">
                    <label for="educationDegree" class="cols-sm-2 control-label">Education Degree : </label>
                    <select name="educationDegree" id="educationDegree">
                        <c:forEach var="educationDegree" items="${educationDegrees}">
                            <option value="${educationDegree.id}">${educationDegree.name}</option>
                        </c:forEach>
                    </select>
                    <%--                    <div class="cols-sm-10">--%>
                    <%--                        <div class="input-group">--%>
                    <%--                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>--%>
                    <%--                            <input type="text" class="form-control" name="educationDegree" id="educationDegree"--%>
                    <%--                                   placeholder="Enter education degree here" required/>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                </div>

                <div class="form-group">
                    <label for="division" class="cols-sm-2 control-label">Division : </label>
                    <select name="division" id="division">
                        <c:forEach var="division" items="${divisions}">
                            <option value="${division.id}">${division.name}</option>
                        </c:forEach>
                    </select>
                    <%--                    <div class="cols-sm-10">--%>
                    <%--                        <div class="input-group">--%>
                    <%--                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>--%>
                    <%--                            <input type="text" class="form-control" name="division" id="division"--%>
                    <%--                                   placeholder="Enter division here" required/>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                </div>

                <div class="form-group">
                    <label for="user" class="cols-sm-2 control-label">User Name : </label>
                    <select name="user" id="user">
                        <c:forEach var="user" items="${users}">
                            <option value="${user.name}">${user.name}</option>
                        </c:forEach>
                    </select>
                    <%--                    <div class="cols-sm-10">--%>
                    <%--                        <div class="input-group">--%>
                    <%--                            <span class="input-group-addon iconbk"><i class="fa fa-user-plus fa" aria-hidden="true"></i></span>--%>
                    <%--                            <input type="text" class="form-control" name="userName" id="userName"--%>
                    <%--                                   placeholder="Enter user name here" required/>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-danger btn-lg btn-block login-button">Update Information Employee</button>
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