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
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<meta name="viewport" content="width=device-width">
<title>PhoneFly</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/mobileCommon.css">
<link rel="stylesheet" type="text/css" href="css/mobileBanner.css">
<!-- <link rel="stylesheet" type="text/css" href="css/mobileFooter.css"> -->
<script src="script/bootstrap.min.js"></script>
<script src="script/jquery-3.6.4.min.js"></script>
<script src="script/mainBanner.js"></script>
<script src="script/mainColorSelect.js"></script>
</head>
<body>
<div class="container-fluid">
<header id="header">



<nav class="navbar bg-light fixed-top">
	<div class="container-fluid">
		<img class="mobile-logo mt-3 fs-4" src="images/mobile_logo.png" />
		<button class="navbar-toggler mt-2 mr-5" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
			<span class="navbar-toggler-icon fs-1"></span>
		</button>
		<div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
			<div class="offcanvas-header">
			<h5 class="offcanvas-title fs-1" id="offcanvasNavbarLabel">PhoneFly</h5>
			<button type="button" class="btn-close fs-1 m-4" data-bs-dismiss="offcanvas" aria-label="Close"></button>
		</div>
		<div class="offcanvas-body">
			<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
				<li class="nav-item mt-2 mb-4">
					<a class="nav-link active fs-1" aria-current="page" href="/mobileMain">Home</a>
				</li>
				<li class="nav-item mb-3">
					<a class="nav-link fs-2" href="#">Apple</a>
				</li>
				<li class="nav-item mb-3">
					<a class="nav-link fs-2" href="#">삼성</a>
				</li>
				<li class="nav-item mb-3">
					<a class="nav-link fs-2" href="#">이벤트</a>
				</li>
				<li class="nav-item mb-3">
					<a class="nav-link fs-2" href="#">상품비교</a>
				</li>
				<li class="nav-item mb-3">
					<a class="nav-link fs-2" href="#">자주하는질문</a>
				</li>
				<li class="nav-item mb-3">
					<a class="nav-link fs-2" href="#">공지사항</a>
				</li>
				<li class="nav-item">
					<a class="nav-link active fs-2" href="/mobileIntro">회사소개</a>
				</li>
			</ul>
		</div>
	</div>
</nav>


</header>

<!-- //HEADER -->

