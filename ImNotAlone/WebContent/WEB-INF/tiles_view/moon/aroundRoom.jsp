<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${fnum !='' ||fnum ne null}">
<script>
 $(document).ready(function(){
	var fnum = ${fnum }
	$("#basic").val(fnum).attr("selected","selected");
	var target = document.getElementById("basic");
	var text = target.options[target.selectedIndex].text;
	$("body > div.container > div > div.col-md-3.mb60 > div > form > div > div > button > span.filter-option.pull-left").html(text); 
}); 
</script>
</c:if>  
<script>

function roomList(){
	var snum=$("#filter").val();
	var fnum=${fnum};
	
	//id가 filter인 요소의 값을 불러옴
	if(snum==""){
		$("#filter option").each(function(){
			$("#filter option:eq(1)").remove();
		});
		
		return;
		
	}
	$.ajax({
		type:"POST"
		,url:"roomfilter"
		,data: {
			snum : snum,
			fnum : fnum
		}
		,dataType:"json"
		,success:function(args){
			$("#moontest").html('');
			
			
			for(var idx=0; idx<args.data1.length; idx++){
				$("#moontest").append(
						'<div class="col-sm-4 mb30" >'+
                        '<div class="card-overlay" id="test1">'+
                        '<img src="${pageContext.request.contextPath}/upload/'+args.data1[idx].rp_sname+'" class="img-responsive" alt="" style="width:300px;height:200px;object-fit:cover">'+
                        '<div class="card-hover" style="width:300px;height:100%">'+
                        '<div class="card-content">'+
                        '<h3><a href="/ImNotAlone/share/moon/roomdetail?rp_board_no='+args.data1[idx].r_board_no+'">Tasty Coffee</a></h3>'+
                        '</div>'+
                        '</div>'+
                        '</div>'+
                    	'</div>')
			}
			
		}
	,error:function(e){
		alert(e.responseText);
		
	}
	
	});
	
	
}

</script>

        <div class="page-bread mb70">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <h3>방 둘러보기</h3>
                    </div>
                    <div class="col-sm-6">

                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-9 mb30">
                    <div class="clearfix mb20">
                        <div class="pull-right">
                            <div class="form-group">
                                <select class="form-control" title="분류" id="filter" onchange="roomList()">                                       
                          			<option value="1">낮은 가격</option>
                                    <option value="2">높은 가격</option>
                                    <option value="3">평점 순서</option>
                                </select>
                            </div>
                        </div>
                        <h3 class="font300">방 목록</h3>
                    </div>
                    
                    <div class="row" id="moontest">
                    <c:forEach var="share" items="${share}">
                    <div class="col-sm-4 mb30" >
                        <div class="card-overlay" id="test1">
                            <img src="${pageContext.request.contextPath}/upload/${share.rp_sname}" class="img-responsive" alt="" style="width:300px;height:200px;object-fit:cover">
                            <div class="card-hover" style="width:300px;height:100%">
                                <div class="card-content">
                                    <h3><a href="/ImNotAlone/share/moon/roomdetail?rp_board_no=${share.rp_board_no}">Tasty Coffee</a></h3>
                                </div><!--/card-content-->
                            </div>
                        </div>
                    </div> 
                    </c:forEach>
                </div>
        
                    <div class="text-right mb30">
                        <nav aria-label="Page navigation">
                            <ul class="pagination">
                                <li>
                                    <a href="#" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                                <li class="active"><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                                <li>
                                    <a href="#" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div><!--/col-->
                <div class="col-md-3 mb60">
                    <h4 class="left-title mb20">검색 조건</h4>
                    <div class="mb40">
                       
                <form method="post" action="/ImNotAlone/share/moon/around4">
             
                            <div class="form-group mb15">
                                <select class="form-control" title="방분류" name="string" id="basic">                                       
                                    <option value="원룸/투룸">원룸/투룸</option>
                                    <option value="쉐어하우스">쉐어하우스</option>
                                    <option value="하우스메이트">하우스메이트</option>
                                    <option value="오피스텔">오피스텔</option>
                                </select>
                            </div>
                            <input type="submit" class="btn btn-dark btn-lg btn-block" value="Search" onclick="javascript()">
                         </form>
                      
                    </div>
                    <h4 class="left-title mb20">최근 둘러본 방</h4>
                    <ul  class="list-unstyled recent-item-card mb40"> 
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
                   
                </div>
            </div>
        </div>
        <!-- jQuery--> 
  
