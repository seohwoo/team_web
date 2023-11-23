package test.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.spring.mvc.bean.GradeDTO;
import test.spring.mvc.bean.MemberDTO;
import test.spring.mvc.repository.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{

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

	@Override
	public int isAdmin(String id) {
		return mapper.isAdmin(id);
	}

	@Override
	public List<MemberDTO> showAll() {
		return mapper.showAll();
	}

	@Override
	public String userStatus(int status) {
		return mapper.userStatus(status);
	}

	@Override
	public List<GradeDTO> allStatus() {
		return mapper.allStatus();
	}

	@Override
	public void changeStatus(String status, String id) {
		mapper.changeStatus(status, id);
	}
}
