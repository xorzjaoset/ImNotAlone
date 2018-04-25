<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
	var no = '${dto.no}'  // 게시글 번호
	
	$('[name=repInsertButton]').click(function() {  // 댓글 등록 버튼 클릭시
		var insertData = $('[name=repInsertForm]').serialize();  // 댓글 내용을 가져옴
		
		
	});
	
	
	// 댓글리스트
	/* function repList() {
		$.ajax({
			
		});
	} */
</script>