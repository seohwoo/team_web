package test.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.spring.mvc.bean.EmpDTO;
import test.spring.mvc.repository.EmpMapper;

@Service("emp") //service 이름을 정해줄 수 있다. 없을경우 클래스명이 서비스 이름이 된다.
public class EmpServiceImpl implements CrudService{

	@Autowired
	private EmpMapper mapper;

	@Override
	public void create(Object dto) {
		
	}
	
	@Override
	public List<Object> read() {

		return null;
	}

	@Override
	public void update(Object dto) {

	}

	@Override
	public void delete(Object dto) {

	}

	
}
