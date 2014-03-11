<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" %>


<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <title>Create a Project</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css" media="screen">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.css" media="screen">
    <link rel="stylesheet" type="text/css" href="../css/custom.css" media="screen">
</head>
<body>
<div class="container">
    <%@ include file="header.jsp" %>

    <div class="col-lg-6 col-lg-offset-3 border">
        <h2>Create Project</h2>

        <form>
            <label for="name">Name:</label><br>
            <input id="name" class="form-control" name="name" type="text"><br>
            <label for="company">Company:</label><br>
            <input id="company" class="form-control" name="company" type="text"><br>
            <label for="description">Description:</label><br>
            <input type="text" class="form-control" id="description">
            <label for="password">Password:</label><br>
            <input id="password" name="password" type="password"><br>
            <label for="passwordAgain">Confirm password</label><br>
            <input id="passwordAgain" name="passwordAgain" type="password"><br><br>
            <button class="btn btn-md">Sign up!</button>
            <br><br>
        </form>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>