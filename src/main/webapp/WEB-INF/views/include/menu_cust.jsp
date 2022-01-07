<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="text-align:right">
<a href = "/eatclipse/customer/main.do">Home</a>
<a href = "/eatclipse/customer/myPage.do?userid=${sessionScope.userid}">마이페이지</a> 
<a href = "/eatclipse/customer/cart.do">장바구니</a>
</div>



<hr>   