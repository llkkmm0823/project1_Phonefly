/**
 * author : BHS
 */


$(function(){
	let sIndex = parseInt(sessionStorage.getItem("menuIndex"));
	function setHover() {
		let idx = $(this).index();
		if (sIndex === idx) {
			$(".main_menu").eq(sIndex).removeClass("main_menu_select");
		}
		$(".main_menu").eq(idx).addClass("main_menu_hover");
	}
	function clearHover() {
		let idx = $(this).index();
		if (sIndex === idx) {
			$(".main_menu").eq(sIndex).addClass("main_menu_select");
		}
		$(".main_menu").eq(idx).removeClass("main_menu_hover");
	}
	function setClick() {
		let idx = $(this).index();
		sessionStorage.setItem("menuIndex", String(idx));
 		if (sessionStorage.getItem("menuIndex") === null) {
			$(".main_menu").eq(idx).addClass("main_menu_select");
		} else {
			$(".main_menu").eq(sIndex).removeClass("main_menu_select");
			$(".main_menu").removeClass("main_menu_select");
			$(".main_menu").eq(idx).addClass("main_menu_select");
		}
	}
	function setClickSub() {
		let idx = $(this).index();
		let setString = "";
		switch (idx) {
			case 0:
				setString = "5";
				break;
			case 1:
				setString = "2";
				break;
			case 2:
				setString = "4";
				break;
		}
		sessionStorage.setItem("menuIndex", setString);
	}
	function reload() {
		$(".main_menu").eq(sIndex).addClass("main_menu_select");
	}
	$("#menu li").hover(setHover,clearHover);
	$("#menu>ul>li").click(setClick);
	$(".sub-click").click(setClickSub);
	$().ready(reload);
});
