<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" %>


<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../resources/bootstrap/css/bootstrap-theme2.css" media="screen">
    <link rel="stylesheet" type="text/css" href="../resources/bootstrap/css/custom.css" media="screen">
    <script src="../resources/js/signup.js"></script>
</head>
<body>
<div class="container">
    <%@ include file="header.jsp" %>

    <div class="col-lg-6 col-lg-offset-3 panel panel-primary">
        <div class="panel-heading">
            <h2 class="panel-title">Register</h2>
        </div>

        <div class="panel-body">
            <form action="/account/save" method="POST" enctype="application/json;charset=UTF-8"
                  name="account" onsubmit="return validateForm()">
                <label for="username">Username (email):</label><br>
                <input id="username" class="form-control" name="username" type="text"><br>
                <label for="firstName">First Name:</label><br>
                <input id="firstName" class="form-control" name="firstName" type="text"><br>
                <label for="lastName">Last Name:</label><br>
                <input id="lastName" class="form-control" name="lastName" type="text"><br>
                <label for="password">Password:</label><br>
                <input id="password" class="form-control" name="password" type="password"><br>
                <label for="passwordAgain">Confirm password</label><br>
                <input id="passwordAgain" class="form-control" name="passwordAgain" type="password"><br><br>
                <button class="btn btn-primary">Sign up!</button>
                <br><br>
            </form>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>