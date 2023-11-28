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

	@Override //���������
	public List<MemberDTO> memberviews(MemberDTO dto) {
		
		return mapper.memberviews();
	}

	@Override //���������
	public void memberstatus(Model model) {
		mapper.memberstatus(model);
		
	}

	@Override  //���� ����� ������ ���� �ڵ��̱⿡ �ϳ��θ� ���� memberviews()
	public List<MemberDTO> memberviews() {
		
		return mapper.memberviews();
	}

	@Override //��
	public int statusChange(MemberDTO dto) {
		
		return mapper.statusChange(dto);
	}
	
	//������ ���� �⺻(�� 2���� �ޱ� ����)
	@Override
	public int imgChange(@Param("id")String id, @Param("img")String img) {
		
		return mapper.imgChange(id, img);
	}

	//�Ʒ� ������ �ڵ�(������ ����)
	@Override
	public boolean imgchange(String path, String id, MultipartFile img) { 
		String contentType = img.getContentType();
		boolean result = typeCheck("image",contentType);
		if(result) {
			String fileName = fileUpload(path, id, img);
			//mapper ȣ��
		}
		return result;
	}
	
	//���Ͼ��ε�
	public String fileUpload(String path, String id, MultipartFile img) {
		String orgName = img.getOriginalFilename(); // �����̸�
		String ext = orgName.substring(orgName.lastIndexOf(".")) ;// 1231.png�� ��� png�� �ڸ�
		String fileName = id+ext;
		File copy = new File(path+fileName); //��θ����		
		try {
			img.transferTo(copy);
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return fileName;
	}
	
	
	// �Ʒ��� ����Ÿ�� �з��� ���� ����
	
	public boolean typeCheck(String checkType, String fileType) { //���� Ÿ���� �´��� Ȯ�ο�
		boolean result = false;
		if(checkType.equals(fileType.split("/")[0])) {
			result = true;
		}
		return result;		
	}	
}
