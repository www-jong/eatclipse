<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 수정</title>
<script>
	function menu_update() {
		var product_name = document.form1.product_name.value;
		var price = document.form1.price.value;
		var image = document.form1.image.value;
		if (product_name == "") {
			alert("상품명을 입력하세요.");
			document.form1.product_name.focus();
			return;
		}
		if (price == "") {
			alert("가격을 입력하세요.");
			document.form1.price.focus();
			return;
		}
		if (image == "") {
			alert("사진을 첨부하세요.");
			return;
		}
		document.form1.action = "/eatclipse/shop/menu_edit.do";
		document.form1.submit();
	}
	function product_delete(){
	    if(confirm("삭제하시겠습니까?")){
	      document.form1.action="/eatclipse/shop/delete.do"
	      document.form1.submit();
	   } 
	}
</script>
</head>
<body>
	<%@ include file="../include/menu_shop.jsp"%>
	<h4>메뉴 수정</h4>
	<form name="form1" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>메뉴이름</td>
				<td><input name="product_name" value="${dto.product_name}"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input name="price" value="${dto.price}"></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td>
					<img src="/eatclipse/images/${dto.image}" width="100px" height="100px">
					<input type="file" name="image">
				</td>
			</tr>
			<tr>
				<td><input type="button" value="수정" onclick="menu_update()" /></td>
				<td><input type="button" value="삭제" onclick="menu_delete()" /></td>
				<td><a href="/shop/main.do">취소</a></td>
			</tr>
		</table>
	</form>
</body>
</html>