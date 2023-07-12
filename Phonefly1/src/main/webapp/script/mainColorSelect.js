/**
 * author : BHS
 */


function colorClick(i, j) {
	$(function(){
		$(".card-color-buttons-"+i+" li>div>div").removeClass("color-button-selector");
		$(".card-color-buttons-"+i+" li>div>div").eq(j-1).addClass("color-button-selector");
		$(".card-img-"+i+" li img").fadeOut(100);
		$(".card-img-"+i+" li img").eq(j-1).fadeIn(0);
	});
}
