function loginCheck() {
	if (document.loginFrm.id.value === "") {
		alert("아이디는 필수입력사항입니다.");
		document.loginFrm.id.focus();
		return false;
	} else if (document.loginFrm.pwd.value === "") {
		alert("비밀번호는 필수입력사항입니다.");
		document.loginFrm.pwd.value();
		return false;
	} else {
		return true;
	}
}

function go_next() {
	// radio 버튼의 같은 name의 okon이 여러개라면 배열로 인식되어 사용
	// 동의함 버튼 : okon[0], 안함 버튼 : okon[1]
	if (document.contractFrm.okon[1].checked === true) {
		alert("회원 약관에 동의 하셔야 회원으로 가입이 가능합니다.");
	} else {
		document.contractFrm.action = "pf.do?command=joinForm";
		document.contractFrm.submit();
		// contractFrm 폼에 action 도 없고 submit 버튼도 없는 것을 스크립트 명령으로 action 값을 설정하고 submit() 메서드로 이동까지 실행합니다.
	}
}

function idcheck() {
	if (document.joinForm.id.value === "" ) {
		alert("아이디를 입력하고 중복체크를 진행하세요.");
		document.joinForm.id.focus();
		return;
	}
	let url = "pf.do?command=idCheck&id=" +  document.joinForm.id.value;
	let opt = "toolbar=no, menubar=no, resizable=no, width=600, height=250, scrollbars=no";
	window.open(url, "IdCheck", opt);
}

function idok(userid) {
	opener.joinForm.id.value = userid;
	opener.joinForm.reid.value = userid;
	self.close();
}

function post_zip() {
	let url = "pf.do?command=findZipnum";
	let opt = "toolbar=no, menubar=no, resizable=no, scrollbars=no, width=550, height=300, top=300, left=300";
	window.open(url, "우편번호 찾기", opt);
}

function result(zip_num, sido, gugun, dong) {
	opener.document.joinForm.zipnum.value = zip_num;
	opener.document.joinForm.address1.value=sido + " " + gugun + " " + dong;
	self.close();
}

function go_save() {
	if (document.joinForm.id.value === "") {
		alert("아이디를 입력해 주세요.");
		document.joinForm.id.focus();
	} else if (document.joinForm.reid.value !== document.joinForm.id.value) {
		alert("아이디를 중복확인을 하지 않았습니다.");
		document.joinForm.id.focus();
	} else if (document.joinForm.pwd.value === "") {
		alert("비밀번호를 입력해 주세요.");
		document.joinForm.pwd.focus();
	} else if (document.joinForm.pwd.value !== document.joinForm.pwdCheck.value) {
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		document.joinForm.id.focus();
	} else if (document.joinForm.name.value === "") {
		alert("이름을 입력해 주세요.");
		document.joinForm.name.focus();
	} else if (document.joinForm.phone.value === "") {
		alert("전화번호를 입력해 주세요.");
		document.joinForm.phone.focus();
	} else if (document.joinForm.email.value === "") {
		alert("이메일을 입력해 주세요.");
		document.joinForm.email.focus();
	} else if (document.joinForm.zipnum.value === "") {
		alert("우편번호를 입력해 주세요.");
		document.joinForm.zipnum.focus();
	} else {
		document.joinForm.action = "pf.do";
		document.joinForm.submit();
	}
}

function go_update() {
	if (document.joinForm.pwd.value === "") {
		alert("비밀번호를 입력해 주세요.");
		document.joinForm.pwd.focus();
	} else if (document.joinForm.pwd.value !== document.joinForm.pwdCheck.value) {
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		document.joinForm.id.focus();
	} else if (document.joinForm.name.value === "") {
		alert("이름을 입력해 주세요.");
		document.joinForm.name.focus();
	} else if (document.joinForm.phone.value === "") {
		alert("전화번호를 입력해 주세요.");
		document.joinForm.phone.focus();
	} else if (document.joinForm.email.value === "") {
		alert("이메일을 입력해 주세요.");
		document.joinForm.email.focus();
	} else if (document.joinForm.zipnum.value === "") {
		alert("우편번호를 입력해 주세요.");
		document.joinForm.zipnum.focus();
	} else {
		document.joinForm.action = "pf.do";
		document.joinForm.submit();
	}
}




/* 아이디 찾기 / 비밀번호 찾기 */

function findIdSubmit() {
	if (document.formm.name.value === "") {
		alert("이름을 입력해 주세요.");
		document.formm.name.focus();
	} else if (document.formm.phone.value === "") {
		alert("전화번호를 입력해 주세요.");
		document.formm.phone.focus();
	} else {
		document.formm.action = "pf.do";
		document.formm.submit();
	}
}

function findPwdSubmit() {
	if (document.formm.name.value === "") {
		alert("이름을 입력해 주세요.");
		document.formm.name.focus();
	} else if (document.formm.id.value === "") {
		alert("아이디를 입력해 주세요.");
		document.formm.id.focus();
	} else if (document.formm.phone.value === "") {
		alert("전화번호를 입력해 주세요.");
		document.formm.phone.focus();
	} else {
		document.formm.action = "pf.do";
		document.formm.submit();
	}
}

function checkPwd() {
	if (document.joinForm.pwd.value === "") {
		alert("비밀번호를 입력해 주세요.");
		document.joinForm.pwd.focus();
	} else if (document.joinForm.pwd.value !== document.joinForm.pwdCheck.value) {
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		document.joinForm.id.focus();
	} else {
		document.joinForm.action = "pf.do";
		document.joinForm.submit();
	}
}


function findId() {
	let url = "pf.do?command=selectId";
	let opt = "toolbar=no, menubar=no, resizable=no, scrollbars=no, width=550, height=350, top=300, left=300";
	window.open(url, "아이디(ID) 찾기", opt);
}

function findPwd() {
	let url = "pf.do?command=selectPwd";
	let opt = "toolbar=no, menubar=no, resizable=no, scrollbars=no, width=550, height=400, top=300, left=300";
	window.open(url, "비밀번호 찾기", opt);
}

