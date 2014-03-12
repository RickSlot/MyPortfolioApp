<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" %>


<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../resources/bootstrap/css/bootstrap-theme2.css" media="screen">
    <link rel="stylesheet" type="text/css" href="../resources/bootstrap/css/custom.css" media="screen">
</head>
<body>
<div class="container">
    <%@ include file="header.jsp" %>
    <div class="row">
        <div class="col-lg-3 top-buffer panel panel-primary">
            <div class="panel-heading">
                <h2 class="panel-title">Profile</h2>
            </div>
            <div class="panel-body">
                <c:if test="${account != null}">
                        <img src="http://www.aafje.nl/filelib/s1/profile.jpg" alt="profile pic" height="200" width="175">
                        <p><br><strong>Firstname: </strong>${account.firstName}<br>
                        <strong>Lastname: </strong>${account.lastName}<br>
                        <strong>Username: </strong>${account.username}<br>
                    <c:if test="${biography != null}">
                        <strong>Motto: </strong>${biography.text}</p>
                    </c:if>
                </c:if>
            </div>


        </div>
        <div class="col-lg-8 col-lg-offset-1 top-buffer panel panel-primary">
            <div class="panel-heading">
                <h2 class="panel-title">CV</h2>
            </div>
            <div class="panel-body">
                <p>ere is all your information!Here is all your information!Here is all your information!Here is all your
                    ere is all your information!Here is all your information!Here is all your information!Here is all your
                    ere is all your information!Here is all your information!Here is all your information!Here is all your
                    ere is all your information!Here is all your information!Here is all your information!Here is all your
                    ere is all your information!Here is all your information!Here is all your information!Here is all your
                    ere is all your information!Here is all your information!Here is all your information!Here is all your
                    ere is all your information!Here is all your information!Here is all your information!Here is all your
                    ere is all your information!Here is all your information!Here is all your information!Here is all your
                    ere is all your information!Here is all your information!Here is all your information!Her is all your</p>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2 top-buffer panel panel-primary">
            <div class="panel-heading">
                <h1 class="panel-title">Projects</h1>
            </div>
            <div class="panel-body">
                You can find all your projects here!
            </div>

        </div>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>