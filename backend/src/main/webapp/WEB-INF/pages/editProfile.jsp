<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" %>


<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <title>MyPortFolioApp | Update Project</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap-theme2.css" media="screen">
    <link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/custom.css" media="screen">
</head>
<body>
<div class="container">
    <%@ include file="header.jsp" %>

    <div class="col-lg-8 col-lg-offset-2 panel panel-primary">
        <div class="panel-heading">
            <h2 class="panel-title">Update Profile</h2>
        </div>

        <div class="panel-body">
            <form form action="/account/edit" method="POST" enctype="application/json;charset=UTF-8"
                  name="project">
                <label for="idShow">Username</label><br>
                <input id="idShow" class="form-control" name="username" type="text" value="${account.username}" disabled><br>
                <input id="id" name="username" type="hidden" value="${account.username}">
                <input id="password" name="password" type="hidden" value="${account.password}">
                <label for="firstName">First Name:</label><br>
                <input id="firstName" class="form-control" name="firstName" type="text" value="${account.firstName}"><br>
                <label for="lastName">Last Name:</label><br>
                <input id="lastName" class="form-control" name="lastName" type="text" value="${account.lastName}"><br>
                <label for="motto">Motto:</label><br>
                <input id="motto" class="form-control" name="biography" type="text" value="${account.biography}"><br>



                <button class="btn btn-md btn-primary">Update!</button>
                <br><br>
            </form>
        </div>

    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>