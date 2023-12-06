package test.spring.mvc.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.spring.mvc.bean.BoardFileDTO;


@Data
@NoArgsConstructor
@Entity
@Table(name="freeboard_file")
@SequenceGenerator(name="fileSeq", sequenceName = "freeboard_file_seq", initialValue = 1, allocationSize = 1)
public class BoardFileEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fileSeq")
	private int num;
	private int freeboardnum;
	private String filename;
	
	@Builder
	public BoardFileEntity(int num, int freeboardnum, String filename) {
		super();
		this.num = num;
		this.freeboardnum = freeboardnum;
		this.filename = filename;
	}
	
	public BoardFileDTO toBoardFileDTO() {
		return BoardFileDTO.builder()
				.num(this.num)
				.freeboardnum(this.freeboardnum)
				.filename(this.filename)
				.build();
	}
}
