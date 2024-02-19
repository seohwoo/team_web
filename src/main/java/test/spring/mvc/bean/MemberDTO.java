package test.spring.mvc.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.spring.mvc.entity.MemberEntity;

@Data
@NoArgsConstructor
public class MemberDTO {
	
	private String id;
	private String passwd;
	private String name;
	private String jumin1;
	private String jumin2;
	private String email;
	private String blog;
	private Date reg_date;
	private int status;
	private String img;
	
	@Builder
	public MemberDTO(String id, String passwd, String name, String jumin1, String jumin2, String email, String blog,
			Date reg_date, int status, String img) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.jumin1 = jumin1;
		this.jumin2 = jumin2;
		this.email = email;
		this.blog = blog;
		this.reg_date = reg_date;
		this.status = status;
		this.img = img;
	}
	
	public MemberEntity toMemberEntity() {
		return MemberEntity.builder()
				.id(this.id)
				.passwd(this.passwd)
				.name(this.name)
				.jumin1(this.jumin1)
				.jumin2(this.jumin2)
				.email(this.email)
				.blog(this.blog)
				.reg_date(this.reg_date)
				.status(this.status)
				.img(this.img)
				.build();
	}
	
	
	
	
}
