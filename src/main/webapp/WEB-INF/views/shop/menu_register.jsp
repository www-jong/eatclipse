<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 등록</title>
<!-- 메뉴 등록 후 가게 관리 페이지로 넘어가는 작업 -->
<!-- 메뉴 등록 취소 버튼 -->
<script>
function menu_register(){
	var shop_name ="<%=session.getAttribute("name")%>";
	var product_name = document.form1.product_name.value;
	var price = document.form1.price.value;
	
	if(product_name==""){
		alert("메뉴를 입력하세요.");
		document.form1.product_name.focus();
	    return;
	}
	
	if(price==""){
		alert("가격을 입력하세요.");
		document.form1.price.focus();
	    return;
	}
	document.form1.action="/eatclipse/shop/insert.do";
	document.form1.submit();
}
</script>
</head>
<body>
	<%@ include file="../include/menu_shop.jsp"%>
	<h4>메뉴 등록</h4>
	<form name="form1" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>메뉴입력</td>
				<td><input type="text" name="product_name"></td>
			</tr>
			<tr>
				<td>가격입력</td>
				<td><input type="text" name="price"></td>

			</tr>
			<tr>
				<td>사진첨부</td>
				<td><input type="file" name="file1"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="메뉴등록" onclick="menu_register()"></td>
			</tr>
		</table>
	</form>
</body>
</html>