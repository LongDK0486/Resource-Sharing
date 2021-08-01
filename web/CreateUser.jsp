<%-- 
    Document   : CreateUser
    Created on : May 20, 2021, 5:12:22 PM
    Author     : PRREDETOR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User</title>
    </head>
    <body>
        <h1>Create new account</h1>
        <form action="MainController" method="POST">
            user ID <input type="text" name="userID" required="true"/><br/>
            ${requestScope.ERROR.userIDERROR}<br/>
            Address <input type="text" name="address" required="true"/><br/>
            ${requestScope.ERROR.addressERROR}<br/>
            Phone <input type="text" name="phone" required="true"/><br/>
            ${requestScope.ERROR.phoneERROR}<br/>
            Email <input type="text" name="email" required="true"/><br/>
             ${requestScope.ERROR.emailERROR}<br/>
            full Name <input type="text" name="fullName" required="true"/><br/>
            ${requestScope.ERROR.fullnamERROR}<br/>
            Password <input type="password" name="password" required="true"/><br/>
            Confirm  <input type="password" name="confirm" required="true"/><br/>
             ${requestScope.ERROR.confirmERROR}<br/>
            
            <input type="submit" name="action" value="Create"/>
        </form>
    </body>
</html>
