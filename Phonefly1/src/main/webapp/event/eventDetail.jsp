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

 
<!-- 이벤트 상세보기 -->

	<!-- 게시판 페이지 왼쪽 메뉴 -->
	<div class="support-left-menu board-menu card-normal" id="sub-scroll-box">

	<%@ include file="../sub/sub_board_menu.jsp"%>

	</div>
	<!-- //게시판 페이지 왼쪽 메뉴 -->


	<!-- 게시판 페이지 오른쪽 내용 -->
	<div class="support-right-content card-normal">
		<div class="support-inner-wrap board-notice-detail-inner-warp">




		<!-- <div class="board-inner-wrap board-event-detail-inner-warp card-normal"> -->
		
			<h1>이벤트</h1>
			
			<table class="table table-striped">
				<tbody class="table-group-divider">

					<tr>
						<th scope="row">번호</th><td>${EventVO.eseq}</td>
					</tr>
					<tr>
						<th scope="row">제목</th><td>${EventVO.subject}</td>
					</tr>
					<tr>
						<th scope="row">작성일자</th><td><fmt:formatDate value="${EventVO.indate}" /></td>
					</tr>
					<tr>
						<td class="board-detail-content" colspan="2"><img id="board-event-content-image" src="images/event/${EventVO.image}" /></td>
					</tr>

				</tbody>
			</table>
			<button type="button" class="btn btn-primary" onclick="location.href='pf.do?command=eventList';" >돌아가기</button>


			<div id="board-bottom"></div>
			<div id="board-list-paging-bottom-margin"></div>
		
		
		</div>



	</div>
	<div class="clear"></div>
	<!-- //게시판 페이지 오른쪽 내용 -->

<!-- //이벤트 상세보기 -->





<div class="clear"></div>
</article>
<!-- //MAIN -->




<!-- footer 불러오기 -->
<%@ include file="../sub/footer.jsp"%>