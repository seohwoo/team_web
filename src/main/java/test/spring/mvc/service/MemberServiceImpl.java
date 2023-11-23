package test.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.spring.mvc.bean.MemberDTO;
import test.spring.mvc.repository.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public int loginCheck(MemberDTO dto) {
		return mapper.loginCheck(dto);
	}

	@Override
	public void userInput(MemberDTO dto) {
		 
	}

	@Override
	public MemberDTO getUser(String id) {
		return mapper.member(id);
	}

	@Override
	public void userUpdate(MemberDTO dto) {
		mapper.memberUpdate(dto);
	}

	@Override
	public int userDelete(String id, String passwd) {
		return mapper.statusChange(id, passwd);
	}
	
	//
	@Override
	public void inputForm(MemberDTO dto) {
		mapper.memberInsert(dto);
	}

	@Override
	public void admin(MemberDTO dto) {
		// TODO Auto-generated method stub
		
	}


}
