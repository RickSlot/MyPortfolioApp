<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" %>


<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <title> MyPortFolioApp | ${project.name}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap-theme2.css" media="screen">
    <link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/custom.css" media="screen">
</head>
<body>
<div class="container">
    <%@ include file="header.jsp" %>
    <sec:authentication var="principal" property="principal" />


    <div class="col-lg-10 col-lg-offset-1 panel panel-primary">
        <div class="panel-heading">
            <h1 class="panel-title">
                ${project.name}
                <c:if test="${principal == project.ownerUsername}">
                    <a href="/project/updatePage/${project.id}" class="btn btn-xs btn-success">Edit</a>
                </c:if>
            </h1>
        </div>

        <div class="panel-body">
            <p><strong>Project Name: </strong>${project.name}</p>
            <p><strong>Company: </strong>${project.company}</p>
            <p><strong>Category: </strong>${project.category}</p>
            <p><strong>Summary: </strong> ${project.summary}</p>
            <p><strong>Description: </strong></p><br>
            <p>${project.description}</p>
        </div>

    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>