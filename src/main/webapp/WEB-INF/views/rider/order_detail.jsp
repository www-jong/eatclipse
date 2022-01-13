<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/eatclipse/resources/css/main.css">
<link rel="stylesheet" href="/eatclipse/resources/css/fontawesome-all.min.css">
<title>주문정보</title>
</head>
<body>
<h2>주문정보</h2>
<table border="1" width="500px">

   <tr>
    <!--   <th>주문자명</th> -->
     <!--  <th>가게명</th> -->
      <th>음식명</th>
      <!-- <th>지역</th> -->
      <th>수량</th><!-- 이거누르면 같은log명을 가진 제품들 alert로 뜨게 -->
   </tr>
   <c:forEach var="row" items="${list}"><!-- status가 2인 log들만 올라옴 -->
   <tr>
     <%--  <td>${row.order_name}</td> --%>
     <%--  <td>${row.shop_name}</td> --%>
      <td>${row.product_name}</td>
     <%--  <td>${row.location}</td> --%>
      <td>${row.amount}</td>
   </tr>
</c:forEach>   
</table>
</body>
</html>