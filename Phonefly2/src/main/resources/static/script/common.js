/**
 * author : BHS
 */


/* 맨위로 돌아가기 */
var backToTopReady = () => {
	// Scroll | button show/hide
	window.addEventListener('scroll', () => {
		if (document.querySelector('html').scrollTop > 100) {
			document.getElementById('go_top').style.display = "block";
		} else {
			document.getElementById('go_top').style.display = "none";
		}
	});
};
backToTopReady();

// back to top
var backToTop = () => {
	window.scrollTo({
		top: 0,
		left: 0,
		behavior: 'smooth'
	});
};

/* // 맨 위로 돌아가기 */



/* 레이어 팝업 */
/* class="layer-popup show" */
// 팝업 열기
$(document).on("click", ".btn-divpopup-open", function (e){
	var target = $(this).attr("href");
	$(target).addClass("show");
});

// 외부영역 클릭 시 팝업 닫기
$(document).mouseup(function (e){
	var LayerPopup = $(".layer-popup");
	if (LayerPopup.has(e.target).length === 0) {
		LayerPopup.removeClass("show");
	}
});
/* // 레이어 팝업 */



/* 스크롤 */
$(window).scroll(function() {
	let scrollPoint = parseInt( $(window).scrollTop());

	// 제품상세용
	let $floater = $('#pdd-scroll-box'), startPoint = 140;
	if (parseInt(scrollPoint) > parseInt(startPoint)) {
		$floater.css("top", ($(window).scrollTop() - startPoint));
	} else if (parseInt(scrollPoint) <= parseInt(startPoint)) {
		$floater.css("top", 0);
	}

	// 서브메뉴용
	let $floater2 = $('#sub-scroll-box'), startPoint2 = 532;
	if (parseInt(scrollPoint) > parseInt(startPoint2)) {
		$floater2.css("top", ($(window).scrollTop() - startPoint2));
	} else if (parseInt(scrollPoint) <= parseInt(startPoint2)) {
		$floater2.css("top", 0);
	}
});
/* // 스크롤*/





/* 정수를 통화 단위 콤마 스트링으로 변환 */

 function toCurrencyString(num) {
	var regexp = /\B(?=(\d{3})+(?!\d))/g;
	return num.toString().replace(regexp, ',');
}

/* // 정수를 통화 단위 콤마 스트링으로 변환 */


function faqMenu(nn) {
	$('.faq-part').addClass('display-none');
	$('.faq-part-'+nn).removeClass('display-none');
} 

function faqToggle(n1,n2) {
	$('.faq-answer-'+n1+''+n2).toggleClass('faqdisabled');
	$('.arrow-'+n1+''+n2).toggleClass('disabled');
}





/* 회원 탈퇴 */
function withdrawalConfirm() {
	let bool = confirm("정말로 탈퇴 하시겠습니까?");
	if (bool) {
		location.href = '/deleteMember';
	} else {
		return;
	}
}


/* Q & A */
function confirmDeleteQna(qseq) {
	let bool = confirm("정말로 삭제 하시겠습니까?");
	if (bool) {
		location.href = '/qnaDelete?qseq='+qseq;
	} else {
		return;
	}
}

function writeQna() {
	if (document.qnafrm.subject.value === "") {
		alert("제목을 입력해 주세요.");
		document.qnafrm.subject.focus();
	} else if (!fn_chk_byte2(document.qnafrm.subject, 100)) {
		alert("제목은 100바이트 까지 입력 가능합니다.");
		document.qnafrm.subject.focus();
	} else if (document.qnafrm.content.value === "") {
		alert("내용을 입력해 주세요.");
		document.qnafrm.content.focus();
	} else if (!fn_chk_byte2(document.qnafrm.content, 3000)) {
		alert("내용은 3000바이트 까지 입력 가능합니다.");
		document.qnafrm.content.focus();
	} else {
		//document.qnafrm.action = "pf.do";
		document.qnafrm.submit();
	}
}

function writeReview() {
	if (document.reviewForm.content.value === "") {
		alert("내용을 입력해 주세요.");
		document.reviewForm.content.focus();
	} else if (!fn_chk_byte2(document.reviewForm.content, 1000)) {
		alert("내용은 1000바이트 까지 입력 가능합니다.");
		document.reviewForm.content.focus();
	} else {
		//document.reviewForm.action = "pf.do";
		document.reviewForm.submit();
	}
}


function fn_chk_byte(obj){
    totalByte = 0;
    var message = $(obj).val();

    for(var i =0; i < message.length; i++) {
            var currentByte = message.charCodeAt(i);
            if(currentByte > 128){
            	totalByte += 2;
            }else {
            	totalByte++;
            }
    }
    $("#messagebyte").text(totalByte);
}

function fn_chk_byte2(obj, nn){
    totalByte = 0;
    var message = $(obj).val();

    for(var i =0; i < message.length; i++) {
            var currentByte = message.charCodeAt(i);
            if(currentByte > 128){
            	totalByte += 2;
            }else {
            	totalByte++;
            }
    }
    if (totalByte > nn) {
		return false;
	} else {
		return true;
	}
}


/* 주문 내역 보기 */
function cancelOrder(odseq) {
	let bool = confirm("정말로 주문접수를 취소 하시겠습니까?");
	if (bool) {
		location.href = '/orderCancel?odseq='+odseq;
	} else {
		return;
	}
}



/* 내가 작성한 후기 */
function modifyReview(rvseq, objString) {
	let real_content = document.getElementById('real-content');
	document.getElementById('real-rvseq').value = rvseq;
	document.getElementById('real-content').value = document.getElementById(objString).value;

	if (real_content.value === "") {
		alert("내용을 입력해 주세요.");
		real_content.focus();
	} else if (!fn_chk_byte2(real_content, 1000)) {
		alert("내용은 1000바이트 까지 입력 가능합니다.");
		real_content.focus();
	} else {
		document.reviewForm.submit();
	}
}

function deleteReview(rvseq) {
	let bool = confirm("정말로 댓글을 삭제 하시겠습니까?");
	if (bool) {
		location.href = '/memberReviewDelete?rvseq='+rvseq;
	} else {
		return;
	}
}

