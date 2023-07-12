<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/header2.jsp"%>
<%@ include file="/admin/sub_menu2.jsp"%>

<article>
<h1>상품 색상 리스트</h1>

<form name="frm"  method="post" enctype="multipart/form-data"  >

	<table id="PCList">
		<tr>
			<td width="642">
				색상명 : <input type="text" name="key" value="${key}">&nbsp;&nbsp;&nbsp;
				<input class="btn" type="button" name="btn_search" value="검색" 
						onClick="go_search('adminProductColorList');">&nbsp;&nbsp;&nbsp;
						
				<input class="btn" type="button" name="btn_total" value="전체보기 " 
						onClick="go_total('adminProductColorList');">&nbsp;&nbsp;&nbsp;

				<input class="btn" type="button" name="btn_write" value="색상등록"  onClick="go_wrt_c(${ProductColorList[0].pseq});">
			</td>
		</tr>
	</table>
</form>

<table id="productColorList">
	<tr>
	<th>색상 번호</th>
	<th>색상 이름</th>
	<th>상품 번호</th>	
	<th>색상 코드</th>
	<th>이미지</th>	
	</tr>
	
	<c:forEach items="${ProductColorList}" var="ColorVO">
		<tr>		
			<td style="text-align:left; padding-left:50px;">${ColorVO.cseq}</td>
			<td>
				<a href="#" onClick="go_detail_c( '${ColorVO.cseq}');">
					${ColorVO.name}
				</a>
			</td>
			<td>${ColorVO.pseq}</td>
			<td>${ColorVO.ccode}</td>
			<td>${ColorVO.image}</td>
			<td>		
			</td>
		</tr>
	</c:forEach>
</table>

<br /><br />



</article>

<%@ include file="/admin/footer.jsp"%>
