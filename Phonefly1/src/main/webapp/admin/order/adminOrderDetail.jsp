<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/admin/header2.jsp"%>
<%@ include file="/admin/sub_menu2.jsp"%>

<article>
	<!-- <h1>주문리스트</h1> -->
	<form name="frm" method="post" action="pf.do">
		<input type="hidden" name="command" value="adminOrderUpdate" /> <input
			type="hidden" name="odseq" value="${orderVO.odseq}" />




		<!-- <div class="support-right-content card-normal"> -->
		<div class="admin-orderdetail-wrap card-normal">
			<div class="support-inner-wrap">

				<h1>주문 상세보기</h1>

				<div class="od-inner-left-wrap">
					<div class="od-inner-left">



						<!-- 이미지, 컬러 리스트, 가격비교 (제품상세 왼쪽) -->
						<div class="od-image-wrap">

							<!-- 제품명 -->
							<div class="card-name pdd-card-name">
								<h3>[${orderVO.mfc}] ${orderVO.pname}</h3>
							</div>
							<!-- //제품명 -->

							<!-- 이미지 -->
							<div class="od-card-img">
								<img src="images/productImage/${orderVO.image}" />
							</div>
							<div class="clear"></div>
							<!-- //이미지 -->

							<!-- 컬러 이름 -->
							<div class="pdd-color-names">
								<div>${orderVO.ccname}</div>
							</div>
							<br /> <br />
							<!-- //컬러 이름 -->

						</div>
						<!-- //이미지, 컬러 리스트, 가격비교 (제품상세 왼쪽) -->






						<!-- 선택사항 (제품상세 오른쪽) -->
						<div class="od-selectors">
							<table>

								<!-- 신청일 -->
								<tr>
									<th>신청일</th>
									<td><fmt:formatDate value="${orderVO.indate}" /></td>
								</tr>

								<!-- 처리결과 -->
								<tr>
									<th>상태</th>
									<td><select name="result" id="admin-orderdetail-combobox">
											<c:choose>
												<c:when test="${orderVO.result == '1'}">
													<option value="1" selected>접수중</option>
													<option value="2">발송중</option>
													<option value="3">완료</option>
												</c:when>
												<c:when test="${orderVO.result == '2'}">
													<option value="1">접수중</option>
													<option value="2" selected>발송중</option>
													<option value="3">완료</option>
												</c:when>
												<c:otherwise>
													<option value="1">접수중</option>
													<option value="2">발송중</option>
													<option value="3" selected>완료</option>
												</c:otherwise>
											</c:choose>
									</select></td>
								</tr>

								<!-- 통신사 (commList) -->
								<tr>
									<th>통신사</th>
									<td><img
										src="images/common/tong-${fn:toLowerCase(orderVO.cname)}.png" />
									</td>
								</tr>

								<!-- 가입종류 : 기기변경 / 통신사이동 -->
								<tr>
									<th>가입종류</th>
									<td><c:choose>
											<c:when test="${orderVO.cc == 0}">통신사이동</c:when>
											<c:otherwise>기기변경</c:otherwise>
										</c:choose></td>
								</tr>

								<!-- 요금제 (rplanList) -->
								<tr>
									<th>요금제</th>
									<td>${orderVO.rname}|월 <fmt:formatNumber
											value="${orderVO.charge}" type="number" />원<br /> 데이터
										${orderVO.dataplan} / 음성 ${orderVO.timeplan} /
										${orderVO.textplan}
									</td>
								</tr>

								<!-- 할인방법
						공시지원 할인 / 선택약정할인 => 할부금 할인, 통신요금 할인 각각 적용 -->
								<tr>
									<th>할인방법</th>
									<td><c:choose>
											<c:when test="${orderVO.discount == 0}">
										공시지원할인 - 총 200,000원<br />
										(단말기 할인 / 개통당시 1회 단말기 구매 비용 할인)
									</c:when>
											<c:otherwise>
												<c:choose>
													<c:when test="${orderVO.buyplan == 1}">
											선택약정할인 - 총 0원<br />
											(25% 요금할인 / 약정기간동안 매월 기본료 25%할인)
											</c:when>
													<c:otherwise>
											선택약정할인 - 총 <fmt:formatNumber
															value="${orderVO.charge / 4 * orderVO.buyplan}"
															type="number" />원<br />
											(25% 요금할인 / 약정기간동안 매월 기본료 25%할인)
											</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose></td>
								</tr>

								<!-- 구매방법 0, 24, 30, 36 개월 -->
								<tr>
									<th>구매방법</th>
									<td><c:choose>
											<c:when test="${orderVO.buyplan > 1}">
										${orderVO.buyplan}개월
									</c:when>
											<c:otherwise>
										일시불
									</c:otherwise>
										</c:choose></td>
								</tr>

							</table>
						</div>
						<!-- //선택사항 (제품상세 오른쪽) -->


					</div>
				</div>







				<div class="od-inner-right-wrap">
					<div class="od-inner-right">



						<!-- 가격 박스 wrap-->
						<div class="od-pricebox-wrap">




							<ul>

								<!-- 납부 금액 (A+B) -->
								<li
									class="pdd-monthly-total-wrap pdd-text-middle pdd-bg-black-label pdd-bg-black-label-big ppd-card-normal od-card-box">
									<ul class="pdd-right-inside-padding">
										<li>
											<div class="float-l">
												<div class="red-circle float-l pdd-plan-chk">A</div>
												<div class="float-l pdd-plan-chk">&nbsp;+&nbsp;</div>
												<div class="red-circle float-l">B</div>
												<div class="float-l">&nbsp;월 납부금액</div>
											</div> <br />
										</li>
										<li>
											<div class="txt-al-r float-r">
												<span class="float-r pdd-price-big"><span
													class="float-r pdd-big-inside">&nbsp;원</span><span
													class="pdd-mtotal-out"><fmt:formatNumber
															value="${orderVO.mtotal}" type="number" /></span></span>
											</div>
										</li>
									</ul>
									<div class="clear"></div>
								</li>


								<!-- 월 할부금 (A) -->
								<li class="pdd-monthly-div-wrap ppd-card-normal od-card-box">



									<ul>
										<!-- 메인 (c / 구매방법(할부개월) = 월할부금) -->
										<li class="pdd-text-middle pdd-bg-black-label">
											<div class="pdd-right-inside-padding">
												<div>
													<div class="red-circle float-l">A</div>
													<div class="float-l pdd-buyplan">


														<c:choose>
															<c:when test="${orderVO.buyplan == 1}">
														&nbsp;일시불
													</c:when>
															<c:otherwise>
																<div class="float-l">&nbsp;월 할부금</div>
																<div class="float-l pdd-right-inside-month-text">
																	&nbsp;(${orderVO.buyplan}개월)</div>
															</c:otherwise>
														</c:choose>


													</div>
												</div>
												<div class="float-r pdd-plan-chk">&nbsp;원</div>
												<div
													class="txt-al-r pdd-price-middle float-r pdd-dcmonth-out pdd-plan-chk">

													<c:choose>
														<c:when test="${orderVO.buyplan == 1}">
													0
												</c:when>
														<c:otherwise>
															<fmt:formatNumber value="${orderVO.dcmonth}"
																type="number" />
														</c:otherwise>
													</c:choose>

												</div>
											</div>
											<div class="clear"></div>
										</li>

										<!-- 출고가 (price2) -(a) -->
										<li>
											<div
												class="pdd-right-inside-padding pdd-right-inside-padding-white">
												<div class="txt-al-l float-l">출고가</div>
												<div class="float-r">&nbsp;원</div>
												<div class="float-r pdd-price2-out">
													<fmt:formatNumber value="${orderVO.price}" type="number" />
												</div>
											</div>
											<div class="clear"></div>
										</li>


										<c:if test="${orderVO.discount == 0}">
											<!-- 공시지원 할인 (hidden toggle) (고정) (b) -->
											<li class="discount-method-1">
												<div
													class="pdd-right-inside-padding pdd-right-inside-padding-white">
													<div class="txt-al-l float-l">공시지원할인</div>
													<div class="float-r">&nbsp;원</div>
													<div class="float-r pdd-text-red discount-value-a-text">-200,000</div>
												</div>
												<div class="clear"></div>
											</li>
										</c:if>



										<!-- 할부원금 (a - b => c) -->
										<li>
											<div
												class="pdd-right-inside-padding pdd-right-inside-padding-white">
												<div class="txt-al-l float-l">할부원금</div>
												<div class="float-r">&nbsp;원</div>
												<div class="float-r pdd-price-middle pdd-dctotal-out">
													<fmt:formatNumber value="${orderVO.dctotal}" type="number" />
												</div>
											</div>
											<div class="clear"></div>
										</li>

									</ul>




								</li>

								<!-- 월 통신요금 (B) -->
								<li class="pdd-monthly-comm-wrap ppd-card-normal od-card-box">



									<ul>
										<!-- 메인 (a -b = 월 통신요금) -->
										<li class="txt-al-r pdd-text-middle pdd-bg-black-label">
											<div class="pdd-right-inside-padding">
												<div class="txt-al-l">
													<div class="red-circle float-l">B</div>
													<div class="float-l">&nbsp;월 통신요금</div>
												</div>
												<div class="float-r">&nbsp;원</div>
												<div class="pdd-price-middle float-r pdd-mmonth-out">
													<fmt:formatNumber value="${orderVO.mmonth}" type="number" />
												</div>
											</div>
											<div class="clear"></div>
										</li>
										<!-- 스탠다드 (요금제에서 가져옴) (a) -->
										<li>
											<div
												class="pdd-right-inside-padding pdd-right-inside-padding-white">
												<div class="txt-al-l float-l rplan-name">${orderVO.rname}</div>
												<div class="float-r">&nbsp;원</div>
												<div class="float-r rplan-charge">
													<fmt:formatNumber value="${orderVO.charge}" type="number" />
												</div>
											</div>
											<div class="clear"></div>
										</li>


										<c:if test="${orderVO.discount == 1}">
											<!-- 선택약정 할인 (hidden toggle) (고정) (b) -->
											<li class="discount-method-2">
												<div
													class="pdd-right-inside-padding pdd-right-inside-padding-white">
													<div class="txt-al-l float-l">선택약정할인(25%)</div>
													<div class="float-r">&nbsp;원</div>
													<div class="float-r pdd-text-red discount-value-b-text">
														-
														<fmt:formatNumber value="${orderVO.charge / 4}"
															type="number" />
													</div>
												</div>
											</li>
										</c:if>

									</ul>



									<div class="clear"></div>
								</li>

								<div class="Bottm-btn-container btn-group">
									<div>
										<input type="button" class="btn" value="목록"
											onclick="location.href='pf.do?command=adminOrderList';" />
											</div> &nbsp;&nbsp;&nbsp;
											<div>
											 <input	type="submit" class="btn"
											value="수정" />
									</div>
									&nbsp;&nbsp;&nbsp;
									<!-- //버튼 -->
									</div>
							</ul>

						</div>
						<!-- //스크롤 박스 (wrap) -->



					</div>
				</div>





			</div>
		</div>






	</form>
</article>

<%@ include file="/admin/footer.jsp"%>



