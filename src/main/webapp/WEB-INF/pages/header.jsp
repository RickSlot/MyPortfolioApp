<header class="navbar navbar-fixed-top navbar-inverse">
    <div class="navbar-inner">
        <div class="container">
            <a href="/" id="logo">MyPortfolioApp</a>
            <nav>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="/">Home</a>
                    </li>
                    <li>
                        <a href="/account/">Show Profile</a>
                    </li>
                    <li>
                        <a href="/login">login</a>
                    </li>
                    <li>
                        <a href="/j_spring_security_logout">logout</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>

</header>
<br><br><br>
<c:if test="${message_error != null}">
    <div class="col-lg-4 col-lg-offset-4 alert alert-danger">${message_error}</div>
</c:if>

<c:if test="${message_succes != null}">
    <div class="col-lg-4 col-lg-offset-4 alert alert-success">${message_succes}</div>
</c:if>