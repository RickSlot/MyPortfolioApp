<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <title>MyPortFolioApp | Create Picture</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../resources/bootstrap/css/bootstrap-theme2.css" media="screen">
    <link rel="stylesheet" type="text/css" href="../resources/bootstrap/css/custom.css" media="screen">
</head>
<body>
<div class="container">
    <%@ include file="header.jsp" %>

    <div class="col-lg-6 col-lg-offset-3 panel panel-primary">
        <div class="panel-heading">
            <h2 class="panel-title">Create Picture</h2>
        </div>

        <div class="panel-body">
            <form form action="/picture/create" method="POST" enctype="multipart/form-data"
                  name="picture">
                <p>Welcome on the page where you can upload a picture which you can use in your projects. We advise to use a prefix
                of the project name in the name of the picture. For example, if you have a project called first, you can use a prefix of first-.
                The image name will be projectname-imagename which will make it easier for you to use your uploaded images. The names are case sensitive!</p>
                <label for="name">Name:</label><br>
                <input id="name" class="form-control" name="name" type="text"><br>
                <label for="file">Picture:</label>
                <input type="file" name="file" id="file"><br>
                <button class="btn btn-md btn-primary">Create!</button>
                <br><br>
            </form>
        </div>

    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>