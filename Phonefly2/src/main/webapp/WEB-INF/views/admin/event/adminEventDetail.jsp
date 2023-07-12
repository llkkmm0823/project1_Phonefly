<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../admin/header2.jsp"%>
<%@ include file="../../admin/sub_menu2.jsp"%>

<article>
	<h1>이벤트 상세 보기</h1>
	<table id="EDList">
		<tr>
			<th align="center">이벤트 제목</th>
			<td colspan="5">${eventVO.subject}</td>
		</tr>
		<tr>
			<th>이벤트 이미지</th>
			<td colspan="5"><img src="images/event/${eventVO.image}" width="600"/></td>
		</tr>
	</table>

	<div class="Bottm-btn-container">
		<div>
			<input class="btn" type="button" value="수정"
				onClick="go_mod_e('${eventVO.eseq}')">
		</div>  &nbsp;&nbsp;&nbsp;
		<div>
			<input class="btn" type="button" value="목록" onClick="go_mov_e()">
		</div>  &nbsp;&nbsp;&nbsp;
		<div>
			<input class="btn" type="button" value="삭제"
				onClick="go_del_e('${eventVO.eseq}')">
		</div>  &nbsp;&nbsp;&nbsp;
	</div>

</article>

<%@ include file="../../admin/footer.jsp"%>