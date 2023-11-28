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
	public List<MemberDTO> memberviews(MemberDTO dto);  //내가만든거
	public void memberstatus(Model model); //내가만든거
	
	public List<MemberDTO> memberviews(); //쌤
	public int statusChange(MemberDTO dto);//쌤
	//선민
	public int imgChange(@Param("id")String id, @Param("img")String img);
	
	public boolean imgchange(String path, String id, MultipartFile img);
	//쌤은 이렇게 3개를 받음
	//프로필이 전달이 됬는지 안됬는지 확인이 필요해 boolean 로 진행
}
