package test.spring.mvc;

import java.io.File;
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
import org.springframework.web.servlet.ModelAndView;

import test.spring.mvc.bean.BoardDTO;
import test.spring.mvc.bean.BoardFileDTO;
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
	public String writePro(ArrayList<MultipartFile> files, BoardDTO dto, HttpServletRequest request) {
		int isfile = 0;
		int result = 0;
		for (MultipartFile file : files) {
			if(!file.getOriginalFilename().equals("")) {
				isfile++;
			}
		}
		dto.setIsfile(isfile);
		dto.setIp(request.getRemoteAddr());	//IP ют╥б
		boardServiceImpl.create(dto);
		if(isfile>0) {
			String path = request.getServletContext().getRealPath("/resources/file/board/");
			result = boardServiceImpl.fileUpload(files, path);
		}
		return "redirect:/free/list";
	}
	
	@RequestMapping("content")
	public String content(Model model, int num, int pageNum) {
		BoardDTO dto = boardServiceImpl.readContent(num);
		List<BoardFileDTO> imgList = boardServiceImpl.findImg(num);
		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("imgList", imgList);
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
	public String deletePro(HttpServletRequest request, Model model, int num, String passwd, int pageNum) {
		int check = 0;
		List<BoardFileDTO> list = boardServiceImpl.findImg(num);
		String path = request.getServletContext().getRealPath("/resources/file/board/");
		if(list != null) {
			for (BoardFileDTO dto : list) {
				File file = new File(path+dto.getFilename());
				if(file.isFile()) {
					file.delete();
				}
			}
		}
		check = boardServiceImpl.deleteArticle(num, passwd);
		model.addAttribute("check", check);
		model.addAttribute("pageNum", pageNum);
		return "/board/deletePro";
	}
	
	@RequestMapping("download")
	   public ModelAndView download(HttpServletRequest request, String filename) {
	      String filePath = request.getServletContext().getRealPath("/resources/file/board/");
	      File file = new File(filePath+filename);
	      ModelAndView mv = new ModelAndView("downView","downFile",file);
	      
	      return mv;
	   }
	
}
