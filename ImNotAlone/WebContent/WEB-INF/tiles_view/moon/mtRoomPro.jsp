<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <div class="page-bread mb70">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <h3>매칭인원 정보</h3>
                    </div>
                    <div class="col-sm-6">

                    </div>
                </div>
            </div>
        </div>

        <div class="">
            <div class="container">
                <div class="row">
                    <div class="col-md-9 mb40">
                        <div class="row mb30">
                            <div class="col-sm-4 mb40">
                                <img src="${pageContext.request.contextPath}/upload/${mtPro.mp_pn}" alt="" class="img-responsive img-thumbnail">
                            </div>
                            <div class="col-sm-8 mb40">
                                <h2 class="font300">${mtPro.mp_name}</h2>
                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam facilisis aliquam finibus. Nullam at ante et nulla vehicula euismod ut eget urna.
                                </p>
                                <p><strong>Phone:</strong>${mtPro.mp_phone}</p>
                                <p><strong>Job:</strong>${mtPro.mp_job}</p>
                                <p class="social-inline"><strong>Social:</strong>
                                <a href="#"><i class="fa fa-facebook-square"></i></a>
                                <a href="#"><i class="fa fa-twitter-square"></i></a>
                                <a href="#"><i class="fa fa-linkedin-square"></i></a>
                                </p>
                            </div>
                        </div>
                        <h2 class="left-title"></h2>
                        <div class="row">
                </div>
                        <div class="row">
                </div>
                        <div class="text-right mb30">
                            <nav aria-label="Page navigation">
                                <ul class="pagination">
                                    <li>
                                        <a href="#" aria-label="Previous">
                                            <span aria-hidden="true">«</span>
                                        </a>
                                    </li>
                                    <li class="active"><a href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#">5</a></li>
                                    <li>
                                        <a href="#" aria-label="Next">
                                            <span aria-hidden="true">»</span>
                                        </a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div><!--/col-->
                    <div class="col-md-3 mb60">
                        <h4 class="left-title mb20">Popular Tags</h4>
                        <ul class="list-inline tags-list">
                            <li><a href="#"><i class="fa fa-tag"></i> Shop</a></li>
                            <li><a href="#"><i class="fa fa-tag"></i> Beer</a></li>
                            <li><a href="#"><i class="fa fa-tag"></i> Beach</a></li>
                            <li><a href="#"><i class="fa fa-tag"></i> Cinemas</a></li>
                            <li><a href="#"><i class="fa fa-tag"></i> Hotel</a></li>
                            <li><a href="#"><i class="fa fa-tag"></i> Dinner</a></li>
                            <li><a href="#"><i class="fa fa-tag"></i> Lunch</a></li>
                            <li><a href="#"><i class="fa fa-tag"></i> Taxi</a></li>
                            <li><a href="#"><i class="fa fa-tag"></i> Bar & pubs</a></li>
                            <li><a href="#"><i class="fa fa-tag"></i> Games</a></li>
                            <li><a href="#"><i class="fa fa-tag"></i> Tickets</a></li>
                        </ul>
                        <div>
                        <input type="submit" class="btn btn-primary btn-lg" value="수락">
                        <input type="submit" class="btn btn-primary btn-lg" value="Submit">
                        </div>
                        
                        
                    </div>
                </div>
            </div>
        </div>

        <!-- jQuery-->
        <script src="js/plugins/all.js"></script>
        <script src="js/finder.custom.js"></script>
    </body>
</html>