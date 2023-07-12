<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 체크</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<script src="script/bootstrap.min.js"></script>
<script src="script/common.js"></script>
<script src="script/member.js"></script>
<script src="script/mypage.js"></script>
</head>
<body>
<div class="id-check-wrap">
	<h2 class="mb-3 mt-3">ID 중복 확인</h2>
	<form method="post" name="idCheckForm" action="pf.do">
		<input type="hidden" name="command" value="idCheck" />
		<div class="form-floating input-group">
			<input type="text" name="id" class="form-control" id="floatingId" value="${id}" placeholder=" 아이디를 입력하세요" maxlength="20" aria-describedby="button-addon1">
			<label for="floatingId">아이디</label>
			<button type="submit" id="button-addon1" class="btn btn-primary">검색</button>
		</div>
			
			
			<br /><br /><br />
		<div>
			<c:if test="${result == 1}">
				<script type="text/javascript">
					opener.document.joinForm.id.value="";
					opener.document.joinForm.reid.value="";
				</script>
				${id}는 이미 사용중인 아이디 입니다.
			</c:if>
			<c:if test="${result == -1}">
				${id}는 사용 가능한 ID입니다.
				&nbsp;&nbsp;<button type="button" class="btn btn-primary" onclick="idok('${id}');">사용</button>
			</c:if>
		</div>
	</form>
</div>
</body>
</html>