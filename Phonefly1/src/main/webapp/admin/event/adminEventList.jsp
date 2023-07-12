<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/header2.jsp"%>
<%@ include file="/admin/sub_menu2.jsp"%>

<article>
<h1>이벤트 리스트</h1>

<form name="frm"  method="post">
	<table id="EList">
		<tr>
			<td width="642">
				이벤트 제목 : <input type="text" name="key" value="${key}">&nbsp;&nbsp;&nbsp;
				<input class="btn" type="button" name="btn_search" value="검색" 
						onClick="go_search('adminEventList');">&nbsp;&nbsp;&nbsp;
						
				<input class="btn" type="button" name="btn_total" value="전체보기 " 
						onClick="go_total('adminEventList');">&nbsp;&nbsp;&nbsp;

				<input class="btn" type="button" name="btn_write" value="이벤트등록"  onClick="go_wrt_e();">
			</td>
		</tr>
	</table>
</form>

<table id="eventList">
	<tr>
	<th>번호</th>
	<th>이벤트 제목</th>
	<th>이벤트 등록일</th>
	</tr>
	<c:forEach items="${eventList}" var="eventVO">
		<tr>
			<td style="text-align:left; padding-left:50px;">${eventVO.eseq}</td>
			<td>
				<a href="javascript:;" onClick="go_detail_e('${eventVO.eseq}');">
					${eventVO.subject}
				</a>
			</td>
			<td><fmt:formatDate value="${eventVO.indate}"/></td>
			
		</tr>
	</c:forEach>
	
	
</table>

<br /><br />
<jsp:include page="/admin/paging/page.jsp">
	<jsp:param name="command" value="pf.do?command=adminEventList" />
</jsp:include>
<!-- jsp:param 으로 필요한 내용을 전달하고 완성된 페이지를  include 합니다 -->

</article>

<%@ include file="/admin/footer.jsp"%>
