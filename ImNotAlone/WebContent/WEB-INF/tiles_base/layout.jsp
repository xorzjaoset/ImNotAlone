	<%@ page contentType="text/html; charset=UTF-8"%>
	<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	
	<html>
	<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/ImNotAlone/resources/css/bundle.css" rel="stylesheet">
    <link href="/ImNotAlone/resources/css/style.css" rel="stylesheet">
	<title><tiles:getAsString name="title" /></title>
	
	<!-- <script>
function result(){   
var url="/ImNotAlone/share/registerComment";
var dg_coment=$("#dg_comment").val();
var params="dg_comment="+dg_comment;
window.alert(url);
	
$.ajax({
	type:"get"		
	,url:url		
	,data:params	
	,dataType:"json"  
	,success:function(result){	
			 $("#comentDown").append(
		               '<div id="commentDown">'+
	                    '<div class="clearfix review-box mb35">'+
	                       '<img src="/ImNotAlone/resources/images/av1.jpg" alt="" class="img-responsive img-circle pull-left" width="80">'+
	                        '<div class="overflow-hidden">'+
	                            '<span class="pull-right">4 days ago</span>'+
	                            '<ul class="list-inline rating-list mb20">'+
	                                '<li><span><b>xorzjaoset</b></span><br>'+
	                            '</ul>'+
	                            '<p>'+
		                                "여기 엄청 좋은것 가타영~~~~ 좋아보인다~~" +
	                            '</p>'+
	                        '</div>'+
	                    '</div>'+
	                  '</div>'
			 );
	}
    ,error:function(e) {	
    	alert(e.responseText);
    }
});
</script> -->


    </head>

        
	<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
	</body>
	
      <script src="/ImNotAlone/resources/js/plugins/all.js"></script>
      <script src="/ImNotAlone/resources/js/finder.custom.js"></script>
      <script type="text/javascript">
   
   $(function() {
       $("#user_file").on('change', function(){
           
           readURL(this);
       });
   });
   function readURL(input) {
       if (input.files && input.files[0]) {
       var reader = new FileReader();

       reader.onload = function (e) {
               $('#blah').attr('src', e.target.result);
           }
         reader.readAsDataURL(input.files[0]);
       }
   }
   </script> 
	</html>