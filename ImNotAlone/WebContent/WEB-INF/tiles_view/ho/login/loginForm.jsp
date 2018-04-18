<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <div class="page-bread mb70">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <h3>로그인 하시면 더 많은 서비스를<br> 이용하실 수 있습니다.</h3>
                    </div>
                    <div class="col-sm-6">

                    </div>
                </div>
            </div>
        </div>
        <div class="container mb70">
            <div class="row">
                <div class="col-sm-4 col-sm-offset-4">
                    <div class="border-card">
                        <h3 class="font300 mb0 text-center">로그인 페이지</h3> <hr>
                          <form role='form' method="post" action="/ImNotAlone/share/login1">
                            <div class='form-group-icon mb15'>
                                <i class='fa fa-envelope'></i>
                                <input type="email" name = "user_email" class='form-control' placeholder="Email">
                            </div>
                            <div class='form-group-icon mb15'>
                                <i class='fa fa-lock'></i>
                                <input type="password" name="user_password" class='form-control' placeholder="Password">
                            </div>
                            <div class="checkbox">
                                <input type="checkbox" id="rm">
                                <label for="rm">
                                     Remember Me
                                </label>
                            </div>
                            <input type="submit" value="Login" class='btn btn-default btn-lg btn-block'>
                        </form>
                        <hr>
                        <div class='text-center'>Or</div>
                        <div class='buttons-login'>
                            <a href='#' class='btn btn-facebook btn-social btn-block'><i class='fa fa-facebook'></i> Login with Facebook</a>
                            <a href='#' class='btn btn-twitter btn-social btn-block'><i class='fa fa-twitter'></i> Login with Twiter</a>
                            <a href='#' class='btn btn-gplus btn-social btn-block'><i class='fa fa-google-plus'></i> Login with Google+</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
   
	