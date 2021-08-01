<%-- 
    Document   : bookingpge
    Created on : May 18, 2021, 7:48:44 PM
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
              Search Name<input type="text" name="Search" value="${param.Search}"/>
              <c:set var="cate" value="${sessionScope.Category}"/>
              Category <select name="SearchCate">
                  <option value="0">ALL</option>
                  <c:forEach var="cateca" items="${cate}">
                      <option value="${cateca.cateID}" 
                              <c:if test="${param.SearchCate==cateca.cateID}">
                                  selected=""
                              </c:if>      
                              >
                          ${cateca.cateName}
                      </option>
                  </c:forEach> 
              </select>
              Using Day<input type="number" name="Searchday" value="${param.Searchday}"/>
            <input type="submit"  name="action" value="Search"/>
         </form>
         <c:if test="${requestScope.List_Item !=null}">
             <c:if test="${not empty requestScope.List_Item}">
                 <table border="1">
                     <thead>
                         <tr>
                             <th>No</th>
                             <th>ID</th>
                             <th>Name</th>
                             <th>Category</th>
                             <th>Color</th>
                             <th>Use Day</th>
                             <th>Booking</th>
                         </tr>
                     </thead>
                     <tbody>
                     <c:forEach var="item" varStatus="counter" items="${requestScope.List_Item}">                       
                         <form action="MainController">
                             <tr>
                                 <td>${counter.count}</td>
                                 <td>${item.itemID}</td>
                                 <td>${item.itemName}</td>
                                 <td>${item.cateid}</td>
                                 <td>${item.color}</td>
                                 <td>${item.useday}</td>
                                 <td>
                                     <c:url var="booking" value="MainController">
                                        <c:param name="action" value="Booking"></c:param>                                      
                                        <c:param name="Search" value="${param.Search}"></c:param>
                                        <c:param name="Search2" value="${param.SearchCate}"></c:param>
                                        <c:param name="Search3" value="${param.Searchday}"></c:param>
                                        <c:param name="userid" value="${sessionScope.LOGIN_USER.userid}"></c:param>
                                        <c:param name="cateID" value="${item.cateid}"></c:param>                                 
                                        <c:param name="itemID" value="${item.itemID}"></c:param>
                                     </c:url>
                                    <a href="${booking}">Booking</a>
                                 </td>
                             </tr>
                             <input type="hidden" name="searchlast" value="${param.Search}" />
                             <input type="hidden" name="searchlastcate" value="${param.SearchCate}" />
                             <input type="hidden" name="searchlastday" value="${param.Searchday}" />
                         </form>
                     </c:forEach>                                                   
                     </tbody>
                 </table>
                 <c:forEach begin="1" end="${requestScope.END_PAGE}" var="i">         
                <c:url var="page" value="MainController">
                    <c:param name="action" value="Search"></c:param>
                    <c:param name="index" value="${i}"></c:param>
                    <c:param name="Search" value="${param.Search}"></c:param>
                    <c:param name="Search2" value="${param.SearchCate}"></c:param>
                    <c:param name="Search3" value="${param.Searchday}"></c:param>
                </c:url>
                     <a href="${page}">${i}</a> 
            </c:forEach>              
             </c:if>
         </c:if>
                     </br>
                     <form action="MainController">
                         <input type="submit" name="action" value="History"/>
                         <input type="hidden" name="UserID" value="${sessionScope.LOGIN_USER.userid}" />
                     </form>
               
            
    </body>
</html>
