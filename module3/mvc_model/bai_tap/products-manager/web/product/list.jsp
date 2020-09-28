<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/27/2020
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Products List</title>--%>

<%--    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">--%>

<%--    <style>--%>
<%--        h1 {--%>
<%--            color: blue;--%>
<%--        }--%>

<%--        table {--%>
<%--            background-color: whitesmoke;--%>
<%--        }--%>

<%--        .row-1 {--%>
<%--            color: crimson;--%>
<%--        }--%>

<%--        .name {--%>
<%--            color: darkviolet;--%>
<%--        }--%>

<%--        .price {--%>
<%--            color: deeppink;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Products</h1>--%>

<%--<p>--%>
<%--    <a href="/products-manager?action=create"><h3>Create new product</h3></a>--%>
<%--</p>--%>

<%--<form method="post">--%>
<%--    <label style="color: blue">Search product by name : <input type="text" name="nameProduct" id="nameProduct"/></label>--%>
<%--    <input type="submit" value="Search">--%>
<%--    <br><br>--%>
<%--</form>--%>

<%--<table border="1">--%>
<%--    <tr class="row-1">--%>
<%--        <td>ID</td>--%>
<%--        <td>Name</td>--%>
<%--        <td>Price</td>--%>
<%--        <td>Description</td>--%>
<%--        <td>Manufacturer</td>--%>
<%--        <td>View</td>--%>
<%--        <td>Edit</td>--%>
<%--        <td>Delete</td>--%>
<%--    </tr>--%>
<%--    <c:forEach items='${requestScope["products"]}' var="product">--%>
<%--        <tr>--%>
<%--            <td>${product.getId()}</td>--%>
<%--            <td class="name">${product.getName()}</td>--%>
<%--            <td class="price">${product.getPrice()}</td>--%>
<%--            <td>${product.getDescription()}</td>--%>
<%--            <td>${product.getManufacturer()}</td>--%>
<%--            <td><a href="/products-manager?action=view&id=${product.getId()}"><i class="material-icons">remove_red_eye</i></a></td>--%>
<%--            <td><a href="/products-manager?action=edit&id=${product.getId()}"><i class="material-icons">edit</i></a></td>--%>
<%--            <td><a href="/products-manager?action=delete&id=${product.getId()}"><i class="material-icons">delete</i></a></td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
<%--</body>--%>
<%--</html>--%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Bootstrap Simple Data Table</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <style>
        body {
            color: #566787;
            background: #f5f5f5;
            font-family: 'Roboto', sans-serif;
        }

        .table-responsive {
            margin: 30px 0;
        }

        .table-wrapper {
            min-width: 1000px;
            background: #fff;
            padding: 20px;
            box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
        }

        .table-title {
            padding-bottom: 10px;
            margin: 0 0 10px;
            min-width: 100%;
        }

        .table-title h2 {
            margin: 8px 0 0;
            font-size: 22px;
        }

        .search-box {
            position: relative;
            float: right;
        }

        .search-box input {
            height: 34px;
            border-radius: 20px;
            padding-left: 35px;
            border-color: #ddd;
            box-shadow: none;
        }

        .search-box input:focus {
            border-color: #3FBAE4;
        }

        .search-box i {
            color: #a0a5b1;
            position: absolute;
            font-size: 19px;
            top: 8px;
            left: 10px;
        }

        table.table tr th, table.table tr td {
            border-color: #e9e9e9;
        }

        table.table-striped tbody tr:nth-of-type(odd) {
            background-color: #fcfcfc;
        }

        table.table-striped.table-hover tbody tr:hover {
            background: #f5f5f5;
        }

        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }

        table.table td:last-child {
            width: 130px;
        }

        table.table td a {
            color: #a0a5b1;
            display: inline-block;
            margin: 0 5px;
        }

        table.table td a.view {
            color: #03A9F4;
        }

        table.table td a.edit {
            color: #FFC107;
        }

        table.table td a.delete {
            color: #E34724;
        }

        table.table td i {
            font-size: 19px;
        }

        .pagination {
            float: right;
            margin: 0 0 5px;
        }

        .pagination li a {
            border: none;
            font-size: 95%;
            width: 30px;
            height: 30px;
            color: #999;
            margin: 0 2px;
            line-height: 30px;
            border-radius: 30px !important;
            text-align: center;
            padding: 0;
        }

        .pagination li a:hover {
            color: #666;
        }

        .pagination li.active a {
            background: #03A9F4;
        }

        .pagination li.active a:hover {
            background: #0397d6;
        }

        .pagination li.disabled i {
            color: #ccc;
        }

        .pagination li i {
            font-size: 16px;
            padding-top: 6px
        }

        .hint-text {
            float: left;
            margin-top: 6px;
            font-size: 95%;
        }

        #search {
            padding-left: 5px;
        }
    </style>
    <script>
        $(document).ready(function () {
            $('[data-toggle="tooltip"]').tooltip();
        });
    </script>
</head>
<body>
<div class="container-xl">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-4">
                        <h1 style="color: red">Products List</h1>
                        <p>
                            <a href="/products-manager?action=create"><h3>Create new product</h3></a>
                        </p>
                    </div>
                    <div class="col-sm-8">
                        <div class="search-box">
                            <form method="post">
                                <i class="material-icons">&#xE8B6;</i>
                                <input type="text" name="nameProduct" id="nameProduct" class="form-control"
                                       placeholder="Search product by name">
                                <input id="search" type="submit" value="Search">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name <i class="fa fa-sort"></i></th>
                    <th>Price</th>
                    <th>Description<i class="fa fa-sort"></i></th>
                    <th>Manufacturer</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items='${requestScope["products"]}' var="product">
                    <tr>
                        <td>${product.getId()}</td>
                        <td class="name">${product.getName()}</td>
                        <td class="price">${product.getPrice()}</td>
                        <td>${product.getDescription()}</td>
                        <td>${product.getManufacturer()}</td>
                        <td>
                            <a href="/products-manager?action=view&id=${product.getId()}" class="view" title="View"
                               data-toggle="tooltip"><i
                                    class="material-icons">&#xE417;</i></a>
                            <a href="/products-manager?action=edit&id=${product.getId()}" class="edit" title="Edit"
                               data-toggle="tooltip"><i
                                    class="material-icons">&#xE254;</i></a>
                            <a href="/products-manager?action=delete&id=${product.getId()}" class="delete"
                               title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <p>
                <a href="/products-manager">Home</a>
            </p>
            <%--            <div class="clearfix">--%>
            <%--                <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>--%>
            <%--                <ul class="pagination">--%>
            <%--                    <li class="page-item disabled"><a href="#"><i class="fa fa-angle-double-left"></i></a></li>--%>
            <%--                    <li class="page-item"><a href="#" class="page-link">1</a></li>--%>
            <%--                    <li class="page-item"><a href="#" class="page-link">2</a></li>--%>
            <%--                    <li class="page-item active"><a href="#" class="page-link">3</a></li>--%>
            <%--                    <li class="page-item"><a href="#" class="page-link">4</a></li>--%>
            <%--                    <li class="page-item"><a href="#" class="page-link">5</a></li>--%>
            <%--                    <li class="page-item"><a href="#" class="page-link"><i class="fa fa-angle-double-right"></i></a>--%>
            <%--                    </li>--%>
            <%--                </ul>--%>
            <%--            </div>--%>
        </div>
    </div>
</div>
</body>
</html>