  <%@ page contentType = "text/html; charset=UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!--fullscreen image-->
        <div class="hero-form bg-parallax parallax-overlay"  data-jarallax='{"speed": 0.2}' style='background-image: url(/ImNotAlone/resources/images/main_image01.jpg)'>
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-sm-7">
                        <c:if test="${member.user_name ne null}">
                        <h1>${member.user_name}님 환영합니다!</h1>
                        </c:if>
                        <c:if test="${member.user_name eq null}">
                        <h1>안녕하세요.<br>로그인 하시면 더 많은<br>혜택이 있습니다!</h1>
                        </c:if>
                        <p class="mb20">Create your own directory website with finder that included modern features for directory websites</p>                           
                        <div class="hero-buttons">
                            <a href="#" class="btn btn-lg btn-white">Learn More</a>
                            <a href="#" class="btn btn-lg btn-danger">Browse Listing</a>
                        </div>
                    </div>
                    <div class="col-md-4 col-md-offset-1 col-sm-5">
                        <div class="hero-search-form">
                            <h3>Search Locations
                            </h3>
                            <hr>
                            <form>
                                <div class="form-hero-group mb15">
                                    <i class="fa fa-search"></i>
                                    <input type="text" class="form-control" placeholder="Keywords...">
                                </div>
                                <div class="form-hero-group mb15">
                                    <i class="fa fa-map-marker"></i>
                                    <select class="form-control" title="Location">                                       
                                        <option>Paris</option>
                                        <option>London</option>
                                        <option>New York</option>
                                        <option>Tokyo</option>
                                    </select>
                                </div>
                                 <div class="form-hero-group mb15">
                                    <i class="fa fa-folder"></i>
                                    <select class="form-control" title="Category">                                       
                                        <option>Restaurants</option>
                                        <option>Jobs</option>
                                        <option>Property</option>
                                        <option>Automotive</option>
                                    </select>
                                </div>
                                 <div class="form-hero-group mb15">
                                    <i class="fa fa-dollar"></i>
                                    <input type="text" class="form-control" placeholder="Min Price...">
                                </div>
                                 <div class="form-hero-group mb15">
                                    <i class="fa fa-dollar"></i>
                                    <input type="text" class="form-control" placeholder="Max Price...">
                                </div>
                                <input type="submit" class="btn btn-dark btn-lg btn-block" value="Search">
                            </form>
                        </div>
                     </div>
                </div>
            </div>
        </div>