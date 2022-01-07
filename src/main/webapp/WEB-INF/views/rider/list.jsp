<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function order_detail(no){
		window.open("/eatclipse/rider/detail/"+no,"_blank","toolber=yes,menubar=yes,width=700,height=500").focus();
		

}
</script>
</head>
<body>
<%@ include file="../include/menu_rider.jsp" %>
<h2>라이더 메인페이지</h2>
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
      <td><input type="button"  onclick="order_detail(no=${row.no})" value="상세보기"></td>
      <td><input type="button" onclick="location.href='/eatclipse/rider/complete/${row.no}'" value="완료"></td>
   </tr>
</c:forEach>   

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
      <td><input type="button"  onclick="order_detail(no=${row.no})" value="상세보기"></td>
      <td><input type='button' onclick="location.href='/eatclipse/rider/accept/${row.no}'" value="수락"></td>
   </tr>
</c:forEach>   

</table>
</body>
</html>