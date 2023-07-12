<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../admin/header2.jsp"%>
<%@ include file="../../admin/sub_menu2.jsp"%>


<article>
	<h1>상품 리스트</h1>

	<form name="frm" method="post">
		<table id="List">
			<tr>
				<td width="642">
				     상품명 :
				    <input type="text" name="key"	value="${key}">&nbsp;&nbsp;&nbsp;
			   	    <input class="btn" type="button" name="btn_search" value="검색"
					onClick="go_search('adminProductList');">&nbsp;&nbsp;&nbsp;
  
					<input class="btn" type="button" name="btn_total" value="전체보기 "
					onClick="go_total('adminProductList');">&nbsp;&nbsp;&nbsp;

					<input class="btn" type="button" name="btn_write" value="상품등록"
					onClick="go_wrt();">
				</td>
			</tr>
		</table>
	</form>

	<table id="productList" style="">
		<tr>
			<th>번호</th>
			<th>상품명</th>
			<th>제조사</th>
			<th>원가(입고가)</th>
			<th>판매가(출고가)</th>
			<th>상품 등록일</th>
			<th>제품 판매 유/무</th>
			<th>이벤트 적용/미적용</th>
			<th>베스트 적용/미적용</th>
		</tr>
				<c:forEach items="${adminproductList}" var="productVO">
					<tr>
						<td style="text-align:; padding: 0px;">${productVO.pseq}</td>
						<td><a href="#" onClick="go_detail( '${productVO.pseq}');"
							style="cursor: pointer;"> ${productVO.name} </a></td>
						<td>${productVO.mfc}</td>
						<td><fmt:formatNumber value="${productVO.price1}" /></td>
						<td><fmt:formatNumber value="${productVO.price2}" /></td>
						<td><fmt:formatDate value="${productVO.indate}" /></td>
						<td><c:choose>
								<c:when test='${productVO.useyn=="N" }'>판매 불가</c:when>
								<c:otherwise>판매 가능</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test='${productVO.eventyn=="N" }'>이벤트 미적용</c:when>
								<c:otherwise>이벤트 적용</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test='${productVO.bestyn=="N" }'>베스트 미적용</c:when>
								<c:otherwise>베스트 적용</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>

	</table>

	<br /> <br />

	<jsp:include page="../../admin/paging/page.jsp">
		<jsp:param name="command" value="adminProductList" />
	</jsp:include>
	<!-- jsp:param 으로 필요한 내용을 전달하고 완성된 페이지를  include 합니다 -->

</article>

<%@ include file="../../admin/footer.jsp"%>
