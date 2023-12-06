package test.spring.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.spring.mvc.bean.TestDTO;
import test.spring.mvc.entity.TestEntity;
import test.spring.mvc.repository.TestJPARepository;

@Service
public class TestServiceImpl {
	
	@Autowired
	private TestJPARepository jpa;

	public long testCount() {
		return jpa.count();
	}
	
	public List<TestDTO> testList() {
		List<TestDTO> list = null;
		// jpa.findAll();  전체 레코드 검색
		List<TestEntity> listEntity = jpa.findAll();
		
		if(listEntity.size() > 0) {
			list = new ArrayList<>();
			for(TestEntity te : listEntity) {
				TestDTO dto = TestDTO.builder()
							  .id(te.getId())
							  .pw(te.getPw())
							  .age(te.getAge())
							  .reg(te.getReg())
							  .build();
				list.add(dto);	  
			}
		}
		
		return list;
	}
	
	public void create(TestDTO dto) {
		jpa.save(dto.toEntity());
	}
	
	public void delete(TestDTO dto) {
		TestEntity te = jpa.findById(dto.getId()).get();
		if(te.getPw().equals(dto.getPw())) {
			jpa.deleteById(dto.getId());
		}
	}
	
}
