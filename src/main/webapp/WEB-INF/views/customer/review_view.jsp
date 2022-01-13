<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰내역</title>
<script>
	function product_write() {
		window.close();
	}
</script>
</head>
<body>
	<h2>리뷰쓰기!</h2>
	<br>
	<div class="center">
		<form name="form1" method="post">
			<table border="1" width="400px">
				<tr>
					<td><textarea rows="5" cols="60" id="review" name="review"
							value="${review}" disabled>${review}</textarea></td>
					<td><button type="button" onclick="product_write()">닫기</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>