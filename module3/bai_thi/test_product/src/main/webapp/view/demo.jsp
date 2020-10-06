<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/7/2020
  Time: 12:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../all/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../all/datatables/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="../all/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../all/style/private_style.css">
    <title>${element_name}</title>
</head>

<body>
<%--<!-- Header -->--%>
<%--<%@ include file="/common/header.jsp" %>--%>
<%--<!-- Header ends -->--%>

<!-- Navigation -->
<div class="container-fluid" style="height: 66px">
    <nav class="navbar navbar-expand-md navbar-light bg-light fixed-top">
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarResponsive">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav mr-auto">

                <li class="nav-item active">
                    <a class="nav-link" href="/index.jsp">Home
                        <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/products">Product
                        <span class="sr-only">(current)</span></a>
                </li>

            </ul>
        </div>
        <p style="color: blue">Hoang Kim Van Chuong</p>
        <form class="form-inline my-2 my-lg-0">
            <%--            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"--%>
            <%--                   style="width: 300px">--%>
            <%--            <button class="btn btn-outline-success my-2 my-sm-2" type="submit">Search</button>--%>
        </form>
    </nav>
</div>
<hr class="my-4" style="width: 98%">
<!-- Navigation ends -->

<!-- Body page -->
<center>
    <h2>${list_element.toUpperCase()}</h2>
    <p>
    <form method="post" action="${originalLink}">
        <button class="btn btn-outline-info btn-sm"><a href="${originalLink}?action=create">${create_element}</a>
        </button>
        <span>&nbsp;</span>
        <button class="btn btn-outline-info btn-sm"><a href="/index.jsp">Back to home</a></button>
        <span>&nbsp;</span>
        <button class="btn btn-outline-info btn-sm"><a href="${originalLink}">Back to ${element_name} list</a></button>
        <span>&nbsp;</span>
        <input type="hidden" name="action" value="search">
        <input class="mr-sm-2" style="width: 200px" type="text" name="keywords" placeholder="search by name">
        <button class="btn btn-primary" type="submit">Search</button>
    </form>
    </p>
    <p class="msg-info">${msg_create}</p>
    <p class="msg-info">${msg_edit}</p>
    <form method="post" id="form" action="/products">
        <input type="hidden" name="action" value="edit">
        <table id="pagination" class="table table-striped table-hover">
            <thead class="thead">
            <tr class="table-info">
                <th scope="col">${title_id}</th>
                <th scope="col">${title_a}</th>
                <th scope="col">${title_b}</th>
                <th scope="col">${title_c}</th>
                <th scope="col">${title_d}</th>
                <th scope="col">${title_e}</th>
                <th scope="col">${title_f}</th>

                <th scope="col">Edit</th>
                <th scope="col">Delete</th>
                <th scope="col">View</th>
                <th scope="col">Clear</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${eList}" var="el">
                <c:choose>
                    <%--  EDIT ON ROW only --%>
                    <c:when test="${id.equals(el.productId) && edit == 1}">
                        <tr>
                            <td scope="col">
                                <input type="text" name="idNew" id="idNew" value="${el.productId}">
                                <input type="hidden" name="id" id="id" value="${el.productId}">
                            </td>


                            <td scope="col"><input type="text" name="a" id="a" value="${el.productName}"></td>

                            <td scope="col"><input type="text" name="b" id="b" value="${el.productPrice}"></td>

                            <td scope="col"><input type="text" name="c" id="c" value="${el.productQuantity}"></td>

                            <td scope="col"><input type="text" name="d" id="d" value="${el.productColor}"></td>

                            <td scope="col"><input type="text" name="e" id="e" value="${el.productDescription}"></td>

                            <td scope="col"><select name="f" id="f" value="${el.productCategory}">
                                <c:forEach items="${eList2}" var="ca">
                                    <option>${ca.categoryName}</option>
                                </c:forEach>
                            </select>
                            </td>

                            <!-- save after edit -->
                            <td scope="col">

                                <button type="button" class="btn btn-primary btn-sm" onclick="document.getElementById('form').submit();">save</button>
                            </td>

                            <!-- delete -->
                            <td scope="col">
                                <button type="button" class="btn btn-outline-danger btn-sm" data-toggle="modal"
                                        data-target="#e${el.productId}">Delete
                                </button>
                                <!-- Modal -->
                                <div class="modal fade" id="e${el.productId}" tabindex="-1"
                                     aria-labelledby="exampleModalLabel1"
                                     aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel1">Do you want to delete?</h5>
                                            </div>
                                            <div class="modal-body">
                                                <h5>${element_name} name: ${el.productName}</h5><!-- $$$ -->
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                                    Cancel
                                                </button>
                                                <a href="${originalLink}?action=delete&id=${el.productId}"><!-- $$$ -->
                                                    <button type="button" class="btn btn-primary">Delete</button>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Modal ends -->
                            </td>

                            <!-- view details -->
                            <td scope="col"><a href="${originalLink}?action=view&id=${el.productId}">
                                <button type="button" class="btn btn-outline-info btn-sm">View</button>
                            </a>
                            </td>

                            <!-- Clear on screen -->
                            <td scope="col">
                                <button type="button" class="btn btn-outline-success btn-sm"
                                        onclick="displayHiddenElement('${el.productId}')">Clear
                                </button>
                            </td>
                        </tr>
                    </c:when>
                    <%-- DISPLAY LIST only --%>
                    <c:otherwise>
                        <tr>
                            <td scope="col">${el.productId}</td>

                            <td scope="col">${el.productName}</td>

                            <td scope="col">${el.productPrice}</td>

                            <td scope="col">${el.productQuantity}</td>

                            <td scope="col">${el.productColor}</td>

                            <td scope="col">${el.productDescription}</td>

                            <td scope="col">${el.productCategory}</td>

                            <!-- edit -->
                            <td scope="col" id="edit"><a href="${originalLink}?action=edit&id=${el.productId}">
                                <button type="button" class="btn btn-outline-warning btn-sm">Edit</button>
                            </a>
                            </td>

                            <!-- delete -->
                            <td scope="col">
                                <button type="button" class="btn btn-outline-danger btn-sm" data-toggle="modal"
                                        data-target="#e${el.productId}">Delete
                                </button>
                                <!-- Modal -->
                                <div class="modal fade" id="e${el.productId}" tabindex="-1"
                                     aria-labelledby="exampleModalLabel"
                                     aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">Do you want to delete?</h5>
                                            </div>
                                            <div class="modal-body">
                                                <h5>${element_name} name: ${el.productName}</h5>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                                    Cancel
                                                </button>
                                                <a href="${originalLink}?action=delete&id=${el.productId}">
                                                    <button type="button" class="btn btn-primary">Delete</button>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Modal ends -->
                            </td>

                            <!-- view details -->
                            <td scope="col"><a href="${originalLink}?action=view&id=${el.productId}">
                                <button type="button" class="btn btn-outline-info btn-sm">View</button>
                            </a>
                            </td>

                            <!-- Clear on screen -->
                            <td scope="col">
                                <button type="button" class="btn btn-outline-success btn-sm"
                                        onclick="displayHiddenElement('${el.productId}')">Clear
                                </button>
                            </td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            </tbody>
        </table>
    </form>
</center>
<!-- Body ends -->

<!-- Footer -->
<script src="http://code.jquery.com/jquery.min.js"></script>
<script src="../all/js/bootstrap.min.js"></script>
<script src="../all/jquery/jquery-3.5.1.min.js"></script>
<script src="../all/datatables/js/jquery.dataTables.min.js"></script>
<script src="../all/datatables/js/dataTables.bootstrap4.min.js"></script>

<%--Pagination--%>
<script>
    $(document).ready(function() {
        $('#pagination').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>

<%--CLEAR ON SCREEN--%>
<script>
    function displayHiddenElement(id) {
        let thisItem = document.getElementById(id);
        thisItem.style.display = "none";
    }
</script>
<hr class="my-4" style ="width: 98%">
<footer>
    <div class="container-fluid" style="height: 42px; background-color: #f5f5f0">
        <p style="padding-top: 15px; text-align: center; font-size: 12px;">Hoang Kim Van Chuong&copy;2020. All rights reserved.</p>
    </div>
</footer>
<!-- Footer ends -->
</body>
</html>