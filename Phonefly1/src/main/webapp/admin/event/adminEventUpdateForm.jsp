<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/admin/header2.jsp"%>
<%@ include file="/admin/sub_menu2.jsp"%>

<article>
	<h1>이벤트 수정</h1>
	<form name="frm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="eseq" value="${eventVO.eseq}"> <input
			type="hidden" name="oldImage" value="${eventVO.image}">

		<table id="EUList">
			<tr>
				<th>이벤트 제목</th>
				<td width="343" colspan="5"><input type="text" name="subject"
					size="47" maxlength="100" value="${eventVO.subject}"></td>
			</tr>

			<tr>
				<th>이벤트 이미지</th>
				<td colspan="5"><img src="images/event/${eventVO.image}"
					width="600"><br> <input type="file" name="image">
				</td>
			</tr>
		</table>
		<div class="Bottm-btn-container">    
			<div>
				<input class="btn" type="button" value="수정"
					onClick="go_mod_save_e(${eventVO.eseq});">
			</div> &nbsp;&nbsp;&nbsp;
			<div>
				<input class="btn" type="button" value="취소"
					onClick="location.href='pf.do?command=adminEventDetail&eseq=${eventVO.eseq}'">
			</div>
		</div>
	</form>
</article>

<%@ include file="/admin/footer.jsp"%>