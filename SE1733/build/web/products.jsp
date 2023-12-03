<%-- 
    Document   : products
    Created on : May 29, 2023, 2:55:30 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/product.css">
    </head>
    <body>
        <div id="wrapper">
            <h1>Dien thoai moi</h1>
            <div id ="tab2">
                <ul>
                <c:forEach items="${requestScope.data}" var="p">
                    <div class="item">
                        <li >
                            <img src="${p.image}"/>
                        </li>
                    </div>
                </c:forEach>
                    </ul>
            </div>
        </div>
        
    </body>
</html>
