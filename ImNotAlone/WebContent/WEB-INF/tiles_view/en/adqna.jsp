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
<div class="container">
	<!-- 김은정 굳아이디어 -->

	<!-- 내용추가할 곳 -->
	<div class="col-lg-6 ui-sortable">
		<div class="box ui-sortable-handle"
			style="position: relative; left: 300px; top: 0px;">

			<!-- 탭 대신 버튼 -->

			<div id="row-1" class="container">

				<div id="tabmenu-1" class="tab">
					<ul class="title">
						<li><a href="#" class="show" id="tab-1">탭메뉴</a></li>
						<li><a href="#" id="tab-2">탭메뉴</a></li>
						<li><a href="#" id="tab-3">탭메뉴</a></li>
					</ul>
					<ul class="panel">
						<li id="content-1">탭 내용1</li>
						<li id="content-2">탭 내용2</li>
						<li id="content-3">탭 내용3</li>
					</ul>
				</div>
			</div>

			<!-- <form style="position: center">
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
			</form> -->

			<!-- 그 밑에 리스트 -->
			<div id="borderedTable" class="body collapse in">
				<table class="table table-bordered responsive-table">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>아이디</th>
							<th>등록일</th>
						</tr>
					</thead>
					<tbody>

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