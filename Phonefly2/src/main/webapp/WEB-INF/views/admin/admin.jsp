<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../admin/adminheader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin </title>
<link rel="stylesheet" href="admin/css/admin3.css">
<script src="admin/script/admin.js"></script>
</head>
<body>
<div id="wrap">
		
		
	<div class="clear"></div>
	<article>
		<div id="loginform">
			<form name="frm" method="post" action="adminLogin">
				<table>
					<tr><td>아 이 디</td><td><input type="text" name="workId" size="10"></td></tr>
					<tr><td>비밀번호</td><td><input type="password" name="workPwd" size="10"></td></tr>
					<tr align="center" >
						<td  colspan="2">	
							<input class="btn" type="submit" value="로그인" onClick="return workerCheck();">
							<br><br><h4 style="color:red">${message}</h4></td></tr>
				</table>
			</form>
		</div>
	</article>
</div>
</body>
</html>