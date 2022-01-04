<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="text-align:right;">
 	<c:choose>
		<c:when test="${sessionScope.userid != null}">
			${sessionScope.name}님이 로그인중입니다. 
				<a href="/eatclipse/commons/logout.do">로그아웃</a>  
		</c:when>
		</c:choose>
</div>
<hr>