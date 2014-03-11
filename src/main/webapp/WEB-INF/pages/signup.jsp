<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" %>


<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css" media="screen">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.css" media="screen">
    <link rel="stylesheet" type="text/css" href="../css/custom.css" media="screen">
</head>
<body>
<div class="container">
    <%@ include file="header.jsp" %>

    <div class="col-lg-6 col-lg-offset-3 border">
        <h2>Register</h2>

        <form>
            <label for="username">Username (email):</label><br>
            <input id="username" class="form-control" name="username" type="text"><br>
            <label for="firstName">First Name:</label><br>
            <input id="firstName" class="form-control" name="lastName" type="text"><br>
            <label for="lastName">Last Name:</label><br>
            <input id="lastName" class="form-control" name="lastName" type="text"><br>
            <label for="password">Password:</label><br>
            <input id="password" class="form-control" name="password" type="password"><br>
            <label for="passwordAgain">Confirm password</label><br>
            <input id="passwordAgain" class="form-control" name="passwordAgain" type="password"><br><br>
            <button class="btn btn-md">Sign up!</button>
            <br><br>
        </form>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>