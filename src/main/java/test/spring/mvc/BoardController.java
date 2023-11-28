package test.spring.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import test.spring.mvc.bean.BoardDTO;
import test.spring.mvc.service.BoardService;

@Controller
@RequestMapping("/free/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService service;
	
	// required = true 유효성 검사(필수항목)
	@RequestMapping("list")
	public String list(Model model, @RequestParam(value="pageNum", /*required = true,*/ defaultValue = "1") int pageNum) {
		service.list(pageNum, model);
		
		return "board/list";
	}
	
	@RequestMapping("writeForm")
	public String writeForm(Model model,
			@RequestParam(value="num",defaultValue = "0") int num,
			@RequestParam(value="ref",defaultValue = "1") int ref,
			@RequestParam(value="re_step",defaultValue = "0") int re_step,
			@RequestParam(value="re_level",defaultValue = "0") int re_level) {
		
		model.addAttribute("num",num);
		model.addAttribute("ref",ref);
		model.addAttribute("re_step",re_step);
		model.addAttribute("re_level",re_level);
		return "board/writeForm";
	}
	
	@RequestMapping("writePro")
	public String writePro(ArrayList<MultipartFile> files, BoardDTO dto, HttpServletRequest request) {
		int isfile = 0;
		for(MultipartFile f : files) {
			if(!f.getOriginalFilename().equals("")) {
				isfile++;
			}
		}
		dto.setIsfile(isfile);
		dto.setIp(request.getRemoteAddr());
		service.create(dto);
		return "redirect:/free/list";
	}
	
	@RequestMapping("content")
	public String content(Model model, int num, int pageNum) {
		BoardDTO article = service.readContent(num);
		
		model.addAttribute("article",article);
		model.addAttribute("pageNum",pageNum);
		
		return "board/content";
	}
	
	@RequestMapping("updateForm")
	public String updateForm(Model model, int num, int pageNum) {
		BoardDTO article = service.update(num);
		
		model.addAttribute("article",article);
		model.addAttribute("pageNum",pageNum);
		
		return "board/updateForm";
	}
	
	// Model model 쓰는 이유 : 컨트롤러에서 작업한 내용을 뷰로 보낼 때 사용
	// 없는거는 따로 선언해주면 됨 int pageNum처럼 
	@RequestMapping("updatePro")
	public String updatePro(Model model, BoardDTO dto, int pageNum) {
		int check = service.updateNum(dto);
		
		model.addAttribute("check", check);
		model.addAttribute("pageNum", pageNum);
		
		return "board/updatePro";
	}
	
	@RequestMapping("deleteForm")
	public String deleteForm(Model model, int num, int pageNum) {
		
		
		model.addAttribute("num", num);
		model.addAttribute("pageNum", pageNum);
		
		return "board/deleteForm";
	}
	
	@RequestMapping("deletePro")
	public String deletePro(Model model, int num, String passwd, int pageNum) {
		int check = service.deleteNum(num, passwd);
		
		model.addAttribute("check", check);
		model.addAttribute("pageNum", pageNum);
		
		return "board/deletePro";
	}
	
}
