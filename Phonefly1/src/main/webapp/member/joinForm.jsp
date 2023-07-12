<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../sub/header.jsp" %>
<%@ include file="../sub/sub_image_menu5.jsp"%>

<article>
<div class="wrap join-form-wrap card-normal">
	<div class="join-form mb-4">
	<form method="post" name="joinForm" action="pf.do">
		<input type="hidden" name="command" value="join" />
		
		<fieldset>
			<legend>기본 정보</legend>
			<div class="form-floating input-group mb-3">
				<input type="text" name="id" size="20" id="join-id" class="form-control" placeholder=" 아이디를 입력하세요" maxlength="20" aria-describedby="button-addon1" /><label for="join-id">아이디</label>
				<input type="hidden" name="reid" />
				<button type="button" id="button-addon1" class="btn btn-secondary" onclick="idcheck();" >중복 체크</button>
			</div>
			<div class="form-floating mb-3">
				<input type="password" name="pwd" id="join-pwd" class="form-control" placeholder=" 암호를 입력하세요" maxlength="20" /><label for="join-pwd">암호</label>
			</div>
			<div class="form-floating mb-3">
				<input type="password" name="pwdCheck" id="join-pwd2" class="form-control" placeholder=" 암호를 입력하세요" maxlength="20" /><label for="join-pwd2">암호 재입력</label>
			</div>
			<div class="form-floating mb-3">
				<input type="text" name="name" id="join-name" class="form-control" placeholder=" 성명을 입력하세요" maxlength="20" /><label for="join-name">성명</label>
			</div>
			<div class="form-floating">
				<input type="text" name="phone" id="join-phone" class="form-control" placeholder=" 전화번호를 입력하세요" maxlength="20" /><label for="join-phone">전화번호</label>
			</div>
		</fieldset>
		
		<fieldset>
			<legend>추가 정보</legend>
			<div class="form-floating input-group mb-3">
				<input type="text" name="zipnum" id="join-zipnum" class="form-control" size="20" placeholder=" 주소찾기를 누르세요" aria-describedby="button-addon2" readonly /><label for="join-zipnum">우편번호</label>
				<input type="button" value="주소 찾기" id="button-addon2" class="btn btn-secondary" class="join-form-input" onclick="post_zip();" />
			</div>
			<div class="form-floating mb-3">
				<input type="text" name="address1" id="join-address1" class="form-control" size="50" placeholder=" 주소찾기를 누르세요" readonly /><label for="join-address1">주소</label>
			</div>
			<div class="form-floating mb-3">
				<input type="text" name="address2" id="join-address2" class="form-control" size="30" placeholder=" 상세주소를 입력하세요" maxlength="100" /><label for="join-address2">상세주소</label>
			</div>
			<div class="form-floating mb-3">
				<input type="text" name="email" id="join-email" class="form-control" size="30" placeholder=" 이메일을 입력하세요" maxlength="40" /><label for="join-email">이메일</label>
			</div>
		</fieldset>
		
		<div class="clear"></div>
		<div class="d-grid gap-2 d-md-block">
			<button type="button" class="btn btn-primary" onclick="go_save();" >회원가입</button>&nbsp;
			<button type="reset" class="btn btn-secondary" >취소</button>
		</div>
	</form>
	</div>
</div>
</article>

<%@ include file="../sub/footer.jsp" %>