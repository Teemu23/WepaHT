<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Book details!</h1>
        Name: ${book.name} <BR>
        ISBN: ${book.isbn} <BR>
        Year: ${book.publishingYear} <BR>
        Publishers: ${book.publishers}<BR>
        Authors: ${book.authors}<BR>
        <img src="http://covers.openlibrary.org/b/isbn/${book.isbn}-M.jpg" /> <BR>
        <sec:authorize access="hasRole('user')">
            <a href="${pageContext.request.contextPath}/app/edit/${book.bookID}">Edit</a>
        </sec:authorize>
        ${message}
        <hr />
        <a href="${pageContext.request.contextPath}/app/books">List and search of books</a><br />
        <sec:authorize access="hasRole('user')">
            <a href="${pageContext.request.contextPath}/app/bookform">To add a new book</a><br />
            <a href="${pageContext.request.contextPath}/app/logout">Kirjaudu ulos</a>
        </sec:authorize>

    </body>
</html>
