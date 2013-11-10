<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <a href="${pageContext.request.contextPath}/app/menu">Back to index page</a><br />
        <sec:authorize access="hasRole('user')">
            <a href="${pageContext.request.contextPath}/app/bookform">To add a new book</a><br />
        </sec:authorize>


        <h1>${title}</h1>

        <c:forEach var="book" items="${books}">
            <a href="${pageContext.request.contextPath}/app/books/${book.bookID}">Name: ${book.name}  Authors: ${book.authors}</a><br />
            <sec:authorize access="hasRole('user')">
                <form:form action="${pageContext.request.contextPath}/app/books/${book.bookID}" method="DELETE">
                    <input type="submit" value="Remove"/>
                </form:form>
            </sec:authorize>
        </c:forEach>

        <hr />

        <form>
            Etsi: <input type="input" name="search" /><br />
            <input type="radio" name="valinta" value="name"/> Name<br/>
            <input type="radio" name="valinta" value="author"/> Author<br/>
            <input type="submit" value="Hae" />
        </form>
        <sec:authorize access="hasRole('user')">
            <a href="${pageContext.request.contextPath}/app/logout">Kirjaudu ulos</a>
        </sec:authorize>
    </body>
</html>
