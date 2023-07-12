/**
 * author : BHS
 */


$(function(){
	let imgIndex = 0;
	let playFlag = false;
	let setFunction;
	function move(){
		$(".main_banner").animate({left:(-imgIndex * 1470)}, 100);
	}
	function run(){
		imgIndex++;
		imgIndex %= 3;
		move();
	}
	function stop() {
		clearInterval(setFunction);
	}
	function play() {
		setFunction = setInterval(run, 5000);
	}
	function slide(n){
		if (playFlag) return;
		imgIndex += n;
		if (imgIndex < 0) imgIndex = 0;
		else if (imgIndex > 2) imgIndex = 2;
		move();
	}
	$("#lbutton").click(function(){
		slide(-1);
	});
	$("#rbutton").click(function(){
		slide(1);
	});
	$("#play_btn").click(function(){
		if (playFlag) {
			stop();
			$("#play_btn").text("▶");
		} else {
			play();
			$("#play_btn").text("∥");
		}
		playFlag = !playFlag;
	}).trigger("click");
});
