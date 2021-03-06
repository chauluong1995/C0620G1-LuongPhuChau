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
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
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

        .btn {
            margin-left: 39px;
        }

        h5 {
            color: sienna;
            margin-left: 11%;
        }

        .col-sm-3 img {
            width: 95%;
        }

        .icon img {
            width: 100%;
            height: 100%;
        }

        .footer {
            background-color: aqua;
            text-align: center;
            height: 25px;
        }
    </style>
</head>
<body>
<form action="/furama">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-8">
                <img src="../img/furama-icon.png" alt="furama-icon">
            </div>

            <div class="col-sm-4">
                <%--<h1>Luxury Resort in Da Nang</h1>--%>
                <h1>LUONG PHU CHAU</h1>
            </div>
        </div>

        <div class="row" style="background-color: powderblue">
            <div class="col-sm-12 icon">
                <nav class="nav nav-tabs row">
                    <a href="#" class="btn btn-outline-success my-2 my-sm-0">Home</a>
                    <a href="/employee?actionFurama=employeeList"
                       class="btn btn-outline-success my-2 my-sm-0">Employee</a>
                    <a href="/customer?actionFurama=customerList"
                       class="btn btn-outline-success my-2 my-sm-0">Customer</a>
                    <a href="/service?actionFurama=addNewService"
                       class="btn btn-outline-success my-2 my-sm-0">Service</a>
                    <a href="/contract?actionFurama=addNewContract"
                       class="btn btn-outline-success my-2 my-sm-0">Contract</a>
                    <a href="/contractDetail?actionFurama=addNewContractDetail" class="btn btn-outline-success my-2 my-sm-0">
                        Contract Detail</a>
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
                               style="margin-left: 70px; width: 500px">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </nav>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-3">
                <img src="../img/villa.jpg" alt="villa-icon">
                <h5>Luxury Villa System</h5>
                <img src="../img/house.jpg" alt="house-icon">
                <h5>Perfect Home System</h5>
                <img src="../img/room.jpg" alt="room-icon">
                <h5>Comfortable Room System</h5>
            </div>

            <div class="col-sm-9">
                <div class="row">
                    <div class="col-sm-6" style="text-align: justify">
                        <h1>FURAMA DANANG, FURAMA INTERNATIONAL RESORT, IS PROUD TO BE A CULINARY RESORT IN VIET
                            NAM</h1>
                        <p style="text-align: justify">
                            Overlooking Da Nang beach stretching white sand, Furama Resort Danang is the gateway to 3 di
                            World Cultural Property:
                            Hoi An (20 minutes), My Son (90 minutes) and Hue (2 hours. 196 luxury rooms with 70 villas
                            villa with two to four rooms
                            Sleep with private swimming pools are all tastefully decorated, in a traditional design
                            style of
                            Vietnamese architecture and belonging
                            location of France, making Furama the most prestigious resort in Vietnam - honored to be
                            welcomed
                            meet many famous people,
                            royalty, politicians, movie stars and international business leaders.
                            The resort has 196 rooms designed in traditional Vietnamese style combined with French
                            style, 2 4-storey buildings overlooking the sea, overlooking the clear blue swimming pool
                            and lush tropical gardens. In addition, Furama Resort also offers legal spas, steam baths,
                            saunas, hot pool massage, water sports services.
                        </p>
                    </div>
                    <div class="col-sm-6 icon">
                        <img src="../img/img3.jpg" alt="img3">
                    </div>
                </div>
            </div>
        </div>

        <%--        <div class="row">--%>
        <%--            <div class="col-sm-3">--%>
        <%--                <img src="../img/img2.jpg" alt="img2">--%>
        <%--            </div>--%>
        <%--            <div class="col-sm-3">--%>
        <%--                <img src="../img/img3.jpg" alt="img3">--%>
        <%--            </div>--%>
        <%--            <div class="col-sm-3">--%>
        <%--                <img src="../img/img4.jpg" alt="img4">--%>
        <%--            </div>--%>
        <%--            <div class="col-sm-3">--%>
        <%--                <img src="../img/img5.jpg" alt="img5">--%>
        <%--            </div>--%>
        <%--        </div>--%>

        <div class="row">
            <div class="col-sm-12 footer">
                <p>Web designed by SuPea Jr</p>
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