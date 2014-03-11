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
    <div class="row">
        <div class="col-lg-3 border top-buffer">
            <h1>Profile</h1>
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
        <div class="col-lg-8 col-lg-offset-1 border top-buffer">
            <h1>CV</h1>
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
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2 border top-buffer">
            <h1>Projects</h1>
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>