<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  trimDirectiveWhitespaces="true"
	import ="com.example.eatclipse.controller.member.SessionUserCounter"
%>
<!DOCTYPE html>

<html lang="en">
<head>
    <link rel="stylesheet" href="/eatclipse/resources/css/test.css">
    <meta charset="UTF-8">
    <title>좌측 토글 사이드 바 만들기</title>
</head>

<body>
    <div class="left-side-bar">
        <div class="status-ico">
            <span>▶</span>
            <span>▼</span>
        </div>

        <ul>
         <li>
                <a href="/eatclipse/admin/main.do">메인</a>
        
            </li>
            <li>
                <a href="#">사용자관리</a>
                <ul>
                    <li><a href="/eatclipse/admin/list/-1">전체사용자</a></li>
                    <li><a href="/eatclipse/admin/list/0">고객</a></li>
                    <li><a href="/eatclipse/admin/list/1">라이더</a></li>
                    <li><a href="/eatclipse/admin/list/2">가게</a></li>
                </ul>
            </li>
            <li>
                <a href="/eatclipse/admin/loglist.do">전체로그 보기</a>
             <!--    <ul>
                    <li><a href="#">2차 메뉴 아이템1</a></li>
                    <li><a href="#">2차 메뉴 아이템2</a></li>
                    <li><a href="#">2차 메뉴 아이템3</a></li>
                    <li><a href="#">2차 메뉴 아이템4</a></li>
                    <li><a href="#">2차 메뉴 아이템5</a></li>
                </ul> -->
            </li>
            <li>
                <a href="/eatclipse/admin/productlist.do">모든식당의 메뉴보기</a>
              <!--   <ul>
                    <li><a href="#">2차 메뉴 아이템1</a></li>
                    <li><a href="#">2차 메뉴 아이템2</a></li>
                    <li><a href="#">2차 메뉴 아이템3</a></li>
                    <li><a href="#">2차 메뉴 아이템4</a></li>
                    <li><a href="#">2차 메뉴 아이템5</a></li>
                </ul> -->
            </li>
            <li>
                <a href="#">현재 접속자 수 : <%=SessionUserCounter.getCount()%></a>

            </li>
        </ul>
    </div>
</body>
</html>