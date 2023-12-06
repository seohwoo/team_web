package test.spring.mvc.bean;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.spring.mvc.entity.BoardEntity;

@NoArgsConstructor
@Data
public class BoardDTO {
	private int num;
	private String writer;
	private String subject;
	private String email;
	private String content;
	private String passwd;
	private Date reg_date;
	private int readcount;
	private String ip;
	private int ref;
	private int re_step;
	private int re_level;
	private int isfile;
	
	@Builder
	public BoardDTO(int num, String writer, String subject, String email, String content, String passwd, Date reg_date,
			int readcount, String ip, int ref, int re_step, int re_level, int isfile) {
		super();
		this.num = num;
		this.writer = writer;
		this.subject = subject;
		this.email = email;
		this.content = content;
		this.passwd = passwd;
		this.reg_date = reg_date;
		this.readcount = readcount;
		this.ip = ip;
		this.ref = ref;
		this.re_step = re_step;
		this.re_level = re_level;
		this.isfile = isfile;
	}

	public BoardEntity toBoardEntity() {
		return BoardEntity.builder()
					   .num(this.num)
					   .writer(this.writer)
					   .subject(this.subject)
					   .email(this.email)
					   .content(this.content)
					   .passwd(this.passwd)
					   .reg_date(this.reg_date)
					   .readcount(this.readcount)
					   .ip(this.ip)
					   .ref(this.ref)
					   .re_step(this.re_step)
					   .re_level(this.re_level)
					   .isfile(this.isfile)
					   .build();
	}
}

/*
package test.spring.mvc.bean;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO {
	private int num;
	private String writer;
	private String subject;
	private String email;
	private String content;
	private String passwd;
	private Date reg_date;
	private int readcount;
	private String ip;
	private int ref;
	private int re_step;
	private int re_level;
	private int pageNum;
	private int isfile;
}
*/