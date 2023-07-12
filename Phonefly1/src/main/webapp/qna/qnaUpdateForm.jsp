<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- MAIN  -->
<!-- 
author : BHS
-->


<!-- 헤더 불러오기 -->
<%@ include file="../sub/header.jsp"%>


<article>

<!-- 서브 배너 불러오기 -->
<%@ include file="../sub/sub_image_menu6.jsp"%>

 
<!-- 고객지원 페이지 -->
<div id="support-inner-wrap">





	<!-- 고객지원 페이지 왼쪽 메뉴 -->
	<div class="support-left-menu card-normal" id="sub-scroll-box">

	<%@ include file="../sub/sub_support_menu.jsp"%>

	</div>
	<!-- //고객지원 페이지 왼쪽 메뉴 -->


	<!-- 고객지원 페이지 오른쪽 내용 -->
	<div class="support-right-content card-normal">
		<div id="qna-detail-wrap-inner" class="support-inner-wrap">
			<div id="board"></div>
			<h1>1:1 문의 수정</h1>
			<form name="qnafrm" method="post" action="pf.do">
				<input type="hidden" name="command" value="qnaUpdate" />
				<input type="hidden" name="qseq" value="${qnaVO.qseq}" />
				<table class="table">
					<tbody class="table-group-divider">
						<tr>
							<td>
								<div class="form-floating mb-3">
									<input type="text" name="subject" id="qna-subject" class="form-control" placeholder="제목을 입력하세요 (100 bytes)" maxlength="100" value="${qnaVO.subject}" /><label for="qna-subject">제목</label>
								</div>
								<div class="form-floating mb-3">
									<textarea type="text" name="content" id="qna-content" class="form-control" placeholder="내용을 입력하세요 (3000 bytes)" maxlength="3000">${qnaVO.content}</textarea><label for="qna-content">내용</label>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="d-grid gap-3 d-md-block">
					<button type="button" class="btn btn-primary" onclick="writeQna();" >수정완료</button>
					&nbsp;<button type="button" class="btn btn-secondary" onclick="location.href='pf.do?command=qnaList';" >목록으로</button>
				</div>
			</form>
		</div>
	</div>
	<!-- //고객지원 페이지 오른쪽 내용 -->








</div>
<!-- //고객지원 페이지 -->

<div class="clear"></div>
</article>
<!-- //MAIN -->



<!-- footer 불러오기 -->
<%@ include file="../sub/footer.jsp"%>