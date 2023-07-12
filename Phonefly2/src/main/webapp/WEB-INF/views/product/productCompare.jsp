<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- MAIN  -->
<!-- 
author : BHS
-->


<!-- 헤더 불러오기 -->
<%@ include file="../sub/header.jsp"%>


<article>

<!-- 서브 배너 불러오기 -->
<%@ include file="../sub/sub_image_menu7.jsp"%>
<c:if test="${compareFlag == 1}">
	<script src="script/removeCompareSession.js"></script> 
</c:if>

<!-- 상품 비교 -->


<h1>상품 비교</h1>

<div id="compare-card-box">
	<ul>
		<c:forEach items="${productList}" var="productVO" varStatus="status">

			<!-- location.href JSTL변수 생성 (onclick="${productDetailLH}" 으로 사용)-->
			<c:set var="productDetailLH" value="location.href='/productDetail?pseq=${productVO.pseq}';" />
			
			
			<!-- 제품 아이템 시작 -->
			<li class="card card-compare">


				<input type="hidden" class="pdPseq" value="${productVO.pseq}" />
				<input type="hidden" class="pdImg" value="${productVO.colorList[0].image}" />
				<input type="hidden" class="pdName" value="${productVO.name}" />
				<input type="hidden" class="pdPrice" value="<fmt:formatNumber value='${productVO.price2}' type='number' maxFractionDigits='3' />원" />


				<!-- 이미지 -->
				<div class="card-img card-img-${status.count}" onclick="${productDetailLH}">
					<ul>
 					<c:forEach items="${productVO.colorList}" var="colorVO" varStatus="statusColor">
						<c:choose>
							<c:when test="${statusColor.count == 1}">
								<li style="z-index:10"><img class="cs-p" src="images/productImage/${colorVO.image}" /></li>
							</c:when>
							<c:otherwise>
								<li><img class="cs-p" src="images/productImage/${colorVO.image}" /></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					</ul>
				</div>
				<!-- //이미지 -->
				
				
				<!-- 컬러 리스트 -->
				<div class="card-color-buttons card-color-buttons-${status.count}">
					<ul>
						<c:forEach items="${productVO.colorList}" var="colorVO" varStatus="statusColor">
							<li onclick="colorClick(${status.count}, ${statusColor.count});">
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
				<!-- //컬러 리스트 -->
				<div class="clear"></div>
				
				
				<!-- 제품명 -->
				<div class="card-name cs-p" onclick="${productDetailLH}">
					<h3>
						${productVO.name}
					</h3>
				</div>
				<!-- //제품명 -->
				
				
				<!-- 가격 -->
				<div class="card-price cs-p" onclick="${productDetailLH}">
					<h3><fmt:formatNumber value="${productVO.price2}" type="number" maxFractionDigits="3" /></h3><h4>원</h4>
				</div>
				<!-- //가격 -->
				
				
				<!-- 구매하기 버튼 -->
				<div class="card_buy" onclick="${productDetailLH}">구매하기</div>
				<!-- //구매하기 버튼 -->
				
				
				<!-- 가격비교 -->
				<c:if test="${compareFlag == 0}">
					<div class="card-compare-price" onclick="compareProduct(${productVO.pseq});">
						<div class="plus-button"><span>&nbsp;가격 비교하기</span></div>
					</div>
				</c:if>
				<!-- //가격비교 -->
			</li>
		</c:forEach>
	</ul>
</div>
<div class="clear"></div>

<!-- //상품 비교 -->





<div class="clear"></div>
</article>
<!-- //MAIN -->


<!-- 비교 상자 불러오기 -->
<%@ include file="../sub/comparePopup.jsp"%>


<!-- footer 불러오기 -->
<%@ include file="../sub/footer.jsp"%>