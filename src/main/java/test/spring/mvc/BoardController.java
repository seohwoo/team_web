package test.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import test.spring.mvc.bean.BoardDTO;
import test.spring.mvc.service.BoardService;

@Controller
@RequestMapping("/free/*") 
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class); 
	
	@Autowired
	private BoardService boardServiceImpl;
	
	@RequestMapping("list")
	public String list(@RequestParam(value="pageNum", defaultValue="1") int pageNum, Model model) {
		boardServiceImpl.showList(pageNum, model);
		return "board/list";
	}
	
	@RequestMapping("writeForm")
	public String writeForm(Model model,
			@RequestParam(value="num", defaultValue = "0") int num,
			@RequestParam(value="ref", defaultValue = "1") int ref,
			@RequestParam(value="re_step", defaultValue = "0") int re_step,
			@RequestParam(value="re_level", defaultValue = "0") int re_level) {
		model.addAttribute("num", num);
		model.addAttribute("ref", ref);
		model.addAttribute("re_step", re_step);
		model.addAttribute("re_level", re_level);
		return "board/writeForm";
	}
	
	@RequestMapping("writePro")
	public String writePro(BoardDTO dto, HttpServletRequest request) {
		dto.setIp(request.getRemoteAddr());	//IP �Է�
		boardServiceImpl.create(dto);
		return "redirect:/free/list";
	}
	
	@RequestMapping("content")
	public String content(Model model, int num, int pageNum) {
		BoardDTO dto = boardServiceImpl.readContent(num);
		model.addAttribute("article", dto);
		model.addAttribute("pageNum", pageNum);
		return "/board/content";
	}
	
	@RequestMapping("updateForm")
	public String updateForm(Model model, int num, int pageNum) {
		BoardDTO dto = boardServiceImpl.update(num);
		model.addAttribute("article", dto);
		model.addAttribute("pageNum", pageNum);
		return "/board/updateForm";
	}
	
	@RequestMapping("updatePro")
	public String updatePro(Model model, BoardDTO dto, int pageNum) {
		int check = boardServiceImpl.updateArticle(dto);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("check", check);
		return "/board/updatePro";
	}
	
	@RequestMapping("deleteForm")
	public String deleteForm(Model model, int num, int pageNum) {
		model.addAttribute("num", num);
		model.addAttribute("pageNum", pageNum);
		return "/board/deleteForm";
	}
	
	@RequestMapping("deletePro")
	public String deletePro(Model model, int num, String passwd, int pageNum) {
		int check = boardServiceImpl.deleteArticle(num, passwd);
		model.addAttribute("check", check);
		model.addAttribute("pageNum", pageNum);
		return "/board/deletePro";
	}
	
}