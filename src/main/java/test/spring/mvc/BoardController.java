package test.spring.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.spring.mvc.bean.BoardDTO;
import test.spring.mvc.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("read.do")
	public String read(Model model) {
		List<BoardDTO> list = service.read();
		model.addAttribute("boardList", list);
		return "board/read"; 
	}
	
	@RequestMapping("insert.do")
	public @ResponseBody String insert(Model model, BoardDTO dto) {
		int i = service.create(dto);
		return "insert board table +" + i; 
	}
	
	@RequestMapping("form.do")
	public String form() {
		return "board/form";
	}
	
	
}
