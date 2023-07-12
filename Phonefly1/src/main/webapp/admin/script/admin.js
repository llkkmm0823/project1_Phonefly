function workerCheck(){
	  if(document.frm.workId.value==""){
	      	alert("아이디를 입력하세요.");
	      	return false;
	  }else if(document.frm.workPwd.value==""){
	     	alert("비밀번호를 입력하세요.");
	      	return false;
	  }
	  return true;  
}



function go_detail( pseq ){
	document.frm.action = "pf.do?command=adminProductDetail&pseq=" + pseq; 
	document.frm.submit();
	// location.href="pf.do?command=adminProductDetail&pseq=" + pseq;
}

function go_detail_e( eseq ){
	document.frm.action = "pf.do?command=adminEventDetail&eseq=" + eseq; 
	document.frm.submit();
	// location.href="pf.do?command=adminEventDetail&eseq=" + eseq;
}

function go_detail_n( nseq ){
	document.frm.action = "pf.do?command=adminNoticeDetail&nseq=" + nseq; 
	document.frm.submit();
	// location.href="pf.do?command=adminEventDetail&nseq=" + nseq;
}


function go_detail_c( cseq ){
	document.frm.action = "pf.do?command=adminColorDetail&cseq=" + cseq; 
	document.frm.submit();
	// location.href="pf.do?command=adminColorDetail&cseq=" + cseq;
}

function go_mov(){
	location.href = "pf.do?command=adminProductList";
}

function go_mov_e(){
	location.href = "pf.do?command=adminEventList";
}

function go_mov_n(){
	location.href = "pf.do?command=adminNoticeList";
}

function go_mov_c(pseq){
	location.href = "pf.do?command=adminColorList&pseq="+pseq;
}




function go_search( comm ){
	if( document.frm.key.value == "" ){
		alert("검색버튼 사용시에는 검색어 입력이 필수입니다");
	 	return;
	}
	var url = "pf.do?command=" + comm + "&page=1";   // 검색어로 검색한 결과의 1페이지로 이동
	document.frm.action = url;
	document.frm.submit();
}




function go_total( comm ){
	document.frm.key.value="";
	document.frm.action = "pf.do?command=" + comm + "&page=1";
	document.frm.submit();
}




function go_wrt(){
	document.frm.action = "pf.do?command=adminProductInsertForm";
	document.frm.submit();
}



function go_wrt_e(){
	document.frm.action = "pf.do?command=adminEventInsertForm";
	document.frm.submit();
}



function go_wrt_n(){
	document.frm.action = "pf.do?command=adminNoticeInsertForm";
	document.frm.submit();
}

function go_wrt_c(pseq){
	document.frm.action = "pf.do?command=adminColorInsertForm&pseq="+pseq;
	document.frm.submit();
}

function cal(){
	if( document.frm.price2.value == "" || document.frm.price1.value=="") return; 
	document.frm.price3.value = document.frm.price2.value - document.frm.price1.value; 
}





function go_save(pseq){
	var theForm = document.frm;
	if (theForm.name.value == "") {
		alert('상품명을 입력하세요.'); 	
		theForm.name.focus();	
	} else if (theForm.price1.value == "") {
		alert('원가를 입력하세요.'); 		
		theForm.price1.focus();
	} else if (theForm.price2.value == "") {
		alert('판매가를 입력하세요.'); 		
		theForm.price2.focus();
	} else if (theForm.content.value == "") {
		alert('상품상세를 입력하세요.'); 		
		theForm.content.focus();
	} else if (theForm.mfc.value == "") {
		alert('제조사를 입력하세요.'); 		
		theForm.mfc.focus();
	} else{
		theForm.action = "pf.do?command=adminProductInsert&pseq=" + pseq ;
		theForm.submit();	
 }
}





function go_save_e(){
	var theForm = document.frm;
	if( theForm.name.value == "") {
		alert('이벤트명을 입력하세요.'); 	
		theForm.name.focus();	
	} else if (theForm.content.value == "") {
		alert('이벤트상세를 입력하세요.'); 		
		theForm.content.focus();
	} else{
		theForm.action = "pf.do?command=adminEventInsert";
		theForm.submit();
	}
}




function go_save_n(){
	var theForm = document.frm;
	if( theForm.subject.value == "") {
		alert('제목을 입력하세요.'); 	
		theForm.subject.focus();	
	} else if (theForm.content.value == "") {
		alert('내용을 입력하세요.');
		theForm.content.focus();
	} else{
		theForm.action = "pf.do?command=adminNoticeInsert";
		theForm.submit();
	}
}

function go_save_c(pseq){
	var theForm = document.frm;	
	if( theForm.name.value == "") {
		alert('색상이름을 입력하세요.'); 	
		theForm.name.focus();	
	} else if (theForm.ccode.value == "") {
		alert('색상코드를 입력하세요.'); 		
		theForm.ccode.focus();
	} else if (theForm.image.value == "") {
		alert('색상 이미지를 입력하세요.'); 		
		theForm.image.focus();	
	} else{
		theForm.action = "pf.do?command=adminColorInsert&pseq=" + pseq;
		theForm.submit();
	}
}

function go_save_insert(){
	if (document.frm.subject.value == '') {
		alert('이벤트 제목을 입력하세요');
		document.frm.subject.focus();
	 } else {
		document.frm.action = "pf.do?command=adminEventInsert";
		document.frm.submit();
	}
}


function go_mod(pseq){
	var url = "pf.do?command=adminProductUpdateForm&pseq=" + pseq;
	location.href=url;
	// document.frm.action = url;
	// document.frm.submit();
}

function go_mod_e(eseq){
	var url = "pf.do?command=adminEventUpdateForm&eseq=" + eseq;
	location.href=url;
	// document.frm.action = url;
	// document.frm.submit();
}

function go_mod_n(nseq){
	var url = "pf.do?command=adminNoticeUpdateForm&nseq=" + nseq;
	location.href=url;
	// document.frm.action = url;
	// document.frm.submit();
}

function go_mod_c(cseq){
	var url = "pf.do?command=adminColorUpdateForm&cseq=" + cseq;
	location.href=url;
	// document.frm.action = url;
	// document.frm.submit();
}


function go_mod_save(pseq){
	if  (document.frm.name.value == '') {
		  alert('상품명을 입력하세요');	  
		  document.frm.name.focus();
	 } else if (document.frm.price1.value == '') {
		  alert('원가를 입력하세요');	 
 		  document.frm.price1.focus();
	 } else if (document.frm.price2.value == '') {
		  alert('판매가를 입력하세요');	  
		  document.frm.price2.focus();
	 } else if (document.frm.content.value == '') {
		  alert('상품상세를 입력하세요');	  
		  document.frm.content.focus();		  
	 } else if (document.frm.bestyn.value == '') {
		  alert('베스트 아이템 등록을 입력하세요');	  
		  document.frm.bestyn.focus();
	} else if (document.frm.eventyn.value == '') {
		  alert('이벤트 아이템 등록을 입력하세요');	  
		  document.frm.eventyn.focus();	  
	} else if (document.frm.mfc.value == '') {
		  alert('제조사를 입력하세요');	  
		  document.frm.mfc.focus();	 		  	    		  
	 } else{
		if( confirm('수정하시겠습니까?') ){
			 document.frm.action = "pf.do?command=adminProductUpdate&pseq="+pseq;
			 document.frm.submit();
		}
	}
}

function go_mod_save_e(eseq){
	if (document.frm.subject.value == '') {
		alert('이벤트 제목을 입력하세요');
		document.frm.subject.focus();
	 } else {
		if( confirm('수정하시겠습니까?') ){
			document.frm.action = "pf.do?command=adminEventUpdate&eseq="+eseq;
			document.frm.submit();
		}
	}
}


function go_mod_save_c(cseq){
	if (document.frm.name.value == '') {
		alert('색상명 을 입력하세요');
		document.frm.name.focus();
		/*} else if (document.frm.image.value == '') {
		  alert('사진를 입력하세요');	  
		  document.frm.image.focus();	*/ 	  
		} else if (document.frm.ccode.value == '') {
		  alert('색상코드를 입력하세요');	  
		  document.frm.ccode.focus();	 	  		  	    		    	    		 		
	 } else {
		if( confirm('수정하시겠습니까?') ){
			document.frm.action = "pf.do?command=adminColorUpdate&cseq="+cseq;
			document.frm.submit();
		}
	}
}





function go_mod_save_n(){
	if  (document.frm.subject.value == '') {
		  alert('공지사항 이름을 입력하세요');	  
		  document.frm.subject.focus();
	 } else if (document.frm.content.value == '') {
		  alert('공지사항 상세를 입력하세요');	  
		  document.frm.content.focus();
	 }else{
		if( confirm('수정하시겠습니까?') ){
			 document.frm.action = "pf.do?command=adminNoticeUpdate";
			 document.frm.submit();
		}
	}
}



function go_order_save(){
		
	// 현재 화면에 보여지고 있는 주문들의 체크박스들의 체크된 상태가  몇개나 체크되어 있는지 갯수를  count  합니다
	var count=0;
	if( document.frm.result.length == undefined ){   // 화면에 표시된 체크박스가 한개인경우
		if( cocument.frm.result.checked == true ) count++;
	}else{  //  화면에 표시된 체크박스가 두개 이상인경우
		for( var i=0; i<document.frm.result.length ; i++)
			if( document.frm.result[i].checked==true)
				count++;
	}
	
	if (count == 0) {
	    alert("주문처리할 항목을 선택해 주세요.");
	}else{
		document.frm.action = "pf.do?command=adminOrderUpdate";
		document.frm.submit();
	}
	// 주문 처리하고(주문의 result 값을 '1' -> '2' 로 변경)    orderList.jsp 로 되돌아 갑니다.
}





function go_view( qseq ){
	location.href = "pf.do?command=adminQnaDetail&qseq=" + qseq;
}


	

function go_rep(qseq){
	document.frm.action="pf.do?command=adminQnaUpdate";
	document.frm.submit();
	// 답변 글 등록 & rep 필드를 2로 업데이트
}

function go_del_e(eseq) {
  var confirmDelete = confirm("정말 이 이벤트를 삭제하시겠습니까?");
  if (confirmDelete) {
    var url = "pf.do?command=adminEventDelete&eseq=" + eseq;
    location.href =url;
  }
}

function go_del(pseq) {  
  var confirmDelete = confirm("정말 이 상품을 삭제하시겠습니까?");
  if (confirmDelete) {  
    var url = "pf.do?command=adminProductDelete&pseq=" + pseq;   
    location.href =url;
  }
}

function go_del_n(nseq) {  
  var confirmDelete = confirm("정말 이 공지사항을 삭제하시겠습니까?");
  if (confirmDelete) {  
    var url = "pf.do?command=adminNoticeDelete&nseq=" + nseq;   
    location.href = url;
  }
}

function go_del_c(cseq,pseq) {  
  var confirmDelete = confirm("정말 이 색상을 삭제하시겠습니까?");
  if (confirmDelete) {   
    var url = "pf.do?command=adminColorDelete&cseq="+ cseq + "&pseq=" + pseq;   
    location.href = url;
  }
}


function go_col(pseq) {  
 location.href = "pf.do?command=adminColorList&pseq=" + pseq;
}
	
/* 헤더 누르면 페이지 이동*/  
function goToAdminProductList() {
 location.href = "pf.do?command=adminProductList&changeMenu;"
}








