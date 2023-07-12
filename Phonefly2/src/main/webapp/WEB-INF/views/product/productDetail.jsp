<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- MAIN  -->
<!-- 
author : BHS
-->


<!-- 헤더 불러오기 -->
<%@ include file="../sub/header.jsp"%>
<script src="script/productDetail.min.js"></script>

<article>
<!-- 제품 상세 전체 프레임 -->
<div class="wrap pdd-wrap">
<form name="productForm" method="post" action="/order">
	<input type="hidden" class="pdd-pseq pdPseq" name="pseq" value="${productVO.pseq}" />
	<input type="hidden" class="pdImg" value="${productVO.colorList[0].image}" />
	<input type="hidden" class="pdName" value="${productVO.name}" />
	<input type="hidden" class="pdPrice" value="<fmt:formatNumber value='${productVO.price2}' type='number' maxFractionDigits='3' />원" />


	<!-- 온라인 신청하기 submit 전달 값 정리 -->
	<input type="hidden" class="pdd-price2-in" value="${productVO.price2}" />
	<input type="hidden" name="id" value="${id}" />
	<input type="hidden" name="cseq" class="cseq" value="${productVO.colorList[0].cseq}" />
	<input type="hidden" name="rseq" class="rseq" value="" /> <!-- KT 첫번째 뽑아내기 필요 -->
	<input type="hidden" name="discount" class="discount-id" value="0" /> <!-- (0: 500000, 1: 600000) 금액 / 24 -->
	<input type="hidden" name="buyplan" class="pdd-buyplan" value="24" /> <!-- (0: 1, 1: 24, 2: 30, 3: 36) -->
	<input type="hidden" name="cc" class="cc-value" value="" /> <!-- (g == h: 기기변경(1), g != h: 통신사이동(0)) -->
	<input type="hidden" name="dctotal" class="pdd-dctotal" value="" />
	<input type="hidden" name="dcmonth" class="pdd-dcmonth" value="" />
	<input type="hidden" name="mmonth" class="pdd-mmonth" value="" />
	<input type="hidden" name="mtotal" class="pdd-mtotal" value="" />
	<!-- //온라인 신청하기 submit 전달 값 정리 -->

	<!-- 온라인 신청하기 가져오는 값 정리 --> <!-- KT 첫번째 뽑아내기 필요 -->
<!-- 	<input type="hidden" name="rplan-name" class="rplan-name" value="" />
	<input type="hidden" name="rplan-charge" class="rplan-charge" value="" />
	<input type="hidden" name="rplan-dataplan" class="rplan-dataplan" value="" />
	<input type="hidden" name="rplan-timeplan" class="rplan-timeplan" value="" />
	<input type="hidden" name="rplan-textplan" class="rplan-textplan" value="" /> -->
	<!-- //온라인 신청하기 가져오는 값 정리 -->


	<!-- 전체 프레임 안쪽 - 중앙 정렬용 -->
	<div class="pdd-inside-wrap">


	<!-- 제품 상세 왼쪽 프레임 -->
	<div class="pdd-left-wrap card-normal">
		<!-- 제품 상세 메인 -->
		<div class="pdd-main">
			<!-- 제품 상세 이미지 및 선택사항 -->
			<div>
			
			
				<!-- 이미지, 컬러 리스트, 가격비교 (제품상세 왼쪽) -->
				<div class="pdd-image-wrap mt-4">

					<!-- 제품명 -->
					<div class="card-name pdd-card-name">
						<h3>
							${productVO.name}
						</h3>
					</div>
					<!-- //제품명 -->
					
					
					<!-- 이미지 -->
					<div class="pdd-card-img card-img-1">
						<ul>
	 					<c:forEach items="${productVO.colorList}" var="colorVO" varStatus="statusColor">
							<c:choose>
								<c:when test="${statusColor.count == 1}">
									<li style="z-index:10"><img src="images/productImage/${colorVO.image}" /></li>
								</c:when>
								<c:otherwise>
									<li><img src="images/productImage/${colorVO.image}" /></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						</ul>
					</div>
					<div class="clear"></div>
					<!-- //이미지 -->
					
					
					<!-- 컬러 리스트 -->
					<div class="card-color-buttons card-color-buttons-1">
						<ul>
							<c:forEach items="${productVO.colorList}" var="colorVO" varStatus="statusColor">
								<li onclick="pddColorClick(1, ${statusColor.count}, ${colorVO.cseq});">
									<div class="color-button" style="background-color:${colorVO.ccode}">
									<c:choose>
										<c:when test="${statusColor.count == 1}">
											<div class="color-button-selector"></div>
										</c:when>
										<c:otherwise>
											<div></div>
										</c:otherwise>
									</c:choose>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
					<div class="clear"></div>
					<!-- //컬러 리스트 -->
					
					
					<!-- 컬러 이름 -->
					<div class="pdd-color-names">
						<ul>
							<c:forEach items="${productVO.colorList}" var="colorVO" varStatus="statusColor">
								<c:choose>
									<c:when test="${statusColor.count == 1}">
										<li class="pdd-color-name">
											<div>${colorVO.name}</div>
										</li>
									</c:when>
									<c:otherwise>
										<li class="pdd-color-name display-none">
											<div>${colorVO.name}</div>
										</li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ul>
					</div>
					<br /><br />
					<!-- //컬러 이름 -->


					<!-- 가격비교 -->
					<div class="card-compare-price" onclick="compareProduct(${productVO.pseq});">
						<div class="plus-button"><span>&nbsp;가격 비교하기</span></div>
					</div>
					<!-- //가격비교 -->
					<div class="clear"></div>

				</div>
				<!-- //이미지, 컬러 리스트, 가격비교 (제품상세 왼쪽) -->



				<!-- 선택사항 (제품상세 오른쪽) -->
				<div class="pdd-selectors">
					<!-- 사용중인 통신사 (commList) -->
					<div class="pdd-selector-wrap">
						<div class="pdd-selector-name">사용중인 통신사</div>
						<div class="pdd-selector-content">
							<div class="pdd-box pdd-box-selected comm-ci comm-ci-1 comm-old comm-old-2" onclick="clickOldComm(2);"><img src="images/common/tong-kt.png" /></div>
							<div class="pdd-box comm-ci comm-ci-2 comm-old comm-old-1" onclick="clickOldComm(1);"><img src="images/common/tong-skt.png" /></div>
							<div class="pdd-box comm-ci comm-ci-3 comm-old comm-old-3" onclick="clickOldComm(3);"><img src="images/common/tong-lg.png" /></div>
						</div>
					</div>
					
					<!-- 사용하실 통신사 (commList) -->
					<div class="pdd-selector-wrap">
						<div class="pdd-selector-name">사용하실 통신사</div>
						<div class="pdd-selector-content">
							<div class="pdd-box pdd-box-selected comm-ci comm-ci-1 comm-new comm-new-2" onclick="clickNewComm(2);"><img src="images/common/tong-kt.png" /></div>
							<div class="pdd-box comm-ci comm-ci-2 comm-new comm-new-1" onclick="clickNewComm(1);"><img src="images/common/tong-skt.png" /></div>
							<div class="pdd-box comm-ci comm-ci-3 comm-new comm-new-3" onclick="clickNewComm(3);"><img src="images/common/tong-lg.png" /></div>
						</div>
					</div>


					<!-- 기기변경 / 통신사이동 (선택 : 위 값 매칭) -->
					<div class="pdd-selector-wrap pdd-small pdd-small-wrap">
						<div class="pdd-selector-name pdd-small"></div>
						<div class="pdd-selector-content pdd-small">
							<div class="pdd-small-blk-wrap pdd-small-txt cc-title">통신사이동</div>
							<div class="pdd-small-txt cc-text">&nbsp;쓰던번호 그대로 <span class="comm-txt">KT</span>로 통신사만 바꿀래요</div>
						</div>
					</div>





					<!-- 요금제 (rplanList) -->
					<!-- 레이어 팝업 #layer-popup-kt skt lg-->
					<div id="btn-popup-open" class="pdd-selector-wrap btn-divpopup-open" href="#layer-popup-kt">
						<div class="pdd-selector-name pdd-rplan-wrap">요금제</div>
						<div class="pdd-selector-content pdd-rplan-wrap">
							<div class="pdd-box pdd-rplan-content-wrap">
								<div class="pdd-rplan-cont-up down_btn">
								<span class="rplan-name"></span> | 월 <span class="rplan-charge"></span>원
								</div>
								<div class="pdd-rplan-cont-dn">
								데이터 <span class="rplan-dataplan"></span> / 음성 <span class="rplan-timeplan"></span> 
								 / <span class="rplan-textplan"></span>
								</div>
							</div>
						</div>
					</div>
					<div class="clear"></div>
					
					<!-- 할인방법 (프론트 선택 후 order_detail에 넘겨주기)
					공시지원 할인 / 선택약정할인 => 할부금 할인, 통신요금 할인 각각 적용 -->
					<div class="pdd-selector-wrap">
						<div class="pdd-selector-name pdd-discount-wrap">할인방법</div>
						<div class="pdd-selector-content pdd-discount-wrap">
							<div class="pdd-box pdd-box-selected pdd-discount cntr-i discount-0" onclick="clickDiscountMethod(0);">
								공시지원할인<br />
								총 200,000원
							</div>
							<div class="pdd-box pdd-discount cntr-i discount-1" onclick="clickDiscountMethod(1);">
								<div>선택약정할인<br />
								총 <span class="rplan-charge-2">300,000</span>원</div>
							</div>
						</div>
					</div>
					<!-- 할인방법 - display -->
					<div class="pdd-selector-wrap pdd-small pdd-small-wrap">
						<div class="pdd-selector-name pdd-small"></div>
						<div class="pdd-selector-content pdd-small">
							<div class="pdd-small-blk-wrap discount-title">단말기 할인</div>
							<div class="pdd-small-txt discount-text">&nbsp;개통당시 1회 단말기 구매 비용 할인</div>
							<input type="hidden" name="rplan-discount" value="0" />
						</div>
					</div>



					<!-- 구매방법 (프론트 선택 후 order_detail에 넘겨주기)
					0, 24, 30, 36 개월 -->
					<div class="pdd-selector-wrap">
						<div class="pdd-selector-name">구매방법</div>
						<div class="pdd-selector-content">
							<div class="pdd-box pdd-mplan cntr-i buy-type buy-type-0" onclick="clickBuyType(0, 1);"><span>일시불</span></div>
							<div class="pdd-box pdd-box-selected pdd-mplan cntr-i buy-type buy-type-1" onclick="clickBuyType(1, 24);"><span>24개월</span></div>
							<div class="pdd-box pdd-mplan cntr-i buy-type buy-type-2" onclick="clickBuyType(2, 30);"><span>30개월</span></div>
							<div class="pdd-box pdd-mplan cntr-i buy-type buy-type-3" onclick="clickBuyType(3, 36);"><span>36개월</span></div>
						</div>
					</div>
				</div>
				<!-- //선택사항 (제품상세 오른쪽) -->
			</div>
			<!-- //제품 상세 이미지 및 선택사항 -->
		</div>
		<div class="clear"></div>
		<!-- //제품 상세 메인 -->





		<!-- 제품 상세 설명 {product : content} -->
		<div>
		<hr class="pdd-detail-hr" />
		<div class="pdd-detail-txt">
			<pre>${productVO.content}</pre>
		</div>
		</div>
		<!-- //제품 상세 설명 -->

	</div>
	<!-- //제품 상세 왼쪽 프레임 -->


	<!-- 제품 상세 오른쪽 프레임 -->
	
	<div class="pdd-right-wrap">
		<!-- 스크롤 박스 wrap-->
		<div class="pdd-scrollbox-wrap" id="pdd-scroll-box">




			<ul>

			<!-- 납부 금액 (A+B) -->
			<li class="pdd-monthly-total-wrap pdd-text-middle pdd-bg-black-label pdd-bg-black-label-big ppd-card-normal">
				<ul class="pdd-right-inside-padding">
					<li>
						<div class="float-l"><div class="red-circle float-l pdd-plan-chk">A</div><div class="float-l pdd-plan-chk">&nbsp;+&nbsp;</div><div class="red-circle float-l">B</div><div class="float-l">&nbsp;월 납부금액</div></div><br />
					</li>
					<li>
						<div class="txt-al-r float-r"><span class="float-r pdd-price-big"><span class="float-r pdd-big-inside">&nbsp;원</span><span class="pdd-mtotal-out">0,000</span></span></div>
					</li>
				</ul>
				<div class="clear"></div>
			</li>

			
			<!-- 월 할부금 (A) -->
			<li class="pdd-monthly-div-wrap ppd-card-normal">
			
			
			
				<ul>
				<!-- 메인 (c / 구매방법(할부개월) = 월할부금) -->
					<li class="pdd-text-middle pdd-bg-black-label">
						<div class="pdd-right-inside-padding">
 							<div><div class="red-circle float-l">A</div><div class="float-l pdd-buyplan">&nbsp;월 할부금<div class="float-l pdd-right-inside-month-text">&nbsp;(24개월)</div></div></div>
							<div class="float-r pdd-plan-chk">&nbsp;원</div><div class="txt-al-r pdd-price-middle float-r pdd-dcmonth-out pdd-plan-chk">0,000</div>
						</div>
					<div class="clear"></div>
					</li>
					
					<!-- 출고가 (price2) -(a) -->
					<li>
						<div class="pdd-right-inside-padding pdd-right-inside-padding-white">
							<div class="txt-al-l float-l">출고가</div>
							<div class="float-r">&nbsp;원</div><div class="float-r pdd-price2-out">0,000</div>
						</div>
					<div class="clear"></div>
					</li>
					
					<!-- 공시지원 할인 (hidden toggle) (고정) (b) -->
					<li class="discount-method-1">
						<div class="pdd-right-inside-padding pdd-right-inside-padding-white">
							<div class="txt-al-l float-l">공시지원할인</div>
							<div class="float-r">&nbsp;원</div><div class="float-r pdd-text-red discount-value-a-text">0,000</div>
						</div>
					<div class="clear"></div>
					</li>
					
					<!-- 할부원금 (a - b => c) -->
					<li>
						<div class="pdd-right-inside-padding pdd-right-inside-padding-white">
							<div class="txt-al-l float-l">할부원금</div>
							<div class="float-r">&nbsp;원</div><div class="float-r pdd-price-middle pdd-dctotal-out">0,000</div>
						</div>
					<div class="clear"></div>
					</li>
				
				</ul>
				
				
				
				
			</li>
			
			<!-- 월 통신요금 (B) -->
			<li class="pdd-monthly-comm-wrap ppd-card-normal">
			
			
			
				<ul>
					<!-- 메인 (a -b = 월 통신요금) -->
					<li class="txt-al-r pdd-text-middle pdd-bg-black-label">
						<div class="pdd-right-inside-padding">
							<div class="txt-al-l"><div class="red-circle float-l">B</div><div class="float-l">&nbsp;월 통신요금</div></div>
							<div class="float-r">&nbsp;원</div><div class="pdd-price-middle float-r pdd-mmonth-out">0,000</div>
						</div>
					<div class="clear"></div>
					</li>
					<!-- 스탠다드 (요금제에서 가져옴) (a) -->
					<li>
						<div class="pdd-right-inside-padding pdd-right-inside-padding-white">
							<div class="txt-al-l float-l rplan-name">세이브</div>
							<div class="float-r">&nbsp;원</div><div class="float-r rplan-charge">0,000</div>
						</div>
					<div class="clear"></div>
					</li>
					<!-- 선택약정 할인 (hidden toggle) (고정) (b) -->
					<li class="discount-method-2 display-none">
						<div class="pdd-right-inside-padding pdd-right-inside-padding-white">
							<div class="txt-al-l float-l">선택약정할인(25%)</div>
							<div class="float-r">&nbsp;원</div><div class="float-r pdd-text-red discount-value-b-text">0,000</div>
						</div>
					</li>
				</ul>
				
				
				
				<div class="clear"></div>
			</li>
			
			<!-- 버튼 (온라인 신청하기) -->
			<li id="pdd-li-submit-wrap">
				<button type="submit" class="btn btn-primary">온라인 신청하기</button>
			</li>



			</ul>

		</div>
		<!-- //스크롤 박스 (wrap) -->
	</div>
	<!-- //제품 상세 오른쪽 프레임 -->
	</div>
	<!-- //전체 프레임 안쪽 - 중앙 정렬용 -->
</form>
</div>
<!-- //제품 상세 전체 프레임 -->


<div class="clear"></div>





<!-- 구매 후기 프레임 -->
<c:if test="${countOrderPseq > 0 || countOrderById > 0}">
<div class="wrap pdd-wrap">
<div class="pdd-inside-wrap">
	<div class="pdd-review-wrap card-normal">
		<!-- 입력 파트 -->
		<c:if test="${countOrderById > 0}">
			<form name="reviewForm" method="post"  action="/reviewWrite">
				<input type="hidden" name="pseq" value="${productVO.pseq}" />
				<div class="pdd-review-inputarea">
					<ul>
						<li class="float-l">
							<div class="form-floating mb-3">
								<textarea type="text" name="content" id="pdd-review-txt" class="form-control" placeholder="구매후기를 입력하세요" maxlength="500"></textarea><label for="pdd-review-txt">구매후기</label>
							</div>
						</li>
						<li class="float-l pdd-review-submit">
							<button type="button" class="btn btn-primary" onclick="writeReview();" >구매후기 작성</button>
						</li>
					</ul>
				</div>
			</form>
		</c:if>
		<div class="clear"></div>
		<!-- //입력 파트 -->
		
		<!-- 출력 파트 -->
		<div id="review-lists">
			<ul>
			<c:forEach items="${reviewList}" var="review" varStatus="statusReview">
				<li class="pdd-review-line">
					<div>
						<ul>
							<li class="pdd-review-ln-name float-l">${review.name}</li>
							<li class="pdd-review-ln-content float-l"><pre>${review.content}</pre></li>
							<li class="float-l">
								<div id="pdd-review-date"><fmt:formatDate value="${review.indate}" /></div>
							</li>
						</ul>
					</div>
					<div class="clear"></div>
					<c:if test="${not statusReview.last}">
						<hr />
					</c:if>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>
	<div class="pdd-right-wrap">
	</div>
</div>
</div>
</c:if>
<!-- //구매 후기 프레임 -->










<br /><br /><br /><br /><br />
<!-- 팝업 KT (2)-->
<div class="comm-kt pdd-popup-wrap card-normal layer-popup" id="layer-popup-kt">
	<div class="pdd-popup-title"><img src="images/common/tong-kt.png" />&nbsp;<span>KT 요금표</span></div>
	<table>
		<tr><td class="pdd-popup-subtitle" colspan="2">5G 수퍼플랜</td><td class="pdd-popup-text" colspan="3">5G 데이터가 완전무제한에 해외에서 끊김없는 데이터!</td></tr>
		<c:forEach items="${rplanVO}" var="plan">
			<c:if test="${plan.mseq == 2}">
				<tr class="cs-p" onclick='selectPlan("${plan.name}", ${plan.charge}, "${plan.dataplan}", "${plan.timeplan}", "${plan.textplan}", "${plan.rseq}");'>
					<td class="pdd-popup-content pdd-popup-left" value="${plan.name}">${plan.name}</td>
					<td class="pdd-popup-content rb-color" value="${plan.charge}">월 <fmt:formatNumber value="${plan.charge}" type="number" maxFractionDigits="3" />원</td>
					<td class="pdd-popup-content" value="${plan.dataplan}">${plan.dataplan}</td>
					<td class="pdd-popup-content" value="${plan.timeplan}">${plan.timeplan}</td>
					<td class="pdd-popup-content" value="${plan.textplan}">${plan.textplan}</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</div>
<!-- //팝업 KT -->


<!-- 팝업 SKT (1)-->
<div class="comm-skt pdd-popup-wrap card-normal layer-popup" id="layer-popup-skt">
	<div class="pdd-popup-title"><img src="images/common/tong-skt.png" />&nbsp;<span>SKT 요금표</span></div>
	<table>
		<tr><td class="pdd-popup-subtitle" colspan="2">5GX 플랜</td><td class="pdd-popup-text" colspan="3">데이터 콘텐츠도 자유롭게! 초시대의 요금플랜</td></tr>
		<c:forEach items="${rplanVO}" var="plan">
			<c:if test="${plan.mseq == 1}">
				<tr class="cs-p" onclick='selectPlan("${plan.name}", ${plan.charge}, "${plan.dataplan}", "${plan.timeplan}", "${plan.textplan}", "${plan.rseq}");'>
					<td class="pdd-popup-content pdd-popup-left" value="${plan.name}">${plan.name}</td>
					<td class="pdd-popup-content rb-color" value="${plan.charge}">월 <fmt:formatNumber value="${plan.charge}" type="number" maxFractionDigits="3" />원</td>
					<td class="pdd-popup-content" value="${plan.dataplan}">${plan.dataplan}</td>
					<td class="pdd-popup-content" value="${plan.timeplan}">${plan.timeplan}</td>
					<td class="pdd-popup-content" value="${plan.textplan}">${plan.textplan}</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</div>
<!-- //팝업 SKT -->


<!-- 팝업 LGU+ (3)-->
<div class="comm-lg pdd-popup-wrap card-normal layer-popup" id="layer-popup-lg">
	<div class="pdd-popup-title"><img src="images/common/tong-lg.png" />&nbsp;<span>LGU+ 요금표</span></div>
	<table>
		<tr><td class="pdd-popup-subtitle" colspan="2">5G 요금제</td><td class="pdd-popup-text" colspan="3">U+ 5G 서비스에 다양한 콘텐츠까지!</td></tr>
		<c:forEach items="${rplanVO}" var="plan">
			<c:if test="${plan.mseq == 3}">
				<tr class="cs-p" onclick='selectPlan("${plan.name}", ${plan.charge}, "${plan.dataplan}", "${plan.timeplan}", "${plan.textplan}", "${plan.rseq}");'>
					<td class="pdd-popup-content pdd-popup-left" value="${plan.name}">${plan.name}</td>
					<td class="pdd-popup-content rb-color" value="${plan.charge}">월 <fmt:formatNumber value="${plan.charge}" type="number" maxFractionDigits="3" />원</td>
					<td class="pdd-popup-content" value="${plan.dataplan}">${plan.dataplan}</td>
					<td class="pdd-popup-content" value="${plan.timeplan}">${plan.timeplan}</td>
					<td class="pdd-popup-content" value="${plan.textplan}">${plan.textplan}</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</div>
<!-- //팝업 LGU+ -->



</article>
<!-- //MAIN -->



<!-- 비교 상자 불러오기 -->
<%@ include file="../sub/comparePopup.jsp"%>

<!-- footer 불러오기 -->
<%@ include file="../sub/footer.jsp"%>