<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/admin/header2.jsp"%>
<%@ include file="/admin/sub_menu2.jsp"%>

<article>
	<h1>상품 등록</h1>
	<form name="frm" method="post"  >	
 	<input type="hidden" name="pseq" value="${ProductVO.pseq}"> 
		
		
		
	
		<table id="PIList">
			<tr>
				<th>상품명</th>
				<td width="343" colspan="5"><input type="text" name="name"
					size="47" maxlength="100"></td>
			</tr>

			<tr id= PITR>
				<th>원가[A]</th>
				<td width="70"><input type="text" name="price1" size="11"
					onkeyup="cal();"></td>
	    	</tr>
			<tr> 		
				<th>판매가[B]</th>
				<td width="50"><input type="text" name="price2" size="11"
		 			onkeyup="cal();"></td>
	    	</tr>
			<tr>
				<th>마진[B-A]</th>
				<td width="72"><input type="text" name="price3" size="11"></td>
			</tr>

			<tr>
				<th>상세<br>설명</th>
				<td colspan="5"><textarea name="content" rows="8" cols="70"></textarea></td>
			</tr>

            <tr>
			<th>판매 가능 여부</th> 	
			<td>
			<c:choose>
					<c:when test='${ProductVO.useyn=="Y"}'>
						<input type="radio" name="useyn" value="Y" checked="checked">판매 불가
				  				<input type="radio" name="useyn" value="N">판매 가능
				  			</c:when>
					<c:otherwise>
						<input type="radio" name="useyn" value="Y">판매 불가
								<input type="radio" name="useyn" value="N" checked="checked">판매 가능
							</c:otherwise>
				</c:choose>
				</td>
             </tr>


               <tr>
			<th>이벤트 상품</th>
			<td><c:choose>
					<c:when test='${ProductVO.eventyn=="Y"}'>
						<input type="radio" name="eventyn" value="Y" checked="checked">사용
				  				<input type="radio" name="eventyn" value="N">>미사용
				  			</c:when>
					<c:otherwise>
						<input type="radio" name="eventyn" value="Y">사용
								<input type="radio" name="eventyn" value="N" checked="checked">미사용
							</c:otherwise>
				</c:choose></td>
             </tr>
               
            <tr>
			<th>베스트상품</th>
			<td><c:choose>
					<c:when test='${ProductVO.bestyn=="Y"}'>
						<input type="radio" name="bestyn" value="Y" checked="checked">사용
				  				<input type="radio" name="bestyn" value="N">미사용
				  			</c:when>
					<c:otherwise>
						<input type="radio" name="bestyn" value="Y">사용
								<input type="radio" name="bestyn" value="N" checked="checked">미사용
							</c:otherwise>
				</c:choose></td>
			</tr>	
			
			<tr>
				<th>제조사</th>
				<td width="343" colspan="5"><input type="text" name="mfc"
					size="47" maxlength="100"></td>
			</tr>




		</table>
		
		<div class="Bottm-btn-container">
		<div>
		<input class="btn" type="submit" value="색상선택" onClick="go_save(${ProductVO.pseq})">
		</div>
		<div>
		<input class="btn" type="button" value="목록으로" onClick="go_mov()">
		</div>
		</div>
		
	</form>
</article>

<%@ include file="/admin/footer.jsp"%>




