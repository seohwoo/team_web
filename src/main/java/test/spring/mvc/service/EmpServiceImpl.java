package test.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.spring.mvc.bean.EmpDTO;
import test.spring.mvc.repository.EmpMapper;

@Service("emp")
public class EmpServiceImpl implements CrudService {
	
	@Autowired
	private EmpMapper mapper;
	
	@Override
	public void create(Object dto) {
		
	}
	
	@Override
	public void delete(Object dto) {
		
	}
	
	@Override
	public void update(Object dto) {
		
	}
	
	@Override
	public List<Object> read() {
		return null;
	}
	
	
	/*
	public List<EmpDTO> read() {
		return mapper.all();
	}
	
	public List<Integer> readNo() {
		return mapper.allEmpno();
	}
	
	public int create(EmpDTO dto) {
		return mapper.insertEmp(dto);
	}
	*/
}
