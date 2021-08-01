<%-- 
    Document   : history
    Created on : May 23, 2021, 4:52:18 PM
    Author     : PRREDETOR
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Page</title>
    </head>
    <body>

        <h1>Welcome : ${sessionScope.LOGIN_USER.username}</h1>
        <input type="hidden" value=" ${sessionScope.History}"  /> 
        <form action="MainController">
             Search by date<input type="date" name="Date"/>
             <input type="hidden" name="id" value="${sessionScope.LOGIN_USER.userid}"/>
             <input type="submit" name="action" value="SearchDay"/>
        </form>
       
             <c:if test="${requestScope.List_History !=null}">
            <c:if test="${not empty requestScope.List_History}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>ID</th>
                            <th>Item Name</th>
                            <th>Category Name</th>
                            <th>Day booking</th>
                            <th>Status</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="request" varStatus="counter" items="${requestScope.List_History}">                       
                        <form action="MainController">
                            <tr>
                                <td>${counter.count}</td>
                                <td>
                                    <c:forEach var="userName" items="${sessionScope.user_Name}">
                                        <c:if test="${(userName.userid)==(request.userID)}">
                                            ${userName.username}
                                        </c:if>                                       
                                    </c:forEach>
                                </td>
                                <td>
                                    <c:forEach var="itemname" items="${sessionScope.Item_Name}">
                                        <c:if test="${(itemname.itemID)==(request.itemID)}">
                                            ${itemname.itemName}
                                        </c:if>
                                    </c:forEach>
                                </td>                               
                                <td>
                                    <c:forEach var="catename" items="${sessionScope.Category_Name}">
                                        <c:if test="${(catename.cateID)==(request.cateID)}">
                                            ${catename.cateName}
                                        </c:if>                                       
                                    </c:forEach>
                                </td>
                                <td>${request.createreq}</td>
                                <td>${request.status}</td>
                                <td>
                                    <c:url var="delete" value="MainController">
                                        <c:param name="action" value="Delete"></c:param>                                      
                                        <c:param name="requestID" value="${request.requestid}"></c:param>                                        
                                    </c:url>
                                    <a href="${delete}">Delete</a>
                                </td>
                            </tr>

                        </form>
                    </c:forEach>                                                   
                </tbody>
            </table>

        </c:if>
    </c:if>
    <a href="bookingpge.jsp"/>Back
</body>
</html>
