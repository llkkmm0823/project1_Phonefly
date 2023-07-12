<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../admin/header2.jsp"%>
<%@ include file="../../admin/sub_menu2.jsp"%>
<article>
	<h1>베너수정</h1>
	<form name="frm" method="post">
		<input type="hidden" name="bseq" value="${bannerVO.bseq}"> <input
			type="hidden" name="oldfilename" value="${bannerVO.image}">
		<table id="list">
			<tr>
				<th>베너 제목</th>
				<td width="343" colspan="5"><input type="text" name="name"
					size="47" value="${bannerVO.subject}"></td>
			</tr>

			<tr>
				<th>사용유무</th>
				<td><c:choose>
						<c:when test='${bannerVO.useyn=="Y"}'>
							<input type="checkbox" name="useyn" value="Y" checked="checked">
						</c:when>
						<c:otherwise>
							<input type="checkbox" name="useyn" value="N">
						</c:otherwise>
					</c:choose></td>
			</tr>

			<tr>
				<th>베너이미지</th>
				<td width="343" colspan="5" style="vertical =align: top;">현재
					이미지 : <img src="admin_images/${bannerVO.image}" width="200px;"><br>
					<!--  <input type="file" name="image"> --> * 주의 : 이미지를 수정할때에만
					선택해주세요 <input type="hidden" name="image" id="image">
					<div id="filename"></div>
				</td>
			</tr>

		<tr><th>순위 </th>
			<td width="642">
				<select name="order_seq">
					<option value="">디스플레이될 순서를 선택하세요 </option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">사용안함 </option>
				</select>
		<input class="btn" type="button" value="수정"
			onClick="go_mod_save('${bannerVO.bseq}')"> <input class="btn"
			type="button" value="취소" onClick="go_mov()">
	

	<div
		style="position: relative; border: 1px solid black; width: 500px; margin: 0 auto;">
		<form name="fromm" id="fileupForm" method="post"
			enctype="multipart/form-data">
			<input type="file" name="fileimage"> <input type="button"
				id="myButton" value="추가">
		</form>
	</div>


</article>
<%@ include file="../../admin/footer.jsp"%>