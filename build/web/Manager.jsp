<%-- 
    Document   : Manager
    Created on : May 21, 2021, 7:24:10 AM
    Author     : PRREDETOR
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

        <h1>Welcome : ${sessionScope.LOGIN_USER.username} </h1>
        <form action="MainController">
            <input type="submit" name="action" value="Logout"/>
        </form>
        <form action="MainController">
            <c:set var="itemname" value="${sessionScope.Item_name}"/>
            Item Name<select name="searchitemid">
                <option value="0">ALL</option>
                <c:forEach var="searchitem" items="${itemname}">
                    <option value="${searchitem.itemID}"
                            <c:if test="${param.searchitemid==searchitem.itemID}">
                                selected=""
                            </c:if>
                            >
                        ${searchitem.itemName}
                    </option>
                </c:forEach>
            </select>
            Status<select name="searchstatus">
                <option <c:if test="${(param.searchstatus)=='new'}">
                        selected=""
                    </c:if>
                    >
                    new
                </option>
                <option <c:if test="${(param.searchstatus)=='active'}">
                        selected=""
                    </c:if>
                    >
                    active
                </option>
                <option <c:if test="${(param.searchstatus)=='inactive'}">
                        selected=""
                    </c:if>>
                    inactive
                </option>
                <option  <c:if test="${(param.searchstatus)=='reject'}">
                        selected=""
                    </c:if>>
                    reject
                </option>
            </select>
            <input type="submit" name="action" value="SearchRequest"/>
        </form>
        <c:if test="${requestScope.List_Request!=mull}">
            <c:if test="${not empty requestScope.List_Request}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>User Name</th>
                            <th>Item Name</th>
                            <th>Category Name</th>
                            <th>Date request</th>
                            <th>status</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="request" varStatus="counter" items="${requestScope.List_Request}">
                        <form action="MainController">
                            <tr>
                                <td>${counter.count}</td>
                                <td>
                                    <c:forEach var="userName" items="${sessionScope.User_Name}">
                                        <c:if test="${(userName.userid)==(request.userID)}">
                                            ${userName.username}
                                        </c:if>                                       
                                    </c:forEach>
                                </td>
                                <td>
                                    <c:forEach var="itemname" items="${sessionScope.Item_name}">
                                        <c:if test="${(itemname.itemID)==(request.itemID)}">
                                            ${itemname.itemName}
                                        </c:if>                                       
                                    </c:forEach>
                                </td>                               
                                <td>
                                    <c:forEach var="catename" items="${sessionScope.Category}">
                                        <c:if test="${(catename.cateID)==(request.cateID)}">
                                            ${catename.cateName}
                                        </c:if>                                       
                                    </c:forEach>
                                </td>
                                <td>${request.createreq}</td>
                                <td>${request.status}</td>
                                <td>
                                    <c:url var="approve" value="MainController">
                                        <c:param name="action" value="Approve"></c:param>                                                                           
                                        <c:param name="reqID" value="${request.requestid}"></c:param>                                                                      
                                    </c:url>
                                    <a href="${approve}">Approve</a>

                                </td>
                                <td>
                                    <c:url var="reject" value="MainController">
                                        <c:param name="action" value="Reject"></c:param>                                                                           
                                        <c:param name="reqid" value="${request.requestid}"></c:param>                                                                      
                                    </c:url>
                                    <a href="${reject}">Refuse</a>
                                </td>
                                 <input type="hidden" name="searchlast" value="${param.searchitemid}" />
                                 <input type="hidden" name="searchlastcate" value="${param.searchstatus}" />
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>                
        </c:if>
    </c:if>
</body>
</html>
