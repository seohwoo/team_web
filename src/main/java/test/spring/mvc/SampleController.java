package test.spring.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import test.spring.mvc.bean.SampleDTO;

@Controller
@RequestMapping("/1120/*") // �� ���� /1120/ �� �������
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	@RequestMapping("main.do")
	public String main(SampleDTO dto, // sampleDTO�� Ȱ�� (�տ� �ҹ��ڷ� �ؾ���)
		@RequestParam("name") String a ,
		@RequestParam("number") int b , Model model , HttpSession session) {
		
		// request.setAttribute()
		model.addAttribute("dto", dto); // dto.number�� Ȱ��
		
		// HttpSession session = request.getSession();
		
		// String name = request.getParameter("name");
		// String number = request.getParameter("number");
		logger.info("parameter->name==="+a);
		logger.info("parameter->number==="+b);
		logger.info("parameter->name==="+dto.getName());
		logger.info("parameter->number==="+dto.getNumber());
		
		return "1120/main";
	}
	
	// properties �� ���� �����ʰ� Mapping�� ��
	@RequestMapping("form.do")
	public String test() {
		return "1120/form";
	}
	
	// ResponseBody�� ���� return �� �� ���ڰ� �������� �ٷ� ����
	@RequestMapping("test.do")
	public @ResponseBody String test2() {
		return "direct page";
	}
	/*
	@RequestMapping("main2.do")
	public String main2(@RequestParam("name") ArrayList<String> name) {
		logger.info("parameter list--->==="+name);
		return "1120/main";
	}
	*/
	@RequestMapping("main2.do")
	public String main2(@RequestParam("name") String [] name) {
		logger.info("parameter list--->==="+name);
		logger.info("parameter list--->==="+name[0]);
		logger.info("parameter list--->==="+name[1]);
		return "1120/main";
	}
	
	
	/*
	 *  Ex1)
	@RequestMapping("main3.do")
	public String main2(SampleDTO dto) {
		
		return "1120/main";
	}
	*/
	
		// Ex2)
	@RequestMapping("main3.do")
	public String main2(Model model,
			@ModelAttribute("name") String name ,
			@ModelAttribute("number") int number) {
			
		model.addAttribute("name", name);
		return "1120/main";
	}
	/*
		// Ex3) ���� ����
	@RequestMapping("test2.do")
	public String main5(Model model) {
		model.addAttribute("msg","helloworld");
		return "redirect:/1120/test3.do"; // �������� �Ѿ�� �ʰ� ��Ʈ�ѷ� ����
	}
	*/
		// Ex3) ���� ����
	@RequestMapping("test2.do")
	public String main5(RedirectAttributes rttr) {
		rttr.addFlashAttribute("msg","helloworld");
		return "redirect:/1120/test3.do";
	}
	
	/*
		// Ex3-1)
	@RequestMapping("test3.do")
	public String main6(String msg , Model model) {
		model.addAttribute("msg", msg);
		return "/1120/main"; 
	}
	*/
		// Ex3-1)
	@RequestMapping("test3.do")
	public String main6() {
		return "1120/main";
	}
	
	
		// Ex4) ���� ���ε�
	@RequestMapping("upload.do")
	public @ResponseBody String upload(MultipartFile save) {
		String fileName = save.getOriginalFilename(); // ���ϸ�
		long size = save.getSize(); // ����ũ��
		
		return fileName+" : "+size;
	}
}





