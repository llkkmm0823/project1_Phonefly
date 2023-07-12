<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../admin/header2.jsp"%>
<%@ include file="../../admin/sub_menu2.jsp"%>
<article>
<h1>회원리스트</h1>  
<form name="frm" method="post">
	<table id="MList" >
		<tr><td>회원 이름 <input type="text" name="key" value="${key3}">
		<input class="btn" type="button" value="검색" onclick="go_search('adminMemberList')">
		<input class="btn" type="button" value="전체보기 " onClick="go_total('adminMemberList')"></td> </tr>
	</table><br>
	<table id="adminMemberList">
		<tr><th>아이디(탈퇴여부)</th><th> 이름 </th><th>이메일</th><th>우편번호</th><th>주소</th>
		<th>전화</th></tr>
	    <c:forEach items="${memberList}" var="memberVO">  
		    <tr><td>${memberVO.id} 
		    	<c:choose>
		      		<c:when test='${memberVO.useyn=="Y"}'>
		        		<input type="checkbox" name="useyn" disabled="disabled">
			        </c:when>
			        <c:otherwise>
			        	<input type="checkbox" name="useyn" checked="checked" disabled="disabled">
			        </c:otherwise>
		    	</c:choose></td>
		    	
		    	<td>${memberVO.name}</td><td>${memberVO.email}</td>
		    	<td>${memberVO.zipnum}</td><td>${memberVO.address1}</td>
		    	<td>${memberVO.phone}</td></tr>
	  </c:forEach>
	</table>
	<jsp:include page="../../admin/paging/page.jsp">   
	    <jsp:param name="command" value="adminMemberList" />
	</jsp:include>
</form>
</article>
<%@ include file="../../admin/footer.jsp"%>