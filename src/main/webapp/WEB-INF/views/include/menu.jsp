<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  trimDirectiveWhitespaces="true"
	import ="com.example.eatclipse.controller.member.SessionUserCounter"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/eatclipse/resources/css/include.css">
<header style="text-align: center;">
		<a href="/eatclipse">
			<span class="title_color_white">{</span>
			<span class="title_color_yellow">Eat</span>
			<span class="title_color_blue">Clipse</span>
			<span class="title_color_white">};</span>
		</a>
	<nav>
	 	<c:choose>
			<c:when test="${sessionScope.userid != null}"> <!-- 로그인상태. -->
				<ul>
					<li>${sessionScope.name}님이 로그인중입니다.</li>
					<li><a class="menu">현재접속자수 : <%=SessionUserCounter.getCount()%></a></li>
					<li><a class="menu" href="/eatclipse/commons/logout.do">로그아웃</a></li>
				</ul>
			</c:when>
			<c:otherwise> <!-- 로그인 안되어있는 상태 -->
				<ul>
				
					<li><a class="menu" href="/eatclipse/commons/login.do">로그인</a></li>
					<li><a class="menu" href="/eatclipse/commons/join.do">회원가입</a></li>
				</ul>
			</c:otherwise>
		</c:choose>
	</nav>
</header>