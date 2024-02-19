package test.spring.mvc.repository;

import java.util.List;

import test.spring.mvc.bean.EmpDTO;

public interface EmpMapper {
	
	// 	id : 메서드명, resultType : 리턴타입
	//	<select id="all" resultType="test.spring.mvc.bean.EmpDTO">
	//	결과값이 여러개 나올 경우 리턴타입을 list로 선언하면 list에 넣어서 리턴해준다. 
	public List<EmpDTO> all();
	public List<Integer> allEmpno();
	public int insertEmp(EmpDTO dto);
}
