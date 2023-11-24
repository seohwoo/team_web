package test.spring.mvc;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import test.spring.mvc.bean.MemberDTO;
import test.spring.mvc.service.MemberService;
@Controller
@RequestMapping("/user/*")
public class MemberController {
	
	@Autowired
	private MemberService service; // 여러개일 땐 앞에 소문자로 memberserviceImpl 써주면 됨
	
	@RequestMapping("main.me")
	public String main() {
		return "member/main";
	}
	
	@RequestMapping("loginPro.me")
	public String loginPro(MemberDTO dto , Model model) {	
		int status = service.loginCheck(dto);
		model.addAttribute("status" , status);
		return "member/loginPro";
	}
	@RequestMapping("logout.me")
	public String logout(HttpSession session) {	
		session.invalidate();  // 전체 삭제
		//session.removeAttribute("memId"); // 해당 이름 삭제 
		return "redirect:/user/main.me";
	}
	
	@RequestMapping("modify.me")
	public String modify() {
		return "member/modify";
	}
	@RequestMapping("modifyForm.me")
	public String modifyForm(HttpSession session , Model model) {
		String id =(String)session.getAttribute("memId");
		MemberDTO dto = service.getUser(id);
		model.addAttribute("dto",dto);
		return "member/modifyForm";
	}
	
	@RequestMapping("modifyPro.me")
	public String modifyPro(HttpSession session,MemberDTO dto, Model model) {
		String id =(String)session.getAttribute("memId");
		dto.setId(id);
		service.userUpdate(dto);
		return "member/modifyPro";
	}
	
	@RequestMapping("deleteForm.me")
	public String deleteForm() {
		return "member/deleteForm";
	}
	
	@RequestMapping("deletePro.me")
	public String deletePro(Model model , String passwd , HttpSession session) {
		String id =(String)session.getAttribute("memId");
		int check = service.userDelete(id, passwd);
		if(check == 1) {
			session.invalidate();
		}
		model.addAttribute("check",check);
		return "member/deletePro";
	}
	
	@RequestMapping("userList.me")
	public String userList(Model model) {
		model.addAttribute("list" ,service.userAll());	
		return "member/memberList";
	}
	
	@RequestMapping("statusChange.me")
	public String statusChange(MemberDTO dto) {
		service.statusChange(dto);
		return "redirect:/user/userList.me";
	}
	
}














