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
		<div class="support-inner-wrap review-inner-wrap">
			<div id="board-anchor"></div>
			<h1>내가 작성한 후기</h1>

			<form name="reviewForm" method="post" action="/memberReviewUpdate">
			<input type="hidden" name="rvseq" id="real-rvseq" value="" />
			<input type="hidden" name="content" id="real-content" value="" />
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">구매하신 휴대폰</th>
						<th scope="col">후기 내용</th>
						<th scope="col">작성일자</th>
						<th scope="col">수정</th>
						<th scope="col">삭제</th>
					</tr>
				</thead>
				<tbody class="table-group-divider">
					<c:forEach items="${reviewList}" var="review" varStatus="status">
					
						<tr>
							<th scope="row">${review.pname}</th>
							<td class="board-content">
								<div class="form-floating mb-3">
									<textarea type="text" name="content_${status.count}" id="content-${status.count}" class="form-control review-list-textarea" placeholder="구매후기를 입력하세요" maxlength="500">${review.content}</textarea><label for="content-${status.count}">구매후기</label>
								</div>
							</td>
							<td><fmt:formatDate value="${review.indate}" /></td>
							<td>
								<button type="button" class="btn btn-primary" onclick="modifyReview(${review.rvseq}, 'content-${status.count}');">수정</button>
							</td>
							<td>
								<button type="button" class="btn btn-secondary" onclick="deleteReview(${review.rvseq});">삭제</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</form>
			<div id="board-bottom"></div>
			
		
			
			<!-- 페이징 -->
			<div class="paging">
				<div id="board-paging">
					<jsp:include page="../paging/paging.jsp">
					<jsp:param name="command" value="/reviewList" />
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