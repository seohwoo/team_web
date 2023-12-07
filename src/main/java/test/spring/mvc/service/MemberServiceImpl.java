package test.spring.mvc.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import test.spring.mvc.bean.GradeDTO;
import test.spring.mvc.bean.MemberDTO;
import test.spring.mvc.entity.MemberEntity;
import test.spring.mvc.repository.MemberJPARepository;
import test.spring.mvc.repository.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private MemberJPARepository jpa; 
	
	@Override
	public int loginCheck(MemberDTO dto) {
		int result = 0;
		MemberEntity me = jpa.findById(dto.getId()).get();
		if(dto.getPasswd().equals(me.getPasswd())) {
			if(me.getStatus() > 0) {
				result = me.getStatus();
			}
		}
		return result;
	}

	@Override
	public void userInput(MemberDTO dto) {
	}

	@Override
	public MemberDTO getUser(String id) {
		MemberEntity me = jpa.findById(id).get();
		return me.toMemberDTO();
		
	}

	@Override
	public void userUpdate(MemberDTO dto) {
		jpa.save(dto.toMemberDTOEntity());
	}

	@Override
	public int userDelete(String id, String passwd) {
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setStatus(0);
		jpa.save(dto.toMemberDTOEntity());		
		return 1;
	}

	@Override
	public int isAdmin(String id) {
		return jpa.findById(id).get().getStatus();
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
	public void changeStatus(MemberDTO dto) {
		mapper.changeStatus(dto);
	}

	@Override
	public boolean changeImg(String id, String path, MultipartFile img) {
		String[] contentType = img.getContentType().split("/");
		boolean result = typeCheck("image", contentType[0]);
		if(result) {
			String fileName =  fileUpload(id, path, img, contentType[1]);
			mapper.changeImg(fileName, id);
		}
		return result;
	}
	
	//파일 업로드
	public String fileUpload(String id, String path,MultipartFile img, String ext) {
		String fileName = id+"."+ext;
		File copy = new File(path+fileName);
		try {
			img.transferTo(copy);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	//file 타입 확인
	public boolean typeCheck(String checkType, String fileType) {
		boolean result = false;
		if(checkType.equals(fileType)) {
			result = true;
		}
		return result;
	}
}





/*
package test.spring.mvc.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	public void changeStatus(MemberDTO dto) {
		mapper.changeStatus(dto);
	}

	@Override
	public boolean changeImg(String id, String path, MultipartFile img) {
		String[] contentType = img.getContentType().split("/");
		boolean result = typeCheck("image", contentType[0]);
		if(result) {
			String fileName =  fileUpload(id, path, img, contentType[1]);
			mapper.changeImg(fileName, id);
		}
		return result;
	}
	
	//파일 업로드
	public String fileUpload(String id, String path,MultipartFile img, String ext) {
		String fileName = id+"."+ext;
		File copy = new File(path+fileName);
		try {
			img.transferTo(copy);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	//file 타입 확인
	public boolean typeCheck(String checkType, String fileType) {
		boolean result = false;
		if(checkType.equals(fileType)) {
			result = true;
		}
		return result;
	}
}
*/