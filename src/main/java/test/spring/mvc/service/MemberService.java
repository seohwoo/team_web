package test.spring.mvc.service;
import java.util.List;

import test.spring.mvc.bean.MemberDTO;
public interface MemberService {
	public int loginCheck(MemberDTO dto);
	public void userInput(MemberDTO dto);
	public MemberDTO getUser(String id);
	public void userUpdate(MemberDTO dto);
	public int userDelete(String id , String passwd);
	
	public List<MemberDTO> userAll();
	public int statusChange(MemberDTO dto);
}









