<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" %>


<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
    <c:if test="${message != null}">
        <div class="fixCenterAlert statusMessage statusMessageSucces"><p>${message}</p></div>
    </c:if>
	<h1>Welcome at my portfolio app!</h1>
</body>
</html>