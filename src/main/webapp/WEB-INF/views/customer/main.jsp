<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 메인 페이지</title>

<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<%-- <%@ include file="../include/menu.jsp" %> --%>
<%@ include file="../include/menu_cust.jsp" %>
<h3>"고객 메인 페이지"</h3>

<h3 style="text-align:center" > {EatClipse}; 배고픔엔 예외가 없잖아요 </h3>

<p style="text-align:center">---------------------------------------------------</p>

<h3 style="text-align:center">[여기는 검색창 들어갈 자리]</h3>

<p style="text-align:center">---------------------------------------------------</p>

<h5 style="text-align:center">[카테고리]</h5>
<div style="text-align:center">
<a href="/eatclipse/customer/shopList/${type=2}">한식</a>
<a href="/eatclipse/customer/shopList/${type=3}">양식</a>
<a href="/eatclipse/customer/shopList/${type=4}">분식</a>
<a href="/eatclipse/customer/shopList/${type=5}">중식</a>
<a href="/eatclipse/customer/shopList/${type=6}">일식</a>
<a href="/eatclipse/customer/shopList/${type=7}">디저트</a>
<a href="/eatclipse/customer/shopList/${type=8}">패스트푸드</a>
</div>


<p style="text-align:center">---------------------------------------------------</p>

<h3 style="text-align:center">[여기는 최근 본 가게 들어갈 자리]</h3>



</body>
</html>