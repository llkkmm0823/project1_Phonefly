<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../admin/header2.jsp"%>
<%@ include file="../../admin/sub_menu2.jsp"%>

<article>
	<h1>공지사항 등록</h1>
	<form name="frm" method="post">
		<table id="PNIList">
			<tr>
				<th>제목</th>
				<td width="343" colspan="5"><input type="text" name="subject"
					size="47" maxlength="100"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td  colspan="5"><textarea name="content" rows="8" cols="70"></textarea></td>
			</tr>
		</table>

		<div class="Bottm-btn-container">
			<div>
				<input class="btn" type="button" value="공지사항등록"
					onClick="go_save_n();">
			</div> 
			<div>
				<input class="btn" type="button" value="목록으로" onClick="go_mov_n();">
			</div>
		</div>

	</form>
</article>

<%@ include file="../../admin/footer.jsp"%>




