<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	var no='${dto.no}';  // 게시글 번호
	alert(no);
	
	$("[name=repInsertButton]").click(function(){  // 댓글 등록 버튼 클릭시
		var insertData=$("[name=repInsertForm]").serialize();  // 댓글 내용을 가져옴
		
		repInsert(insertData);  // insert 함수 호출(아래)
	});
	
	
	// 댓글리스트
	function repList() {
		$.ajax({
			url:'/ImNotAlone/share/qnaRep',
			type:'get',
			data:{'no':no},
			success:function(data){
				var a ='';
				
				$.each(data, function(key, value){
					a+='<div class="repArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
		            a+='<div class="repInfo'+value.rep_no+'">'+'댓글번호 : '+value.rep_no+' / 작성자 : '+value.id;
		            a+='<a onclick="repUpdate('+value.rep_no+',\''+value.rep_content+'\');"> 수정 </a>';
		            a+='<a onclick="repDelete('+value.rep_no+');"> 삭제 </a> </div>';
		            a+='<div class="repContent'+value.rep_no+'"> <p> 내용 : '+value.rep_content +'</p>';
		            a+='</div></div>';
				});
				$(".qnaRepList").html(a);
			}
		});
	}
	
	// 댓글 등록
	function repInsert(insertData){
		 $.ajax({
			 url:'/ImNotAlone/share/qnaRepInsert',
		     type:'post',
		     data:insertData,
		     success:function(data){
		    	 if(data == 1) {
		    		 repList(); //댓글 작성 후 댓글 목록 reload
		    		 $("[name=rep_content]").val("");
		         }
		     }
		 });
	}
	
	$(document).ready(function(){
		repList(); //페이지 로딩시 댓글 목록 출력 
	});

</script>