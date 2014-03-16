<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" %>


<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <title>MyPortFolioApp | Profile ${account.username}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../resources/bootstrap/css/bootstrap-theme2.css" media="screen">
    <link rel="stylesheet" type="text/css" href="../resources/bootstrap/css/custom.css" media="screen">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">

    <script src="//code.jquery.com/jquery-1.9.1.js"></script>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <script type="text/javascript" src="../resources/bootstrap/js/bootstrap.js"></script>


    <script>
        $(function () {
            $("#accordion").accordion({
                active: false,
                collapsible: true
            });
        });
    </script>

</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
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
                <h1 class="panel-title">Projects</h1>
            </div>
            <div class="panel-body">
                <div id="accordion">


                    <c:if test="${categories != null}">
                        <c:forEach items="${categories}" var="categorie">
                            <h3>${categorie}</h3>

                            <div>
                                <c:if test="${projects != null}">
                                    <c:forEach items="${projects}" var="project">
                                        <c:if test="${project.category == categorie}">
                                            <a href="/project/show/${project.id}"
                                               class="btn top-buffer btn-default col-lg-12">${project.name}</a>
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </div>
                        </c:forEach>
                    </c:if>


                </div>
            </div>

        </div>

    </div>
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2 top-buffer panel panel-primary">
            <div class="panel-heading">
                <h2 class="panel-title">CV</h2>
            </div>
            <div class="panel-body">
                <p>ere is all your information!Here is all your information!Here is all your information!Here is all
                    your
                    ere is all your information!Here is all your information!Here is all your information!Here is all
                    your
                    ere is all your information!Here is all your information!Here is all your information!Here is all
                    your
                    ere is all your information!Here is all your information!Here is all your information!Here is all
                    your
                    ere is all your information!Here is all your information!Here is all your information!Here is all
                    your
                    ere is all your information!Here is all your information!Here is all your information!Here is all
                    your
                    ere is all your information!Here is all your information!Here is all your information!Here is all
                    your
                    ere is all your information!Here is all your information!Here is all your information!Here is all
                    your
                    ere is all your information!Here is all your information!Here is all your information!Her is all
                    your</p>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>