/**
 * author : BHS
 */



/* 제품 상세 */ 

// 페이지 로딩시 기본값 세팅
var varPrice2 = 0;
var varCommOld = 2;
var varCommNew = 2;
var arrayCommArray = ["", "SKT", "KT", "LGT"];
var varDiscount = 0;  // 결과값에 포함
var arrayDiscountText = ["공시지원할인", "선택약정할인"];
var arrayDiscountValue = [200000, 0];
var varBuyplan = 1;
var varBuyplanMul = 1;
var buyplanArray = [1, 24, 30, 36]; // 결과값에 포함
var varDiscountValueA = arrayDiscountValue[0];
var varDiscountValueB = arrayDiscountValue[1] / buyplanArray[varBuyplan];
var varDiscountArray1 = var_rplan_charge / 4 * buyplanArray[varBuyplan];

// 결과 값들
var varRseq = 0;
var varCseq = 0;
var varCc = 1;
var varCcTitleString = "기기변경";
var varCcTextString = "&nbsp;통신사는 그대로, 휴대폰만 바꾸고 싶어요.";
var varDiscountTitleString = "단말기 할인";
var varDiscountTextString = "&nbsp;개통당시 1회 단말기 구매 비용 할인";

var var_rplan_name = "";
var var_rplan_charge = 0;
var var_rplan_dataplan = "";
var var_rplan_timeplan = "";
var var_rplan_textplan = "";

var var_pdd_dctotal = 0;
var var_pdd_dcmonth = 0;
var var_pdd_mmonth = 0;
var var_pdd_mtotal = 0;


function pddColorClick(i, j, cseq) {
	$(function(){
		$(".card-color-buttons-"+i+" li>div>div").removeClass("color-button-selector");
		$(".card-color-buttons-"+i+" li>div>div").eq(j-1).addClass("color-button-selector");
		$(".card-img-"+i+" li img").fadeOut(100);
		$(".card-img-"+i+" li img").eq(j-1).fadeIn(0);
		$(".pdd-color-names li").addClass("display-none");
		$(".pdd-color-names li").eq(j-1).removeClass("display-none");
	});
	varCseq = parseInt(cseq);
	setFields();
}


// 페이지 준비되면 최초 실행하여 기본값 설정
$(document).ready(function() {
	var price2_array = document.getElementsByClassName("pdd-price2-in");
	varPrice2 = price2_array[0].value;
	cseq_array = document.getElementsByClassName("cseq");
	varCseq = cseq_array[0].value;

	selectPlan("스페셜", 100000, "무제한", "유무선 무제한", "문자 무제한", "15");
	setFields();
});
/* 함수 */
// 사용중인 통신사
function clickOldComm (nCommOld) {
	varCommOld = nCommOld;
	if (varCommOld === varCommNew) {
		varCc = 1;
		varCcTitleString = "기기변경";
		varCcTextString = "통신사는 그대로, 휴대폰만 바꾸고 싶어요.";
	} else {
		varCc = 0;
		varCcTitleString = "통신사이동";
		varCcTextString = "&nbsp;쓰던번호 그대로 "+arrayCommArray[varCommNew]+"로 통신사만 바꿀래요";
	}

	$(function(){
		$(".comm-old").removeClass("pdd-box-selected");
		$(".comm-old-"+nCommOld).addClass("pdd-box-selected");
	});

	setFields();
}

// 사용하실 통신사
function clickNewComm (nCommNew) {
	var commUrlArray = ['', '#layer-popup-skt', '#layer-popup-kt', '#layer-popup-lg'];
	varCommNew = nCommNew;
	if (varCommOld === varCommNew) {
		varCc = 1;
		varCcTitleString = "기기변경";
		varCcTextString = "&nbsp;통신사는 그대로, 휴대폰만 바꾸고 싶어요.";
	} else {
		varCc = 0;
		varCcTitleString = "통신사이동";
		varCcTextString = "&nbsp;쓰던번호 그대로 "+arrayCommArray[varCommNew]+"로 통신사만 바꿀래요";
	}
	if (varCommNew === 1) {
		selectPlan("플래티넘", 125000, "무제한", "유무선 무제한", "문자 무제한", "8");
	} else if (varCommNew === 2) {
		selectPlan("스페셜", 100000, "무제한", "유무선 무제한", "문자 무제한", "15");
	} else {
		selectPlan("프리미어슈퍼", 115000, "무제한", "유무선 무제한", "문자 무제한", "23");
	}

	$(function(){
		$(".comm-new").removeClass("pdd-box-selected");
		$(".comm-new-"+nCommNew).addClass("pdd-box-selected");
	});
	
	$("#btn-popup-open").attr("href", commUrlArray[nCommNew]);

	setFields();
}


// 요금제
function selectPlan(n_rplan_name, n_rplan_charge, n_rplan_dataplan, n_rplan_timeplan, n_rplan_textplan, n_rseq) {
	var_rplan_name = n_rplan_name;
	var_rplan_charge = n_rplan_charge;
	var_rplan_dataplan = n_rplan_dataplan;
	var_rplan_timeplan = n_rplan_timeplan;
	var_rplan_textplan = n_rplan_textplan;
	varRseq = n_rseq;
	var_rplan_charge = n_rplan_charge;
	varBuyplanMul = 1;
	if (varBuyplan === 0) {
		varBuyplanMul = 0;
	}
	varDiscountArray1 = var_rplan_charge / 4 * buyplanArray[varBuyplan] * varBuyplanMul;
	arrayDiscountValue[1] = varDiscountArray1;
	varDiscountValueA = arrayDiscountValue[0];
	varDiscountValueB = arrayDiscountValue[1] / buyplanArray[varBuyplan];
	setFields();
	$(".layer-popup").removeClass("show");
}

// 할인방법
function clickDiscountMethod(nDiscount) {
	varDiscount = nDiscount;
	if (nDiscount == 0) {
		arrayDiscountValue[0] = 200000;
		arrayDiscountValue[1] = 0;
		varDiscountTitleString = "단말기 할인";
		varDiscountTextString = "&nbsp;개통당시 1회 단말기 구매 비용 할인";
		$(function(){
			$(".discount-method-1").removeClass("display-none");
			$(".discount-method-2").addClass("display-none");
		});
	} else {
		arrayDiscountValue[0] = 0;
		arrayDiscountValue[1] = varDiscountArray1;
		varDiscountTitleString = "25% 요금할인";
		varDiscountTextString = "&nbsp;약정기간동안 매월 기본료 25%할인";
		$(function(){
			$(".discount-method-2").removeClass("display-none");
			$(".discount-method-1").addClass("display-none");
		});
	}

	$(function(){
		$(".pdd-discount").removeClass("pdd-box-selected");
		$(".discount-"+nDiscount).addClass("pdd-box-selected");
	});

	setFields();
}

// 구매방법
function clickBuyType(nBuyplan, nBuyplanValue) {
	varBuyplan = nBuyplan;
	buyplanArray[varBuyplan] = nBuyplanValue;
	varBuyplanMul = 1;
	if (varBuyplan === 0) {
		varBuyplanMul = 0;
	}
	varDiscountArray1 = var_rplan_charge / 4 * buyplanArray[varBuyplan] * varBuyplanMul;
	arrayDiscountValue[1] = varDiscountArray1;
	varDiscountValueB = arrayDiscountValue[1] / buyplanArray[varBuyplan];
	
	if (nBuyplan == 0) {
		$(".pdd-plan-chk").addClass("display-none");
	} else {
		$(".pdd-plan-chk").removeClass("display-none");
	}
	
	$(function(){
		$(".buy-type").removeClass("pdd-box-selected");
		$(".buy-type-"+nBuyplan).addClass("pdd-box-selected");
	});

	setFields();
}

// 데이터 화면에 세팅하기
function setFields () {
	//document.getElementById("rplan-name").innerText = var_rplan_name;
	var rplan_name_array = document.getElementsByClassName("rplan-name");
	var rplan_charge_array = document.getElementsByClassName("rplan-charge");
	var rplan_charge_2_array = document.getElementsByClassName("rplan-charge-2");
	var rplan_dataplan_array = document.getElementsByClassName("rplan-dataplan");
	var rplan_timeplan_array = document.getElementsByClassName("rplan-timeplan");
	var rplan_textplan_array = document.getElementsByClassName("rplan-textplan");

	var rseq_array = document.getElementsByClassName("rseq");
	var cseq_array = document.getElementsByClassName("cseq");
	
	var cc_array = document.getElementsByClassName("cc-value");
	var cc_title_array = document.getElementsByClassName("cc-title");
	var cc_text_array = document.getElementsByClassName("cc-text");

	var discount_id_array = document.getElementsByClassName("discount-id");
	var discount_title_array = document.getElementsByClassName("discount-title");
	var discount_text_array = document.getElementsByClassName("discount-text");
	var discount_value_a_array = document.getElementsByClassName("discount-value-a-text");
	var discount_value_b_array = document.getElementsByClassName("discount-value-b-text");

	var buyplan_value_array = document.getElementsByClassName("pdd-buyplan");

	var price2_array = document.getElementsByClassName("pdd-price2-out");
	
	var pdd_dctotal = document.getElementsByClassName("pdd-dctotal");
	var pdd_dctotal_out = document.getElementsByClassName("pdd-dctotal-out");
	var pdd_dcmonth = document.getElementsByClassName("pdd-dcmonth");
	var pdd_dcmonth_out = document.getElementsByClassName("pdd-dcmonth-out");
	var pdd_mmonth = document.getElementsByClassName("pdd-mmonth");
	var pdd_mmonth_out = document.getElementsByClassName("pdd-mmonth-out");
	var pdd_mtotal = document.getElementsByClassName("pdd-mtotal");
	var pdd_mtotal_out = document.getElementsByClassName("pdd-mtotal-out");

	for (var i = 0; i < rplan_name_array.length; i++) {
		rplan_name_array[i].innerText = var_rplan_name;
		rplan_name_array[i].value = var_rplan_name;
	}
	for (var i = 0; i < rplan_charge_array.length; i++) {
		rplan_charge_array[i].innerText = toCurrencyString(var_rplan_charge);
		rplan_charge_array[i].value = var_rplan_charge;
	}
	for (var i = 0; i < rplan_charge_2_array.length; i++) {
		rplan_charge_2_array[i].innerText = toCurrencyString(varDiscountArray1);
		rplan_charge_2_array[i].value = varDiscountArray1
	}
	for (var i = 0; i < rplan_dataplan_array.length; i++) {
		rplan_dataplan_array[i].innerText = var_rplan_dataplan;
		rplan_dataplan_array[i].value = var_rplan_dataplan;
	}
	for (var i = 0; i < rplan_timeplan_array.length; i++) {
		rplan_timeplan_array[i].innerText = var_rplan_timeplan;
		rplan_timeplan_array[i].value = var_rplan_timeplan;
	}
	for (var i = 0; i < rplan_textplan_array.length; i++) {
		rplan_textplan_array[i].innerText = var_rplan_textplan;
		rplan_textplan_array[i].value = var_rplan_textplan;
	}

	for (var i = 0; i < rseq_array.length; i++) {
		rseq_array[i].value = varRseq;
	}
	for (var i = 0; i < cseq_array.length; i++) {
		cseq_array[i].value = varCseq;
	}

	for (var i = 0; i < cc_array.length; i++) {
		cc_array[i].value = varCc;
	}
	for (var i = 0; i < cc_title_array.length; i++) {
		cc_title_array[i].innerText = varCcTitleString;
	}
	for (var i = 0; i < cc_text_array.length; i++) {
		cc_text_array[i].innerHTML = varCcTextString;
	}

	for (var i = 0; i < discount_id_array.length; i++) {
		discount_id_array[i].value = varDiscount;
	}
	for (var i = 0; i < discount_title_array.length; i++) {
		discount_title_array[i].innerText = varDiscountTitleString;
	}
	for (var i = 0; i < discount_text_array.length; i++) {
		discount_text_array[i].innerHTML = varDiscountTextString;
	}
	for (var i = 0; i < discount_value_a_array.length; i++) {
		discount_value_a_array[i].innerText = '-' + toCurrencyString(varDiscountValueA);
	}
	for (var i = 0; i < discount_value_b_array.length; i++) {
		discount_value_b_array[i].innerText = '-' + toCurrencyString(varDiscountValueB);
	}

	for (var i = 0; i < buyplan_value_array.length; i++) {
		var tempString = '&nbsp;월 할부금<div class="float-r pdd-right-inside-month-text">&nbsp;(' + buyplanArray[varBuyplan] + '개월)</div>';
		if (varBuyplan === 0) {
			tempString = '&nbsp;일시불 구매가';
		}
		buyplan_value_array[i].innerHTML = tempString;
		buyplan_value_array[i].value = buyplanArray[varBuyplan];
	}

	for (var i = 0; i < price2_array.length; i++) {
		price2_array[i].innerText = toCurrencyString(varPrice2);
	}

	var pdd_factor_by_buyplan_1 = 1;
	var pdd_factor_by_buyplan_2 = 1;
	
	if (varBuyplan === 0) {
		pdd_factor_by_buyplan_1 = 0;
	}
	if (varDiscount === 0) {
		pdd_factor_by_buyplan_2 = 0;
	}

	var_pdd_dctotal = varPrice2 - arrayDiscountValue[0];
	var_pdd_dcmonth = Math.round(var_pdd_dctotal / buyplanArray[varBuyplan] / 10) * 10;
	var_pdd_mmonth = var_rplan_charge - parseInt(varDiscountValueB * pdd_factor_by_buyplan_2);
	var_pdd_mtotal = var_pdd_dcmonth * pdd_factor_by_buyplan_1 + var_pdd_mmonth;


	for (var i = 0; i < pdd_dctotal.length; i++) {
		pdd_dctotal[i].value = var_pdd_dctotal;
	}
	for (var i = 0; i < pdd_dctotal_out.length; i++) {
		pdd_dctotal_out[i].innerText = toCurrencyString(var_pdd_dctotal);
	}
	for (var i = 0; i < pdd_dcmonth.length; i++) {
		pdd_dcmonth[i].value = var_pdd_dcmonth;
	}
	for (var i = 0; i < pdd_dcmonth_out.length; i++) {
		pdd_dcmonth_out[i].innerText = toCurrencyString(var_pdd_dcmonth);
	}
	for (var i = 0; i < pdd_mmonth.length; i++) {
		pdd_mmonth[i].value = var_pdd_mmonth;
	}
	for (var i = 0; i < pdd_mmonth_out.length; i++) {
		pdd_mmonth_out[i].innerText = toCurrencyString(var_pdd_mmonth);
	}
	for (var i = 0; i < pdd_mtotal.length; i++) {
		pdd_mtotal[i].value = var_pdd_mtotal;
	}
	for (var i = 0; i < pdd_mtotal_out.length; i++) {
		pdd_mtotal_out[i].innerText = toCurrencyString(var_pdd_mtotal);
	}


}


/* // 제품 상세 */ 
