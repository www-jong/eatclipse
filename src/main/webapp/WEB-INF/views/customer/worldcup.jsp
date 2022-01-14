<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴추천!</title>
<link rel="stylesheet"
   href="/eatclipse/resources/css/fontawesome-all.min.css">
<link rel="stylesheet" href="/eatclipse/resources/css/main.css">
<link rel="stylesheet" href="/eatclipse/resources/css/home_cust.css">
<link rel="stylesheet" href="/eatclipse/resources/css/table_shop.css">
<script>
   function a(c) {
      document.form1.action = "/eatclipse/customer/worldcup.do?num=" + c;
      document.form1.submit();
   }
   function b(c) {
      document.form1.action = "/eatclipse/customer/worldcup.do?num=2";
      document.form1.submit();
   }
   function gogo() {
      document.form1.action = "/eatclipse/customer/worldcup.do";
      document.form1.submit();
   }
   function out() {
      window.close();
   }
</script>
</head>
<body>
   <h2>음식월드컵!</h2>
   <div style=center>
   <form name="form1" method="post">
      <table>
         <c:if test="${count==0}">
            <tr>
               <td>오늘의 배달메뉴를 월드컵으로 정해보세요!</td>
            </tr>
            <tr>
               <td><button onclick="gogo()" id="count" name="count" value="1">시작</button></td>
            </tr>
         </c:if>
         <c:if test="${count==1||count==2}">
            <tr>
               <td>둘중 더 좋아하는 것으로 골라보세요!</td>
            </tr>
            <tr>
               <td>
                  <a style="cursor: pointer;" onclick="a(1)">
                  <img src="../images/${first_image}" alt="${first_product_name}" /></a>
               </td>
               <td>
                  <a style="cursor: pointer;" onclick="a(2)">
                  <img src="../images/${second_image}" alt="${second_product_name}" /></a>
               </td>
            </tr>
            <tr>
                  <td>
                  ${first_shop_name}
               </td>
                        <td>
                  ${second_shop_name}
               </td>
            </tr>
            <tr>
               <td>
                  ${first_product_name}
               </td>
               <td>
                  ${second_product_name}
               </td>
            </tr>
         </c:if>
         <c:if test="${count==3}">
            <h2>당신의 음식은!</h2>
            <table>
            <tr><td><a style="cursor: pointer;"><img
                  src="../images/${first_image}" alt="${first_product_name}" /></a></td></tr>
                   <tr>
                  <td>
                  ${first_shop_name}
               </td>
               </tr>
               <tr>
                        <td>
                  ${first_product_name}
               </td>
            </tr>
            <tr><td><button onclick="out()" id="count" name="count" value="3">종료</button></td></tr>
            </table>
         </c:if>
         <input type="hidden" name="count" id="count" value="2">
      </table>
   </form>
</div>
</body>
</html>