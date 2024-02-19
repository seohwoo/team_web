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

@Data				// set, get, �⺻������, toString()
@NoArgsConstructor	// �⺻ ������ �������
@Entity				// JPA ����(DB����)
@Table(name="test")	// ���̺� �̸�
public class TestEntity {
	
	@Id	//primary key
	private String id;
	private String pw;
	private int age;
	
	@Temporal(TemporalType.TIMESTAMP)		// DATE ��°� ����
	@Column(name="reg", updatable = false)	// ���� �Ұ����� �÷�
	private Date reg;
	
	@Builder
	public TestEntity(String id, String pw, int age, Date reg) {
		super();
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.reg = reg;
	}
	
	public TestDTO toDTO() { //��ü���� (new)
		return TestDTO.builder()
				.id(this.id)
				.pw(this.pw)
				.age(this.age)
				.reg(this.reg)
				.build(); 
	}
	

	// jpa���� ������ _����� �Ұ����ϴ�. 
	// re_step -> reStep���� ��Ī���ش�.
	//@Column(name="re_step")
	//private int reStep;
	
}
