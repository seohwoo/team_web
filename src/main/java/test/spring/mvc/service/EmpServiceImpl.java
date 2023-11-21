package test.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.spring.mvc.bean.EmpDTO;
import test.spring.mvc.repository.EmpMapper;

@Service
public class EmpServiceImpl {
	
	@Autowired
	private EmpMapper mapper;
	
	public List<EmpDTO> list(){
		return mapper.test1();
	}
	
	public int form(EmpDTO dto){
		return mapper.test2(dto);
	}
}
