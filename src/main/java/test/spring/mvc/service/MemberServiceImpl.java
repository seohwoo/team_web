package test.spring.mvc.service;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import test.spring.mvc.bean.GradeDTO;
import test.spring.mvc.bean.MemberDTO;
import test.spring.mvc.entity.GradeEntity;
import test.spring.mvc.entity.MemberEntity;
import test.spring.mvc.repository.GradeJPARepository;
import test.spring.mvc.repository.MemberJPARepository;
import test.spring.mvc.repository.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private MemberJPARepository jpa;
	
	@Autowired
	private GradeJPARepository gradeJpa;
	
	@Override
	public int loginCheck(MemberDTO dto) {
		int count = 0;
		MemberEntity entity = jpa.findById(dto.getId()).get();
		if(entity.getPasswd().equals(dto.getPasswd()) && entity.getStatus() > 0) {
			count = entity.getStatus();
		}
		return count;
	}
	
	@Override
	public int confirmId(String id) {
		int check = 0;
		if(jpa.findById(id).get().getId().equals(id)) {
			check++;
		}
		return check;
	}

	@Override
	public void userInput(MemberDTO dto) {
		dto.setReg_date(new Timestamp(System.currentTimeMillis()));
		dto.setStatus(1);
		jpa.save(dto.toMemberEntity());
	}

	@Override
	public MemberDTO getUser(String id) {
		return jpa.findById(id).get().toMemberDTO();
	}

	@Override
	public void userUpdate(MemberDTO dto) {
		MemberEntity entity = jpa.findById(dto.getId()).get();
		if(entity.getId().equals(dto.getId())) {
			dto.setJumin1(entity.getJumin1());
			dto.setJumin2(entity.getJumin2());
			dto.setReg_date(entity.getRegDate());
			dto.setStatus(entity.getStatus());
			jpa.save(dto.toMemberEntity());
		}
	}

	@Override
	public int userDelete(String id, String passwd) {
		int check = 0;
		MemberEntity entity = jpa.findById(id).get();
		if(entity.getPasswd().equals(passwd)) {
			MemberDTO dto = entity.toMemberDTO();
			dto.setStatus(0);
			jpa.save(dto.toMemberEntity());
			check++;
		}
		return check;
	}

	@Override
	public int isAdmin(String id) {
		return jpa.findById(id).get().getStatus();
	}

	@Override
	public List<MemberDTO> showAll() {
		Sort sort = Sort.by(Sort.Order.desc("status"));
		List<MemberEntity> entityList = jpa.findAll(sort);
		List<MemberDTO> list = null;
		if(entityList.size()>0) {
			list = new ArrayList<MemberDTO>();
			for (MemberEntity entity : entityList) {
				MemberDTO dto = entity.toMemberDTO();
				list.add(dto);
			}
		}
		return list;
	}

	@Override
	public String userStatus(int status) {
		GradeDTO dto = gradeJpa.findById(status).get().toGradeDTO();
		String result = dto.getStatusname();
		return result;
	}

	@Override
	public List<GradeDTO> allStatus() {
		Sort sort = Sort.by(Sort.Order.desc("status"));
		List<GradeEntity> entityList = gradeJpa.findAll(sort);
		List<GradeDTO> list = null;
		if(entityList.size()>0) {
			list = new ArrayList<GradeDTO>();
			for (GradeEntity entity : entityList) {
				GradeDTO dto = entity.toGradeDTO();
				list.add(dto);
			}
		}
		return list;
	}

	@Override
	public void changeStatus(MemberDTO dto) {
		MemberEntity entity = jpa.findById(dto.getId()).get();
		MemberDTO newDTO = entity.toMemberDTO();
		newDTO.setStatus(dto.getStatus());
		jpa.save(newDTO.toMemberEntity());
	}

	@Override
	public boolean changeImg(String id, String path, MultipartFile img) {
		String[] contentType = img.getContentType().split("/");
		boolean result = typeCheck("image", contentType[0]);
		if(result) {
			String fileName =  fileUpload(id, path, img, contentType[1]);
			MemberDTO dto = jpa.findById(id).get().toMemberDTO();
			dto.setImg(fileName);
			jpa.save(dto.toMemberEntity());
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
