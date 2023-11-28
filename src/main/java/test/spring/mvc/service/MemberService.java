package test.spring.mvc.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import test.spring.mvc.bean.GradeDTO;
import test.spring.mvc.bean.MemberDTO;

public interface MemberService {
	
	public int loginCheck(MemberDTO dto);
	public void userInput(MemberDTO dto);
	public MemberDTO getUser(String id);
	public void userUpdate(MemberDTO dto);
	public int userDelete(String id, String passwd);
	public int isAdmin(String id);
	public List<MemberDTO> showAll();
	public String userStatus(int status);
	public List<GradeDTO> allStatus();
	public void changeStatus(MemberDTO dto);
	public boolean changeImg(String id, String path, MultipartFile img);
}
