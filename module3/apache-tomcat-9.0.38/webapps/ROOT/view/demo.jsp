<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/6/2020
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Customer</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/customer.css">
    <link rel="stylesheet" href=" https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="  https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css">
</head>
<body>

<div class="container-lg">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>Customer <b>Details</b></h2>
                            </div>
                            <div class="col-sm-6">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <a href="/" class="btn btn-success"><i class="material-icons">&#xe84f;</i> <span>Home</span></a>
                                    </div>
                                    <div class="col-sm-6">
                                        <a href="#addCustomerModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add</span></a>
                                    </div>

                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="search-box">
                            <div class="input-group">
                                <input type="text" id="search" class="form-control" placeholder="Search by Name">
                                <span class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <table class="table table-striped" id="customerTable" >
                <thead>
                <tr>
                    <th>ID</th>
                    <th style="width: 15%;">NAME</th>
                    <th style="width: 15%;">BIRTHDAY</th>
                    <th style="width: 15%;">GENDER</th>
                    <th style="width: 15%;">ADDRESS</th>
                    <th style="width: 15%;">CUSTOMER TYPE</th>
                    <th>ACTIONS</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${listCustomer}">
                    <tr>
                        <td><c:out value="${customer.customer_id}"/></td>
                        <td><c:out value="${customer.customer_name}" /></td>
                        <td><c:out value="${customer.customer_birthday}" /></td>

                        <td>

                            <c:if test="${customer.customer_gender == 0}">
                                Nữ
                            </c:if>
                            <c:if test="${customer.customer_gender == 1}">
                                Nam
                            </c:if>
                        </td>
                        <td><c:out value="${customer.customer_address}" /></td>
                        <td><c:out value="${customer.customer_type_name}" /></td>
                        <td>
                            <a data-toggle="modal" data-target="#editCustomerModal"onclick="setCustomerInfor('${customer.customer_id}','${customer.customer_name}','${customer.customer_birthday}','${customer.customer_address}','${customer.customer_type_name}')"  href="#"   class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                            <a data-toggle="modal" data-target="#deleteCustomerModal" href="#" onclick="setCustomerId('${customer.customer_id}')" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Add Modal HTML -->
<div id="addCustomerModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/customer" method="post" id="target">
                <input type="hidden" name="action"  value="create">
                <div class="modal-header">
                    <h4 class="modal-title">Add Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" name="customer_name" id="name_cus" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Birthday</label>
                        <input type="date" name="customer_birthday" id="birthday_cus" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Gender</label>
                        <select class="custom-select" name="customer_gender" required>

                            <option value="0">Nữ</option>
                            <option value="1">Nam</option>

                        </select>
                    </div>
                    <div class="form-group">
                        <label>ID_CARD</label>
                        <input type="text" name="customer_id_card" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Phone</label>
                        <input type="text" name="customer_phone" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="text" name="customer_email" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Address</label>
                        <input type="text" name="customer_address" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Type of Customer</label>
                        <select class="custom-select" name="customer_type">
                            <c:forEach var="customerType" items="${customerTypeList}">
                                <option value="${customerType.getCustomer_type_id()}"> ${customerType.getCustomer_type_name()} </option>
                            </c:forEach>

                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success"  value="Add Customer">
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Edit Modal HTML -->
<div id="editCustomerModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/customer" method="post">
                <input type="hidden" name="action" value="edit">
                <input id="customer_id_edit" type="hidden" name="customer_id" />
                <div class="modal-header">
                    <h4 class="modal-title">Edit Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" id="customer_name" name="customer_name" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Birthday</label>
                        <input type="date" id ="customer_birthday" name="customer_birthday" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label>Address</label>
                        <input type="text" id="customer_address"name="customer_address" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Type of Customer</label>
                        <select class="custom-select" name="customer_type">
                            <c:forEach var="customerType" items="${customerTypeList}">
                                <option id="${customerType.getCustomer_type_name()}" value="${customerType.getCustomer_type_id()}"> ${customerType.getCustomer_type_name()} </option>
                            </c:forEach>

                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success" value="Edit Customer">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteCustomerModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="/customer" id="formDelete">
                <input type="hidden" name="action" value="delete">
                <input id="customer_id" type="hidden" name="customer_id" />
                <div class="modal-header">
                    <h4 class="modal-title">Delete Customer</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete this customer?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit"  class="btn btn-danger" value="Delete">
                </div>
            </form>
        </div>
    </div>
</div>



<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>

<script>
    $(document).ready(function(){
        // Activate tooltips
        $('[data-toggle="tooltip"]').tooltip();

        // Filter table rows based on searched term
        $("#search").on("keyup", function() {
            let term = $(this).val().toLowerCase();
            $("table tbody tr").each(function(){
                $row = $(this);
                let name = $row.find("td:nth-child(2)").text().toLowerCase();
                console.log(name);
                if(name.search(term) < 0){
                    $row.hide();
                } else{
                    $row.show();
                }
            });

        });
        let groupColumn = 2;
        let table = $('#customerTable').DataTable({

            "lengthChange":false,
            "columnDefs": [
                { "visible": false, "targets": groupColumn }
            ],
            "order": [[ groupColumn, 'asc' ]],
            "displayLength": 5,
            "drawCallback": function ( settings ) {
                let api = this.api();
                let rows = api.rows( {page:'current'} ).nodes();
                let last=null;


            }
        } );
    });

    function setCustomerId(customer_id) {
        document.getElementById("customer_id").value = customer_id;

    }

    function setCustomerInfor(customer_id,customer_name,customer_birthday,customer_address,customer_type_name) {
        document.getElementById("customer_id_edit").value = customer_id;
        document.getElementById("customer_name").value = customer_name;
        document.getElementById("customer_birthday").value = customer_birthday;
        document.getElementById("customer_address").value = customer_address;
        document.getElementById(customer_type_name).selected = true;
    }

    if ( window.history.replaceState ) {
        window.history.replaceState( null, null, window.location.href );
    }
</script>
</body>
</html>