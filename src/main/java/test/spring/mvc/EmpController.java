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
import test.spring.mvc.service.CrudService;
import test.spring.mvc.service.EmpServiceImpl;

@Controller
@RequestMapping("/emp/*")
public class EmpController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);

	@Autowired
	private CrudService emp;
	@Autowired	
	private CrudService free;
	
}














