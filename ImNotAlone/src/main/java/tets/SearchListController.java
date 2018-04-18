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


//������ �˻��� ���Ǵ� ��Ʈ�ѷ�

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
      
      // ���� , ���Ը�, ����
      String[] search_1 = {"store_info", "store_nm"};
      String[] search_2 = { "'�ѽ�'", "'���'", "'�߽�'", "'�Ͻ�'" };
      String[] search_3 = { "avg_price", "avg_price", "preference", "avl_tbl_cnt" };
      
      // search �� searchn �� null ��ó�� ����
      System.out.println("======== �Ķ���Ͱ� ��� ========");
      System.out.println("page �� :"+page);
      System.out.println("search �� :"+search);
      System.out.println("searchn �� :"+searchn);
      System.out.println("maxSal �� :"+maxSal);
      System.out.println("minSal �� :"+minSal);
      System.out.println("sortValue �� :"+sortValue);
      System.out.println("cate_nm �� :"+cate_nm);
      System.out.println("floor_no �� :"+floor_no);
      System.out.println("=============================");
      
      if(search=="" || searchn==0) {
         search = "";
         searchn = 0;
      }
      
      // search �� searchn �� null ��ó�� ��
      
      searchDto.setSearch(search);
      searchDto.setSearchn(searchn);
      searchDto.setSortValue(sortValue);
      searchDto.setMinSal(minSal);
      searchDto.setMaxSal(maxSal);
      searchDto.setCate_nm(cate_nm);
      searchDto.setFloor_no(floor_no);
      
      // �˻��� ����
      searchDto.setSearch_1(search_1);
      searchDto.setSearch_2(search_2);
      searchDto.setSearch_3(search_3);
      
      �� ������ ����
      int pageSize = 10;
      // getDetailList() �� ���� �Ķ���� �ʿ��� ( �˻�� ������ )
      int detailListCount = listService.getDetailListCount(searchDto).get(0);
      System.out.println("�˻������� ����:"+detailListCount);
      int maxPage =0;
      if(detailListCount%pageSize >0) {
         maxPage = detailListCount/pageSize +1; 
      }else {
         maxPage = detailListCount/pageSize;
      }
      
      �ش� ������ �Խ��� ����Ʈ ����
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
      
      ����¡ ��ȣ ����
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
      mav.addObject("storeListInPage", detailListInPage); // ��������ü�� main ȣ���������� �ٸ�
      mav.addObject("detailListCount", detailListCount);
      mav.addObject("searchDto", searchDto);
      mav.addObject("maxPage", maxPage);
      mav.addObject("startPage", startPage);
      mav.addObject("endPage", endPage);
      
      // �˻��Ķ���Ͱ� ����¡ó���� url��û�ϴºκп� ����ϱ�����
      // searchDto �� ��簪�� ��������Ƿ� ${searchDto.getxxx()} �� ��밡���ϱ⿡ �ʿ����
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