<%@ page import="com.mbstu.ehcare.Utils" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu tree" data-widget="tree">
            <li class="treeview menu-open">
                <a href="#">
                    <i class="fa fa-laptop "></i>
                    <span>Administration</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu" style="display: block;">
                    <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
                        <li><a href="/"><i class="fa fa-fw fa-home text-aqua"></i>Home</a></li>
                    </security:authorize>
                    <security:authorize access="hasAnyRole('ROLE_ADMIN')">
                        <li><a href="/upsertUser"><i class="fa fa-fw fa-user-plus text-red"></i>Add User</a></li>
                            <li><a href="/userList"><i class="fa fa-fw fa-th-list text-orange"></i>User Information</a></li>
                        </security:authorize>
                </ul>
            </li>
        </ul>

        <ul class="sidebar-menu tree" data-widget="tree">
            <li class="treeview menu-open">
                <a href="#">
                    <i class="fa fa-user"></i>
                    <span>Patient</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu" style="display: block;">
                    <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
                        <li><a href="/upsertPatient"><i class="fa fa-fw  fa-user-plus text-red"></i>Add Patient</a></li>
                        <li><a href="/patientList"><i class="fa fa-fw fa-th-list text-yellow"></i>Patient Information</a></li>
                    </security:authorize>
                </ul>
            </li>
        </ul>

        <ul class="sidebar-menu tree" data-widget="tree">
            <li class="treeview menu-open">
                <a href="#">
                    <i class="fa fa-fw fa-th-large"></i>
                    <span>Doctor</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu" style="display: block;">
                    <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
                        <li><a href="/upsertDoctor"><i class="fa fa-fw  fa-user-plus text-red"></i>Add Doctor</a></li>
                        <li><a href="/doctorList"><i class="fa fa-fw fa-th-list text-yellow"></i>Doctor Information</a></li>
                        <li><a href="/fileupload"><i class="fa fa-fw fa-th-list text-yellow"></i>File Upload</a></li>
                    </security:authorize>
                </ul>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>