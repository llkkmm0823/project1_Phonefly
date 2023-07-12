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

 
<!-- 공지사항 상세보기 -->

	<!-- 게시판 페이지 왼쪽 메뉴 -->
	<div class="support-left-menu board-menu card-normal" id="sub-scroll-box">

	<%@ include file="../sub/sub_board_menu.jsp"%>

	</div>
	<!-- //게시판 페이지 왼쪽 메뉴 -->


	<!-- 게시판 페이지 오른쪽 내용 -->
	<div class="support-right-content card-normal">
		<div class="support-inner-wrap board-notice-detail-inner-warp">



		<!-- <div class="board-inner-wrap card-normal board-notice-detail-inner-warp"> -->
		
			<h1>공지사항</h1>
			<div id="board-nd-wrap-inner">
			
			<table class="table table-striped">
			
				<tbody class="table-group-divider">
					<tr>
						<th scope="row">번호</th><td>${noticeVO.nseq}</td>
					</tr>
					<tr>
						<th scope="row">제목</th><td>${noticeVO.subject}</td>
					</tr>
					<tr>
						<th scope="row">작성일자</th><td><fmt:formatDate value="${noticeVO.indate}" /></td>
					</tr>
					<tr>
						<th scope="row">내용</th><td><div id="board-detail-content-inner-wrap"><pre>${noticeVO.content}</pre></div></td>
					</tr>
			
				</tbody>
			</table>
			<button type="button" class="btn btn-primary" onclick="location.href='/noticeList';" >돌아가기</button>
			
			
			</div>
		</div>



	</div>
	<div class="clear"></div>
	<!-- //게시판 페이지 오른쪽 내용 -->

<!-- //공지사항 상세보기 -->


<div class="clear"></div>
</article>
<!-- //MAIN -->




<!-- footer 불러오기 -->
<%@ include file="../sub/footer.jsp"%>