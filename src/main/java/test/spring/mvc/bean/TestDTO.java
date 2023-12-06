package test.spring.mvc.bean;


import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.spring.mvc.entity.TestEntity;

/*
	�ڹٷ� ���� <beans:bean />�� ���� �ǹ�
	@Component() 		: <bean id='testDTO'�� �ǹ�
	@Component("dto") 	: <bean id='dto'�� �ǹ�

@Component()
*/
@Data
@NoArgsConstructor
public class TestDTO {
	private String id;
	private String pw;
	private int age;
	private Date reg;
	
	@Builder
	public TestDTO(String id, String pw, int age, Date reg) {
		super();
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.reg = reg;
	}
	
	public TestEntity toEntity() {
		//��ü ���� (new)
		return TestEntity.builder()
						 .id(this.id)
						 .pw(this.pw)
						 .age(this.age)
						 .reg(this.reg)
						 .build();
	}
	
	
}
