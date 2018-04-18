<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>
<script>
function changeClass(board_no) {
	alert("위시가 삭제되었습니다");
var wishId = document.getElementById(board_no);
	var params="bst_board_no="+board_no;

	var url="/ImNotAlone/share/oddWishList";
	$.ajax({
		type:"get"
		,url:url
		,data:params
		,dataType:"json"
		,success:function(result){
			if(result.check==1){
			location.href="/ImNotAlone/share/wishList";
		}
		}
	});

} 
</script>
</head>

        <div class="page-bread mb50">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <h3>나의 위시리스트</h3>
                    </div>
                    <div class="col-sm-6">

                    </div>
                </div>
            </div>
        </div>
        
        <div class="container mb70"></div>
        
        <div class=""></div>
        
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3 text-center center-heading mb40">
                        <h2>${wishListCount}개의 위시가 있습니다.</h2>
                        <p>
                           	자유롭게 추가/삭제가 가능합니다.
                        </p>
                        
                    </div>
                </div><!--/row-->
                
                <div class="clearfix">
                     <div class="form-group pull-right">
                                <select class="form-control" title="Sorting">                                       
                                    <option>Popular</option>
                                    <option>Low Price</option>
                                    <option>Best Rating</option>
                                    <option>High price</option>
                                </select>
                      </div>
                </div>
			 <c:forEach var="bst_contents" items="${wishList}" varStatus="status">

                <c:if test="${status.index == 0 || status.index == 4 || status.index == 8 || status.index == 12 || status.index == 16 || status.index == 20 || status.index == 24 || status.index == 28 || status.index == 32}">
              	  <div class="row">
                </c:if>
                    <div class="col-sm-6 col-md-3 mb30">
                        <div class="card-overlay">
                            <img src="/ImNotAlone/uploadedFile/${bst_contents.bst_img_sname}" class="img-responsive" style="width:100%; height:180px; object-fit:none"> 
                            
                            <div class="card-hover">
                                <div class="card-content">
                                    <a class="label label-primary" href="#">인기급상승</a>
                                    <h3><a href="#">${bst_contents.bst_title}</a></h3>
                                 <!--    <ul class="list-inline mb0 rating-list">
                                        <li><i class="fa fa-star text-warning"></i></li>
                                        <li><i class="fa fa-star text-warning"></i></li>
                </div>
                                        <li><i class="fa fa-star text-warning"></i></li>
                                        <li><i class="fa fa-star text-warning"></i></li>
                                        <li><i class="fa fa-star-half-empty text-warning"></i></li>
                                    </ul> -->
                                </div><!--/card-content-->
                               	<div class="card-icons">
	                                   <div onclick="changeClass('${bst_contents.bst_board_no}');"><a href="#" title="Add to Wishlist"><i id="${bst_contents.bst_board_no}" class="fa fa-heart"></i></a></div>
	                                    <div><a href="/ImNotAlone/share/roomStarContentView?bst_board_no=${bst_contents.bst_board_no}" title="View Detail"><i class="fa fa-search"></i></a></div>
                                </div>
                            </div>
                        </div>
                    </div>
               <c:if test="${status.index == 3 || status.index == 7 || status.index == 11 || status.index == 15 || status.index == 19 || status.index == 23 || status.end == status.index}">
                    </div>
               </c:if>
            </c:forEach>
  		 
  		 </div>
  		 </div>



