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
        <form:form commandName="book" action="${pageContext.request.contextPath}/app/edit/${book.bookID}" method="POST">
            Name: <form:input path="name" /> <form:errors path="name" /><br/>
            ISBN: <form:input path="isbn"/> <form:errors path="isbn" /><br/>
            Year: <form:input path="publishingYear"/> <form:errors path="publishingYear" /><br/>
            Authors:<form:input path="authors"/> <form:errors path="authors" /> <br />
            Publishers:<form:input path="publishers"/> <form:errors path="publishers" /> <br />
            <input type="submit" value="EDIT"/>
            <input type="reset" value="Empty" />
        </form:form>    

        <hr />
        <a href="${pageContext.request.contextPath}/app/books">List and search of books</a><br />
        <a href="${pageContext.request.contextPath}/app/bookform">To add a new book</a><br />
        <a href="${pageContext.request.contextPath}/app/logout">Kirjaudu ulos</a>
    </body>
</html>