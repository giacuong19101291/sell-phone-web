<%-- 
    Document   : new
    Created on : May 29, 2023, 1:43:02 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add a new category</h1>
        <h3 style="color: red"> ${requestScope.error}</h3>
        <form action="add" method="get">
            enter id:<input type="number" name="id"/><br/>
            enter name:<input type="text" name="name"/><br/>
            enter describe:<input type="text" name="desc"/><br/>
            <input type="submit" value="SAVE"/>
        </form>
    </body>
</html>
