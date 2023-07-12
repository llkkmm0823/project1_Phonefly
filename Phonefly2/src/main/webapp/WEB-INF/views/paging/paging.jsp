<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav id="paging" aria-label="Page navigation default">
	<ul class="pagination justify-content-center">
		<c:if test="${paging.endPage > 1}">
			<c:url var="action" value="${param.command}" />
			<c:if test="${paging.prev}">
				<li class="page-item">
					<a class="page-link" href="${action}?page=1#board-anchor"><span style="font-size:70%">처음으로</span></a>
				</li>
				<li class="page-item">
					<a class="page-link" href="${action}?page=${paging.beginPage - 1}#board-anchor">&laquo;</a>
				</li>
			</c:if>
			<c:forEach begin="${paging.beginPage}" end="${paging.endPage}" var="index">
				<c:choose>
					<c:when test="${index == paging.page}">
						<li class="page-item">
							<a class="page-link active" aria-current="page">${index}</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item">
							<a class="page-link" href="${action}?page=${index}#board-anchor">${index}</a>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${paging.next}">
				<li class="page-item">
					<a class="page-link" href="${action}?page=${paging.endPage + 1}#board-anchor">&raquo;</a>
				</li>
				<li class="page-item">
					<a class="page-link" href="${action}?page=${paging.totalPage}#board-anchor"><span style="font-size:70%">마지막으로</span></a>
				</li>
			</c:if>
		</c:if>
	</ul>
</nav>
<div class="clear"></div>