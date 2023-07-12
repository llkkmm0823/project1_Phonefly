<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../admin/header2.jsp"%>
<%@ include file="../../admin/sub_menu2.jsp"%>

<article>
	<h1>상품 색상 등록</h1>
	<form name="frm" method="post" enctype="multipart/form-data">

		<table id="PCIList">
			<tr>
				<th>색상 이름</th>
				<td width="343" colspan="5"><input type="text" name="name"
					size="47" maxlength="100"></td>
			</tr>

			<tr>
				<th>색상 코드</th>
				<td width="343" colspan="5"><input type="text" name="ccode"
					size="47" maxlength="100"></td>
			</tr>

			<tr>
				<th>색상 이미지</th>
				<td width="343" colspan="5"><input type="file" name="image"></td>
			</tr>
		</table>

		<div class="Bottm-btn-container">
			<div>
				<input class="btn" type="button" value="색상등록"
					onClick="go_save_c(${ProductVO.pseq})">
			</div>
			<div>
				<input class="btn" type="button" value="목록으로" onClick="go_mov()">
			</div>
		</div>
	</form>
</article>

<%@ include file="../../admin/footer.jsp"%>




