package test.spring.mvc.repository;

import java.util.List;

import test.spring.mvc.bean.EmpDTO;

public interface EmpMapper {
	
	// 	id : �޼����, resultType : ����Ÿ��
	//	<select id="all" resultType="test.spring.mvc.bean.EmpDTO">
	//	������� ������ ���� ��� ����Ÿ���� list�� �����ϸ� list�� �־ �������ش�. 
	public List<EmpDTO> all();
	public List<Integer> allEmpno();
	public int insertEmp(EmpDTO dto);
}
