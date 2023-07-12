<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- MAIN  -->
<!-- 
author : BHS
-->


<!-- 헤더 불러오기 -->
<%@ include file="../sub/header.jsp"%>
<script src="script/removeMenuSession.js"></script>


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
		<div class="support-inner-wrap">
			<div id="board-anchor"></div>
			<h1>1:1 문의</h1>
			
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">작성일자</th>
						<th scope="col">상태</th>
					</tr>
				</thead>
				<tbody class="table-group-divider">
					<c:forEach items="${qnaList}" var="board" varStatus="status">
					
						<tr class="cs-p" onclick="location.href='/qnaDetail?qseq=${board.qseq}';">
							<th scope="row">${board.qseq}</th>
							<td class="board-title">${board.subject}</td>
							<td><fmt:formatDate value="${board.indate}" /></td>
							<td>
								<c:choose>
									<c:when test="${board.rep == '1'}">접수중</c:when>
									<c:otherwise>상담완료</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="d-grid gap-2 d-md-flex justify-content-md-end">
				<button type="button" class="btn btn-primary" onclick="location.href='/qnaWriteForm';" >작성하기</button>
			</div>
			<div id="board-bottom"></div>
			
		
			
			<!-- 페이징 -->
			<div class="paging">
				<div id="board-paging">
					<jsp:include page="../paging/paging.jsp">
					<jsp:param name="command" value="/qnaList" />
					</jsp:include>
				</div>
			</div>
			<!-- //페이징 -->
			<!-- <div id="board-list-paging-bottom-margin"></div> -->
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