<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 
author : BHS
-->
<!-- HEADER -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PhoneFly</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/common.min.css">
<script src="script/bootstrap.min.js"></script>
<script src="script/jquery-3.6.4.min.js"></script>
<script src="script/common.min.js"></script>
</head>
<body>
<div class="wrap">
<header id="header">
	<div id="logo" onclick="location.href='/index';">
		<img src="images/logo.png" />
	</div>
				<nav id="sub_menu">
					<ul class="nav justify-cotent-end">

						<c:choose>
							<c:when test="${empty loginUser}">
								<li class="nav-item"><a class="nav-link" href="/loginForm">로그인</a></li>
								<li class="nav-item"><a class="nav-link" href="/contract">회원가입</a></li>
							</c:when>
							<c:otherwise>

								<li class="nav-item"><a class="nav-link" href="javascript:;">${loginUser.name}(${loginUser.id})</a></li>
								<li class="nav-item"><a class="nav-link" href="/memberUpdateForm">정보수정</a></li>
								<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
								<!-- <li><a href="/cartList">장바구니</a></li> -->
								<li class="nav-item"><a class="nav-link" href="/orderList">마이페이지</a></li>
								<li class="nav-item"><a class="nav-link" href="/qnaList">1:1 문의</a></li>
							</c:otherwise>
						</c:choose>

						 <li class="nav-item"><a class="nav-link" href="/admin">admin</a></li> 

					</ul>
				</nav>
				<nav id="menu">
					<ul>
						<li onclick="location.href='/productList&mfc=Apple';">
							<div class="main_menu"></div><a href="javascript:void(0);">Apple</a>
						</li>
						<li onclick="location.href='/productList&mfc=Samsung';">
							<div class="main_menu"></div><a href="javascript:void(0);">삼성</a>
						</li>
 						<li onclick="location.href='/eventList';">
 							<div class="main_menu"></div><a href="javascript:void(0);">이벤트</a>
 						</li>
						<li onclick="location.href='/productCompare';">
							<div class="main_menu"></div><a href="javascript:void(0);">상품비교</a>
						</li>
						<li onclick="location.href='/FAQList';">
							<div class="main_menu"></div><a href="javascript:void(0);">자주하는질문</a>
						</li>
						<li onclick="location.href='/noticeList';">
							<div class="main_menu"></div><a href="javascript:void(0);">공지사항</a>
						</li>
					</ul>
				</nav>
</header>




<!-- To top button -->
    <button id="go_top" onclick="backToTop();"><svg xmlns="http://www.w3.org/2000/svg" width="38" height="38" fill="currentColor"
        class="bi bi-arrow-up-circle-fill" viewBox="0 0 16 16">
        <path fill-rule="evenodd"
          d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-7.5 3.5a.5.5 0 0 1-1 0V5.707L5.354 7.854a.5.5 0 1 1-.708-.708l3-3a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 5.707V11.5z" />
      </svg></button>
<!-- //To top button -->





<div class="clear"></div>
<!-- //HEADER -->



