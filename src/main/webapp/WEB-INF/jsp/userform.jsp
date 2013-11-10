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
        <a href="${pageContext.request.contextPath}/app/menu">Back to login page</a><br />
        <h1>Register to book library!</h1>
        <form:form commandName="user" action="${pageContext.request.contextPath}/app/userform" method="POST">
            Username: <form:input path="username" id="username"/> <form:errors path="username" />${error}<br/> 
            Password: <form:input path="password" id="password"/> <form:errors path="password" /><br/>
            <input type="submit" value="Register"/>
            <input type="reset" value="Empty" />
        </form:form>
        <hr>
        ${message}

    </body>
</html>
