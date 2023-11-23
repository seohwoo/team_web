package test.spring.mvc.repository;

import org.apache.ibatis.annotations.Param;

import test.spring.mvc.bean.MemberDTO;

public interface MemberMapper {
	// MemberMapper.xml������ id���� �޼��� �̸�
	
	public int loginCheck(MemberDTO dto);
	
	public MemberDTO member(String id);
	
	public void memberUpdate(MemberDTO dto);
									// �Ķ���͸� ������ ���� ���� �տ� @Param ������� / �������� xml�� #id,passwd �ִ´�
	public int statusChange(@Param("id") String id, @Param("passwd") String passwd);
	
	//
	public void memberInsert(MemberDTO dto);
	
	public void admin(MemberDTO dto);
}
