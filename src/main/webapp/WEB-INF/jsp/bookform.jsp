<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book library</title>
    </head>
    <body>
        <h1>Welcome to use book library</h1>
        <a href="${pageContext.request.contextPath}/app/menu">Back to index page</a><br />
        <a href="${pageContext.request.contextPath}/app/books">List and search of books</a><br />

        Lisää uusi kirja:
        <form:form commandName="book" action="${pageContext.request.contextPath}/app/bookform/new" method="POST">
            Name: <form:input path="name" /> <form:errors path="name" /><br/>
            ISBN: <form:input path="isbn"/> <form:errors path="isbn" /><br/>
            Year: <form:input path="publishingYear"/> <form:errors path="publishingYear" /><br/>
            Authors:<form:input path="authors"/> <form:errors path="authors" /> <br />
            Publishers:<form:input path="publishers"/> <form:errors path="publishers" /> <br />
            <input type="submit" value="ADD"/>
            <input type="reset" value="Empty" />
        </form:form>    
        ${message} 

        <hr>

        <form:form commandName="book" action="${pageContext.request.contextPath}/app/bookform/newApi" method="POST">
            Hae: <form:input path="isbn" /><br />
            <input type="radio" name="valinta" value="name"/> Name<br/>
            <input type="radio" name="valinta" value="isbn"/> ISBN<br/>
            <input type="submit" value="ADD" />
        </form:form>
        <a href="${pageContext.request.contextPath}/app/logout">Kirjaudu ulos</a>
    </body>
</html>
