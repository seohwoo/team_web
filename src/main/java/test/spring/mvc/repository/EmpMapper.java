package test.spring.mvc.repository;

import java.util.List;
import test.spring.mvc.bean.EmpDTO;

public interface EmpMapper {
	// <select id�� ���� �޼�������� �����, resultType�� ���� ����Ÿ��
	// ���� �������� �� �޾ƾ� �� ���� List�� ����� 
	public List<EmpDTO> all();
	
	public List<Integer> allEmpno();

	public int insertEmp(EmpDTO dto);
}
