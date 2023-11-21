package test.spring.mvc.repository;

import java.util.List;

import test.spring.mvc.bean.EmpDTO;

public interface EmpMapper {
	public List<EmpDTO> test1();
	
	public int test2(EmpDTO dto);
}
