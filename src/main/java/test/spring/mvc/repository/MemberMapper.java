package test.spring.mvc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import test.spring.mvc.bean.GradeDTO;
import test.spring.mvc.bean.MemberDTO;

public interface MemberMapper {
	
	public int loginCheck(MemberDTO dto);
	public MemberDTO member(String id);
	public void memberUpdate(MemberDTO dto);
	public int statusChange(	@Param("id") String id, 
								@Param("passwd") String passwd);
	public int isAdmin(String id);
	public List<MemberDTO> showAll();
	public String userStatus(int status);
	public List<GradeDTO> allStatus();
	public void changeStatus(MemberDTO dto);
}
