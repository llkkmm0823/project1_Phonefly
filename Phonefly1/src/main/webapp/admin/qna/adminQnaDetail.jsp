<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/admin/header2.jsp"%>
<%@ include file="/admin/sub_menu2.jsp"%>
<article>
	<h1>Q&amp;A 게시판</h1>
	<form name="frm" method="post">
		<input type="hidden" name="qseq" value="${qnaVO.qseq}">

		<table id="QnaList">
			<!-- 게시물의 내용 -->
			<tr>
				<th width="20%">제목</th>
				<td align="left">${qnaVO.subject} ${qnaVO.rep}</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td align="left"><fmt:formatDate value="${qnaVO.indate}" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td align="left"><pre>${qnaVO.content}</pre></td>
			</tr>
		</table>

		<!-- 관리자가 쓴 답글 또는 답글을 쓸 입력란 표시 -->
		<c:choose>
			<c:when test='${qnaVO.rep=="1"}'>
				<!-- 관리자 답변 전 표시 -->
				<table id="orderList">
					
					<tr>
						<td colspan="2"><textarea name="reply" rows="3" cols="50"></textarea>
							<input type="button" class="btn" value="저장" onClick="go_rep()"></td>
					</tr>
				</table>	
			</c:when>
			<c:otherwise>
				<!-- 관리자 답변 후 표시 -->
				<table id="orderList">
					<tr >
						<th width="180">댓글</th>
						<td>${qnaVO.reply}</td>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>

		<div class="Bottm-btn-container">
			<div>
				<input type="button" class="btn" value="목록"
					onClick="location.href='pf.do?command=adminQnaList'">
			</div>
		</div>
	</form>
</article>
<%@ include file="/admin/footer.jsp"%>