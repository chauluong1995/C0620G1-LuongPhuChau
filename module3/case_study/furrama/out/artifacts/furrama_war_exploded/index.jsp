<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/26/2020
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Furama resort management</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        img {
            height: 150px;
            width: 270px;
        }

        h1 {
            color: blue;
        }

        .nav-link {
            margin-left: 70px;
        }

        h5 {
            color: sienna;
            margin-left: 15px;
        }

        .footer {
            background-color: aqua;
            text-align: center;
            height: 25px;
        }
    </style>
</head>
<body>
<form action="/furama" method="post">
    <div class="container-fluid">
        <div class="row" style="background-color: violet">
            <div class="col-sm-8">
                <img src="img/furama-icon.png" alt="furama-icon">
            </div>

            <div class="col-sm-4">
                <h1>Luxury resort in Da Nang</h1>
            </div>
        </div>

        <div class="row" style="background-color: aquamarine">
            <div class="col-sm-12">
                <nav class="nav nav-tabs row">
                    <a href="#" class="nav-link text-dark">Home</a>
                    <a href="#" class="nav-link text-dark">Employee</a>
                    <a href="#" class="nav-link text-dark">Customer</a>
                    <a href="#" class="nav-link text-dark">Service</a>
                    <a href="#" class="nav-link text-dark">Contract</a>
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
                               style="margin-left: 70px; width: 500px">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </nav>
            </div>
        </div>

        <div class="row" style="background-color: cadetblue">
            <div class="col-sm-4">
                <img src="img/villa.jpg" alt="villa-icon">
                <h5>Luxury Villa System</h5>
                <img src="img/house.jpg" alt="house-icon">
                <h5>Perfect Home System</h5>
                <img src="img/room.jpg" alt="room-icon">
                <h5>Comfortable Room System</h5>
            </div>

            <div class="col-sm-8">
                <h1>Đin Lương</h1>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12 footer">
                <p>Web được thiết kế bởi Hội Bàn Đào</p>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script>

</form>
</body>
</html>
