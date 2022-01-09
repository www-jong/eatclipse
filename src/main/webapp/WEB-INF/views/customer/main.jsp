<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 메인 페이지</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
$(function(){
	$("#btnKorean").click(function(){  // 이거 왜 안돼!@#$#%^&^%#@&%^^%
		document.form1.action="/eatclipse/customer/korean.do";  // 경로가 맞나???
		document.form1.submit();
	});
</script>

</head>
<body>
<%-- <%@ include file="../include/menu.jsp" %> --%>
<%@ include file="../include/menu_cust.jsp" %>
<h2>고객 메인 페이지</h2>

<h3 style="text-align:center" > 배달은, 요기요! </h3><br>
<h3 style="text-align:center">[여기는 검색창 들어갈 자리]</h3><br>

<div style="text-align:center">
	<a href = "/eatclipse/customer/korean.do">한식</a>
	<a href = "/eatclipse/customer/western.do">양식</a>
	<a href = "/eatclipse/customer/bunsick.do">분식</a>
	<a href = "/eatclipse/customer/cart.do">중식</a>
	<a href = "/eatclipse/customer/cart.do">일식</a>
	<a href = "/eatclipse/customer/cart.do">디저트</a>
	<a href = "/eatclipse/customer/cart.do">패스트푸드</a>
</div>

<br>

<form name="form1" method="post">
<div>
	<input type="button" value="한식" id="btnKorean">
	<input type="button" value="양식" id="btnWestern">
	<input type="button" value="분식" id="btnBunsick">
</div>
</form>

<br>

<h3 style="text-align:center">[여기는 최근 본 가게 들어갈 자리]</h3>



</body>
</html>