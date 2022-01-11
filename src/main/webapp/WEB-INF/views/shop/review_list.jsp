<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 보기</title>
</head>
<body>
	<h4>최근 리뷰</h4>
	<!-- <c:forEach val="row" items="${}" status="stat"></c:forEach>
		이렇게 구현하시고 
		stat의 count는 1부터 인덱스가 적용되요 
		그러니 if문을 사용하여 stat.count값이 홀수인지 판단해서 
		내용을 담는 문장을 구현해주시면 됩니다. -->
	<c:forEach var="log" items="${reviewlist}">
		${log.order_name}<br>
		${log.product_name} ${log.amount}<br>
		${log.review}<br>
		${log.start_date}<br>
	</c:forEach>
	
	
	<table>
		<tr>
			<td></td>
		</tr>
	</table>

</body>
</html>