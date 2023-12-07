package test.spring.mvc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.spring.mvc.bean.MemberDTO;

@Data
@NoArgsConstructor
@Entity
@Table(name="freemember")
public class MemberEntity {
	
	@Id
	private String id;
	private String passwd;
	private String name;
	private String jumin1;
	private String jumin2;
	private String email;
	private String blog;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reg_date")
	private Date regDate;
	
	private int status;
	private String img;
	
	@Builder
	public MemberEntity(String id, String passwd, String name, String jumin1, String jumin2, String email, String blog,
			Date regDate, int status, String img) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.jumin1 = jumin1;
		this.jumin2 = jumin2;
		this.email = email;
		this.blog = blog;
		this.regDate = regDate;
		this.status = status;
		this.img = img;
	}
	
	public MemberDTO toMemberDTO() {
		return MemberDTO.builder()
						.id(this.id)
						.passwd(this.passwd)
						.name(this.name)
						.jumin1(this.jumin1)
						.jumin2(this.jumin2)
						.email(this.email)
						.blog(this.blog)
						.reg_date(this.regDate)
						.status(this.status)
						.img(this.img)
						.build();
	}
	
	
	
}
