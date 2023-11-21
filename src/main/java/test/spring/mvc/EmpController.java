package test.spring.mvc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.spring.mvc.bean.EmpDTO;
import test.spring.mvc.service.EmpServiceImpl;

@Controller
@RequestMapping("/emp/*")
public class EmpController {
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);

	
	@Autowired
	private EmpServiceImpl service;
	
	@RequestMapping("list.do")
	public String list(Model model) {
		List<EmpDTO> list = service.list();
		logger.info("select freemember=>>"+list);
		model.addAttribute("list", list);
		
		return "emp/list";
	}
	
	@RequestMapping("form.do")
	public String form() {
		return "emp/form";
	}
	
	@RequestMapping("insert.do")
	public @ResponseBody String result(Model model, EmpDTO dto) {
		int r = service.form(dto);
		logger.info("result"+r);
		
		return "°á°ú="+r;
	}
}
