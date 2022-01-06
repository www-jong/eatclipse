<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>라이더 메인페이지</h2>
<table>
<h2>현재 배달중인 목록</h2>
<table border="1" width="700px">
   <tr>
      <th>주문자명</th>
      <th>가게명</th>
      <th>지역</th>
      <th>상세보기</th><!-- 이거누르면 같은log명을 가진 제품들 alert로 뜨게 -->
      <th>()()</th>
   </tr>
   <c:forEach var="row" items="${accept_list}"><!-- status가 2인 log들만 올라옴 -->
   <tr>
      <td>${row.order_name}</td>
      <td>${row.shop_name}</td>
      <td>${row.location}</td>
      <td>상세보기</td>
      <td>배달완료</td>
   </tr>
</c:forEach>   

</table>
</table>
<h2>수락가능한 배달목록</h2>
<table border="1" width="700px">
   <tr>
      <th>주문자명</th>
      <th>가게명</th>
      <th>지역</th>
      <th>상세보기</th><!-- 이거누르면 같은log명을 가진 제품들 alert로 뜨게 -->
      <th>()()</th>
   </tr>
   <c:forEach var="row" items="${delivery_list}"><!-- status가 2인 log들만 올라옴 -->
   <tr>
      <td>${row.order_name}</td>
      <td>${row.shop_name}</td>
      <td>${row.location}</td>
      <td>대충 상세보기 버튼이 들어간다는 내용</td>
      <td>수락</td>
   </tr>
</c:forEach>   

</table>
</body>
</html>