<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="page-bread mb70">
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<h3>문의글 쓰기</h3>
			</div>
			<div class="col-sm-6"></div>
		</div>
	</div>
</div>
<script type="text/javascript">
	function fn_formSubmit() {
		var form1 = document.form1;   

		if (form1.title.value == "") {
			alert("글 제목을 입력해주세요.");
			form1.title.focus();
			return;
		}

		if (form1.content.value == "") {
			alert("글 내용을 입력해주세요.");
			form1.content.focus();
			return;
		}
		document.form1.submit();
	}
</script>
<div class="container">
	<button onclick="history.back(-1)">돌아가기</button>
	<br>
	<form name=form1 action="insert" method="post">
		<div id="borderedTable" class="body collapse in">
			<table class="table table-bordered responsive-table">
				<tbody>
					<tr>
						<td>아이디</td>
						<td><input type="text" id="id" name="id" name="id"
							value="${dto.id}" readonly="readonly"></td>
					</tr>

					<tr>
						<td>제목</td>
						<td><input type="text" id="title" style="width: 1050"
							name="title" value="${dto.title}"></td>
					</tr>

					<tr>
						<td>내용</td>
						<td><textarea id="content"
								style="width: 1050px; height: 200px;" name="content">${dto.content}</textarea></td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" id="no" name="no" value="${dto.no}"> 
			<button onclick="fn_formSubmit()">등록</button>
		</div>
	</form>
</div>
<div class="pt200 pb40">
	<!-- @@@@@@@@@@@@@@@@@ 위쪽공백@@@@@@@@@@@@@@@@ -->
</div>