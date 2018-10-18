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
                User's Information Form
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-9">
                    <form:form id="userForm" commandName="user" method="post">
                        <form:hidden path="id"/>
                        <form:hidden path="role"/>
                        <div class="box box-success">
                            <div class="box-header with-border">
                                <h3 class="box-title"></h3>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <p>*Field must be fell up</p>
                                <!-- text input -->
                                <div class="form-group">
                                    <label>User Name*   ( atleast 3 Characters)</label>
                                    <form:input path="username" required="true"  minlength="3" class="form-control" placeholder="Enter your User Name..."/>
                                </div>

                                <div class="form-group">
                                    <label>Password*     ( Required: atleast 3 Characters)</label>
                                    <form:password path="password" required="true"  minlength="3" class="form-control" placeholder="Enter your Password..."/>
                                </div>

                                <div class="form-group">
                                    <label>E-mail*</label>
                                    <form:input path="email" required="true"  class="form-control" placeholder="Enter your Email Address..."/>
                                </div>
                                <div class="form-group">
                                    <label>Enabled </label>
                                    <form:checkbox path="enabled"/>
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
    $("#userForm").validate();
</script>

</body>
</html>















<%--



<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    &lt;%&ndash;<link type="text/css" rel="stylesheet" href="<c:url value="/styles/bootstrap.min.css"/>" />&ndash;%&gt;
        <%@ include file="/WEB-INF/views/head.jsp" %>
</head>
<body>
<h1><p class="text-center">Blood user Information Form</p></h1>
    &lt;%&ndash;@elvariable id="user" type=""&ndash;%&gt;
    <form:form commandName="user" method="post">
    <form:input path="id" cssStyle="display: none;"/>
    <table class="table">
        <tbody>
            <tr>
                <td>Name: </td>
                <td><form:input path="name" cssClass="form-control"/></td>
            </tr>
            <tr>
                <td>Blood Group </td>
                <td><form:select path="bgroup" cssClass="form-control">
                    <option value="A+(Positive)">A+(Positive)</option>
                    <option value="B+(Positive)">B+(Positive)</option>
                    <option value="O+(Positive)">O+(Positive)</option>
                    <option value="AB+(Positive)">AB+(Positive)</option>
                    <option value="A-(Negative)">A-(Negative)</option>
                    <option value="B-(Negative)">B-(Negative)</option>
                    <option value="O-(Negative)">O-(Negative)</option>
                    <option value="AB-(Negative)">AB-(Negative)</option>
                    </form:select>
            </tr>
            <tr>
                <td>Department:</td>
                <td><form:input path="dept" cssClass="form-control"/></td>
            </tr>
            <tr>
                <td>Phone No:</td>
                <td><form:input path="phone" cssClass="form-control"/></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><form:input path="email" cssClass="form-control"/></td>
            </tr>
            <tr>
                <td>District: </td>
                <td><form:input path="district" cssClass="form-control"/></td>
            </tr>
            <tr>
                <td>Number of Donation: </td>
                <td><form:input path="dtime" cssClass="form-control"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" class="btn btn-info btn-block"></td>
            </tr>
        </tbody>
    </table>
    </form:form>
</body>
</html>--%>
