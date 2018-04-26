<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="page-bread mb70">
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<h3>문의글 읽기</h3>
			</div>
			<div class="col-sm-6"></div>
		</div>
	</div>
</div>
<div class="container">
	<div id="borderedTable" class="body collapse in">
		<a href="qna" onclick="history.back(-1)">돌아가기</a>
		<br>
		<table class="table table-bordered responsive-table">
			<tbody>
				<tr>
					<td>글번호</td>
					<td>${dto.no}</td>
				</tr>

				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name ="id" value="${dto.id}" style="width: 1050" readonly="readonly">
					</td>
				</tr>

				<tr>
					<td>제목</td>
					<td>
						<input type="text" name ="title" style="width: 1050" readonly="readonly" value="${dto.title}">
					</td>
				</tr>

				<tr> 
					<td>내용</td>
					<td><textarea name ="content" readonly="readonly" style="width: 1050px; height: 200px;">${dto.content}</textarea></td>
				</tr>
			</tbody>
		</table>
		<a href="qnaWrite?no=${dto.no}&content=${dto.content}&id=${dto.id}&title=${dto.title}">수정</a>
		<!-- &nbsp;&nbsp;&nbsp; -->
		<a href="qnaDelete?no=${dto.no}" style="position: relative; left: 1070px;">삭제</a>
	</div>
	
	<br>
	<div class="container">
	<label for="rep_content">댓  글</label>
	<form name="repInsertForm">
		<div class="input-group">
			<input type="hidden" name="no" id="no" value="${dto.no}"/>
			<input type="text" class="form-control" id="rep_content" name="rep_content" placeholder="내용을 입력하세요." />
			<span class="input-group-btn">
				<button class="btn btn-default" type="button" name="repInsertButton">등  록</button>
			</span>
		</div>
	</form>
	</div>
	
	<div class="container">
		<div class="qnaRepList"></div>
	</div>
</div>

<%@ include file="Reps.jsp" %>

<div class="pt200 pb40">
	<!-- @@@@@@@@@@@@@@@@@ 위쪽공백@@@@@@@@@@@@@@@@ -->
</div>

