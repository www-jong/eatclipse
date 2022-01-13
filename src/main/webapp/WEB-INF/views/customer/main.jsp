<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EATCLIPSE</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="/eatclipse/resources/css/fontawesome-all.min.css">
<link rel="stylesheet" href="/eatclipse/resources/css/main.css">
<link rel="stylesheet" href="/eatclipse/resources/css/home.css">
<link rel="stylesheet" href="/eatclipse/resources/css/table_shop.css">
<style type="text/css">
img.recent {
  width: 150px;
  height: 150px;
  text-align:center;
}
</style>
</head>
<body>
<%@ include file="../include/menu_cust.jsp" %>
<div style="text-align:center; padding: 40px;">
   <a class="main" href="/eatclipse/customer/shopList/${type=2}">한식</a>
   <a class="main" href="/eatclipse/customer/shopList/${type=3}">양식</a>
   <a class="main" href="/eatclipse/customer/shopList/${type=4}">분식</a>
   <a class="main" href="/eatclipse/customer/shopList/${type=5}">중식</a>
</div>
<div style="text-align:center; padding: 40px;">
   <a class="main" href="/eatclipse/customer/shopList/${type=6}">일식</a>
   <a class="main" href="/eatclipse/customer/shopList/${type=7}">디저트</a>
   <a class="main" href="/eatclipse/customer/shopList/${type=8}">패스트푸드</a>
</div>
<div style="text-align: center;">
   <a href=""><img src="../images/menu_e.png" alt="메뉴월드컵"/></a>
   <a style="cursor:pointer;" onclick="gogogo()"><img src="../images/menu_r.png" alt="메뉴추천받기"/></a>
</div>

<br>
<h3 style="text-align: center;">[ 최근 주문한 가게]</h3>
<div class="center">
<table style="background-color:white;">
<tr>
<td><img class="recent" src="/eatclipse/images/크림치즈볼.jpg"></td>
<td><img class="recent" src="/eatclipse/images/크림치즈볼.jpg"></td>
<td><img class="recent" src="/eatclipse/images/크림치즈볼.jpg"></td>
<td><img class="recent" src="/eatclipse/images/크림치즈볼.jpg"></td>
<td><img class="recent" src="/eatclipse/images/크림치즈볼.jpg"></td>
</tr>
<tr>
<td>f</td>
<td>f</td>
<td>f</td>
<td>f</td>
<td>f</td>
</tr>
</table>
</div>
<script>
function gogogo(){
   window.open("/eatclipse/customer/recommendon","_blank","toolber=yes,menubar=yes,width=500,height=400").focus();   
}
</script>
</body>
</html>