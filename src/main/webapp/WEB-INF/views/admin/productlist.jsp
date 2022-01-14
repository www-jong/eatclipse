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
<h2>전체메뉴목록</h2>
 <a href="/eatclipse/admin/main.do">[메인화면]</a>
<table border="1" width="700px">
   <tr>
      <th>no</th>
      <th>가게명</th>
      <th>음식명</th>
      <th>가격</th>
      <th>사진</th>
   </tr>
   <c:forEach var="row" items="${list}">
   <tr>
      <td>${row.no}</td>
      <td>${row.shop_name}</td>
      <td>${row.product_name}</td>
      <td>${row.price}</td>
      <td><img src="/eatclipse/images/${row.image}" width="100px" height="100px"></td>
   </tr>
</c:forEach>   
</table>
</body>
</html>