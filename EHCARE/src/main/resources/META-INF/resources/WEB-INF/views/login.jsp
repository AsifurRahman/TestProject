<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>EHCare_MBSTU</title>
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template -->
    <link href="css/landing-page.min.css" rel="stylesheet">
</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-light bg-light position-static-top">
    <div class="container">
        <%--<a class="btn btn-outline-danger" href="/brequest">Request for Blood</a>--%>
        <a class="btn btn-primary" href="/register">Register New Member</a>
        <a class="btn btn-info" href="/mbstu">Badhon MBSTU</a>
    </div>
</nav>

<!-- Masthead -->
<header class="masthead text-white text-center">
    <%--<div class="overlay"></div>--%>
    <div class="login-box">
        <div class="login-logo">
            <h3><P style="color:whitesmoke">E-Health Care->MBSTU</P></h3>
            <h4>
                <a style="text-decoration: none; color:aqua">
                    <i class="fa fa-phone"></i>
                    +8801944548934
                </a>
            </h4>
        </div>
        <!-- /.login-logo -->
        <div class="login-box-body">
            <%--<h4><p style="color:lightgoldenrodyellow" class="login-box-msg">Sign in as Badhon Member</p></h4>--%>
            <div class="col-md-8 col-lg-6 col-xl-5 mx-auto">
                <form:form action="/login" method="post">
                    <div class="form-group has-feedback">
                        <input id="username" type="text" class="form-control" name="username" placeholder="User Name"/>
                        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input id="password" type="password" class="form-control" name="password" placeholder="Password"/>
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="row">
                        <c:if test="${param.error ne null}">
                            <div class="alert-danger">${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</div>
                        </c:if>
                        <!-- /.col -->
                        <div class="col-md-12">
                            <button type="submit" class="btn btn-success btn-block">Sign In</button>
                        </div>
                        <!-- /.col -->
                    </div>
                </form:form>
                <!-- /.social-auth-links -->
            </div>

        </div>
        <!-- /.login-box-body -->
    </div>



        <%--<footer class="footer bg-light-blue">
            <div class="container">
                <div class="row ">
                    <div class="col-lg-12 h-100 text-center text-lg-left my-auto">
                        <ul class="list-inline mb-2">
                            <li class="list-inline-item">
                                <a href="#">About</a>
                            </li>
                            <li class="list-inline-item">&sdot;</li>
                            <li class="list-inline-item">
                                <a href="#">Contact</a>
                            </li>
                            <h4><p style="color:aqua" class="text-muted small mb-4 mb-lg-0">
                                &copy; AR_ASIF 2018. All Rights Reserved.</p></h4>
                        </ul>

                    </div>
                </div>
        </footer>--%>


</header>


<!-- Footer -->


<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
