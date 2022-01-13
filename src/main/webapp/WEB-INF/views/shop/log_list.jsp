<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 목록</title>
<link rel="stylesheet" href="/eatclipse/resources/css/main.css">
<link rel="stylesheet" href="/eatclipse/resources/css/fontawesome-all.min.css">
<link rel="stylesheet" href="/eatclipse/resources/css/table_shop.css">
</head>
<body>
	<!-- 주문 목록 -->
	<section style="text-align: center"><h4>주문목록</h4></section>
	
	<div>
	<table>
		<tr>
			<td>주문번호</td>
			<td>주문시간</td>
			<td>메뉴이름</td>
			<td>수량</td>
			<td>결제금액</td>
			<td>주문자명</td>
			<td>주소</td>
			<td>주문상태</td>
		</tr>
		<c:forEach var="log" items="${loglist}">
			<tr>
				<td>${log.no}</td>
				<td><fmt:formatDate value="${log.start_date}" pattern="YY-MM-dd HH:mm:ss"/></td>
				<td>${log.product_name}</td>
				<td>${log.amount}</td>
				<td>${log.totalmoney}</td>
				<td>${log.order_name}</td>
				<td>${log.location}</td>
				<td  style="text-align: left">
					<c:if test="${log.status==0}">
						주문요청
						<input type="button" value="주문수락" onclick="location.href='/eatclipse/shop/status_update/${log.no}'">
					</c:if>
					
					<c:if test="${log.status==1}">
						조리중
						<input type="button" value="배달요청" onclick="location.href='/eatclipse/shop/status_update/${log.no}'">
					</c:if>
					
					<c:if test="${log.status==2}">
						라이더 요청중
					</c:if>
					
					<c:if test="${log.status==3}">
						배달중
						라이더 : ${log.rider_name}
					</c:if>
					
					<c:if test="${log.status==4}">
						배달완료
						<ul>
							<li>라이더 : ${log.rider_name}</li>
							<li>배달완료시간 : <fmt:formatDate value="${log.end_date}" pattern="YY-MM-dd HH:mm:ss"/></li>
						</ul>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>