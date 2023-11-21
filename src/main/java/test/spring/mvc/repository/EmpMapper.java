package test.spring.mvc.repository;

import java.util.List;
import test.spring.mvc.bean.EmpDTO;

public interface EmpMapper {
	// <select id의 값을 메서드명으로 써야함, resultType의 값이 리턴타입
	// 값이 여러개라 다 받아야 할 때는 List를 쓰면됨 
	public List<EmpDTO> all();
	
	public List<Integer> allEmpno();

	public int insertEmp(EmpDTO dto);
}
