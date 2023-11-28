package test.spring.mvc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import test.spring.mvc.bean.MemberDTO;

public interface MemberService {
	public int loginCheck(MemberDTO dto);
	public void userInput(MemberDTO dto);
	public MemberDTO getUser(String id);
	public void userUpdate(MemberDTO dto);
	public int userDelete(String id, String passwd);
	public List<MemberDTO> memberviews(MemberDTO dto);  //���������
	public void memberstatus(Model model); //���������
	
	public List<MemberDTO> memberviews(); //��
	public int statusChange(MemberDTO dto);//��
	//����
	public int imgChange(@Param("id")String id, @Param("img")String img);
	
	public boolean imgchange(String path, String id, MultipartFile img);
	//���� �̷��� 3���� ����
	//�������� ������ ����� �ȉ���� Ȯ���� �ʿ��� boolean �� ����
}
