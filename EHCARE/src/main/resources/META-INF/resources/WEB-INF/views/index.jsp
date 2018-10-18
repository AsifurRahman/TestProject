<%@ page import="com.mbstu.ehcare.Utils" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html lang="en">
<head>
    <%@ include file="/WEB-INF/views/head.jsp" %>
</head>
<body class="hold-transition skin-purple sidebar-mini">
<div class="wrapper">

    <!-- This is Top menu bar  -->
    <%@ include file="/WEB-INF/views/topMenuBar.jsp" %>
    <!-- Left side column. contains the logo and sidebar -->
    <%@ include file="/WEB-INF/views/leftMenuBar.jsp" %>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                My Dashboard
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                        </div>
                        <div class="box-body">
                            <div class="dataTables_wrapper form-inline dt-bootstrap">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <table id="brequestTable" class="table table-striped">
                                            <thead>
                                            <tr>
                                                <th>Serial No</th>
                                                <th>Blood-Group</th>
                                                <th>Contact</th>
                                                <th>Location</th>
                                                <th>Status</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${brequestList}" var="brq" varStatus="status">
                                                <tr>
                                                    <td>${status.index+1}</td>
                                                    <td>${brq.bgroup}</td>
                                                    <td>${brq.phone}</td>
                                                    <td>${brq.location}</td>
                                                    <td>
                                                        <a class="btn btn-danger btn-sm" href="./deletebrequest?brequestId=${brq.id}">Delete</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </section>
        <!-- /.content -->

    </div>
</div>

<script>
    // $("#donorTable").dataTable();
    $(document).ready( function () {
        var table = $('#brequestTable').DataTable({
            "columnDefs": [
                {"className": "dt-center", "targets": "_all"}
            ]
        });
    } );
</script>
</body>
</html>