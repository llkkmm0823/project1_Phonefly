<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/header2.jsp"%>
<%@ include file="/admin/sub_menu2.jsp"%>

<article >
<h1>상품 상세 보기</h1> 
<table id="PDList" >
	<tr><th align="center" >상품 명</th><td colspan="5">${productVO.name}</td></tr>
	
	<tr>
	    <th>원가(입고가) [A]</th><td width="60">${productVO.price1}</td>
		<th>판매가(출고가) [B]</th><td width="60">${productVO.price2}</td>
       	<th>마진[B-A]</th><td>${productVO.price3}</td>
       	<th>제조사</th><td>${productVO.mfc}</td>     	
    </tr>
    <tr>
       	<th>제품 판매 유/무</th>
        	<td >
			<c:choose>
			     <c:when test='${productVO.useyn=="N" }'>판매 불가</c:when>
			     <c:otherwise>판매 <br> 가능</c:otherwise>
			</c:choose>
			</td>
	    <th>이벤트 적용/미적용</th>
	         <td>
			<c:choose>
			     <c:when test='${productVO.eventyn=="N" }'>이벤트 미적용</c:when>
			     <c:otherwise>이벤트 적용</c:otherwise>
			</c:choose>
			</td>    
	    <th>베스트 적용/미적용</th>	
	    <td>
			<c:choose>
			     <c:when test='${productVO.bestyn=="N" }'>베스트 미적용</c:when>
			     <c:otherwise>베스트 적용</c:otherwise>
			</c:choose>
			</td>
	</tr>
	
   	<tr >
   	<th>상세설명</th><td colspan="10"><pre>${productVO.content}</pre></td>
   	</tr>
     
   		 		
</table>

<div class="Bottm-btn-container">
  <div>
    <input class="btn" type="button" value="수정" onClick="go_mod('${productVO.pseq}')">
  </div> &nbsp;&nbsp;&nbsp;
  <div>
    <input class="btn" type="button" value="목록" onClick="go_mov()">
  </div>  &nbsp;&nbsp;&nbsp;
  <div>
    <input class="btn" type="button" value="삭제" onClick="go_del(${productVO.pseq})">
  </div>   &nbsp;&nbsp;&nbsp;
  <div>
    <input class="btn" type="button" value="색상리스트" onClick="go_col('${productVO.pseq}')">
  </div>
</div>
</article>

<%@ include file="/admin/footer.jsp"%>