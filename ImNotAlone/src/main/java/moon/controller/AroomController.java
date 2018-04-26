package moon.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import moon.dto.ProfileDTO;
import moon.dto.roomUpDTO;
import moon.service.ProfileService;
import net.sf.json.JSONObject;

@Controller
public class AroomController {

	@Autowired
	ProfileService service;

	@ModelAttribute(value = "basic")
	public String keyForm(String string) {

		if (string == null) {

		}

		return string;
	}

	@RequestMapping(value = "/moon/around", method = RequestMethod.GET)
	public String aroundForm() {
		
		return "aroundRoom";
	}

	@RequestMapping(value = "/moon/around4", method = RequestMethod.POST)
	public ModelAndView searchForm(@RequestParam String string,HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		if (string.equals("하우스메이트") || string == "하우스메이트") {
			List<roomUpDTO> a = service.getRmate(string);
			mv.addObject("share", a);
			mv.setViewName("aroundRoom");

		} else if (string.equals("쉐어하우스") || string == "쉐어하우스") {
			List<roomUpDTO> a = service.getShare(string);
			mv.addObject("share", a);
			mv.setViewName("aroundRoom");

		} else if (string.equals("오피스텔") || string == "오피스텔") {

			List<roomUpDTO> a = service.getOffice(string);
			mv.addObject("share", a);
			mv.setViewName("aroundRoom");

		} else if (string.equals("원룸/투룸") || string == "원룸/투룸") {
			List<roomUpDTO> a = service.getOther(string);
			mv.addObject("share", a);
			mv.setViewName("aroundRoom");

		}
		return mv;

	}
	
	
	@RequestMapping(value = "/moon/roomfilter", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String filterForm(HttpServletResponse resp, @RequestParam("fnum") String fnum,
			@RequestParam("snum") String snum) throws Exception {
		JSONObject jso = new JSONObject();
		
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("snum", snum);
		map.put("fnum", fnum);
		
		if (fnum.equals("1") || fnum == "1") {
			if (snum.equals("1") || snum == "1") {
				List<ProfileDTO> a = service.getShare1(map);
				jso.put("data1",a);
								
			} else if (snum.equals("2") || snum == "2") {
				List<ProfileDTO> a = service.getShare2(map);
				jso.put("data1",a);
				
			} else if (snum.equals("3") || snum == "3") {

			}else if(snum.equals("4")|| snum =="4") {
				
			}
		} else if (fnum.equals("2") || fnum == "2") {
			if (snum.equals("1") || snum == "1") {
				List<ProfileDTO>a = service.getShare5(map);
				jso.put("data1", a);
				
			} else if (snum.equals("2") || snum == "2") {
				List<ProfileDTO>a = service.getShare6(map);
				jso.put("data1", a);

			} else if (snum.equals("3") || snum == "3") {

			}
		} else if (fnum.equals("3") || fnum == "3") {
			
			if (snum.equals("1") || snum == "1") {

			} else if (snum.equals("2") || snum == "2") {

			} else if (snum.equals("3") || snum == "3") {

			}
		} else if (fnum.equals("4") || fnum == "4") {
			
			if (snum.equals("1") || snum == "1") {

			} else if (snum.equals("2") || snum == "2") {

			} else if (snum.equals("3") || snum == "3") {

			}

		}

		resp.setContentType("text/html; charset=UTF-8");
		System.out.println(jso.toString());
		return jso.toString();
	}

}
