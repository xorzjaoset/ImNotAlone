<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="page-bread mb70">
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<h3>블랙리스트 관리</h3>
			</div>
			<div class="col-sm-6"></div>
		</div>
	</div>
</div>
<div class="container">
	<!-- 김은정 굳아이디어 -->

	<!-- 왼쪽 메뉴바 사이즈 조절 -->
	<div class="col-md-2 mb60">

		<!-- <div class="mb20"> -->
		<form>
			<div class="form-group">
				<input type="button" class="form-control" value="회원통계"
					onclick="location.href='/ImNotAlone/share/statistics'">
			</div>
			<div class="form-group">
				<input type="button" class="form-control" value="블랙리스트 관리"
					onclick="location.href='/ImNotAlone/share/blackwait'">
			</div>
			<div class="form-group">
				<input type="button" class="form-control" value="게시판 관리"
					onclick="location.href='/ImNotAlone/share/board'">
			</div>
			<div class="form-group">
				<input type="button" class="form-control" value="광고 관리"
					onclick="location.href='/ImNotAlone/share/superhost'">
			</div>
			<div class="form-group">
				<input type="button" class="form-control" value="관리자 등록 및 삭제"
					onclick="location.href='/ImNotAlone/share/admin'">
			</div>
		</form>
	</div>

	<!-- 내용추가할 곳 -->
	<div class="col-lg-6 ui-sortable">
		<div class="box ui-sortable-handle"
			style="position: relative; left: 200px; top: 0px;">
			<header>
				<h3>블랙리스트 명단</h3>
			</header>
			<!-- 탭 대신 버튼 -->

			<form>
				<div class="col-md-3 col-sm-6"
					style="padding-right: 0px; padding-left: 0px;">
					<div class="form-group">
						<input type="button" class="form-control" value="대기명단"
							style="border-right-width: 1px;"
							onclick="location.href='/ImNotAlone/share/blackwait'">
					</div>
				</div>
				<div class="col-md-3 col-sm-6"
					style="padding-right: 0px; padding-left: 0px;">
					<div class="form-group">
						<input type="button" class="form-control" value="블랙회원"
							style="border-left-width: 1px; border-right-width: 1px;"
							onclick="location.href='/ImNotAlone/share/blacklist'">
					</div>
				</div>
				<div class="col-md-3 col-sm-6"
					style="padding-right: 0px; padding-left: 0px;">
					<div class="form-group">
						<input type="button" class="form-control" value="하나더"
							style="border-left-width: 1px;"
							onclick="location.href='/ImNotAlone/share/blacklist'">
					</div>
				</div>

				<!-- 그 밑에 리스트 -->

			</form>

			<div id="borderedTable" class="body collapse in">
				<table class="table table-bordered responsive-table">
					<thead>
						<tr>
							<th>순서</th>
							<th>ID</th>
							<th>등록일</th>
							<th>등록사유</th>
							<th>해제일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="black" items="${blacklist}">
							<tr>
								<td>${black.no}</td>
								<td>${black.id}</td>
								<td>${black.reg_dt}</td>
								<td>${black.reason}</td>
								<td>${black.release}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>


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