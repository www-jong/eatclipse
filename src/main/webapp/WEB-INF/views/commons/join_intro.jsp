<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
	$("#btnLogin").click(function(){
		var userid=$("#userid").val();
		var passwd=$("#passwd").val();
		
		if(userid==""){
			alert("아이디는 필수값입니다.");
			$("#userid").focus();
			return;
			}
		if(passwd==""){
			alert("비밀번호는 필수값입니다.");
			$("#passwd").focus();
			return;
			}
		
		document.form1.action="/eatclipse/commons/join_check.do"; /* 확인하는페이지로 */
		document.form1.submit();
		});
	});
</script>
</head>
<body>
	<h2>회원가입</h2>
	<form name="form1" method="post">
		<a href="/eatclipse/commons/jointo/0">손님</a>
<a href="/eatclipse/commons/jointo/1">라이더</a>
<a href="/eatclipse/commons/jointo/2">가게</a>
		</form>
	</body>
</html>