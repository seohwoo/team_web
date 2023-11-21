package test.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.spring.mvc.bean.EmpDTO;
import test.spring.mvc.repository.EmpMapper;

@Service
public class EmpServiceEmp1{

	@Autowired
	private EmpMapper mapper;
	
	public List<EmpDTO> read() {
		return mapper.all();
	}
	
	public List<Integer> readNum() {
		return mapper.allEmpno();
	}

	public int create(EmpDTO dto) {
		return mapper.insertEmp(dto);
	}
	
}
