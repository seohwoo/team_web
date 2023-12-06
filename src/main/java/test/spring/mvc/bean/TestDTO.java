package test.spring.mvc.bean;


import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.spring.mvc.entity.TestEntity;

/*
	자바로 설정 <beans:bean />과 같은 의미
	@Component() 		: <bean id='testDTO'의 의미
	@Component("dto") 	: <bean id='dto'의 의미

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
		//객체 생성 (new)
		return TestEntity.builder()
						 .id(this.id)
						 .pw(this.pw)
						 .age(this.age)
						 .reg(this.reg)
						 .build();
	}
	
	
}
