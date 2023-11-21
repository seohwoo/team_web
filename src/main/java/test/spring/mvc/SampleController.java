package test.spring.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import test.spring.mvc.bean.SampleDTO;

@Controller
@RequestMapping("/1120/*") // 로 쓰면 /1120/ 이 깔려있음
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	@RequestMapping("main.do")
	public String main(SampleDTO dto, // sampleDTO로 활용 (앞에 소문자로 해야함)
		@RequestParam("name") String a ,
		@RequestParam("number") int b , Model model , HttpSession session) {
		
		// request.setAttribute()
		model.addAttribute("dto", dto); // dto.number로 활용
		
		// HttpSession session = request.getSession();
		
		// String name = request.getParameter("name");
		// String number = request.getParameter("number");
		logger.info("parameter->name==="+a);
		logger.info("parameter->number==="+b);
		logger.info("parameter->name==="+dto.getName());
		logger.info("parameter->number==="+dto.getNumber());
		
		return "1120/main";
	}
	
	// properties 를 따로 쓰지않고 Mapping에 씀
	@RequestMapping("form.do")
	public String test() {
		return "1120/form";
	}
	
	// ResponseBody로 쓰면 return 에 쓴 글자가 페이지에 바로 나옴
	@RequestMapping("test.do")
	public @ResponseBody String test2() {
		return "direct page";
	}
	
	
}
