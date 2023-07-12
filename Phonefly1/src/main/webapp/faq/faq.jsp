<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- MAIN  -->
<!-- 
author : BHS
-->


<!-- 헤더 불러오기 -->
<%@ include file="../sub/header.jsp"%>


<article>

<!-- 서브 배너 불러오기 -->
<%@ include file="../sub/sub_image_menu6.jsp"%>

 
<!-- 자주하는질문 (FAQ) -->

	<!-- 게시판 페이지 왼쪽 메뉴 -->
	<div class="support-left-menu board-menu card-normal" id="sub-scroll-box">

	<%@ include file="../sub/sub_board_menu.jsp"%>

	</div>
	<!-- //게시판 페이지 왼쪽 메뉴 -->


	<!-- 게시판 페이지 오른쪽 내용 -->
	<div class="support-right-content card-normal">
		<div class="support-inner-wrap">


<!-- 		<div class="board-inner-wrap faq-inner-wrap"> -->
		<div id="board"></div>
		<h1>자주하는질문 (FAQ)</h1>
		
		<!-- 메뉴 -->
		<div id="faq-sub-wrap">
			<!-- <div id="faq-sub-menu"> -->
			<div class="btn-group mt-3 mb-1" role="group" aria-label="Basic radio toggle button group">
				<input type="radio" class="btn-check" name="btnradio" id="btnradio1" autocomplete="off" onclick="faqMenu(1);" checked>
				<label class="btn btn-outline-primary btn-lg" for="btnradio1">신청 / 개통문의</label>
				
				<input type="radio" class="btn-check" name="btnradio" id="btnradio2" autocomplete="off" onclick="faqMenu(2);">
				<label class="btn btn-outline-primary btn-lg" for="btnradio2">배송문의</label>
				
				<input type="radio" class="btn-check" name="btnradio" id="btnradio3" autocomplete="off" onclick="faqMenu(3);">
				<label class="btn btn-outline-primary btn-lg" for="btnradio3">취소 / 반품문의</label>
			</div>

		</div>
		<div class="clear"></div>
		<!-- //메뉴 -->
		
		<div id="faq-main-wrap">
			<div id="faq-main-inner-wrap">
		
			<%@ include file="faq_part1.jsp"%>
			<%@ include file="faq_part2.jsp"%>
			<%@ include file="faq_part3.jsp"%>
		
			</div>
		</div>
		
		<div id="board-bottom"></div>


	</div>
	<div class="clear"></div>
	<!-- //게시판 페이지 오른쪽 내용 -->


		
<!-- 자주하는질문 (FAQ) -->




<!-- 페이징 -->
<%-- <div class="paging">
	<div id="board-paging">
		<jsp:include page="/paging/paging.jsp">
		<jsp:param name="command" value="pf.do?command=faq" />
		</jsp:include>
	</div>
</div> --%>
<!-- //페이징 -->
<!-- <div id="board-list-paging-bottom-margin"></div> -->

</div>





<div class="clear"></div>
</article>
<!-- //MAIN -->




<!-- footer 불러오기 -->
<%@ include file="../sub/footer.jsp"%>