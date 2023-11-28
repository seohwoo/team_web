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
	// 원래는 하나만 보낼 수 있는데 2개 이상의 파라미터를 넘길려면 앞에 파람을 붙인다
	public List<MemberDTO> memberviews(); //내가만든거 //쌤이만든거 동일
	public void memberstatus(Model model); //내가만든거
	
	public int statusChange(MemberDTO dto); // 쌤
	//public List<MemberDTO> memberList(); //쌤이 만든거 위에와 같은 코드이기에 하나로만 받음 memberviews()
	
	public int imgChange(@Param("id")String id, @Param("img")String img);
}
