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

 
<!-- 고객지원 페이지 -->
<div id="support-inner-wrap">





	<!-- 고객지원 페이지 왼쪽 메뉴 -->
	<div class="support-left-menu card-normal" id="sub-scroll-box">

	<%@ include file="../sub/sub_support_menu.jsp"%>

	</div>
	<!-- //고객지원 페이지 왼쪽 메뉴 -->


	<!-- 고객지원 페이지 오른쪽 내용 -->
	<div class="support-right-content card-normal">
		<div id="qna-wrap-inner" class="support-inner-wrap">
			<div id="board-anchor"></div>
			<h1>1:1 문의 보기</h1>
			
			<table class="table table-striped">
				<tbody class="table-group-divider">
					<tr>
						<th scope="row">번호</th><td>${qnaVO.qseq}</td>
					</tr>
					<tr>
						<th scope="row">제목</th><td>${qnaVO.subject}</td>
					</tr>
					<tr>
						<th scope="row">작성일자</th><td><fmt:formatDate value="${qnaVO.indate}" /></td>
					</tr>
					<tr>
						<th scope="row">내용</th><td><div id="board-detail-content-inner-wrap"><pre>${qnaVO.content}</pre></div></td>
					</tr>
	
					<c:if test="${not empty qnaVO.reply}">
						<tr class="table-group-divider">
							<th scope="row">상담답변</th><td><div id="board-detail-content-inner-wrap"><pre>${qnaVO.reply}</pre></div></td>
						</tr>
					</c:if>
				</tbody>
			</table>

			<div>
				<c:if test="${qnaVO.rep == '1'}">
					<button type="button" class="btn btn-secondary" onclick="confirmDeleteQna(${qnaVO.qseq});" >삭제하기</button>
					<button type="button" class="btn btn-primary" onclick="location.href='pf.do?command=qnaUpdateform&qseq=${qnaVO.qseq}';" >수정하기</button>
				</c:if>
				<button type="button" class="btn btn-primary" onclick="location.href='pf.do?command=qnaList';" >목록으로</button>
			</div>

		</div>
	</div>
	<!-- //고객지원 페이지 오른쪽 내용 -->








</div>
<!-- //고객지원 페이지 -->

<div class="clear"></div>
</article>
<!-- //MAIN -->



<!-- footer 불러오기 -->
<%@ include file="../sub/footer.jsp"%>