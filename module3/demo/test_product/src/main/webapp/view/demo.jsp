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
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Product List</title>
</head>

<body>
<center>
    <form method="post" id="form" action="/product">
        <input type="hidden" name="actionProduct" value="updateProduct" />
        <table id="tableProduct" class="table table-striped table-hover table-bordered" style="width: 100%">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Color</th>
                <th>Description</th>
                <th>Category</th>
                <th>Actions</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${productList}" var="product">
                <c:choose>

                    <%--  EDIT ON ROW only --%>
                    <c:when test="${id.equals(product.id) && edit == 1}">
                        <tr>
                            <td scope="col">
                                <input type="text" name="idNew" id="idNew" value="${product.id}">
                                <input type="hidden" name="id" id="id" value="${product.id}">
                            </td>


                            <td scope="col"><input type="text" name="a" id="a" value="${product.name}"></td>

                            <td scope="col"><input type="text" name="b" id="b" value="${product.price}"></td>

                            <td scope="col"><input type="text" name="c" id="c" value="${product.quantity}"></td>

                            <td scope="col"><input type="text" name="d" id="d" value="${product.color}"></td>

                            <td scope="col"><input type="text" name="e" id="e" value="${product.description}"></td>

                            <td scope="col"><select name="f" id="f" value="${product.idCategory}">
                                <c:forEach var="category" items="${categoryList}">
                                    <c:choose>
                                        <c:when test="${category.id.equals(product.idCategory)}">
                                            ${category.name}
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                            </select>
                            </td>

                            <!-- save after edit -->
                            <td scope="col">
                                <button type="button" class="btn btn-primary btn-sm" onclick="document.getElementById('form').submit();">save</button>
                            </td>
                        </tr>
                    </c:when>

                    <%-- DISPLAY LIST only --%>
                    <c:otherwise>
                        <tr>
                            <td scope="col">${product.id}</td>

                            <td scope="col">${product.name}</td>

                            <td scope="col">${product.price}</td>

                            <td scope="col">${product.quantity}</td>

                            <td scope="col">${product.color}</td>

                            <td scope="col">${product.description}</td>

                            <td scope="col">
                                <c:forEach var="category" items="${categoryList}">
                                    <c:choose>
                                        <c:when test="${category.id.equals(product.idCategory)}">
                                            ${category.name}
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                            </td>

                            <!-- edit -->
                            <td scope="col" id="edit"><a href="/product?action=updateProduct&id=${product.id}">
                                <button type="button" class="btn btn-outline-warning btn-sm">Edit</button>
                            </a>
                            </td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            </tbody>
        </table>
    </form>
</center>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>


<script>
    $(document).ready(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    $(document).ready(function () {
        $('#tableProduct').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });

    function displayHiddenElement(id) {
        let thisItem = document.getElementById(id);
        thisItem.style.display = "none";
    }
</script>
</body>
</html>