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
                File Upload Form
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-9">
                        <div class="box box-success">
                            <!-- /.box-header -->
                            <div class="box-body">
                                <p>*Field must be fell up</p>
                                <form method="POST" action="/fileupload" enctype="multipart/form-data">
                                    <input type="file" name="file" /><br/><br/>
                                    <input type="submit" id="fusb" value="Submit" />
                                </form>
                            <!-- /.box-body -->
                        </div>
                </div>
                <div class="col-md-3"></div>
            </div>
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
        console.log("Msg:"+msg);

    });
</script>



</body>
</html>










