<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- MAIN  -->
<!-- 
author : BHS
-->


<!-- 헤더 불러오기 -->
<%@ include file="../sub/header.jsp"%>
<script src="script/removeMenuSession.js"></script>


<article>
<div class="wrap login-form-wrap card-normal">
	<div class="login-form">
		<form method="post" action="pf.do" name="loginForm">
				<input type="hidden" name="command" value="login" />
				<div class="title">PhoneFly계정으로 로그인</div>
				<fieldset>
					<legend></legend>
					<!-- <div class="loginID login-box-outside form-floating"> -->
					<div class="form-floating mb-3">
						<input name="id" type="text" class="form-control" placeholder="아이디를 입력하세요."/>
						<label for="floatingInput">User ID</label>
					</div>
					<!-- <div class="loginPwd login-box-outside form-floating"> -->
					<div class="form-floating mb-3">
						<input name="pwd" type="password" class="form-control" placeholder="암호를 입력하세요." />
						<label for="floatingInput">Password</label>
					</div>
				</fieldset>
				<!-- <div class="buttons"> -->
				<div class="login-form-btns d-grid gap-2 col-5 mx-auto">
					<button class="btn btn-primary" type="submit" onclick="return loginCheck();" >로그인</button>
					<button class="btn btn-secondary" type="button" onclick="location.href='pf.do?command=contract';" >회원가입</button>
					<button class="btn btn-secondary" type="button" onclick="findId();" >아이디 찾기</button>
					<button class="btn btn-secondary" type="button" onclick="findPwd();">비밀번호 찾기</button>
				</div><br /><br />
				<c:if test="${not empty param.message}">
					<div>&nbsp;&nbsp;&nbsp;${param.message}</div>
				</c:if>
				<c:if test="${not empty message}">
					<div>&nbsp;&nbsp;&nbsp;${message}</div>
				</c:if>
		</form>
	</div>
</div>

<div class="clear"></div>
</article>
<!-- //MAIN -->



<!-- footer 불러오기 -->
<%@ include file="../sub/footer.jsp"%>