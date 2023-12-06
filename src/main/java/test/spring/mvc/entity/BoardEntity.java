package test.spring.mvc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.spring.mvc.bean.BoardDTO;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name="feeSeq",sequenceName = "freeboard_seq", initialValue = 1, allocationSize = 1)
@Table(name="freeboard")
public class BoardEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "feeSeq") // 자동 증가값을 적용한다
	private int num;
	
	private String writer;
	private String subject;
	private String email;
	private String content;
	private String passwd;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reg_Date")
	private Date regDate;
	
	private int readcount;
	private String ip;
	private int ref;
	
	@Column(name="re_step")
	private int reStep;
	@Column(name="re_level")
	private int reLevel;
	
	private int pageNum;
	private int isfile;
	
	@Builder
	public BoardEntity(int num, String writer, String subject, String email, String content, String passwd, Date reg_date,
		int readcount, String ip, int ref, int re_step, int re_level, int pageNum, int isfile) {
	super();
	this.num = num;
	this.writer = writer;
	this.subject = subject;
	this.email = email;
	this.content = content;
	this.passwd = passwd;
	this.regDate = reg_date;
	this.readcount = readcount;
	this.ip = ip;
	this.ref = ref;
	this.reStep = re_step;
	this.reLevel = re_level;
	this.pageNum = pageNum;
	this.isfile = isfile;
	}
	
	public BoardDTO toBoardDTO() {
		return BoardDTO.builder()
					   .num(this.num)
					   .writer(this.writer)
					   .subject(this.subject)
					   .email(this.email)
					   .content(this.content)
					   .passwd(this.passwd)
					   .reg_date(this.regDate)
					   .readcount(this.readcount)
					   .ip(this.ip)
					   .ref(this.ref)
					   .re_step(this.reStep)
					   .re_level(this.reLevel)
					   .pageNum(this.pageNum)
					   .isfile(this.isfile)
					   .build();
	}
}
