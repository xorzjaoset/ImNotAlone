/*package tets;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


//데이터 검색에 사용되는 컨트롤러

//@Controller
public class SearchListController {

   @Autowired
   private ListService listService;
   
   @RequestMapping("/main/list/list.do")
   public ModelAndView intoListPage(
         @Valid SearchDTO searchDto, @RequestParam(defaultValue="1") int page, 
         @RequestParam(defaultValue="", value="search", required=false) String search, 
         @RequestParam(defaultValue="-1", value="searchn", required=false) int searchn,
         @RequestParam(defaultValue="-1", value="maxSal", required=false) int maxSal,
         @RequestParam(defaultValue="-1", value="minSal", required=false) int minSal,
         @RequestParam(defaultValue="-1", value="sortValue", required=false) int sortValue,
         @RequestParam(defaultValue="-1", value="cate_nm", required=false) int cate_nm,
         @RequestParam(defaultValue="-1", value="floor_no", required=false) int floor_no) {
      ModelAndView mav = new ModelAndView();
      
      // 음식 , 가게명, 층별
      String[] search_1 = {"store_info", "store_nm"};
      String[] search_2 = { "'한식'", "'양식'", "'중식'", "'일식'" };
      String[] search_3 = { "avg_price", "avg_price", "preference", "avl_tbl_cnt" };
      
      // search 와 searchn 의 null 값처리 시작
      System.out.println("======== 파라미터값 출력 ========");
      System.out.println("page 값 :"+page);
      System.out.println("search 값 :"+search);
      System.out.println("searchn 값 :"+searchn);
      System.out.println("maxSal 값 :"+maxSal);
      System.out.println("minSal 값 :"+minSal);
      System.out.println("sortValue 값 :"+sortValue);
      System.out.println("cate_nm 값 :"+cate_nm);
      System.out.println("floor_no 값 :"+floor_no);
      System.out.println("=============================");
      
      if(search=="" || searchn==0) {
         search = "";
         searchn = 0;
      }
      
      // search 와 searchn 의 null 값처리 끝
      
      searchDto.setSearch(search);
      searchDto.setSearchn(searchn);
      searchDto.setSortValue(sortValue);
      searchDto.setMinSal(minSal);
      searchDto.setMaxSal(maxSal);
      searchDto.setCate_nm(cate_nm);
      searchDto.setFloor_no(floor_no);
      
      // 검색어 쿼리
      searchDto.setSearch_1(search_1);
      searchDto.setSearch_2(search_2);
      searchDto.setSearch_3(search_3);
      
      총 페이지 연산
      int pageSize = 10;
      // getDetailList() 에 넣을 파라미터 필요함 ( 검색어가 들어가야함 )
      int detailListCount = listService.getDetailListCount(searchDto).get(0);
      System.out.println("검색데이터 개수:"+detailListCount);
      int maxPage =0;
      if(detailListCount%pageSize >0) {
         maxPage = detailListCount/pageSize +1; 
      }else {
         maxPage = detailListCount/pageSize;
      }
      
      해당 페이지 게시판 리스트 연산
      if(page==0) {
         page = 1;
      }
      
      int startListIndex = (page -1)* pageSize;      
      int endListIndex = 0;
      if(page * 10 >detailListCount) {
         endListIndex = detailListCount;
      }else {
         endListIndex = page * pageSize;
      }
      
      페이징 번호 연산
      int pageRange = 5;
      int startPage = ((page-1)/pageRange + 1)* pageRange - (pageRange - 1);
      int endPage = ((page-1)/pageRange + 1) * pageRange; 
      if(endPage > maxPage) {      
         endPage = maxPage;
      }
      
      List<ListCommand> detailListInPage = new ArrayList<ListCommand>();
      for(int i=startListIndex;i<endListIndex;i++) {
         detailListInPage.add(listService.getDetailList(searchDto).get(i));
      }
      
      mav.setViewName("main/list/list");
      mav.addObject("storeListInPage", detailListInPage); // 데이터자체는 main 호출했을때와 다름
      mav.addObject("detailListCount", detailListCount);
      mav.addObject("searchDto", searchDto);
      mav.addObject("maxPage", maxPage);
      mav.addObject("startPage", startPage);
      mav.addObject("endPage", endPage);
      
      // 검색파라미터값 페이징처리때 url요청하는부분에 사용하기위함
      // searchDto 에 모든값이 담겨있으므로 ${searchDto.getxxx()} 로 사용가능하기에 필요없음
      mav.addObject("search", search);
      mav.addObject("searchn", searchn);
      mav.addObject("sortValue", sortValue);
      mav.addObject("minSal", minSal);
      mav.addObject("maxSal", maxSal);
      mav.addObject("cate_nm", cate_nm);
      mav.addObject("floor_no", floor_no);
      
      mav.addObject("search_1", search_1);
      mav.addObject("search_2", search_2);
      mav.addObject("search_3", search_3);
      
      return mav;
      return "main/list/list";
   }
}*/