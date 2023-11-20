package test.spring.mvc;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import test.spring.mvc.bean.SampleDTO;

/**
 * form.jsp -> main.jsp로 parameter를 보내는 클래스
 * */
@Controller
@RequestMapping("1120/*") //해당 클래스의 모든 매핑 적용
public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("main.do")
	public String main(
			SampleDTO dto, 
			@RequestParam("name")String a, 
			@RequestParam("number")int b,
			Model model, HttpSession session) {
		//dto로 받은 값은 자동으로 views로 전달된다
		dto.setDay(new Date());
		
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("dto", dto);
		
		logger.info("parameter -> name === " + dto.getName());
		logger.info("parameter -> number === " + dto.getNumber());
		logger.info("parameter -> day === " + dto.getDay());
		logger.info("parameter -> a === " + a);
		logger.info("parameter -> b === " + b);
		return "1120/main";
	}
	
	@RequestMapping("form.do")
	public String form() {
		return "1120/form";
	}
	
	@RequestMapping("test.do")
	public @ResponseBody String test2() {
		//@ResponseBody : jsp로 가는 것이 아니라 리턴값을 바로 보여쥼
		return "why can't use korean??";
	}
	
}
