package test.spring.mvc.service;

import java.io.File;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

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

	@Override //내가만든거
	public List<MemberDTO> memberviews(MemberDTO dto) {
		
		return mapper.memberviews();
	}

	@Override //내가만든거
	public void memberstatus(Model model) {
		mapper.memberstatus(model);
		
	}

	@Override  //쌤이 만든거 위에와 같은 코드이기에 하나로만 받음 memberviews()
	public List<MemberDTO> memberviews() {
		
		return mapper.memberviews();
	}

	@Override //쌤
	public int statusChange(MemberDTO dto) {
		
		return mapper.statusChange(dto);
	}
	
	//프로필 변경 기본(값 2개만 받기 선민)
	@Override
	public int imgChange(@Param("id")String id, @Param("img")String img) {
		
		return mapper.imgChange(id, img);
	}

	//아래 선생님 코드(프로필 변경)
	@Override
	public boolean imgchange(String path, String id, MultipartFile img) { 
		String contentType = img.getContentType();
		boolean result = typeCheck("image",contentType);
		if(result) {
			String fileName = fileUpload(path, id, img);
			//mapper 호출
		}
		return result;
	}
	
	//파일업로드
	public String fileUpload(String path, String id, MultipartFile img) {
		String orgName = img.getOriginalFilename(); // 파일이름
		String ext = orgName.substring(orgName.lastIndexOf(".")) ;// 1231.png일 경우 png를 자름
		String fileName = id+ext;
		File copy = new File(path+fileName); //경로만들기		
		try {
			img.transferTo(copy);
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return fileName;
	}
	
	
	// 아래는 파일타입 분류를 따로 진행
	
	public boolean typeCheck(String checkType, String fileType) { //파일 타입이 맞는지 확인용
		boolean result = false;
		if(checkType.equals(fileType.split("/")[0])) {
			result = true;
		}
		return result;		
	}	
}
