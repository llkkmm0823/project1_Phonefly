<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../sub/header.jsp" %>
<%@ include file="../sub/sub_image_menu5.jsp"%>



<!-- 카카오 도로명 주소 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function sample6_execDaumPostcode() {
	new daum.Postcode({
		oncomplete: function(data) {
			var addr = '';
			var extraAddr = '';

			if (data.userSelectedType === 'R') {
				addr = data.roadAddress;
			} else {
				addr = data.jibunAddress;
			}
			if(data.userSelectedType === 'R'){
			if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
				extraAddr += data.bname;
			}
			if(data.buildingName !== '' && data.apartment === 'Y'){
				extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
			}
			if(extraAddr !== ''){
				extraAddr = ' (' + extraAddr + ')';
			}
			document.getElementById("sample6_extraAddress").value = extraAddr;
		} else {
			document.getElementById("sample6_extraAddress").value = '';
		}
		document.getElementById('sample6_postcode').value = data.zonecode;
		document.getElementById("sample6_address").value = addr;
		document.getElementById("sample6_detailAddress").focus();
		}
	}).open();
}
</script>
<!-- //카카오 도로명 주소 -->



<script src="script/removeMenuSession.js"></script>

<article>
<div class="wrap join-form-wrap card-normal">
	<div class="join-form mb-4">
	<form method="post" name="joinForm" action="/memberUpdate">
		<input type="hidden" name="provider" value="${loginUser.provider}" />
		<fieldset>
			<legend>기본 정보</legend>
			<div class="form-floating input-group mb-3">
				<input type="text" name="id" size="20" id="join-id" class="form-control" placeholder=" 아이디를 입력하세요" maxlength="20" aria-describedby="button-addon1" value="${loginUser.id}" readonly /><label for="join-id">아이디</label>
				<input type="hidden" name="reid" />
				<button type="button" id="button-addon1" class="btn btn-secondary" onclick="idcheck();" >중복 체크</button>
			</div>

			<c:choose>
				<c:when test="${loginUser.provider == 'kakao'}">
					<div class="form-floating mb-3">
						<input type="password" name="pwd" id="join-pwd" class="form-control" placeholder=" 암호를 입력하세요" maxlength="20" readonly /><label for="join-pwd">암호</label>
					</div>
					<div class="form-floating mb-3">
						<input type="password" name="pwdCheck" id="join-pwd2" class="form-control" placeholder=" 암호를 입력하세요" maxlength="20" readonly /><label for="join-pwd2">암호 재입력</label>
					</div>
				</c:when>
				<c:otherwise>
					<div class="form-floating mb-3">
						<input type="password" name="pwd" id="join-pwd" class="form-control" placeholder=" 암호를 입력하세요" maxlength="20" /><label for="join-pwd">암호</label>
					</div>
					<div class="form-floating mb-3">
						<input type="password" name="pwdCheck" id="join-pwd2" class="form-control" placeholder=" 암호를 입력하세요" maxlength="20" /><label for="join-pwd2">암호 재입력</label>
					</div>
				</c:otherwise>
			</c:choose>

			<div class="form-floating mb-3">
				<input type="text" name="name" id="join-name" class="form-control" placeholder=" 성명을 입력하세요" maxlength="20" value="${loginUser.name}" /><label for="join-name">성명</label>
			</div>
			<div class="form-floating">
				<input type="text" name="phone" id="join-phone" class="form-control" placeholder=" 전화번호를 입력하세요" maxlength="20" value="${loginUser.phone}" /><label for="join-phone">전화번호</label>
			</div>
		</fieldset>

		<fieldset>
			<legend>추가 정보</legend>
			<div class="form-floating input-group mb-3">
				<input type="text" name="zipnum" id="sample6_postcode" class="form-control" size="20" placeholder=" 주소찾기를 누르세요" aria-describedby="button-addon2" value="${loginUser.zipnum}" readonly /><label for="sample6_postcode">우편번호</label>
				<input type="button" value="주소 찾기" id="button-addon2" class="btn btn-secondary" class="join-form-input" onclick="sample6_execDaumPostcode();" />
			</div>
			<div class="form-floating mb-3">
				<input type="text" name="address1" id="sample6_address" class="form-control" size="50" placeholder=" 주소찾기를 누르세요" value="${loginUser.address1}" readonly /><label for="sample6_address">주소</label>
			</div>
			<div class="form-floating mb-3">
				<input type="text" name="address2" id="sample6_detailAddress" class="form-control" size="30" placeholder=" 상세주소를 입력하세요" value="${loginUser.address2}" maxlength="100" /><label for="sample6_detailAddress">상세주소</label>
			</div>
			<div class="form-floating mb-3">
				<input type="text" name="address3" id="sample6_extraAddress" class="form-control" size="30" placeholder=" 기타주소(세부사항)을 입력하세요" value="${loginUser.address3}" maxlength="100" /><label for="sample6_extraAddress">기타주소(세부사항)</label>
			</div>

			<c:choose>
				<c:when test="${loginUser.provider == 'kakao'}">
					<div class="form-floating mb-3">
						<input type="text" name="email" id="join-email" class="form-control" size="30" placeholder=" 이메일을 입력하세요" maxlength="40" value="${loginUser.email}" readonly /><label for="join-email">이메일</label>
					</div>
				</c:when>
				<c:otherwise>
					<div class="form-floating mb-3">
						<input type="text" name="email" id="join-email" class="form-control" size="30" placeholder=" 이메일을 입력하세요" maxlength="40" value="${loginUser.email}" /><label for="join-email">이메일</label>
					</div>
				</c:otherwise>
			</c:choose>

		</fieldset>

		<div class="clear"></div>
		<div class="d-grid gap-2 d-md-block">
			<button type="button" class="btn btn-primary" onclick="go_update();" >회원정보 수정</button>&nbsp;
			<button type="reset" class="btn btn-secondary" >취소</button>

		</div>
	</form>
	</div>
</div>
</article>

<%@ include file="../sub/footer.jsp" %>