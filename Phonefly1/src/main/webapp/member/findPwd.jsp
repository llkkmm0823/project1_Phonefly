<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<script src="script/bootstrap.min.js"></script>
<script src="script/common.js"></script>
<script src="script/member.js"></script>
</head>
<body>
<div class="zipnum-wrap id-check-wrap">
	<h2 class="mb-4 mt-4">비밀번호 찾기</h2>
	<c:if test="${result == 0}">
	<form method="post" name="formm" action="pf.do">
		<input type="hidden" name="command" value="selectPwd" />
		<table id="find-id">
			<tr>
				<td>
					<div class="form-floating mb-3">
						<input type="text" name="id" id="find-pwd-id" class="form-control" maxlength="20" placeholder="검색할 아이디를 입력하세요" /><label for="find-pwd-id">아이디</label>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-floating mb-3">
						<input type="text" name="name" id="find-pwd-name" class="form-control" maxlength="20" placeholder="검색할 이름을 입력하세요" /><label for="find-pwd-name">이름</label>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-floating mb-3">
						<input type="text" name="phone" id="find-pwd-phone" class="form-control" maxlength="20" placeholder="검색할 전화번호를 입력하세요" /><label for="find-pwd-phone">전화번호</label>
					</div>
				</td>
			</tr>
		</table>
		<button type="button" class="btn btn-primary" onclick="findPwdSubmit();">찾기</button>
	</form>
	<br /><br />
	</c:if>
	<c:if test="${result == 1}">
		<form method="post" name="joinForm" action="pf.do">
			<input type="hidden" name="command" value="setPwd" />
			<input type="hidden" name="id" value="${id}" />
			<fieldset>
				<div class="form-floating mb-3">
					<input type="password" name="pwd" id="find-pwd-pwd" class="form-control" maxlength="20" placeholder="암호를 입력하세요" /><label for="find-pwd-phone">암호</label>
				</div>
				<div class="form-floating mb-3">
					<input type="password" name="pwdCheck" id="find-pwd-pwd-check" class="form-control" maxlength="20" placeholder="암호를 입력하세요" /><label for="find-pwd-pwd-check">암호 재입력</label>
				</div>
			</fieldset>
			<div class="clear"></div>
			<br />
			<div class="buttons">
				<button type="button" class="btn btn-primary" onclick="checkPwd();">암호변경</button>
				<button type="reset" class="btn btn-secondary">취소</button>
			</div>
			<br />
		</form>
	</c:if>
	<c:if test="${result == 3}">
		<script type="text/javascript">self.close();</script>
	</c:if>
	
</div>
</body>
</html>