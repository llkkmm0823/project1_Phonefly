<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../admin/header2.jsp"%>
<%@ include file="../../admin/sub_menu2.jsp"%>

<article>
	<h1>공지사항 상세 보기</h1>
	<table id="PNDList">
		<tr>
			<th align="center">공지사항 제목</th>
			<td colspan="5">${noticeVO.subject}</td>
		</tr>
		<tr>
			<th>상세설명</th>
			<td colspan="5"><pre>${noticeVO.content}</pre></td>
		</tr>
	</table>

	<div class="Bottm-btn-container">
		<div>
			<input class="btn" type="button" value="수정"
				onClick="go_mod_n('${noticeVO.nseq}')">
		</div>  &nbsp;&nbsp;&nbsp;
		<div>
			<input class="btn" type="button" value="목록" onClick="go_mov_n()">
		</div>  &nbsp;&nbsp;&nbsp;
		<div>
			<input class="btn" type="button" value="삭제"
				onClick="go_del_n('${noticeVO.nseq}')">
		</div>  &nbsp;&nbsp;&nbsp;
	</div>

</article>

<%@ include file="../../admin/footer.jsp"%>