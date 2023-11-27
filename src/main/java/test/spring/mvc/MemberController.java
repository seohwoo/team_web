package test.spring.mvc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import test.spring.mvc.bean.GradeDTO;
import test.spring.mvc.bean.MemberDTO;
import test.spring.mvc.service.MemberService;

@Controller
@RequestMapping("/user/*")
public class MemberController {
	
	@Autowired
	private MemberService memberServiceImpl;
	
	
	@RequestMapping("main.me")
	public String main(HttpSession session, Model model) {
		String id = "";
		int admin = 1;
		if(session.getAttribute("memId") != null) {
			id = (String) session.getAttribute("memId");
			admin = memberServiceImpl.isAdmin(id);
		}
		model.addAttribute("admin", admin);
		return "member/main";
	}
	
	@RequestMapping("loginPro.me")
	public String loginPro(MemberDTO dto, Model model) {
		int check = memberServiceImpl.loginCheck(dto);
		model.addAttribute("check", check);
		return "member/loginPro";
	}
	
	@RequestMapping("logout.me")
	public String logout(HttpSession session) {
		session.invalidate();			//  전체 삭제
		//session.removeAttribute("memId"); 해당 세션 삭제
		return "redirect:/user/main.me";
	}
	
	@RequestMapping("modify.me")
	public String modify(HttpSession session, Model model) {
		String id = (String) session.getAttribute("memId");
		MemberDTO dto =  memberServiceImpl.getUser(id);
		model.addAttribute("dto", dto);
		return "member/modify";
	}
	
	@RequestMapping("modifyForm.me")
	public String modifyForm(HttpSession session, Model model) {
		String id = (String) session.getAttribute("memId");
		MemberDTO dto =  memberServiceImpl.getUser(id);
		model.addAttribute("dto", dto);
		return "member/modifyForm";
	}
	
	@RequestMapping("modifyPro.me")
	public String modifyPro(HttpSession session,MemberDTO dto, Model model) {
		String id = (String) session.getAttribute("memId");
		dto.setId(id);
		memberServiceImpl.userUpdate(dto);
		return "member/modifyPro";
	}
	
	@RequestMapping("uploadForm.me")
	public String uploadForm() {
		return "member/uploadForm";
	}
	
	@RequestMapping("uploadPro.me")
	public String uploadPro(HttpSession session, HttpServletRequest request, MultipartFile upload) {
		String id = (String) session.getAttribute("memId");
		String img = upload.getOriginalFilename();
		String filePath = request.getServletContext().getRealPath("/resources/file/user/");
		if(upload.getContentType().split("/")[0].equals("image")) {
			File copy = new File(filePath + img);	
			try {
				upload.transferTo(copy);
				memberServiceImpl.changeImg(id, img); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/user/modify.me";
	}
	
	@RequestMapping("deleteForm.me")
	public String deleteForm() {
		return "member/deleteForm";
	}
	
	@RequestMapping("deletePro.me")
	public String deletePro(Model model, String passwd, HttpSession session) {
		String id = (String) session.getAttribute("memId");
		int check = memberServiceImpl.userDelete(id, passwd);
		if(check == 1) session.invalidate();
		model.addAttribute("check", check);
		return "member/deletePro";
	}
	
	@RequestMapping("adminShowUsers.me")
	public String adminShowUsers(Model model) {
		List<MemberDTO> userList = memberServiceImpl.showAll();
		List<GradeDTO> gradeList = memberServiceImpl.allStatus();
		model.addAttribute("userList", userList);
		model.addAttribute("gradeList", gradeList);
		return "member/adminShowUsers";
	}
	
	@RequestMapping("adminModifyUsersForm.me")
	public String adminModifyUsersForm( String id, Model model) {
		List<GradeDTO> list = memberServiceImpl.allStatus();
		model.addAttribute("gradeList", list);
		model.addAttribute("id", id);
		return "member/adminModifyUsersForm";
	}
	
	@RequestMapping("adminModifyUsersPro.me")
	public String adminModifyUsersPro(MemberDTO dto, Model model) {
		memberServiceImpl.changeStatus(dto);
		String statusname = memberServiceImpl.userStatus(dto.getStatus());
		model.addAttribute("statusname", statusname);
		model.addAttribute("id", dto.getId());
		return "member/adminModifyUsersPro";
	}
	
}
