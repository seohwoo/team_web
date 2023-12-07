package test.spring.mvc;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import test.spring.mvc.bean.SampleDTO;
import test.spring.mvc.service.SampleServiceImpl;

/**
 * form.jsp -> main.jsp로 parameter를 보내는 클래스
 * */
@Controller
@RequestMapping("1120/*") //해당 클래스의 모든 매핑 적용
public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@Autowired
	private SampleServiceImpl service;
	
	@RequestMapping("tx")
	public @ResponseBody String tx() {
		service.add("HELLO WORLD");
		return "transaction success!!";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("main.do")
	public String main(
			SampleDTO dto, 
			@RequestParam("name") String a, //이름이 다를 경우 @RequestParam("파라미터명")으로 지정해 줄 수 있다.
			@RequestParam("number") int b,
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
	  public @ResponseBody String test2() {//@ResponseBody : jsp로 가는 것이 아니라 리턴값을 바로 보여쥼 
		  return "why can't use korean??";
	  }
	 
	
	//public String main2(@RequestParam("name") ArrayList<String> name) {//같은 이름으로 된 파라미터는 ArrayList로 받을 수 있다.
	@RequestMapping("main2.do")
	public String main2(@RequestParam("name") String[] names) {
		logger.info("parameter list --->"+names);
		for (String name : names) {
			logger.info("parameter list --->"+name);
		}
		return "1120/main";
	}
	
	//@ModelAttribute("name") : Model > @RequestParam("name") String a > model.addAttribute("a", a);
	@RequestMapping("main3.do")
	public String main3(
			@ModelAttribute("name") String name, 
			@ModelAttribute("number") int number) {
		return "1120/main";
	}
	
	@RequestMapping("main4.do")
	public void main4() {
		// 1120/main4.do -> 1120/main4.jsp
	}
	
	//addFlashAttribute : 한번 보내면 다시 사용 불가능
	@RequestMapping("test2.do")
	public String main5(RedirectAttributes rttr) {
		rttr.addFlashAttribute("msg", "Hello World");
		return "redirect:/1120/test3.do";	//view로 이동하지 않고 다른 controller를 다시 실행
	}
	
	@RequestMapping("test3.do")
	public String main6() {
		return "1120/main";	
	}
	
	@RequestMapping("upload.do")
	public @ResponseBody String upload(MultipartFile save) {
		String fileName = save.getOriginalFilename();	//파일명
		long size = save.getSize();						//파일크기
		return fileName + " : " + size;
	}
}

