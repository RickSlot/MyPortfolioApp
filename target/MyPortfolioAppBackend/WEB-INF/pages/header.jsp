<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="hasRole('ROLE_USER')">
                    <li>
                        <a href="/account/">Show Profile</a>
                    </li>

                    <li>
                        <a href="/project/createPage">New Project</a>
                    </li>

                    <li>
                        <a href="/picture/createPage">New Picture</a>
                    </li>

                    <li>
                        <a href="/logout">logout</a>
                    </li>
                </sec:authorize>

                <sec:authorize access="hasRole('ROLE_ANONYMOUS')">
                    <li>
                        <a href="/">Home</a>
                    </li>

                    <li>
                        <a href="/login">login</a>
                    </li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</div>
<br><br><br>

<div class="container">
    <c:if test="${param.message_error != null}">
        <div class="col-lg-4 col-lg-offset-4 alert alert-danger">${message_error}</div>
    </c:if>

    <c:if test="${param.logout != null}">
        <div class="col-lg-4 col-lg-offset-4 alert alert-success">Succesfully logged out!</div>
    </c:if>

    <c:if test="${param.error != null}">
        <div class="col-lg-4 col-lg-offset-4 alert alert-danger">Something went wrong with logging in :(</div>
    </c:if>

    <c:if test="${param.message_success != null}">
        <div class="col-lg-4 col-lg-offset-4 alert alert-success">${param.message_success}</div>
    </c:if>
</div>

