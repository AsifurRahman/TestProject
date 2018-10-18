<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body, html {
            height: 100%;
            margin: 0;
        }

        .bg {
            /* The image used */
            background-image: url("/img/bg-masthead.jpg");

            /* Full height */
            height: 100%;

            /* Center and scale the image nicely */
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }
    </style>
</head>
<%@ include file="/WEB-INF/views/head.jsp" %>
<script src="<c:url value="/scripts/jquery.validate.js"/>"></script>
<body class="bg">
<div class="register-box">
    <div class="register-logo">
        <h1 style="color:floralwhite">Badhon MBSTU</h1>
        <a href="/login" class="btn btn-info"> Back to Home Page</a>

    </div>
    <div class="register-box-body">
        <p class="login-box-msg"><strong>Register a new Account</strong></p>

        <form id="registerForm" action="/register" method="post">
            <div class="form-group has-feedback">
                <label>User Name</label>
                <input type="text" name="username" class="form-control" required="true" placeholder="Enter User Name">
                <%--<span class="glyphicon glyphicon-user form-control-feedback"></span>--%>
            </div>
            <div class="form-group has-feedback">
                <label>E-Mail</label>
                <input type="email" name="email" class="form-control" required="true" placeholder="Enter Email">
                <%--<span class="glyphicon glyphicon-envelope form-control-feedback"></span>--%>
            </div>
            <div class="form-group has-feedback">
                <label>Password</label>
                <input type="password" name="password" class="form-control" required="true" placeholder="Enter Password">
                <%--<span class="glyphicon glyphicon-lock form-control-feedback"></span>--%>
            </div>
            <%--<div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="Retype password">
                <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
            </div>--%>
            <div class="row">
                <!-- /.col -->
                <div class="col-xs-12">
                    <button type="submit" class="btn btn-info btn-block">Register</button>
                </div>
                <!-- /.col -->
            </div>
        </form>
        <div class="row">
            <div class="col-xs-12"></div>
        </div>
        <a href="/login" class="btn btn-success btn-block">I already have a membership</a>
    </div>
    <!-- /.form-box -->
</div>

<footer class="footer bg-light">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 h-100 text-center text-lg-left my-auto">
                <ul class="list-inline mb-2">
                    <li class="list-inline-item">
                        <a href="#">About</a>
                    </li>
                    <li class="list-inline-item">&sdot;</li>
                    <li class="list-inline-item">
                        <a href="#">Contact</a>
                    </li>
                    <li class="list-inline-item">&sdot;</li>
                    <li class="list-inline-item">
                        <a href="#">Privacy Policy</a>
                    </li>
                </ul>
                <h3><p style="color:aqua" class="text-muted small mb-4 mb-lg-0">
                    &copy; AR_ASIF 2018. All Rights Reserved.</p></h3>
            </div>
            <div class="col-lg-6 h-100 text-center text-lg-right my-auto">
                <ul class="list-inline mb-0">
                    <li class="list-inline-item mr-3">
                        <a href="#">
                            <i class="fa fa-facebook fa-2x fa-fw"></i>
                        </a>
                    </li>
                    <li class="list-inline-item mr-3">
                        <a href="#">
                            <i class="fa fa-twitter fa-2x fa-fw"></i>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="#">
                            <i class="fa fa-instagram fa-2x fa-fw"></i>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</footer>
<!-- /.register-box -->
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
</script>
<script>
    $("#registerForm").validate();
</script>
</body>
</html>
