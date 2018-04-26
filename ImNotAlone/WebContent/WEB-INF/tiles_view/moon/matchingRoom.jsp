<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="listing-detail-header mb50">
</div>
<div class="container">
<div id="sortableTable" class="body collapse in">
<div class="col-sm-10 mb40">
            <table class="table table-bordered sortableTable responsive-table tablesorter tablesorter-default"
               role="grid">
               <thead>
                  <tr role="row" class="tablesorter-headerRow">
                     <th data-column="0"
                        class="tablesorter-header tablesorter-headerUnSorted"
                        tabindex="0" scope="col" role="columnheader"
                        aria-disabled="false" unselectable="on" aria-sort="none"
                        aria-label="#
                            
                          : No sort applied, activate to apply an ascending sort"
                        style="user-select: none;"><div
                           class="tablesorter-header-inner">
                           # <i class="fa sort"></i>
                        </div></th>
                     <th data-column="1"
                        class="tablesorter-header tablesorter-headerUnSorted"
                        tabindex="0" scope="col" role="columnheader"
                        aria-disabled="false" unselectable="on" aria-sort="none"
                        aria-label="First Name
                            
                          : No sort applied, activate to apply an ascending sort"
                        style="user-select: none;"><div
                           class="tablesorter-header-inner">ID<i class="fa sort"></i>
                        </div></th>
                         <th data-column="2"
                        class="tablesorter-header tablesorter-headerUnSorted"
                        tabindex="0" scope="col" role="columnheader"
                        aria-disabled="false" unselectable="on" aria-sort="none"
                        aria-label="First Name
                            
                          : No sort applied, activate to apply an ascending sort"
                        style="user-select: none;"><div
                           class="tablesorter-header-inner">
                           DATE <i class="fa sort"></i>
                        </div></th>
                  
                  </tr>
               </thead>
               <tb,ody aria-live="polite" aria-relevant="all">
               <c:forEach var="mtRoom" items="${mtRoom}">
	               <tr>
	               <td>${mtRoom.mt_no}</td>
	               <td><a href="/ImNotAlone/share/mtPro.do?mt_id=${mtRoom.mt_id}">${mtRoom.mt_id}</a></td>
                   <td>${mtRoom.mt_date}</td>
                  </tr>                
               </c:forEach>
               </tbody>
            </table>
         </div>
         </div>
            <ul class="pagination" style="position: relative; left: 125px;">
               <li><a href="#" aria-label="Previous"> <span
                     aria-hidden="true">«</span>
               </a></li>
               <li class="active"><a href="#">1</a></li>
               <li><a href="#">2</a></li>
               <li><a href="#">3</a></li>
               <li><a href="#">4</a></li>
               <li><a href="#">5</a></li>
               <li><a href="#" aria-label="Next"> <span
                     aria-hidden="true">»</span>
               </a></li>
            </ul>
         </div>