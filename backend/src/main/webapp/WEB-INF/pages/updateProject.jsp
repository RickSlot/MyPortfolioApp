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

    <script src="//code.jquery.com/jquery-1.9.1.js"></script>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <script type="text/javascript" src="/resources/js/updateProject.js"></script>
</head>
<body>
<div class="container">
    <%@ include file="header.jsp" %>

    <div class="col-lg-8 col-lg-offset-2 panel panel-primary">
        <div class="panel-heading">
            <h2 class="panel-title">Update Project</h2>
        </div>

        <div class="panel-body">
            <form form action="/project/update" method="POST" enctype="application/json;charset=UTF-8"
                  name="project">
                <label for="idShow">Project Id:</label><br>
                <input id="idShow" class="form-control" name="id" type="text" value="${project.id}" disabled><br>
                <input id="id" name="id" type="hidden" value="${project.id}">
                <label for="ownerShow">Owner:</label><br>
                <input id="ownerShow" class="form-control" name="id" type="text" value="${project.ownerUsername}" disabled><br>
                <input id="ownerUsername" name="ownerUsername" type="hidden" value="${project.ownerUsername}">
                <label for="name">Name:</label><br>
                <input id="name" class="form-control" name="name" type="text" value="${project.name}"><br>
                <label for="company">Company:</label><br>
                <input id="company" class="form-control" name="company" type="text" value="${project.company}"><br>
                <label for="text">Category:</label><br>
                <input type="text" class="form-control" name="category" id="category" value="${project.category}"><br>
                <label for="summary">Summary:</label><br>
                <input type="text" class="form-control" name="summary" id="summary" value="${project.summary}"><br>
                <label for="text">Text:</label><br>
                <textarea class="form-control" name="description" id="text" rows="10">${project.description}</textarea><br>
                <div id="collaborators-field">
                    <p>Collaborators:</p>
                    <c:set var="count" value="0" scope="page" />

                        <c:forEach items="${project.collaboratorUsernames}" var="collaborator">
                            <div class="row">
                                <c:if test="${collaborator != null}">
                                    <input id='collaborator${count}' class='col-lg-10' name='collaboratorUsernames[${count}]' type='text' value="${collaborator}"><a class="btn btn-danger btn-sm pull-right" id="removeButton${count}" onclick="removeCollaborator(${count})">Remove</a><br>
                                </c:if>
                                <c:set var="count" value="${count + 1}" scope="page"/>
                            </div>
                        </c:forEach>
                        <script type="text/javascript">
                            setCollaboratorsSize(${count});
                        </script>
                </div>
                <br>
                <button type="submit" class="btn btn-md btn-primary">Update!</button>
                <a class="btn btn-default btn-sm pull-right" onclick="addCollaborator()">Add colaborator!</a>
                <br><br>
            </form>
        </div>

    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>