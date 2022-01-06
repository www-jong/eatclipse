<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="text-align:right">
<a href = "/eatclipse/customer/">Home</a>
<a href = "/eatclipse/customer/myPage.do">마이페이지</a>   
<a href = "/eatclipse/customer/cart.do">장바구니</a>
</div>

<div style="text-align:left;">

 	<c:choose>
		<c:when test="${sessionScope.userid != null}"> <!-- 로그인상태. -->
			${sessionScope.name}님이 로그인중입니다. 
				<a href="/eatclipse/commons/logout.do">로그아웃</a>  
		</c:when>
		<c:otherwise> <!-- 로그인 안되어있는 상태 -->
			<a href="/eatclipse/commons/login.do">로그인</a>  |
			<a href="/eatclipse/commons/join.do">회원가입</a>
		</c:otherwise>
		</c:choose>
</div>

<hr>   