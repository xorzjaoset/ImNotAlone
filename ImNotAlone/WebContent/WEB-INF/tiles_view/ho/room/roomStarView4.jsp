<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
   String cp = request.getContextPath();// /projectName
request.setCharacterEncoding("UTF-8");  //전달되는 값에대해서 한글처리
%>

<head>

<script>
function changeClass(board_no) {
	alert("확인");
var wishId = document.getElementById(board_no);
	var params="bst_board_no="+board_no;

if(wishId.className == "fa fa-heart-o") {
		wishId.className = "fa fa-heart";
	var url="/ImNotAlone/share/addWishList";
	$.ajax({
		type:"get"
		,url:url
		,data:params
		,dataType:"json"
		,success:function(result){
			if(result.check != 1){
			location.href="/ImNotAlone/share/login";
			}
		}
	});

} else {
		wishId.className="fa fa-heart-o";
	var url="/ImNotAlone/share/oddWishList";
	$.ajax({
		type:"get"
		,url:url
		,data:params
		,dataType:"json"
		,success:function(result){
			if(result.check != 1){
			location.href="/ImNotAlone/share/login";
			}
		}
	});
}
} 
</script>

</head>


        <div class="page-bread mb70">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <h3>방스타그램</h3>
                    </div>
                    <div class="col-sm-6">

                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-9 mb30">
                    
                    
                      
                      
                      
                      
                       <div class="clearfix mb30">
                            <div class="pull-right">
                                <div class="form-group">
                                    <select class="form-control" title="Sorting">                                       
                                        <option>Popular</option>
                                        <option>Low Price</option>
                                        <option>Best Rating</option>
                                        <option>High price</option>
                                    </select>
                                </div>
                            </div>
                            <h3 class="font300">${pageVO.totalCount} 개의 게시물이 있습니다.</h3>
                       </div>
                     
                     
                     
                 <!-- 게시물 시작 -->    
                     
          <c:forEach var="bst_contents" items="${bst_contents}">
           <div class="post-row">
             <input type="hidden" value="${bst_contents.bst_board_no}">
              <div class="post-thumb mb20" >
                
                <div class="card-overlay">
                       <a href="#"><img src="<%=cp%>/uploadedFile/${bst_contents.bst_img_sname}" alt="" class="img-responsive" style="margin-bottom:0px;"></a>
                     
                       
                   <div class="card-hover">
					<div class="card-content">
						<a class="label label-primary" href="#">인기급상승</a>
						<h3>
							<a href="#">${bst_contents.bst_type_of}</a>
						</h3>
						<ul class="list-inline mb0 rating-list">
							<li><i class="fa fa-star text-warning"></i></li>
							<li><i class="fa fa-star text-warning"></i></li>
							<li><i class="fa fa-star text-warning"></i></li>
							<li><i class="fa fa-star text-warning"></i></li>
						</ul>
					</div>
					<!--/card-content-->
					<div class="card-icons" > <!--  style="opacity: 1;" -->
						<c:set var="checkWish" value="${checkWish}"/>
						<c:set var="board_no" value="${bst_contents.bst_board_no}"/>
						<c:if test="${!fn:contains(checkWish,board_no)}">						
							<a title="Add to Wishlist" id="like" onclick="changeClass('${bst_contents.bst_board_no}');">	 <i class="fa fa-heart-o" id="${bst_contents.bst_board_no}"></i></a>
						</c:if>
						<c:if test="${fn:contains(checkWish,board_no)}">						
							<a title="Add to Wishlist" id="like" onclick="changeClass('${bst_contents.bst_board_no}');">	 <i class="fa fa-heart" id="${bst_contents.bst_board_no}"></i></a>
						</c:if>
		
					<a href="/ImNotAlone/share/roomStarContentView?bst_board_no=${bst_contents.bst_board_no}" title="View Detail">
						<i class="fa fa-search"></i></a>
					</div>
				</div>    
			</div>
            
              </div><!--/thumb-->  
               
               
                  
               <div class="post-content">
                           <div class="post-header clearfix">
                               <a href="#"><img width="80" src="/ImNotAlone/resources/images/av1.jpg" alt="" class="img-responsive img-circle"></a>
                               
                               <div class="overflow-hidden">
                                   <h3><a href="#">${bst_contents.bst_title}</a></h3>
                                   <ul class="list-inline">
                                       <li><a href="#"><i class="fa fa-user"></i> ${bst_contents.user_id}</a></li>
                                       <li><a href="#"><i class="fa fa-calendar"></i> ${bst_contents.bst_board_date}</a></li>
                                       <li><a href="#"><i class="fa fa-reply-all"></i> ${bst_contents.bst_view}</a></li>
                                   </ul>
                               </div>
                           </div><!--/header-->
                           <p>	
                               ${bst_contents.bst_contents} 
                           </p>
                           <div class="text-right">
                               <a href="/ImNotAlone/share/roomStarContentView?bst_board_no=${bst_contents.bst_board_no}" class="link-underline">Continue Reading...</a>
                           </div>
                       </div>
                   </div><!--게시물 종료-->
            </c:forEach>
                       
                       
                       
                   
                   
              <!-- 페이징 -->
                <div>
                   <div class="text-right mb30">
                       <nav aria-label="Page navigation">
                           <ul class="pagination">
                				<c:if test="${(PageVO.startPageNum-5) >= 0 }" >
                                <li>
	                                <a href="/ImNotAlone/share/roomStar4?pageNum=${pageVO.startPageNum-5}" aria-label="Previous2">
	                                <span aria-hidden="true">&laquo;</span></a>  <!-- 페이지이전 -->
                               	</li>
                             	</c:if>
                                <li>
                                    <a href="/ImNotAlone/share/roomStar4?pageNum=${pageVO.prevPageNum}" aria-label="Previous1">
	                                    <span aria-hidden="true">&lt;</span>  <!-- 이전 -->
	                                </a>
                                </li>
                              
                         		<c:forEach var="count" step="1" begin="${pageVO.startPageNum}" end="${pageVO.endPageNum}" >
                            	<c:if test="${pageVO.pageNum eq count}">
                             	  	 <li class="active"><a href="/ImNotAlone/share/roomStar4?pageNum=${count}">${count}</a></li>
                                </c:if>
                                <c:if test="${pageVO.pageNum ne count}">
                               		 <li><a href="/ImNotAlone/share/roomStar4?pageNum=${count}">${count}</a></li>
								</c:if>
                               </c:forEach>
                               
                                <li>
                                    <a href="/ImNotAlone/share/roomStar4?pageNum=${pageVO.nextPageNum}" aria-label="Next1">
                                        <span aria-hidden="true">&gt;</span> <!-- 다음 -->
                                    </a>
                                </li>
                         		
                         		<c:if test="${(pageVO.endPageNum+1) <= pageVO.finalPageNum }" >
                                <li>
                                    <a href="/ImNotAlone/share/roomStar4?pageNum=${pageVO.endPageNum+1}" aria-label="Next2">
                                        <span aria-hidden="true">&raquo;</span> <!-- 페이지다음 -->
                                    </a>
                                </li>
							</c:if>                                
                               
                           </ul>
                       </nav>
                   </div>
               </div>
                   
                   
               </div><!--/col-->
               <div class="col-md-3 mb60">
                   <h4 class="left-title mb20">Search Filter</h4>
                   <div class="mb40">
                       <form>
                           <div class="form-group">
                               <input type="text" class="form-control" placeholder="Keywords...">
                           </div>
                           <div class="form-group mb15">
                               <select class="form-control" title="Location">                                       
                                   <option>Paris</option>
                                   <option>London</option>
                                   <option>New York</option>
                                   <option>Tokyo</option>
                               </select>
                           </div>
                           <div class="form-group">
                               <select class="form-control" title="Category">                                       
                                   <option>Restaurants</option>
                                   <option>Jobs</option>
                                   <option>Property</option>
                                   <option>Automotive</option>
                               </select>
                           </div>
                           <div class="form-group">
                               <input type="text" class="form-control" placeholder="Min Price...">
                           </div>
                           <input type="submit" class="btn btn-dark btn-lg btn-block" value="Search">
                       </form>
                   </div>
                   <h4 class="left-title mb20">Recent Listings</h4>
                   <ul  class="list-unstyled recent-item-card mb40">
                       <li class="media">
                           <div class="media-left">
                               <a href="#">
                                   <img src="/ImNotAlone/resources/images/img1.jpg" alt="" class="img-responsive" width="90">
                               </a>
                           </div>
                           <div class="media-body">
                               <h4><a href="#">Doloremque laudantium, totam rem aperiam</a></h4>
                               <em>New York / Coffee</em>
                               <span class="text-primary">$140/Person</span>
                           </div>
                       </li><!--/li-->
                       <li class="media">
                           <div class="media-left">
                               <a href="#">
                                   <img src="/ImNotAlone/resources/images/img2.jpg" alt="" class="img-responsive" width="90">
                               </a>
                           </div>
                           <div class="media-body">
                               <h4><a href="#">Doloremque laudantium, totam rem aperiam</a></h4>
                               <em>New York / Coffee</em>
                               <span class="text-primary">$140/Person</span>
                           </div>
                       </li><!--/li-->
                       <li class="media">
                           <div class="media-left">
                               <a href="#">
                                   <img src="/ImNotAlone/resources/images/img3.jpg" alt="" class="img-responsive" width="90">
                               </a>
                           </div>
                           <div class="media-body">
                               <h4><a href="#">Doloremque laudantium, totam rem aperiam</a></h4>
                               <em>New York / Coffee</em>
                               <span class="text-primary">$140/Person</span>
                           </div>
                       </li><!--/li-->
                   </ul><!--/ul-->
                   <h4 class="left-title mb20">Popular Tags</h4>
                   <ul class="list-inline tags-list">
                       <li><a href="#"><i class="fa fa-tag"></i> Shop</a></li>
                       <li><a href="#"><i class="fa fa-tag"></i> Beer</a></li>
                       <li><a href="#"><i class="fa fa-tag"></i> Beach</a></li>
                       <li><a href="#"><i class="fa fa-tag"></i> Cinemas</a></li>
                       <li><a href="#"><i class="fa fa-tag"></i> Hotel</a></li>
                       <li><a href="#"><i class="fa fa-tag"></i> Dinner</a></li>
                       <li><a href="#"><i class="fa fa-tag"></i> Lunch</a></li>
                       <li><a href="#"><i class="fa fa-tag"></i> Taxi</a></li>
                       <li><a href="#"><i class="fa fa-tag"></i> Bar & pubs</a></li>
                       <li><a href="#"><i class="fa fa-tag"></i> Games</a></li>
                       <li><a href="#"><i class="fa fa-tag"></i> Tickets</a></li>
                   </ul>
               </div>
           </div>
       </div>
