<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register form</h1>
        <h3 style="color: red">${requestScope.error}</h3>
        <form action="register" method="post">
            username:<input type="text" name="user" /><br/>
            password:<input type="password" name="pass" /><br/>
            role:
            <select name="role">
                <option value="1">Admin</option>
                <option value="2">User</option>
                <!-- Thêm các lựa chọn khác nếu cần -->
            </select><br/>
            <input type="submit" value="REGISTER"/>
        </form>
    </body>
</html>
