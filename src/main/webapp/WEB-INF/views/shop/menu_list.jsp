<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function menu_type_update(){
			var type = document.menu.type.value;
			document.menu.action="/eatclipse/shop/menu_type_update.do";
		}
	</script>
</head>
<body>
	<!-- 가게 메뉴 -->
	<h4>가게 메뉴</h4>
	<a href="/eatclipse/shop/menu_register.do">메뉴 등록</a>
	<table>
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
					</select> <input type="button" value="변경" onclick="menu_type_update()">
				</td>
				<td><a href="/eatclipse/shop/menu_edit.do">수정하기</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>