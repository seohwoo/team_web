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

@Data // set / get / 기본생성자 / toString
@NoArgsConstructor // 기본생성자
@Entity // JPA 연동 객체
@Table(name="test") // 테이블 이름
public class TestEntity {

	@Id // 이 컬럼을 primary key로 하겠다
	private String id;
	private String pw;
	private int age;
	@Temporal(TemporalType.TIMESTAMP) // 날짜, 시간 다 알려줌
	@Column(name="reg" , updatable = false) // 수정 불가능한 컬럼이다
	private Date reg;
	
	@Builder
	public TestEntity(String id, String pw, int age, Date reg) {
		super();
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.reg = reg;
	}
	
	
	
	
	/*
	 * JPA에선 _를 못쓰기 때문에 @Column 에 컬럼명을 적고 변수명을 바꿔서 써야함
	@Column(name="re_step")
	private int step;
	*/
}
