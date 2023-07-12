<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../sub/header.jsp" %>
<script src="script/removeMenuSession.js"></script>
<article>
<div class="contract-wrap card-normal">
	<br />
	<h2 class="mt-3 mb-4">회원 가입 약관</h2>
	<form id="join" method="post" name="contractFrm">
	<p>
	언제나 새로운 즐거움이 가득한 PhoneFly의 회원가입 페이지 입니다.<br />
	PhoneFly의 회원가입은 무료이며, 회원님의 개인신상에 관한 정보는 '정보통신망이용촉진 및<br />정보보호등에 관한 법률'에 의해 회원님의 동의없이 제 3자에게 제공되지 않으며, 철저히 보호되고 있사오니 안심하시고 이용하시기 바랍니다.<br />
	</p>
	<textarea rows="15" cols="100">
	<%@ include file="contract.txt" %>
	</textarea>
	<br />
	<div class="contract-agree">
		<div class="form-check form-check-inline">
			<input class="form-check-input" type="radio" name="okon" id="inlineRadio1">
			<label class="form-check-label" for="inlineRadio1">동의함</label>
		</div>&nbsp;
		<div class="form-check form-check-inline">
			<input class="form-check-input" type="radio" name="okon" id="inlineRadio2" checked>
			<label class="form-check-label" for="inlineRadio2">동의안함</label>
		</div>
	</div>
	<div class="contract-btns d-grid gap-2 d-md-flex justify-content-md-end">
		<button class="btn btn-primary" type="button" onclick="go_next();">가입하기</button>
	</div>
	</form>
</div>
</article>

<%@ include file="../sub/footer.jsp" %>