/**
 * author : BHS
 */


let compare_box_count = 0;
let check_compare_box = 0;
let pseq_list = document.getElementsByClassName('pdPseq');
let image_list = document.getElementsByClassName('pdImg');
let name_list = document.getElementsByClassName('pdName');
let price_list = document.getElementsByClassName('pdPrice');
let compare_price_list = document.getElementsByClassName('card-compare-price');
let plus_btn_list = document.getElementsByClassName('plus-button');

let comp_pseq_list = document.getElementsByClassName('compare-box-pseq-real');
let comp_image_list = document.getElementsByClassName('compare-box-image-real');
let comp_name_list = document.getElementsByClassName('compare-box-name');
let comp_price_list = document.getElementsByClassName('compare-box-price');

let comp_pseq_h_list = document.getElementsByClassName('compare-box-pseq-h');
let comp_image_h_list = document.getElementsByClassName('compare-box-image-real-h');
let comp_name_h_list = document.getElementsByClassName('compare-box-name-h');
let comp_price_h_list = document.getElementsByClassName('compare-box-price-h');




/* 비교하기 카드(펼치기 숨기기) */
function openCloseArrow(){// console.log("비교하기 카드(펼치기 숨기기)");
	$(function(){
		if ($('.compare-popup').hasClass('compare-popup-open')) {
		//if (check_compare_box === 0) {
			$('.compare-popup').removeClass('compare-popup-open');
			$('.compare-popup').addClass('compare-popup-close');
			$('.arrow-i').removeClass('disabled');
		} else {
			$('.compare-popup').removeClass('compare-popup-close');
			$('.compare-popup').addClass('compare-popup-open');
			$('.arrow-i').addClass('disabled');
		}
	});
	check_compare_box++;
	check_compare_box %= 2;
	setCompareSession();
}



function compareProduct(pseq_from) {
	if (compare_box_count > 3) {
		alert("비교는 4개까지 가능합니다.");
		return;
	}
	check_compare_box = 1;

	for (let i = 0; i < pseq_list.length; i++) {
		if (pseq_from == pseq_list[i].value) {
			compare_price_list[i].classList.add('disabled');
			plus_btn_list[i].classList.add('disabled');

			comp_pseq_list[compare_box_count].value = pseq_from;
			comp_image_list[compare_box_count].src = 'images/productImage/' + image_list[i].value;
			comp_name_list[compare_box_count].innerHTML = name_list[i].value;
			comp_price_list[compare_box_count].innerHTML = price_list[i].value;

			comp_pseq_h_list[compare_box_count].value = pseq_from;
			comp_image_h_list[compare_box_count].value = 'images/productImage/' + image_list[i].value;
			comp_name_h_list[compare_box_count].value = name_list[i].value;
			comp_price_h_list[compare_box_count].value = price_list[i].value;


			$(function(){
				$('.compare-box').eq(compare_box_count-1).removeClass('disabled');
				$('.compare-box-image').eq(compare_box_count-1).removeClass('visibility-hidden');
				$('.compare-box-text').eq(compare_box_count-1).removeClass('visibility-hidden');
				$('.compare-box-price').eq(compare_box_count-1).removeClass('visibility-hidden');
				$('.compare-box-xbtn').eq(compare_box_count-1).removeClass('visibility-hidden');
			});

			compare_box_count++;
		}
	}
	if (pseq_list.length > 0) {
		$(function(){
			$('.compare-popup').removeClass('compare-popup-close');
			$('.compare-popup').addClass('compare-popup-open');
		});
	}

	document.getElementsByClassName('compare-counts').value = compare_box_count;

	setCompareSession();
}



function btnReset() {
	compare_box_count = 0;

	$(function(){
		$('.compare-box').addClass('disabled');
		$('.compare-box-image').addClass('visibility-hidden');
		$('.compare-box-text').addClass('visibility-hidden');
		$('.compare-box-price').addClass('visibility-hidden');
		$('.compare-box-xbtn').addClass('visibility-hidden');
		$('.compare-popup').removeClass('compare-popup-close');
		$('.compare-popup').removeClass('compare-popup-open');
		$('.card-compare-price').removeClass('disabled');
		$('.plus-button').removeClass('disabled');
	});

	document.getElementsByClassName('compare-counts').value = compare_box_count;
	sessionStorage.removeItem("comparePseqs");
}



function btnX(count) {
	let local_count = 0;

	for (let i = 0; i < pseq_list.length; i++) {
		if (comp_pseq_list[count].value == pseq_list[i].value) {
			compare_price_list[i].classList.remove('disabled');
			plus_btn_list[i].classList.remove('disabled');
		}
	}

	for (let i = 0; i < comp_pseq_list.length; i++) {
		if (i !== count) {
			comp_pseq_list[local_count].value = comp_pseq_h_list[i].value;
			comp_image_list[local_count].src = comp_image_h_list[i].value;
			comp_name_list[local_count].innerHTML = comp_name_h_list[i].value;
			comp_price_list[local_count].innerHTML = comp_price_h_list[i].value;
			local_count++;
		}
	}

	$(function(){
		$('.compare-box').eq(compare_box_count).addClass('disabled');
		$('.compare-box-image').eq(compare_box_count).addClass('visibility-hidden');
		$('.compare-box-text').eq(compare_box_count).addClass('visibility-hidden');
		$('.compare-box-price').eq(compare_box_count).addClass('visibility-hidden');
		$('.compare-box-xbtn').eq(compare_box_count).addClass('visibility-hidden');
	});

	compare_box_count--;

	for (let i = 0; i < compare_box_count; i++) {
		comp_pseq_h_list[i].value = comp_pseq_list[i].value;
		comp_image_h_list[i].value = comp_image_list[i].src;
		comp_name_h_list[i].value = comp_name_list[i].innerHTML;
		comp_price_h_list[i].value = comp_price_list[i].innerHTML;
	}

	document.getElementsByClassName('compare-counts').value = compare_box_count;

	setCompareSession();

	if (compare_box_count == 0) {
		btnReset()
	}
}



function toComparePage() {
	if (compare_box_count < 2) {
		alert("상품을 2개이상 선택하세요.");
		return false;
	}

	setCompareSession();

	return true;
}

function setCompareSession() {
/*	let comp_pseq_h_list = document.getElementsByClassName('compare-box-pseq-h');
	let comp_image_h_list = document.getElementsByClassName('compare-box-image-real-h');
	let comp_name_h_list = document.getElementsByClassName('compare-box-name-h');
	let comp_price_h_list = document.getElementsByClassName('compare-box-price-h');
*/	
	let data_set2 = new Array();
	for (let i = 0; i < compare_box_count; i++) {
		let data = new Object();
		let data_set = new Array();
		data.pseq = comp_pseq_h_list[i].value;
		data.image = comp_image_h_list[i].value;
		data.name = comp_name_h_list[i].value;
		data.price = comp_price_h_list[i].value;
		data_set.push(data);
		data_set2.push(data_set);
	}
	let data_cpbox = new Object();
	data_cpbox.chkbox = check_compare_box;
	data_set2.push(data_cpbox);
	let data_last = new Object();
	data_last.count = compare_box_count;
	data_set2.push(data_last);
	let json_data = JSON.stringify(data_set2);
	sessionStorage.setItem("comparePseqs", json_data);	
}





$(document).ready(function() {

	let data = JSON.parse(sessionStorage.getItem("comparePseqs"));
	compare_box_count = data.pop().count;
	check_compare_box = data.pop().chkbox;
	document.getElementsByClassName('compare-counts').value = compare_box_count;
	for (let i = 0; i < data.length; i++) {
		let temp = data[i];
		let temp2 = temp.pop();
		let pseq = temp2.pseq;
		let image = temp2.image;
		let nname = temp2.name;
		let price = temp2.price;
		comp_pseq_h_list[i].value = pseq;
		comp_image_h_list[i].value = image;
		comp_name_h_list[i].value = nname;
		comp_price_h_list[i].value = price;
		comp_pseq_list[i].value = pseq;
		comp_image_list[i].src = image;
		comp_name_list[i].innerHTML = nname;
		comp_price_list[i].innerHTML = price;
		$('.compare-box').eq(i).removeClass('disabled');
		$('.compare-box-image').eq(i).removeClass('visibility-hidden');
		$('.compare-box-text').eq(i).removeClass('visibility-hidden');
		$('.compare-box-price').eq(i).removeClass('visibility-hidden');
		$('.compare-box-xbtn').eq(i).removeClass('visibility-hidden');

		for (let j = 0; j < pseq_list.length; j++) {
			if (pseq == pseq_list[j].value) {
				compare_price_list[j].classList.add('disabled');
				plus_btn_list[j].classList.add('disabled');
			}
		}
		//alert(pseq+","+image+","+nname+","+price);
	}

	if (compare_box_count > 0) {
		if (check_compare_box === 0) {
			$('.compare-popup').removeClass('compare-popup-open');
			$('.compare-popup').addClass('compare-popup-close');
			$('.arrow-i').removeClass('disabled');
		} else {
			$('.compare-popup').removeClass('compare-popup-close');
			$('.compare-popup').addClass('compare-popup-open');
			$('.arrow-i').addClass('disabled');
		}
	} else {
		btnReset();
	}
});
