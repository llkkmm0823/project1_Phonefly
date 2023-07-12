<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 찾기</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<script src="script/bootstrap.min.js"></script>
<script src="script/common.js"></script>
<script src="script/member.js"></script>
<script src="script/mypage.js"></script>
</head>
<body>
<div class="zipnum-wrap id-check-wrap">
	<h2 class="mb-3 mt-3">우편번호검색</h2>
	<form method="post" name="formm" action="pf.do">
		<input type="hidden" name="command" value="findZipnum" />
		<div class="form-floating input-group">
			<input type="text" name="dong" id="zipnum-dong" class="form-control" maxlength="100" placeholder="검색할 동을 입력하세요" aria-describedby="button-addon1" />
			<label for="zipnum-dong">동 이름</label>
			<button type="submit" id="button-addon1" class="btn btn-primary">찾기</button>
		</div>
	</form>
	<br />
	<table id="zipcode">
		<tr><th with="100">우편번호</th><th>주소</th></tr>
		<c:forEach items="${addressList}" var="add">
			<tr>
				<td>
					<a href="#" onclick="result('${add.zipnum}', '${add.sido}', '${add.gugun}', '${add.dong}');">${add.zipnum}</a>
				</td>
				<td>
					<a href="#" onclick="result('${add.zipnum}', '${add.sido}', '${add.gugun}', '${add.dong}');">${add.sido} ${add.gugun} ${add.dong}</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>