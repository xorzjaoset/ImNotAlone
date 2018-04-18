<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page isELIgnored="false" %>

<%
    String cp = request.getContextPath();// /projectName
	request.setCharacterEncoding("UTF-8");  //전달되는 값에대해서 한글처리
%>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script> 
<head>

<script>
function result(){   
var url="/ImNotAlone/share/registerComment";
var dg_comment=$("#dg_comment").val();
var bst_by_id="${contents.user_id}";
var bst_board_no="${contents.bst_board_no}";
var params="dg_comment="+dg_comment+"&bst_by_id="+bst_by_id+"&bst_board_no="+bst_board_no;
// var params="dg_comment="+dg_comment+"&user_id="+${contents.user_id}+"&bst_board_no="+${contents.bst_board_no}
window.alert(url);
	
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
	                            '<span class="pull-right">' + result.dg_board_date +'</span>'+
	                            '<ul class="list-inline rating-list mb20">'+
	                                '<li><span><b>' + result.dg_by_id + '</b></span><br>'+
	                            '</ul>'+
	                            '<p>'+
                                result.dg_comment +
	                            '</p>'+
	                        '</div>'+
	                    '</div>'+
	                  '</div>');
	}
    ,error:function(e) {	
    	alert(e.responseText);
    }
});
}

	
	
</script>

</head>


        <div class="listing-detail-header mb50">
            <div class="container">
                <h2 class="font300">${contents.bst_title}</h2>
                <p><i class="fa fa-map-signs"></i>${contents.user_id}</p>
                <ul class="rating-list list-inline clearfix">
                    <li><i class="fa fa-star text-warning"></i></li>
                    <li><i class="fa fa-star text-warning"></i></li>
                    <li><i class="fa fa-star text-warning"></i></li>
                    <li><i class="fa fa-star text-warning"></i></li>
                    <li><i class="fa fa-star-half-empty text-warning"></i></li>
                    <li>(234)</li>
                    <li class="pull-right"><a href="#review" class="link-underline">Submit a Review</a></li>
                </ul>
            </div>
        </div>
        
        <div class="listing-slider-row mb70">
          <div class="owl-carousel owl-theme detail-slider">
	        <c:forEach var="imgList" items="${imgList}">
                <div class="item">
                    <img src="/ImNotAlone/uploadedFile/${imgList.bst_img_sname}" alt="" class="img-responsive">
                </div>
			</c:forEach>
          </div>
        </div>

        <div class="container mb30">
            <div class="row">
                <div class="col-sm-8 mb40">
                    <h3 class="left-title mb25">내  용</h3>
                    <p>
							${contents.bst_contents}
                    </p>
                    <br>
                    <h3 class="left-title mb25">시  설</h3>
                    <ul class="list-inline tags-list mb25">
                    <c:forEach var="type" items="${type_of_list}">
                        <li><a href="#"><i class="fa fa-check-circle"></i> ${type}</a></li>
                    </c:forEach>
                    </ul>
                    <h3 class="left-title mb25">위  치</h3>
                    <iframe height="350" frameborder="0" style="border:0;width:100%;" class="mb30"
                            src="https://www.google.com/maps/embed/v1/place?q=place_id:ChIJWalJ2wO6j4AR4A9dNSj2ATI&key=AIzaSyAcC0a6iry-BDvy1LA4EFqlvKBGTdZELJA
                            " allowfullscreen></iframe>
                    <h3 class="left-title mb25">댓글 리스트</h3>
                  
                  
                  <!--review-box-->
                  <div id="commentDown">
                 <c:forEach var="cmList" items="${cmList}">
                    <div class="clearfix review-box mb35">
                        <img src="/ImNotAlone/resources/images/av1.jpg" alt="" class="img-responsive img-circle pull-left" width="80">
                        <div class="overflow-hidden">
                            <span class="pull-right">${cmList.dg_board_date}</span>
                            <ul class="list-inline rating-list mb20">
                                <li><span><b>${cmList.dg_by_id}</b></span><br>
                            </ul>
                            <p>
                               ${cmList.dg_comment} 
                            </p>
                        </div>
                    </div>
                 </c:forEach>
                  </div>
                 <!--/review-box-->
                    
                    
                    
                    
                    <!--  <div class="clearfix review-box mb45">
                        <img src="/ImNotAlone/resources/images/av3.jpg" alt="" class="img-responsive img-circle pull-left" width="80">
                        <div class="overflow-hidden">
                            <span class=" pull-right">3 days ago</span>
                            <ul class="list-inline rating-list mb20">
                                <li><i class="fa fa-star text-warning"></i></li>
                                <li><i class="fa fa-star text-warning"></i></li>
                                <li><i class="fa fa-star text-warning"></i></li>
                                <li><i class="fa fa-star text-warning"></i></li>
                                <li><i class="fa fa-star-half-empty text-warning"></i></li>
                            </ul>
                            <span>xorzjaoset</span>
                            
                            <p>
                                Doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.
                            </p>
                        </div>
                    </div>/review-box -->
                    
                    <h3 class="left-title mb25">댓글 작성</h3>
                        <div class="form-group">
                                 <label for="msgr">내 용</label>
                                 <textarea id="dg_comment" name="dg_comment" class="form-control" rows="6" id="msgr" placeholder="Describe your experience"></textarea>
                             </div>
                             <div class="text-right">
                                 <input type="button" class="btn btn-primary btn-lg" value="댓글 남기기" onclick="result();">
                             </div>                             
                </div>
                <div class="col-sm-4">
                    <div class="mb40">
                        <h2 class="font300 mb25"><i class="fa fa-heart-o text-danger"></i> ${likeCount}<small>People Love it</small></h2>
                        <h2 class="font300 mb25"><i class="fa fa-star text-warning"></i> 4.8/5 <small>From <a href="#reviews" class="link-underline">234 Reviews</a></small></h2>
                        <div class="buttons">
                            <a href="#" class="btn btn-primary"><i class="fa fa-shopping-bag"></i>ADD WISH LIST</a>
                            <a href="#" class="btn btn-warning"><i class="fa fa-hand-peace-o"></i>LIKE IT</a>
                        </div>
                    </div>
                    <div class="mb40">
                        <h3 class="left-title mb25">HISTORY OF <br>WHO WITH OWNER</h3>
                        <div class="working-hours">
                            <div class="day clearfix">
                                <span class="name">onecredesign</span><span class="hours">2013.02.13 - 2014.08.13</span>
                            </div><!-- /.day -->

                            <div class="day clearfix">
                                <span class="name">sexyboy</span><span class="hours">2014.02.13 - 2014.08.13</span>
                            </div><!-- /.day -->

                            <div class="day clearfix">
                                <span class="name">helloworld</span><span class="hours">2015.02.13 - 2014.08.13</span>
                            </div><!-- /.day -->

                            <div class="day clearfix">
                                <span class="name">mrmoon</span><span class="hours">2015.02.13 - 2014.08.13</span>
                            </div><!-- /.day -->

                            <div class="day clearfix">
                                <span class="name">poolmoown</span><span class="hours">2016.02.13 - 2014.08.13</span>
                            </div><!-- /.day -->

                            <div class="day clearfix">
                                <span class="name">samsu</span><span class="hours">2017.02.13 - 2014.08.13</span>
                            </div><!-- /.day -->

                            <div class="day clearfix">
                                <span class="name">oeoepp</span><span class="hours">2018.02.13 - 2014.08.13</span>
                            </div><!-- /.day -->
                        </div>
                    </div>
                  
                  
                 <!--    <div class="mb40">
                         <h3 class="left-title mb25">Enquire Form</h3>
                         <form>
                             <div class="form-group">
                                 <label for="name">Name</label>
                                 <input type="text" class="form-control" id="name">
                             </div>
                              <div class="form-group">
                                 <label for="email">Email</label>
                                 <input type="text" class="form-control" id="email">
                             </div>
                              <div class="form-group">
                                 <label for="msg">Message</label>
                                 <textarea class="form-control" rows="6" id="msg"></textarea>
                             </div>
                             <div class="text-right">
                                 <button type="button" class="btn btn-primary btn-lg">Submit</button>
                             </div>
                         </form>
                    </div> -->
                    
                    
                    
                    
                    
                </div>
            </div>
        </div>

