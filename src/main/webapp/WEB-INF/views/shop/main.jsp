<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가게 관리</title>
<style>
	section{
	border-style: outset;
	}
	
	h4{
	text-align: center;
	}
</style>
<script>
function menu_type_update(){
	var type = document.menu.type.value;
	document.menu.action="/eatclipse/shop/menu_type_update.do"
}
</script>
</head>

<body>
	<%@ include file="../include/menu_shop.jsp"%>
	<h3>[${sessionScope.name}]관리 페이지</h3>

	<section id="menu" name="menu"> <!-- 가게 메뉴 section -->
		<h4>가게 메뉴</h4>
		<a href="/eatclipse/shop/menu_register.do">메뉴 등록</a>
		<table border="solid">
			<tr>
				<th>이미지</th>
				<th>메뉴</th>
				<th>가격</th>
				<th>상태</th>
				<th>수정</th>
			</tr>
			<c:forEach var="row" items="${menulist}">
			<tr>
				<td><img src="/eatclipse/images/${row.image}" width="100px" height="100px"></td> 
				<td>${row.product_name}</td>
				<td>${row.price}</td>
				<td>
				<c:if test="${row.type == 0}">판매중</c:if>
				<c:if test="${row.type == 1}">품절</c:if>
					<select>
						<option>판매</option>
						<option>품절</option>
					</select>
					<input type="button" value="변경" onclick="menu_type_update()">
				</td>
				<td>
				<a href="/eatclipse/shop/menu_edit.do">수정하기</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<br>
	</section>
<br>
	<section id="log"> <!-- 주문 목록 section -->
		<h4>주문목록</h4>
		<table>
		<tr>
			<th>주문번호</th>
			<th>주문자명</th>
			<th>주소</th>
			<th>주문시간</th>
			<th>메뉴이름</th>
			<th>수량</th>
			<th>상태</th>
			<th>라이더</th>
			<th>배달완료시간</th>
		</tr>
		<c:forEach var="log" items="${loglist}"> <!-- loglist?? -->
		<tr>
			<td>${log.no}</td>
			<td>${log.order_name}</td>
			<td>${log.order_name}</td>
		</tr>
		</c:forEach>
		</table>
	</section>
<br>
	<section id="review"> <!-- 리뷰 section -->
		<h4>최근 리뷰</h4>

	</section>

	
</body>
</html>