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
	var shop_name ="<%=session.getAttribute("name")%>
	";
		var product_name = document.form1.product_name.value;
		var price = document.form1.price.value;

		if (product_name == "") {
			alert("메뉴를 입력하세요.");
			document.form1.product_name.focus();
			return;
		}

		if (price == "") {
			alert("가격을 입력하세요.");
			document.form1.price.focus();
			return;
		}
		document.form1.action = "/eatclipse/shop/insert.do";
		document.form1.submit();
	}
</script>
</head>
<body>
	<%@ include file="../include/menu_shop.jsp"%>
	<h4>메뉴 등록</h4>
	<form name="form1" method="post" enctype="multipart/form-data">
		<table>
			<thead>
				<tr>
					<th>메뉴 이름</th>
					<th>가격</th>
					<th>사진</th>
					<!-- <th>추가/삭제</th> -->
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="product_name"></td>
					<td><input type="text" name="price"></td>
					<td><input type="file" name="file1"></td>
					<!-- <td>
						<button onclick="copy_row(this); return false;">추가</button>
						<button onclick="remove_row(this)">삭제</button>
					</td> -->
				</tr>
			</tbody>
		</table>
		<input type="button" value="메뉴등록" onclick="menu_register()">
	</form>
</body>
</html>