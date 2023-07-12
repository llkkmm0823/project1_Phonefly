<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="compare-popup">
	<!-- 열고 닫는 화살표 -->
	<div class="arrow-btn">
		<a href="javascript:;" class="arrow-i disabled" onclick="openCloseArrow();"></a>
	</div>
	<!-- //열고 닫는 화살표 -->


	<!-- 비교 팝업 본체 -->
	<div class="wrap compare-wrap">
		<form name="frm" method="post" action="/productCompare" onsubmit="return toComparePage();">
			<input type="hidden" class="compare-counts" name="counts" value="0" />


		<!-- 우측 상단 버튼 -->
		<div class="compare-btns">
			<ul>
				<li class="reset-i"><span class="btn-underline" onclick="btnReset();">비우기</span></li>
				<li><button type="submit" class="btn-compare">비교하기</button></li>
			</ul>
		</div>
		<div class="clear"></div>
		<!-- //우측 상단 버튼 -->


		<!-- 비교 상자 전체 -->
		<div class="compare-boxes">
			<ul>
				<c:forEach begin="1" end="4" varStatus="status">
					<li>
						<input type="hidden" class="compare-box-pseq-real" name="pseqr" value="0" />
						<input type="hidden" class="compare-box-pseq-h" name="pseq" value="0" />
						<input type="hidden" class="compare-box-image-real-h" value="" />
						<input type="hidden" class="compare-box-name-h" value="" />
						<input type="hidden" class="compare-box-price-h" value="" />
						<div class="compare-box disabled">
							<div>
								<div class="compare-box-image visibility-hidden">
									<img src="images/productImage/Aippr1401.png" class="compare-box-image-real" />
								</div>
								<div class="compare-box-text visibility-hidden">
									<div class="compare-box-name">
									iPhone 14 Pro
									</div>
									<div class="compare-box-price visibility-hidden">
									0원
									</div>
								</div>
								<div class="compare-box-xbtn visibility-hidden" onclick="btnX(${status.index-1});">
								</div>
							</div>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
		<!-- //비교 상자 전체 -->


		</form>
	</div>
	<!-- //비교 팝업 본체 -->
</div>
