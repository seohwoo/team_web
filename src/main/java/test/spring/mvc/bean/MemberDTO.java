package test.spring.mvc.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberDTO {
	private String id;
	private String passwd;
	private String name;
	private String jumin1;
	private String jumin2;
	private String email;
	private String blog;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date reg_date;	// DateTimeFormat : 날짜 패턴 지정
	private int status;
}
