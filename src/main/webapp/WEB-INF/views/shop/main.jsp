<%@ page language="java" contentType="text/html; charset=UTF-8"
 		pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/eatclipse/resources/css/main.css">
<link rel="stylesheet"
	href="/eatclipse/resources/css/fontawesome-all.min.css">
<link rel="stylesheet" href="/eatclipse/resources/css/table_shop.css">
<title>가게 관리</title>
</head>
 
<body>
	<%@ include file="../include/menu_shop.jsp"%>
	
	<h3>[${sessionScope.name}]관리 페이지</h3>
	<br>
	
	<!-- 가게 메뉴 -->
	<div class="center">
		<%@ include file="../shop/menu_list.jsp"%>
		<br>
	</div>

	<!-- 주문 목록 -->
	<div class="center">
		<%@ include file="../shop/log_list.jsp"%>
		<br>
	</div>

	<!-- 리뷰 목록 -->
	<div class="center">
		<%@ include file="../shop/review_list.jsp"%>
	</div>
</body>
</html>