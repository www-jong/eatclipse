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
<link rel="stylesheet" href="/eatclipse/resources/css/home_cust.css">
<link rel="stylesheet" href="/eatclipse/resources/css/table_shop.css">
<style type="text/css">
img:hover{
   box-sizing: border-box;
   padding: 1px 1px 0;
    box-shadow: 0 10px 30px -15px;
    transition: .3s;
    padding: 10px;
}
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
   <a style="cursor:pointer;" onclick="gogogogo()"><img src="../images/menu_e.png" alt="메뉴월드컵"/></a>
   <a style="cursor:pointer;" onclick="gogogo()"><img src="../images/menu_r.png" alt="메뉴추천받기"/></a>
</div>

<h3 style="text-align: center;">[ 최근 주문한 가게]</h3>
		<table>
			<tr>
				<c:forEach var="row" items="${recent_shoplist}">
					<td><a
						href="/eatclipse/customer/shopInfo.do?shop_name=${row.shop_name}">
							<img class="recent" src="/eatclipse/images/${row.image}">
					</a></td>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach var="row" items="${recent_shoplist}">
					<td>${row.shop_name}</td>
				</c:forEach>
			</tr>
		</table>
	</div>
<script>
function gogogo(){
   window.open("/eatclipse/customer/recommendon","_blank","toolber=yes,menubar=yes,width=500,height=400").focus();   
}
function gogogogo(){
	   window.open("/eatclipse/customer/worldcupon","_blank","toolber=yes,menubar=yes,width=500,height=400").focus();   
	}
</script>
</body>
</html>