<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div class="page-bread mb70">
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<h3>신고</h3>
			</div>
			<div class="col-sm-6"></div>
		</div>
	</div>
</div>

<form method="post" action="/ImNotAlone/share/WaitInsert">
 
	<div class="container">
		신고대상 <input type="text" value="${id}" readonly name="id"> <br>
		<br> 신고사유 <br>
		<textarea rows="5" cols="40" placeholder="신고사유를 써주세요." name="reason"></textarea>
		<br> <br> 
		<input type="submit" value="신고" style="position: relative; margin-left: 115px;"
			onclick="alert('신고접수가 완료되었습니다.');">
			<input type="button" class="form-control" value="취소" onclick="window.close()"
			style="position: relative; margin-right: 100px;">
	</div>


</form>