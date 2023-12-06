package test.spring.mvc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.spring.mvc.bean.TestDTO;

@Data				// set, get, 기본생성자, toString()
@NoArgsConstructor	// 기본 생성자 만들어줌
@Entity				// JPA 연동(DB연결)
@Table(name="test")	// 테이블 이름
public class TestEntity {
	
	@Id	//primary key
	private String id;
	private String pw;
	private int age;
	
	@Temporal(TemporalType.TIMESTAMP)		// DATE 출력값 설정
	@Column(name="reg", updatable = false)	// 수정 불가능한 컬럼
	private Date reg;
	
	@Builder
	public TestEntity(String id, String pw, int age, Date reg) {
		super();
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.reg = reg;
	}
	
	public TestDTO toDTO() { //객체생성 (new)
		return TestDTO.builder()
				.id(this.id)
				.pw(this.pw)
				.age(this.age)
				.reg(this.reg)
				.build(); 
	}
	

	// jpa에서 변수명에 _사용이 불가능하다. 
	// re_step -> reStep으로 매칭해준다.
	//@Column(name="re_step")
	//private int reStep;
	
}
