<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/eatclipse/resources/css/main.css">
<link rel="stylesheet" href="/eatclipse/resources/css/fontawesome-all.min.css">
<title>메뉴 수정</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
	function menu_update(){
		var product_name = document.form1.product_name.value;
		var price = document.form1.price.value;
		var file1 = document.form1.file1.value;
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
		if (file1 == "") {
			alert("사진을 첨부하세요.");
			return;
		}
		document.form1.action="/eatclipse/shop/menu_update.do";
		document.form1.submit();
	}
</script>
</head>
<body>
	<%@ include file="../include/menu_shop.jsp"%>
	<h4>메뉴 수정</h4>
	<form name="form1" method="post" enctype="multipart/form-data">
	<input type="hidden" name="no" value="${dto.no}">
	<input type="hidden" name="shop_name" value="${dto.product_name}"><!--  -->
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
					<input type="file" name="file1">
				</td>
			</tr>
			<tr>
				<td>
					<button onclick="menu_update()">수정</button>
					<button onclick="menu_delete(no=${dto.no});">삭제</button>
	            	<script>
						function menu_delete(no){
							var msg = "삭제하시겠습니까?";
							var flag = confirm(msg);
							if(flag==true) {
								alert("메뉴를 삭제했습니다.");
								document.form1.action="/eatclipse/shop/delete/"+no;
								document.form1.submit();
							}
							else alert("취소되었습니다.");
						}
					</script>
				</td>
			</tr>
		</table>
			<c:if test="${message == 'error'}">
			<div style="color: red">존재하는 상품명이 있습니다.</div>
		</c:if>
	</form>
</body>
</html>