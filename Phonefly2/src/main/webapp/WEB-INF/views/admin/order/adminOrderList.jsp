<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../admin/header2.jsp"%>
<%@ include file="../../admin/sub_menu2.jsp"%>

<article>
<h1>주문리스트</h1>
<form name="frm" method="post">
	<table id="OList">
		<tr>
			<td>주문자 아이디<input type="text" name="key" value="${key}" >
				<input class="btn" type="button" value="검색" onClick="go_search('adminOrderList');">
				<input class="btn" type="button" value="전체보기 " onClick="go_total('adminOrderList');">
			</td>
		</tr>
	</table>
	
	<table id="orderList">
		<tr>
		<th>주문상세 번호</th>
		<th>아이디(구매자명)</th>
		<th>제품명(통신사)</th>
		<th>주문일</th>
		<th>처리상태</th>
		<th></th>
		</tr>
		<c:forEach items="${orderList}" var="order">
			<tr onclick="location.href='adminOrderDetail?odseq=${order.odseq}';">
				<td>${order.odseq}</td>
				<td>${order.id} (${order.mname})</td>
				<td>${order.pname} (${order.cname})</td>
				<td><fmt:formatDate value="${order.indate}" /></td>
				<c:choose>
					<c:when test="${order.result == 1 }"><td>접수중</td></c:when>
					<c:when test="${order.result == 2 }"><td>발송중</td></c:when>
					<c:otherwise><td>완료</td></c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
	</table>
	<div class="clear"></div>
	

	<br><br>

	<jsp:include page="../../admin/paging/page.jsp" >
		<jsp:param  name="command" value="adminOrderList"/>
	</jsp:include>
</form>
</article>

<%@ include file="../../admin/footer.jsp"%>



