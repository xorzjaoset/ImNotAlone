package moon.controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ho.dto.MemberDTO;
import moon.dto.ProfileDTO;
import moon.service.ProfileService;

@Controller
public class ProfileController implements ApplicationContextAware{
	Random random = new Random();

	private WebApplicationContext context = null;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
		
	}
	
	@Autowired
	ProfileService service;
	
	
	@RequestMapping(value="/moon/profile",method=RequestMethod.GET)
	public String aroundForm(@ModelAttribute ProfileDTO dto, HttpSession session, Model model) {

		MemberDTO member = (MemberDTO) session.getAttribute("member");
		model.addAttribute("dto",dto);
		String mp_id = member.getUser_id();
	
		
		int result = service.profilecheck(mp_id);
		
		if(result == 1) { //1일 경우 프로필이 등록되어 있는 상태이므로 수정페이지로 넘어간다.
			ProfileDTO dto1 = service.ProfileInfo(mp_id);
			System.out.println("프로필 등록되어 있는 상태입니다.");
			model.addAttribute("dto1",dto1);	
			return "profileCheck";
		
		}else{ // 아닌 경우 프로필 등록 페이지로 넘어감.
			dto.setMp_id(mp_id);
			String mp_name = member.getUser_name();
			dto.setMp_name(mp_name);

			return "insertProfile";

			
}

	}
	//프로필 등록
	@RequestMapping(value="/moon/profile1",method=RequestMethod.POST)
	public String insertForm(ProfileDTO dto,HttpSession session) {
	
		dto = makeFile(dto);
		service.insertProfile(dto);
		
		return "redirect:/share/main/mainView";
	}
	
	//프로필 수정
	@RequestMapping(value="/moon/profile2",method=RequestMethod.POST)
	public ModelAndView updateForm(ProfileDTO dto) {
		
		ModelAndView mv = new ModelAndView();
		service.updateProfile(dto);
		mv.addObject("content",dto);
		mv.setViewName("redirect:/share/main/mainView");
		
		return mv;
	}
	
	
	public ProfileDTO makeFile(ProfileDTO dto) {
		MultipartFile file = dto.getFile();
		long currentTime = System.currentTimeMillis();
		int randomValue = random.nextInt(50);
		String filename = Long.toString(currentTime)+"_"+Integer.toString(randomValue)+file.getOriginalFilename();
		String path = context.getServletContext().getRealPath("/uploadedFile");
		File newfile = new File(path+"/"+filename);
		dto.setMp_pn(filename);
		dto.setMp_pp(path);
		
		try {
			file.transferTo(newfile);
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return dto;
		
		
	}

	
	
	
}
