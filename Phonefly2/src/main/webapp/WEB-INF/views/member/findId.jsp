<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디(ID) 찾기</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<script src="script/bootstrap.min.js"></script>
<script src="script/common.js"></script>
<script src="script/member.js"></script>
</head>
<body>
<div class="zipnum-wrap id-check-wrap">
	<h2 class="mb-4 mt-4">아이디(ID) 찾기</h2>
	<form method="post" name="formm" action="/selectId">
		<table id="find-id">
			<tr>
				<td>
					<div class="form-floating mb-3">
						<input type="text" name="name" id="find-id-name" class="form-control" maxlength="20" placeholder="검색할 이름을 입력하세요" /><label for="find-id-name">이름</label>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-floating">
						<input type="text" name="phone" id="find-id-phone" class="form-control" maxlength="20" placeholder="검색할 전화번호를 입력하세요" /><label for="find-id-phone">전화번호</label>
					</div>
				</td>
			</tr>
		</table>
		<br />
		<button type="button" class="btn btn-primary" onclick="findIdSubmit();">찾기</button>
	</form>
	<br />
	<c:if test="${not empty member}">
		<h2>확인된 아이디는 ${member.id} 입니다.</h2>
	</c:if>
</div>
</body>
</html>