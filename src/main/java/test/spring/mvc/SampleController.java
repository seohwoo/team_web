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
 * form.jsp -> main.jsp�� parameter�� ������ Ŭ����
 * */
@Controller
@RequestMapping("1120/*") //�ش� Ŭ������ ��� ���� ����
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
			@RequestParam("name") String a, //�̸��� �ٸ� ��� @RequestParam("�Ķ���͸�")���� ������ �� �� �ִ�.
			@RequestParam("number") int b,
			Model model, HttpSession session) {
		//dto�� ���� ���� �ڵ����� views�� ���޵ȴ�
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
	  public @ResponseBody String test2() {//@ResponseBody : jsp�� ���� ���� �ƴ϶� ���ϰ��� �ٷ� ������ 
		  return "why can't use korean??";
	  }
	 
	
	//public String main2(@RequestParam("name") ArrayList<String> name) {//���� �̸����� �� �Ķ���ʹ� ArrayList�� ���� �� �ִ�.
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
	
	//addFlashAttribute : �ѹ� ������ �ٽ� ��� �Ұ���
	@RequestMapping("test2.do")
	public String main5(RedirectAttributes rttr) {
		rttr.addFlashAttribute("msg", "Hello World");
		return "redirect:/1120/test3.do";	//view�� �̵����� �ʰ� �ٸ� controller�� �ٽ� ����
	}
	
	@RequestMapping("test3.do")
	public String main6() {
		return "1120/main";	
	}
	
	@RequestMapping("upload.do")
	public @ResponseBody String upload(MultipartFile save) {
		String fileName = save.getOriginalFilename();	//���ϸ�
		long size = save.getSize();						//����ũ��
		return fileName + " : " + size;
	}
}

