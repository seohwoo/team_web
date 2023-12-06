package test.spring.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.spring.mvc.bean.TestDTO;
import test.spring.mvc.service.TestServiceImpl;

@Controller
@RequestMapping("/jpa/*")
public class TestController {
	
	@Autowired
	private TestServiceImpl service;
	
	@RequestMapping("list")
	public  String list(Model model) {
		long count = service.testCount();
		List<TestDTO> list = service.testList();
		model.addAttribute("count" , count);
		model.addAttribute("list" , list);
		return "jpa/list";
	}
	
	@RequestMapping("form")
	public String form() {
		return "jpa/form";
	}
	
	@RequestMapping("insert")
	public String insert(TestDTO dto) {
		service.create(dto);
		return "redirect:/jpa/list";
	}
	
	@RequestMapping("delete")
	public String delete(TestDTO dto) {
		service.delete(dto);
		return "redirect:/jpa/list";
	}
}
