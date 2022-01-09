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
	<!-- 주문 목록 -->
	<h4>주문목록</h4>
	<table>
		<tr>
			<th>주문번호</th>
			<th>주문시간</th>
			<th>메뉴이름</th>
			<th>수량</th>
			<th>주문자명</th>
			<th>주소</th>
			<th>상태</th>
			<th>라이더</th>
			<th>배달완료시간</th>
		</tr>
		<c:forEach var="log" items="${loglist}">
			<tr>
				<td>${log.no}</td>
				<td>${log.start_date}</td>
				<td>${log.product_name}</td>
				<td>${log.amount}</td>
				<td>${log.order_name}</td>
				<td>${log.location}</td>
				<td>
					${log.status}
					
				</td>
				<td>${log.rider_name}</td>
				<td>${log.end_date}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>