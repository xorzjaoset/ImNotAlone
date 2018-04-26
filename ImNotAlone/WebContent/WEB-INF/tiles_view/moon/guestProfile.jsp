 <!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <div class="page-bread mb70">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <h3>프로필 등록</h3>
                    </div>
                    <div class="col-sm-6">

                    </div>
                </div>
            </div>
        </div>

      <form method="POST" action="/ImNotAlone/share/moon/profile1" enctype="multipart/form-data">
        <div class="container mb30">
            <div class="row">
                <div class="col-sm-3 mb40">
          
                  <img id="blah" src="/ImNotAlone/resources/images/p.jpg" alt="" style="width:250px; height:250px; object-fit:cover">
                    <div style="text-align:center;"><label class="btn btn-primary btn-lg" >사진등록
                     <input type="file" class="form-control" name="file" id="file" class="btn btn-primary btn-lg" style="display: none;">
                     </label></div> 
                  	
                </div>
                <div class="col-sm-8 col-sm-offset-1 mb40"> 
                    <div class="form-group">
                    <label>ID</label>
                    <input type="text" class="form-control" name="mp_id"  maxlength="25" value="${dto.mp_id}" readonly="readonly">
                  </div>
                    
                  <div class="form-group">
                    <label>이름</label>
                    <input type="text" class="form-control" name="mp_name" value="${dto.mp_name}" maxlength="15" readonly="readonly">
                  </div>
                  
                  <div class="form-group">
                    <label>생년월일</label>
                    <input type="text" class="form-control" name="mp_jumin1" placeholder="ex:911209" maxlength="6" required="required">
                  </div>
                  
                  <div class="form-group">
                    <label>성별</label>
                    <select class = "form-control" name="mp_gender" title="성별을 선택하세요" required="required" >
                    <option value="여성">여성</option>
                    <option value="남성">남성</option>
                    </select>
                  </div>
                  
                   <div class="form-group">
                    <label>직업</label>
                    <select class = "form-control" name="mp_job" title="직업을 선택하세요" required="required">
                    <option value="대학생">대학생</option>
                    <option value="직장인">직장인</option>
                    <option value="취준생">취준생</option>
                    </select>
                  </div>
	
                  <div class="form-group">
                    <label>전화번호</label>
                    <input type="text" class="form-control" name="mp_phone" placeholder="01-394-4932" required="required">
                  </div>
                  
                  <div class="form-group">
                    <label>주소</label>
                    <input type="text" class="form-control" name="mp_addr1" placeholder="124, Munnawali, Jaipur, 302012" required="required">
                  </div>
                  
                  <div class="text-right">
                      <button type="submit" class="btn btn-primary btn-lg">프로필 등록</button>
                  </div>
                  
                </form>
                </div>
            </div>
        </div>

      
        <!-- jQuery-->
        <script src="js/plugins/all.js"></script>
        <script src="js/finder.custom.js"></script>
        <script type="text/javascript">
        /* function asdf(){
        	alert("되라");
        	$("#file").click(); 
        }
         */
        $(function() {
            $("#file").on('change', function(){
                
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
    </body>
</html>