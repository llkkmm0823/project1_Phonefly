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
			<h1>주문내역</h1>
			
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">기종 및 요금제</th>
						<th scope="col">주문일자</th>
						<th scope="col">상태</th>
					</tr>
				</thead>
				<tbody class="table-group-divider">
					<c:choose>
						<c:when test="${not empty orderList}">
							<c:forEach items="${orderList}" var="order" varStatus="status">
							
								<tr class="cs-p" onclick="location.href='/orderDetail?odseq=${order.odseq}';">
									<th scope="row">${order.odseq}</th>
									<td class="board-title">[${order.mfc}] ${order.pname}&nbsp; -&nbsp; [${order.cname}] ${order.rname} 요금제</td>
									<td><fmt:formatDate value="${order.indate}" /></td>
									<td>
										<c:choose>
											<c:when test="${order.result == '1'}">접수중</c:when>
											<c:when test="${order.result == '2'}">발송중</c:when>
											<c:otherwise>처리완료</c:otherwise>
										</c:choose>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="4">현재 주문내역이 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			<div id="board-bottom"></div>
			
		
			<!-- 페이징 -->
			<div class="paging">
				<div id="board-paging">
					<jsp:include page="../paging/paging.jsp">
					<jsp:param name="command" value="/orderList" />
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