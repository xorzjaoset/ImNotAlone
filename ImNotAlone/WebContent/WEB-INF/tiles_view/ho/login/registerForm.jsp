<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <div class="page-bread mb70">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <h3>회원가입을 하시면 더 많은<br> 서비스를 이용하실 수 있습니다.</h3>
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
                        <h3 class="font300 mb0 text-center">회원가입 페이지</h3> <hr>
                   <form role='form' action="/ImNotAlone/share/register2">
                            <div class='form-group-icon mb15'>
                                <i class='fa fa-user'></i>
                                <input type="text" name="user_id" class='form-control' placeholder="ID">
                            </div>
                            <div class='form-group-icon mb15'>
                                <i class='fa fa-user'></i>
                                <input type="text" name="user_name" class='form-control' placeholder="Name">
                            </div>
                            <div class='form-group-icon mb15'>
                                <i class='fa fa-envelope'></i>
                                <input type="email" name="user_email" class='form-control' placeholder="E-mail">
                            </div>
                            <div class='form-group-icon mb15'>
                                <i class='fa fa-lock'></i>
                                <input type="password" name="user_password" class='form-control' placeholder="Password">
                            </div>
                            <div class='form-group-icon mb15'>
                                <i class='fa fa-refresh'></i>
                                <input type="password" name="user_password2" class='form-control' placeholder="Confirm Password">
                            </div>
                            <div class="checkbox">
                                <input type="checkbox" id="tm">
                                 <label for="tm">
                                    Accept Terms & Conditions
                                </label>
                            </div>
                            <input type="submit" value="SignUp" class='btn btn-primary btn-lg btn-block'>
                        </form>
                    </div>
                </div>
            </div>
        </div>

