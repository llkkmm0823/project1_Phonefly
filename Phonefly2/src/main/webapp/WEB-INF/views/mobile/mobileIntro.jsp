<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- MAIN  -->
<!-- 
author : BHS
-->



<!-- 헤더 불러오기 -->
<%@ include file="../mobile/mobileHeader.jsp"%>


<article>

<!-- 서브 배너 불러오기 -->
<%@ include file="../mobile/mobileMainBanner.jsp"%>



<!-- 회사소개 -->

	<!-- 게시판 페이지 왼쪽 메뉴 -->
<%-- 	
	<div class="support-left-menu board-menu card-normal" id="sub-scroll-box">

	<%@ include file="../sub/sub_board_menu.jsp"%>

	</div>
 --%>
	<!-- //게시판 페이지 왼쪽 메뉴 -->


	<!-- 게시판 페이지 오른쪽 내용 -->
	<div class="">
		<div class="">

			<br /><br />
			<h3>오시는 길</h3>
			- 서울특별시 서대문구 신촌로 141 (은하빌딩 1층 101호)<br />
			- 전화 02)393-4321<br />
			- 팩스 02)365-5880
			<br /><br />
			<h3>버스</h3>
			- 신촌 5거리
			<br /><br />
			<h3>지하철</h3>
			- 2호선 신촌역 4번 출구 200M 직진 또는 이대역 1번 출구 100M 직진
			<br /><br />
			<h3>위치안내</h3>
			<div>
				<!-- * 카카오맵 - 지도퍼가기 -->
				<!-- 1. 지도 노드 -->
				<div id="daumRoughmapContainer1687325161939" class="root_daum_roughmap root_daum_roughmap_landing"></div>
				<!-- 2. 설치 스크립트 -->
				<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>
				<!-- 3. 실행 스크립트 -->
				<script charset="UTF-8">
					new daum.roughmap.Lander({
						"timestamp" : "1687325161939",
						"key" : "2f9tk",
						/* "mapWidth" : "640", */
						"mapWidth" : "380",
						"mapHeight" : "360"
					}).render();
				</script>
			</div>

		</div>
	</div>

	<!-- //게시판 페이지 오른쪽 내용 -->



<!-- //회사소개 -->




</article>
<!-- //MAIN -->
<br />
<hr style="width:98%;"/>
<br />


<!-- footer 불러오기 -->
<%@ include file="../mobile/mobileFooter.jsp"%>