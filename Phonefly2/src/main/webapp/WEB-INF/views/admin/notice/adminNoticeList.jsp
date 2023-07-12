<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../admin/header2.jsp"%>
<%@ include file="../../admin/sub_menu2.jsp"%>

<article>
<h1>공지사항리스트</h1>

<form name="frm"  method="post">
	<table id= "NList">
		<tr>
			<td  width="642">
				공지사항명 : <input type="text" name="key" value="${key}">&nbsp;&nbsp;&nbsp;
				<input class="btn" type="button" name="btn_search" value="검색" 
						onClick="go_search('adminNoticeList');">&nbsp;&nbsp;&nbsp;
						
				<input class="btn" type="button" name="btn_total" value="전체보기 " 
						onClick="go_total('adminNoticeList');">&nbsp;&nbsp;&nbsp;

				<input class="btn" type="button" name="btn_write" value="공지사항등록"  onClick="go_wrt_n();">
			</td>
		</tr>
	</table>
</form>

<table id="noticeList">
	<tr>
	<th>번호</th>
	<th>공지사항명</th>
	<th>공지등록일</th>
	</tr>
	<c:forEach items="${noticeList}" var="noticeVO">
		<tr>
			<td style="text-align:left; padding-left:50px;">${noticeVO.nseq}</td>
			<td>
				<a href="javascript:;" onClick="go_detail_n( '${noticeVO.nseq}');">
					${noticeVO.subject}
				</a>
			</td>
			<td><fmt:formatDate value="${noticeVO.indate}"/></td>
			
		</tr>
	</c:forEach>
</table>

<br /><br />
<jsp:include page="../../admin/paging/page.jsp">
	<jsp:param name="command" value="adminNoticeList" />
</jsp:include>
<!-- jsp:param 으로 필요한 내용을 전달하고 완성된 페이지를  include 합니다 -->

</article>

<%@ include file="../../admin/footer.jsp"%>
