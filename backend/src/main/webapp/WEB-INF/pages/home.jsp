<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>MyPortFolioApp | Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../resources/bootstrap/css/bootstrap-theme2.css" media="screen">
    <link rel="stylesheet" type="text/css" href="../resources/bootstrap/css/custom.css" media="screen">
</head>
<body>
<div class="container">
    <%@ include file="header.jsp" %>
    <div class="col-lg-10 col-lg-offset-1 jumbotron">
        <h1>MyPortfolioApp <br><small>A portfolio for everyone!</small></h1>
        <p>Welcome to the MyPortfolioApp website. On this site, you can create your very own portfolio. The only thing you need is an account
        and you can start creating. In less than 15 minutes you can build a good looking simple portfolio. Many people need to make a portfolio for
        school assignments. MyPortfolioApp is the solution!</p>
        <a class="btn btn-lg btn-primary" href="/signup">Sign up now!</a>
    </div>

    <div class="col-lg-6 col-lg-offset-3 panel panel-primary">
        <div class="panel-heading">
            <h2 class="panel-title">Login</h2>
        </div>

        <div class="panel-body">
            <form action="/j_spring_security_check" method='POST'/>
            <label for="name">Username:</label><br>
            <input id="name" class="form-control" name="j_username" type="text"><br>
            <label for="password">Password:</label><br>
            <input id="password" class="form-control" name="j_password" type="password"><br>
            <button class="btn btn-primary" name="submit" type="submit" value="submit">Login!</button>
            <br><br>
            </form>
        </div>

    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>