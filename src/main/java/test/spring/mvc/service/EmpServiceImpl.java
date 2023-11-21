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
	
	public List<EmpDTO> read() {
		return mapper.all();
	}
	
	public List<Integer> readNo() {
		return mapper.allEmpno();
	}
	
	public int create(EmpDTO dto) {
		return mapper.insertEmp(dto);
	}
	
}
