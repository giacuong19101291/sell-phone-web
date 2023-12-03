<%-- 
    Document   : new
    Created on : May 29, 2023, 1:43:02 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update a category</h1>
        <c:set var="c" value="${requestScope.category}" />
        <form action="update" method="post">
            enter id:<input type="number" readonly name="id" value="${c.id}"/><br/>
            enter name:<input type="text" name="name" value="${c.name}"/><br/>
            enter describe:<input type="text" name="desc" value="${c.describe}"/><br/>
            <input type="submit" value="UPDATE"/>
        </form>
    </body>
</html>
