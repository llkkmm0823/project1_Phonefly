<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="sub-banner sub-banner-product wrap_main_banner">
	<video class="sub-video" src="videos/movie7.webm" autoplay muted loop preload="auto"></video>
	<c:choose>
		<c:when test="${mfc == 'Samsung'}">
			<div id="banner_text4">
				<!-- 제품 설명 4 -->
				<h1>갤럭시 S23 Ultra</h1>
				<p class="txt_1">노트의 시그니처에서 울트라의 상징으로</p>
				<p class="txt_2">노트를 넘어 갤럭시 S23 Ultra의 일상에서도<br />
								만날 수 있게 된 S펜으로 떠오르는 영감들을 <br />
								바로바로 스케치하고 메모해 보세요.<br />
								S펜으로 이미지 속 텍스트를 캡처한 후 바로 캘린더에 저장할 수도 있죠.</p>
				<!-- //제품 설명 4 -->
			</div>
		</c:when>
		<c:otherwise>
			<div id="banner_text4">
					<!-- 제품 설명 1 -->
					<h1>iPhone 14 Pro</h1>
					<p class="txt_1">변화무쌍 Dynamic Island.</p>
					<p class="txt_2">당신이 원래 하던 일을 방해하지 않으면서도 음악, 통화 등<br />
					요긴한 정보를 그때그때 띄워주는 Dynamic Island.<br/>
					길게 꾹 누르면 음악 제어, AirPods 배터리 잔량 확인 등<br />
					다양한 기능을 사용할 수 있죠. 게다가 iOS 전반에 통합되어 있고<br/>
					 수많은 앱과 연동되기 때문에 꼭 필요한 걸 꼭 필요한 순간에 매끄럽게 띄워준답니다.</p>
					<!-- //제품 설명 1 -->
			</div>
		</c:otherwise>
	</c:choose>
</div>
<!-- <script type="text/javascript">var id=document.getElementById("sub-video"); id.playbackRate=0.6;</script> -->
<div class="clear"></div>
