<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="preloader"></div>
        <!-- Static navbar -->
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/ImNotAlone/share/main/mainView"><img src="/ImNotAlone/resources/images/logo.png" alt=""></a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">







                  <li><a href="blog.html">호스팅하기</a></li>
                  <li><a href="blog.html">방둘러보기</a></li>
                  
                  <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">방스타그램 <span class="caret"></span></a>
                      <ul class="dropdown-menu">
                          <li><a href="add-listing.html">오늘의 추천방</a></li>
                          <li><a href="/ImNotAlone/share/roomStar4">방 구경하기</a></li>
                          <li><a href="/ImNotAlone/share/roomStarReviewView">후기스타그램</a></li>
	                        <li class="divider"></li>
     	                  <li><a href="/ImNotAlone/share/roomStarRegisterForm">방 자랑하기</a></li>
                      </ul>
                  </li>
                  <li><a href="blog.html">문의</a></li>
                  <li><a href="/ImNotAlone/share/register">이용안내</a></li>
           		<c:if test="${member.user_id ne null}">
                  <li class="dropdown active">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">마이페이지<span class="caret"></span></a>
                      <ul class="dropdown-menu">
                          <li><a href="how-work.html">마이룸</a></li>
                          <li><a href="/ImNotAlone/share/wishList">위시리스트</a></li>
                          <li><a href="faq.html">매칭확인</a></li>
                          <li class="divider"></li>
                          <li><a href="typography.html">프로필등록</a></li>
                          <li><a href="grid-system.html">개인정보보기</a></li>
                          <li><a href="grid-system.html">개인정보수정</a></li>
                      </ul>
                  </li>
				</c:if>
				
				<c:if test="${member.user_id eq 'admin'}">
                  <li class="dropdown active">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">관리하기<span class="caret"></span></a>
                      <ul class="dropdown-menu">
                          <li><a href="how-work.html">블랙리스트 관리</a></li>
                          <li><a href="pricing.html">검색 관리</a></li>
                          <li><a href="faq.html">광고 관리</a></li>
                          <li class="divider"></li>
                          <li><a href="typography.html">관리자 등록 및 삭제</a></li>
                      </ul>
                  </li>
				</c:if>
				<c:if test="${member.user_id eq null}">
	              	<li class="button-navbar"><a href="/ImNotAlone/share/login"><i class="fa fa-plus"></i> Login </a></li>
                </c:if>
				<c:if test="${member.user_id ne null}">
                 	<li class="button-navbar"><a href="/ImNotAlone/share/logout"><i class="fa fa-minus"></i> Logout </a></li>
                </c:if>
                    </ul>
                    
                    
                    
                    
                </div><!--/.nav-collapse -->
            </div><!--/.container-fluid -->
        </nav>