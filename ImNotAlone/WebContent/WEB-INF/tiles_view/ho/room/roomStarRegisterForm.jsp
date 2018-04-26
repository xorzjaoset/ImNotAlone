<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    


        <div class="page-bread mb70">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <h3>여러분의 방을 보여주세요~~!</h3>
                    </div>
                    <div class="col-sm-6">

                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-9 mb30">
                <form role='form' action="/ImNotAlone/share/roomStarUpload" method="post" enctype="multipart/form-data">
	
	
	               <div class="mb40">
		                <h2 class="left-title">사진 올리기</h2>
	                  <img id="blah" src="/ImNotAlone/resources/images/img1.jpg" alt="" class="img-responsive mb15">
		                 <input id="user_file" multiple="multiple" type="file" name="user_file" >
                   </div><!--/-->
	                 
                 
                 
                 
                 
                    <div class="mb40">
                        <h2 class="left-title">설  명</h2>
                  
<!-- 		                  <form id="my-awesome-dropzone" action="/ImNotAlone/share/roomStarUpload" class="dropzone dz-clickable"> -->
<!-- 		                  	<div class="dz-default dz-message"> -->
<!-- 		                  	  <input type="file" name="user_file2" /> -->
<!-- 		                  	<span>Drop IMAGES here to upload</span></div> -->
<!-- 		                  </form> -->


                        <input class="form-control" type="hidden" name="user_id" value="${member.user_id}">
                        
                        <div class="form-group">
                            <input class="form-control" type="text" placeholder="Title" name="bst_title">
                        </div>
                        <div class="form-group">
                            <textarea class="form-control" placeholder="Description" name="bst_contents" rows="8"></textarea>
                            <div class="textarea-resize"></div>
                        </div>
                    </div><!--/-->
                    
                    
                    
                    <div class="mb40">
                        <h2 class="left-title">구  분</h2>
                        <ul class="amenities list-inline">
                            <li class="checkbox"><input name="type_of" value="주방" type="checkbox" id="amenity-1"> <label for="amenity-1">주방</label></li>
                            <li class="checkbox"><input name="type_of" value="초인종" type="checkbox" id="amenity-2"> <label for="amenity-2">초인종/인터폰</label></li>
                            <li class="checkbox"><input name="type_of" value="무선인터넷" type="checkbox" id="amenity-3"> <label for="amenity-3">무선인터넷</label></li>
                            <li class="checkbox"><input name="type_of" value="에어컨" type="checkbox" id="amenity-4"> <label for="amenity-4">에어컨</label></li>
                            <li class="checkbox"><input name="type_of" value="건조기" type="checkbox" id="amenity-5"> <label for="amenity-5">건조기</label></li>
                            <li class="checkbox"><input name="type_of" value="화재 감지기" type="checkbox" id="amenity-6"> <label for="amenity-6">화재 감지기</label></li>
                            <li class="checkbox"><input name="type_of" value="세탁기" type="checkbox" id="amenity-7"> <label for="amenity-7">세탁기</label></li>
                            <li class="checkbox"><input name="type_of" value="건물 내 무료 주차" type="checkbox" id="amenity-8"> <label for="amenity-8">건물 내 무료 주차</label></li>
                            <li class="checkbox"><input name="type_of" value="헬스장" type="checkbox" id="amenity-9"> <label for="amenity-9">헬스장</label></li>
                            <li class="checkbox"><input name="type_of" value="수영장" type="checkbox" id="amenity-10"> <label for="amenity-10">수영장</label></li>
                            <li class="checkbox"><input name="type_of" value="주택" type="checkbox" id="amenity-11"> <label for="amenity-11">주택</label></li>
                            <li class="checkbox"><input name="type_of" value="전원주택" type="checkbox" id="amenity-12"> <label for="amenity-12">전원주택</label></li>
                            <li class="checkbox"><input name="type_of" value="아파트" type="checkbox" id="amenity-13"> <label for="amenity-13">아파트</label></li>
                            <li class="checkbox"><input name="type_of" value="호텔" type="checkbox" id="amenity-14"> <label for="amenity-14">호텔</label></li>
                            <li class="checkbox"><input name="type_of" value="리조트" type="checkbox" id="amenity-15"> <label for="amenity-15">리조트</label></li>
                            <li class="checkbox"><input name="type_of" value="B&B" type="checkbox" id="amenity-16"> <label for="amenity-16">B&B</label></li>
                            <li class="checkbox"><input name="type_of" value="반려동물" type="checkbox" id="amenity-17"> <label for="amenity-17">반려동물</label></li>
                            <li class="checkbox"><input name="type_of" value="English" type ="checkbox" id="amenity-18"> <label for="amenity-18">English</label></li>
                            <li class="checkbox"><input name="type_of" value="흡연가능" type="checkbox" id="amenity-19"> <label for="amenity-19">흡연가능</label></li>
                            <li class="checkbox"><input name="type_of" value="이벤트/행사가능" type="checkbox" id="amenity-20"> <label for="amenity-20">이벤트/행사가능</label></li>
                            
                        </ul>
                    </div>
                    
                
                
                  
                  
                  
      
                    <div class="text-right mb40">
                        <input type="submit" class="btn btn-lg btn-primary" value="내 방 등록하기">
                    </div>
                  </form> 
                  

                </div><!--/col-->
                
                
                
                
             
                
                
                
                
                <div class="col-md-3">
                    <h4 class="left-title mb20">오늘의 추천방</h4>
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
                    
                    
                     <h4 class="left-title mb20">최근 봤던 방</h4>
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
                    
                    
                    
                </div>
                
                
                
                
                
                
            </div>
        </div>
