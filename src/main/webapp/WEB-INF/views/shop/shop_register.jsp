<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가게 등록</title>
<script src=""></script> <!-- 여기 주소 모르겠음 -->
<script>
function shop_register(){
	var shop_name = document.form1.shop_name.value;
	var product_name = document.form1.product_name.value;
	var price = documenet.form1.price.value;
	
	if(shop_name==""){
		alert("상호명을 입력하세요.");
		document.form1.shop_name.focus();
	    return;
	}
	
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
	<%@ include file="../include/menu.jsp"%>
	<h4>가게 등록</h4>
	<form name="form1" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>상호명</td>
				<td><input type="text" name="shop_name"></td>
			</tr>
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
				<input type="button" value="가게등록" onclick="shop_register()"></td>
			</tr>
		</table>
	</form>
</body>
</html>