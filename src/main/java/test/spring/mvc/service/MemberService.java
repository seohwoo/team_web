package test.spring.mvc.service;

import test.spring.mvc.bean.MemberDTO;

public interface MemberService {
	public int loginCheck(MemberDTO dto);
	
	public void userInput(MemberDTO dto);

	public MemberDTO getUser(String id);

	public void userUpdate(MemberDTO dto);

	public int userDelete(String id, String passwd);
	
	//
	public void inputForm(MemberDTO dto);
	
	public void admin(MemberDTO dto);
}
