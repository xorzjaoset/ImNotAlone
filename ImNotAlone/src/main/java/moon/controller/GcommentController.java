package moon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GcommentController {

	@RequestMapping(value="/moon/comment11",method=RequestMethod.GET)
	public String commentForm() {
		
		return "commentForm";
	}
}
