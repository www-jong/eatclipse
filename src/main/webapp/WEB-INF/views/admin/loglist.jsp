<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>전체로그 목록</h2>
 <a href="/eatclipse/admin/main.do">[메인화면]</a>
<table border="1" width="700px">
   <tr>
      <th>no</th>
      <th>주문자명</th>
      <th>가게명</th>
      <th>음식명</th>
      <th>수량</th>
  	  <th>라이더명</th>
  	  <th>장소</th>
  	  <th>상태</th>
  	  <th>주문시간</th>
  	  <th>배달완료시간</th>	
   </tr>
   <c:forEach var="row" items="${list}">
   <tr>
      <td>${row.no}</td>
      <td>${row.order_name}</td>
      <td>${row.shop_name}</td>
      <td>${row.product_name}</td>
      <td>${row.amount}</td>
      <td>${row.rider_name}</td>
      <td>${row.location}</td>
      <td>
       <c:if test="${row.status==0}">주문</c:if>
      <c:if test="${row.status==1}">주문접수</c:if>
      <c:if test="${row.status==2}">조리완료</c:if>
      <c:if test="${row.status==3}">배달중</c:if>
      <c:if test="${row.status==4}">배달완료</c:if>
      </td>
      <td><fmt:formatDate value="${row.start_date}" pattern="yyyy-MM-dd HH:mm:s"/></td>
      <td><fmt:formatDate value="${row.end_date}" pattern="yyyy-MM-dd HH:mm:s"/></td>
   </tr>
</c:forEach>   
</table>
</body>
</html>