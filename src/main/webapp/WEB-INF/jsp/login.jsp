<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WepaHT</title>
    </head>
    <body>
        <h1>Book Library</h1>
        <a href="${pageContext.request.contextPath}/app/books">List of the books</a><br/>

        <h3> Log in to use everything</h3>
        ${errorInData}
        <form action="<c:url value='/j_spring_security_check' />" method="POST">
            Username: <input type="text" name="username" id="username"/>
            Password: <input type="password" name="password" id="password"/>
            <input type="submit" value="Login" />
        </form>
        <a href="${pageContext.request.contextPath}/app/userform">Register here!</a><br/>
    </body>
</html>
