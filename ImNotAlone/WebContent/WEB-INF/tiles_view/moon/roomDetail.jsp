<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page isELIgnored="false" %>

<%
String cp = request.getContextPath();
request.setCharacterEncoding("UTF-8");
%>

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script> 
<head>
<script>
function result(){
	var url = "/ImNotAlone/share/moon/roomComment";
	var rc_content=$("#rc_content").val();
	var params="rc_content="+rc_content+"&r_board_no="+${param.rp_board_no};
	$.ajax({
		type:"get"
		,url:url
		,data:params
		,dataType:"json"
		,success:function(result){
			$("#commentDown").append(
					  '<div id="commentDown">'+
	                    '<div class="clearfix review-box mb35">'+
	                       '<img src="/ImNotAlone/resources/images/av1.jpg" alt="" class="img-responsive img-circle pull-left" width="80">'+
	                        '<div class="overflow-hidden">'+
					'<span class="pull-right">'+result.rc_date + '</span>'+
					'<ul class="list-inline rating-list mb20">'+
					'<li><span><b>'+result.rc_id+'</b></span><br>'+
					'</ul>'+
					'</p>'+
					result.rc_content+
					'</p>'+
					'</div>'+
                    '</div>'+
                  '</div>');
		}
	,erro:function(e){
		alert(e.responseText);
		
	}		
	})
}

</script>

</head>

        <div class="listing-detail-header mb50">
            <div class="container">
              <h3><i class="fa fa-map-signs"></i> 124, Lorem Street Ave, NYK, 302012</h3>
                <ul class="rating-list list-inline clearfix">
                    <li><i class="fa fa-star text-warning"></i></li>
                    <li><i class="fa fa-star text-warning"></i></li>
                    <li><i class="fa fa-star text-warning"></i></li>
                    <li><i class="fa fa-star text-warning"></i></li>
                    <li><i class="fa fa-star-half-empty text-warning"></i></li>
                    <li>(234)</li>
                </ul>
            </div>
        </div>
        
        <div class="listing-slider-row mb70">
            <div class="owl-carousel owl-theme detail-slider">
        <c:forEach var="roomphoto" items="${roomphoto}"> <!-- 이거 for:each문 쓰면 안됨 연습한거임 -->
                <div class="item">
                    <img src="${pageContext.request.contextPath}/upload/${roomphoto.rp_sname}" alt="" class="img-responsive" style="width:100%; height:300px; object-fit:cover">
                </div>
        </c:forEach>
            </div>
        </div>

        <div class="container mb30">
            <div class="row">
                <div class="col-sm-8 mb40">
                    <h3 class="left-title mb25">방 정보</h3>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec efficitur tristique enim, ac tincidunt massa pulvinar non. Donec scelerisque libero eu tincidunt cursus. Phasellus vel commodo nunc, nec suscipit enim. Integer suscipit, mauris consectetur pharetra ultrices, neque sem malesuada mauris, id tristique ante leo vel magna. Phasellus ac risus vel erat elementum fringilla et non massa. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.
                    </p>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec efficitur tristique enim, ac tincidunt massa pulvinar non. Donec scelerisque libero eu tincidunt cursus. Phasellus vel commodo nunc, nec suscipit enim. Integer suscipit, mauris consectetur pharetra ultrices, neque sem malesuada mauris, id tristique ante leo vel magna. Phasellus ac risus vel erat elementum fringilla et non massa. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.
                    </p>
                    <br>
                    <h3 class="left-title mb25">기본옵션</h3>
                    <ul class="list-inline tags-list mb25">
                        <li><i class="fa fa-check-circle"></i> 무선 인터넷</li>
                        <li><i class="fa fa-check-circle"></i> 세탁기</li>
                        <li><i class="fa fa-check-circle"></i> 에어컨</li>
                        <li><i class="fa fa-check-circle"></i> 냉장고</li>
                        <li><i class="fa fa-check-circle"></i> 가스레인지</li>
                        <li><i class="fa fa-check-circle"></i> 전자레인지</li>
                        <li><i class="fa fa-check-circle"></i> 중앙난방</li>
                        <li><i class="fa fa-check-circle"></i> 개인난방</li>
                        <li><i class="fa fa-check-circle"></i> 책장</li>
                        <li><i class="fa fa-check-circle"></i> 옷장</li>
                        
                    </ul>
                    <h3 class="left-title mb25">Location</h3>
                    <iframe height="350" frameborder="0" style="border:0;width:100%;" class="mb30"
                            src="https://www.google.com/maps/embed/v1/place?q=place_id:ChIJWalJ2wO6j4AR4A9dNSj2ATI&key=AIzaSyAcC0a6iry-BDvy1LA4EFqlvKBGTdZELJA
                            " allowfullscreen></iframe>
                   
                <!-- @@@@@@@@@@@ 리뷰 달기 @@@@@@@@@@@@@@@@@ -->
           <%--       <div class="gray-bg pt70 pb40">
                <div class="row">
                 <div class="col-sm-6 col-sm-offset-3 text-center center-heading" style="text-align:center;">
                        <h2 style="margin-bottom:20px;margin-top:20px;">Review</h2>
                 </div>
               <!--  <h4 class="center-title mb25">Comment</h4> -->
                </div>
                <div class="row" style="vertical-align: middle;">
                    <div class="col-sm-12 col-sm-offset-0">                     
                        <div class="owl-carousel owl-theme testimonial-slider mb40">
                           
                           
                           <c:forEach var="photo" items="${photo}">
                            <div class="item">
                                <div class="testimonial-card">
                                    <div class="content">
                                        " There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. "
                                    </div>
                                    <div class="testimonial-author clearfix">
                                        <img src="${pageContext.request.contextPath}/upload/${photo.mp_pn}"  alt="" class="img-responsive img-circle pull-left" style="object-fit:cover;width: 60px; height: 60px;" >
                                        <div class="author-meta">
                                            <h5 class="mb0">문영광</h5>
                                            <em>직장인</em>
                                        </div>
                                    </div>
                                </div>
                            </div><!--/item-->
                           </c:forEach>
                        </div><!--/slider-->
                    </div>
                </div>
        </div> --%>
        
        <!-- 댓글달면 뿌려주기!!!!!!!!ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ -->
               <h3 class="left-title mb25">Comment</h3>
              
               <div id="commentDown">     
                    <c:forEach var="comment" items="${comment}" >
                    <div class="clearfix review-box mb35">
                       <img src="${pageContext.request.contextPath}/upload/${content.mp_pn}" alt="" class="img-responsive img-circle pull-left" width="80">
                        <div class="overflow-hidden">
                            <span class=" pull-right">${comment.rc_date}</span>
                            <ul class="list-inline rating-list mb20">
                            <li><span><b>${comment.rc_id}</b></span><br>
                            </ul>
                            <p>
                               ${comment.rc_content}
                            </p>
                        </div>
                    </div>
                    </c:forEach>
                    </div>
                    <!--/review-box-->
             
                     <!--댓글 달기@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
                    <form id="review" action="/ImNotAlone/share/moon/roomComment"  method="GET">
                        <div class="form-group">
                                 <label for="msgr">Your Message</label>
                                 <textarea class="form-control" rows="6" id="rc_content" name="rc_content" placeholder="Describe your experience"></textarea>
                                 <input type="hidden" value="${param.rp_board_no}" name="r_board_no" id="rc_board_no"/>
                             </div>
                             <input type="button" class="btn btn-primary btn-lg" value="등록" onclick="result();">
                    </form>
                </div>
                <div class="col-sm-4">
                    <div class="mb40">
                        <h2 class="font300 mb25"><i class="fa fa-heart-o text-danger"></i> 413 <small>People Love it</small></h2>
                        <h2 class="font300 mb25"><i class="fa fa-star text-warning"></i> 4.8/5 <small>From <a href="#reviews" class="link-underline">234 Reviews</a></small></h2>
                     
                    </div>
                 
                    <div class="mb40">
                         <h3 class="left-title mb25">문의하기</h3>
                         <form action="/ImNotAlone/share/moon/roomInquiry" method="POST">
                              <div class="form-group">
                                 <label for="email">Email</label>
                                 <input type="text" class="form-control" id="email" name="ri_email">
                             </div>
                              <div class="form-group">
                                 <label for="msg">Message</label>
                                 <textarea class="form-control" rows="6" id="msg" name="ri_content"></textarea>
                             </div>
                             <div class="text-right">
                                 <input type="submit" class="btn btn-primary btn-lg" value="Submit">
                             </div>
                         </form>
                    </div>
                    <form method="POST">
                    <div class="col-mb-6 col-sm-14">
                    	<input type="submit" class="btn btn-primary btn-block" value="매칭 신청" style="height: 80px; object-fit:none">
                    </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- jQuery-->
        <script src="js/plugins/all.js"></script>
        <script src="js/finder.custom.js"></script>
</html>