<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<head>
    <%@ include file="/WEB-INF/views/head.jsp" %>
    <script src="<c:url value="/scripts/jquery.validate.js"/>"></script>
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
                Donor Information Form
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-9">
                    <form:form id="donorForm" commandName="patient" method="post">
                        <form:hidden path="id"/>
                        <div class="box box-success">
                            <div class="box-header with-border">
                                <h3 class="box-title"></h3>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <p>*Field must be fell up</p>
                                <!-- text input -->
                                <div class="form-group">
                                    <label>Name*</label>
                                    <form:input path="name" class="form-control" required="true" placeholder="Enter Name..."/>
                                </div>

                                <div class="form-group">
                                    <label>ID No.</label>
                                    <form:input path="idno" class="form-control" required="true" placeholder="Enter ID..."/>
                                </div>

                                <div class="form-group">
                                    <label>Blood Group*</label>
                                    <form:select  id="bloodgroup" path="bgroup" Class="form-control" required="true">
                                        <option value="A+(Positive)">A+(Positive)</option>
                                        <option value="B+(Positive)">B+(Positive)</option>
                                        <option value="O+(Positive)">O+(Positive)</option>
                                        <option value="AB+(Positive)">AB+(Positive)</option>
                                        <option value="A-(Negative)">A-(Negative)</option>
                                        <option value="B-(Negative)">B-(Negative)</option>
                                        <option value="O-(Negative)">O-(Negative)</option>
                                        <option value="AB-(Negative)">AB-(Negative)</option>
                                    </form:select>
                                </div>

                                <div class="form-group">
                                    <label>Department</label>
                                    <form:input path="dept" class="form-control" placeholder="Enter Department..."/>
                                </div>
                                <div class="form-group">
                                    <label>Contact Number*</label>
                                    <form:input path="phone" required="true" class="form-control" placeholder="Enter Contact No..."/>
                                </div>

                                <div class="form-group">
                                    <label>Email</label>
                                    <form:input path="email" class="form-control" placeholder="Enter Email Address..."/>
                                </div>

                                <div class="form-group">
                                    <label>District*</label>
                                    <form:input path="district" required="true" class="form-control" placeholder="Enter Home District..."/>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="submit" class="btn btn-info btn-block">Submit</button>
                            </div>
                        </div>
                    </form:form>
                </div>
                <div class="col-md-3"></div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->


    <!-- thisis footer -->
    <%@ include file="/WEB-INF/views/footer.jsp" %>

    <!-- Control Sidebar -->
    <%@ include file="/WEB-INF/views/settings.jsp" %>
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>

</div>
<!-- ./wrapper -->
<script>
    $(document).ready(function(){

    });
</script>

<script>
    $("#donorForm").validate();
     //document.getElementById("bloodgroup");
    $("#bloodgroup").prop('selectedIndex',-1);
    //$("#bloodgroup :selected").valueOf();
    //$("#bloodgroup").val();
</script>

</body>
</html>










