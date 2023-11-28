package test.spring.mvc;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import test.spring.mvc.bean.MemberDTO;
import test.spring.mvc.service.MemberService;

@Controller
@RequestMapping("/user/*")
public class MemberController {
	
	@Autowired
	private MemberService service;

	@RequestMapping("main.me")
	public String main() {
		return "member/main";
	}

	@RequestMapping("loginPro.me")
	public String loginPro(MemberDTO dto, Model model) {		
		int status = service.loginCheck(dto);
		model.addAttribute("status", status);		
		return "member/loginPro";
	}
	
	@RequestMapping("logout.me")
	public String logout(HttpSession session) {		
		session.invalidate(); //��ü����
		//session.removeAttribute("menId"); // �ش��̸�����		
		return "redirect:/user/main.me";
	}	
	
	
	@RequestMapping("modify.me")
	public String modify(HttpSession session, Model model) {
		String id = (String)session.getAttribute("memId");
		MemberDTO dto = service.getUser(id);
		model.addAttribute("dto", dto);
		return "member/modify";
	}	
	
	@RequestMapping("modifyForm.me")
	public String modifyForm(HttpSession session, Model model) {
		String id = (String)session.getAttribute("memId");
		MemberDTO dto = service.getUser(id);
		model.addAttribute("dto", dto);
		return "member/modifyForm";
	}	
	
	@RequestMapping("modifyPro.me")
	public String modifyForm(HttpSession session, MemberDTO dto, Model model) {
		String id = (String)session.getAttribute("memId");
		dto.setId(id);	
		service.userUpdate(dto);
		return "member/modifyPro";
	}	
	
	@RequestMapping("deleteForm.me")
	public String deleteForm() {		
		return "member/deleteForm";
	}	
	
	@RequestMapping("deletePro.me")
	public String deletePro(Model model, String passwd, HttpSession session) {	
		String id = (String)session.getAttribute("memId");
		int check = service.userDelete(id, passwd);
		if(check==1) {
			session.invalidate();
		}
		model.addAttribute("check", check);
		return "member/deletePro";
	}	
	
	@RequestMapping("memberviews.me")  //���������
	public String memberviews(Model model) {
		List<MemberDTO> members = service.memberviews(null);
		model.addAttribute("members", members);
		return "member/memberviews";
	}	
	
	@RequestMapping("memberviewsPro.me") //���������
	public String memberviewsPro(Model model,
			@ModelAttribute("id") String id,
			@ModelAttribute("status") int status) {		
		model.addAttribute("id",id);
		model.addAttribute("status",status);
		service.memberstatus(model);  // ������Ʈ ����		
		return "member/memberviewsPro";
	}
	
	@RequestMapping("userList.me")   //��
	public String userList(Model model) {
		model.addAttribute("list", service.memberviews());	
		return "member/memberList";
	}	
	
	@RequestMapping("statusChange.me")   //��
	public String statusChange(MemberDTO dto) {
		service.statusChange(dto);
		return "redirect:/user/userList.me";
	}	
	
	@RequestMapping("imgForm.me")
	public String imgForm() {
		return "member/imgForm";
	}
	
	@RequestMapping("imgPro.me")
	public String imgPro(HttpSession session, Model model, HttpServletRequest request, MultipartFile imgFile) {
		String id = (String)session.getAttribute("memId");
		String filePath = request.getServletContext().getRealPath("/resources/file/user/"); // ������
		String contentType = imgFile.getContentType(); // mime type Ȯ��
		int check = 0;
		if(contentType.split("/")[0].equals("image")) {
			String orgName = imgFile.getOriginalFilename(); // �����̸�
			String ext = orgName.substring(orgName.lastIndexOf(".")) ;// 1231.png�� ��� png�� �ڸ�
			String img = id+ext;  // ȸ�� ���̵� ���ϱ� .png ���� ���� 
			File copy = new File(filePath+id+ext);
			try {
				imgFile.transferTo(copy);
			}catch (Exception e) {
				e.printStackTrace();
			}
			check = service.imgChange(id,img);
		}	
		model.addAttribute("check",check);
		return "member/imgPro";
	}
	
	
}
