<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="page-bread mb70">
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<h3>문의</h3>
			</div>
			<div class="col-sm-6"></div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$("#qnaRead").onClick(function() {
			
			alert("로그인 후 이용해주세요.");
			location.href="/ImNotAlone/share/login";
		
		});
	});
</script>
<div class="container">
	<!-- 김은정 굳아이디어 -->

	<!-- 내용추가할 곳 -->
	<div class="col-lg-6 ui-sortable">
		<div class="box ui-sortable-handle"
			style="position: relative; left: 300px; top: 0px;">

			<!-- 탭 대신 버튼 -->

			<form>
				<div class="col-md-3 col-sm-6"
					style="padding-right: 0px; padding-left: 0px;">
					<div class="form-group">
						<input type="button" class="form-control" value="문의"
							style="border-right-width: 1px;"
							onclick="location.href='/ImNotAlone/share/qna'">
					</div>
				</div>
				<div class="col-md-3 col-sm-6"
					style="padding-right: 0px; padding-left: 0px;">
					<div class="form-group">
						<input type="button" class="form-control" value="광고문의"
							style="border-left-width: 1px; border-right-width: 1px;"
							onclick="location.href='/ImNotAlone/share/adqna'">
					</div>
				</div>
			</form>

			<!-- 그 밑에 리스트 -->
			<br> <br>
			<c:if test="${member.user_id != null}">
				<button type="button" id="qnaWrite" class="btn-primary" onclick="location.href='qnaWrite'">글쓰기</button>
			</c:if>
			<!-- <button type="button" id="qnaWrite" class="btn-primary" onclick="location.href='qnaWrite'">글쓰기</button> -->
			<form>
				<div id="borderedTable" class="body collapse in">
					<table class="table table-bordered responsive-table">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>아이디</th>
								<th>등록일</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="qna" items="${qnalist}">
								<c:url var="link" value="qnaRead">
									<c:param name="no" value="${qna.no}" />
								</c:url>
								<tr>
									<td>${qna.no}</td>
									<td><a id="qnaRead" href="${link}"><c:out value="${qna.title}" /></a></td>
									<td>${qna.id}</td>
									<td>${qna.reg_dt}</td>
									<td>${qna.hit}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</form>


			<!-- 페이지넘김 -->

			<ul class="pagination" style="position: relative; left: 125px;">
				<li><a href="#" aria-label="Previous"> <span
						aria-hidden="true">«</span>
				</a></li>
				<li class="active"><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">»</span>
				</a></li>
			</ul>
		</div>
	</div>
</div>
<div class="pt200 pb40">
	<!-- @@@@@@@@@@@@@@@@@ 위쪽공백@@@@@@@@@@@@@@@@ -->
</div>