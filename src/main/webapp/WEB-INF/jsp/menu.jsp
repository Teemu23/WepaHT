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
        ${message}

        <a href="${pageContext.request.contextPath}/app/books">List of the books</a><br/>
        <a href="${pageContext.request.contextPath}/app/bookform">Add new book</a><br/>
        <a href="${pageContext.request.contextPath}/app/logout">Kirjaudu ulos</a>
    </body>
</html>
