<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<table>
		<tr>
			<c:forEach var="log" items="${reviewlist}" varStatus="status">
				<c:if test="${status.index%5==0}">
					<tr></tr>
				</c:if>
				<td>
					${log.order_name}
				</td>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach var="log" items="${reviewlist}" varStatus="status">
				<c:if test="${status.index%5==0}">
					<tr></tr>
				</c:if>
				<td>
					${log.product_name} ${log.amount}
				</td>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach var="log" items="${reviewlist}" varStatus="status">
				<c:if test="${status.index%5==0}">
					<tr></tr>
				</c:if>
				<td>
					${log.review}
				</td>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach var="log" items="${reviewlist}" varStatus="status">
				<c:if test="${status.index%5==0}">
					<tr></tr>
				</c:if>
				<td>
					<fmt:formatDate value="${log.start_date}" pattern="YY-MM-dd HH:mm:ss"/>
				</td>
			</c:forEach>
		</tr>
	</table>
</body>
</html>