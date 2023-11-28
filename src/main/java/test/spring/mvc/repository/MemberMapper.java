package test.spring.mvc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import test.spring.mvc.bean.MemberDTO;

public interface MemberMapper {
	public int loginCheck(MemberDTO dto);
	public MemberDTO member(String id);
	public void memberUpdate(MemberDTO dto);
	
	public int statusChange(@Param("id") String id, @Param("passwd") String passwd);
	// ������ �ϳ��� ���� �� �ִµ� 2�� �̻��� �Ķ���͸� �ѱ���� �տ� �Ķ��� ���δ�
	public List<MemberDTO> memberviews(); //��������� //���̸���� ����
	public void memberstatus(Model model); //���������
	
	public int statusChange(MemberDTO dto); // ��
	//public List<MemberDTO> memberList(); //���� ����� ������ ���� �ڵ��̱⿡ �ϳ��θ� ���� memberviews()
	
	public int imgChange(@Param("id")String id, @Param("img")String img);
}
