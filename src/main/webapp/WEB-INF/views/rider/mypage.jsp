<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <!-- 날짜수정용 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/eatclipse/resources/css/main.css">
<link rel="stylesheet" href="/eatclipse/resources/css/fontawesome-all.min.css">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	
	$("#btnOn").click(function(){
		document.form2.action="/eatclipse/rider/mypageon.do";
		document.form2.submit();
	});
	$("#btnUpdate").click(function(){
		document.form1.action="/eatclipse/rider/update.do";
		document.form1.submit();
	});
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까?")){
		document.form1.action="/eatclipse/rider/delete.do";
		document.form1.submit();
		}
	});
});
</script>
</head>
<body>
 <%@ include file="../include/menu_rider.jsp" %> 
 <c:choose>
 <c:when test="${a==1}">
 

<form name="form1" method="post">
	<table border="1" width="700px" align="right">
	<caption>회원정보</caption>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userid" value="${sessionScope.userid}" readonly></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="passwd" value="${sessionScope.passwd}"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"value="${sessionScope.name}" ></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" value="${sessionScope.email}"></td>
		</tr>
		<tr>
			<td>잔액</td>
			<td><input type="text" name="money" value="${sessionScope.money}" readonly></td>
		</tr>
		<tr>
			<td>지역</td>
			<td><input type="text" name="location" value="${sessionScope.location}"></td>
		</tr>
		<tr>
			<td>가입일자</td>
			<td>
				<fmt:formatDate value="${sessionScope.join_date}" pattern="yyyy-MM-dd HH:mm:s"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="수정" id="btnUpdate">
				<input type="button" value="삭제" id="btnDelete">
			</td>
		</tr>
	</table>
	<div style="color:red;">${message}</div>
</form>
 </c:when>
 <c:otherwise>
<form name="form2" method="post">
	<table border="1" width="700px" align="right">
	<caption>회원정보</caption>
		<tr>
			<td>아이디</td>
			<td>${sessionScope.userid}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${sessionScope.passwd}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${sessionScope.name}</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${sessionScope.email}</td>
		</tr>
		<tr>
			<td>잔액</td>
			<td>${sessionScope.money}원</td>
		</tr>
		<tr>
			<td>지역</td>
			<td>${sessionScope.location}</td>
		</tr>
		<tr>
			<td>가입일자</td>
			<td>
				<fmt:formatDate value="${sessionScope.join_date}" pattern="yyyy-MM-dd HH:mm:s"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="수정" id="btnOn">
		
			</td>
		</tr>
	</table>
	<div style="color:red;">${message}</div>
</form>
 </c:otherwise>
 </c:choose>
<form name="form3" method="post">
	<table border="1" width="700px" align="left">
	<caption>배달내역</caption>
		<tr>
      <th>주문자명</th>
      <th>가게명</th>
      <th>지역</th>
      <th>상세보기</th><!-- 이거누르면 같은log명을 가진 제품들 alert로 뜨게 -->
      <th>배달완료날짜</th>
      <th>수익금</th>
   </tr>
   <c:forEach var="row" items="${complete_list}"><!-- status가 2인 log들만 올라옴 -->
   <tr>
      <td>${row.order_name}</td>
      <td>${row.shop_name}</td>
      <td>${row.location}</td>
      <td><input type="button"  onclick="order_detail(no=${row.no})" value="상세보기"></td>
      <td>${row.end_date}</td>
      <td>${row.totalmoney}</td>
   </tr>
   <script>
function order_detail(no){
		window.open("/eatclipse/rider/detail/"+no,"_blank","toolber=yes,menubar=yes,width=700,height=500").focus();
		

}
</script>
</c:forEach>   
	</table>
	<div style="color:red;">${message}</div>
</form>
</body>
</html>