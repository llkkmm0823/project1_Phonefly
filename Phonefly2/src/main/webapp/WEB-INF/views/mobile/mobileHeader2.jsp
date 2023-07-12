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
<link rel="stylesheet" type="text/css" href="css/mobileheader.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/mobileBanner.css">
<script src="script/bootstrap.min.js"></script>
<script src="script/jquery-3.6.4.min.js"></script>
<script src="script/mobile.js"></script>
<script src="script/mainBanner.js"></script>
<script src="script/mainColorSelect.js"></script>
</head>
<body>
<div class="container-fluid">
<header id="header">



	<div class="d-flex mb-3">
		<div class="p-2">
			<div class="d-grid gap-2 d-md-block">
				<img src="images/logo.png" />
			</div>
		</div>
		<div class="ms-auto p-2">
			<!-- 메뉴 버튼 -->
			<div class="mobile-menu-btn m-4" onclick="">
				<svg xmlns="http://www.w3.org/2000/svg" width="100" height="100" fill="currentColor" class="bi bi-menu-button-wide" viewBox="0 0 16 16">
				  <path d="M0 1.5A1.5 1.5 0 0 1 1.5 0h13A1.5 1.5 0 0 1 16 1.5v2A1.5 1.5 0 0 1 14.5 5h-13A1.5 1.5 0 0 1 0 3.5v-2zM1.5 1a.5.5 0 0 0-.5.5v2a.5.5 0 0 0 .5.5h13a.5.5 0 0 0 .5-.5v-2a.5.5 0 0 0-.5-.5h-13z"/>
				  <path d="M2 2.5a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1-.5-.5zm10.823.323-.396-.396A.25.25 0 0 1 12.604 2h.792a.25.25 0 0 1 .177.427l-.396.396a.25.25 0 0 1-.354 0zM0 8a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V8zm1 3v2a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2H1zm14-1V8a1 1 0 0 0-1-1H2a1 1 0 0 0-1 1v2h14zM2 8.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0 4a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5z"/>
				</svg>
			</div>
			<!-- //메뉴 버튼 -->
		</div>
	</div>








	<!-- 모바일 메뉴 -->
	<div class="mobile-menu disabled">
		<!-- X 버튼 -->
		<div class="mobile-menu-x-btn">
			<svg xmlns="http://www.w3.org/2000/svg" width="100" height="100" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16">
			  <path d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z"/>
			</svg>
		</div>
		<!-- //X 버튼 -->
	
		<nav id="menu">
			<ul>
				<li>
					Apple
				</li>
				<li>
					삼성
				</li>
				<li>
					이벤트
				</li>
				<li>
					상품비교
				</li>
				<li>
					자주하는질문
				</li>
				<li>
					공지사항
				</li>
			</ul>
		</nav>
	</div>
	<!-- //모바일 메뉴 -->



</header>

<div class="clear"></div>
<!-- //HEADER -->

