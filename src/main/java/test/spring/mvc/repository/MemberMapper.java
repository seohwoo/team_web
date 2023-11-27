package test.spring.mvc.repository;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import test.spring.mvc.bean.MemberDTO;

public interface MemberMapper {
	// MemberMapper.xml������ id���� �޼��� �̸�
	
	public List<MemberDTO> memberList();
	public int statusAdminChange(MemberDTO dto);
	
	public int loginCheck(MemberDTO dto);
	public MemberDTO member(String id);
	public void memberUpdate(MemberDTO dto);
	// �Ķ���͸� ������ ���� ���� �տ� @Param ������� / �������� xml�� #id,passwd �ִ´�
	public int statusChange(@Param("id") String id ,
							@Param("passwd") String passwd);
	
	// test
	public void imgUpdate(@Param("id") String id, @Param("img") String img);
	




}
