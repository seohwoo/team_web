package test.spring.mvc.repository;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import test.spring.mvc.bean.MemberDTO;

public interface MemberMapper {
	// MemberMapper.xml에서의 id값이 메서드 이름
	
	public List<MemberDTO> memberList();
	public int statusAdminChange(MemberDTO dto);
	
	public int loginCheck(MemberDTO dto);
	public MemberDTO member(String id);
	public void memberUpdate(MemberDTO dto);
	// 파라미터를 여러개 보낼 때는 앞에 @Param 해줘야함 / 변수들을 xml에 #id,passwd 넣는다
	public int statusChange(@Param("id") String id ,
							@Param("passwd") String passwd);
	
	// test
	public void imgUpdate(@Param("id") String id, @Param("img") String img);
	




}
