<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/eatclipse/resources/css/main.css">
<link rel="stylesheet" href="/eatclipse/resources/css/include.css">
<header style="text-align: center;">
	<h1>
		<a href="/eatclipse/customer/main.do">
			<span class="title_color_white">{</span>
			<span class="title_color_yellow">Eat</span>
			<span class="title_color_blue">Clipse</span>
			<span class="title_color_white">};</span>
		</a>
	</h1>

	<nav>
		<c:choose>
			<c:when test="${sessionScope.userid != null}">
				<!-- 로그인상태. -->
				<ul>
					<li>${sessionScope.name} 님 환영합니다!</li>
					<li><a class="menu" href="/eatclipse/commons/logout.do">로그아웃</a></li>
					<li><a class="menu" href="/eatclipse/customer/myPage.do?userid=${sessionScope.userid}">마이페이지</a></li>
					<li><a class="menu" href="/eatclipse/cart/cartlist.do">장바구니</a></li>
				</ul>
			</c:when>
			<c:otherwise>
				<!-- 로그인 안되어있는 상태 -->
				<ul>
					<li><a class="menu" href="/eatclipse/commons/login.do">로그인</a></li>
					<li><a class="menu" href="/eatclipse/commons/join.do">회원가입</a></li>
				</ul>
			</c:otherwise>
		</c:choose>
	</nav>
</header>
