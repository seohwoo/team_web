package test.spring.mvc.bean;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.spring.mvc.entity.BoardFileEntity;

@Data
@NoArgsConstructor
public class BoardFileDTO {
	
	private int num;
	private int freeboardnum;
	private String filename;
	
	@Builder
	public BoardFileDTO(int num, int freeboardnum, String filename) {
		super();
		this.num = num;
		this.freeboardnum = freeboardnum;
		this.filename = filename;
	}
	
	public BoardFileEntity toBoardFileEntity() {
		return BoardFileEntity.builder()
				.num(this.num)
				.freeboardnum(this.freeboardnum)
				.filename(this.filename)
				.build();
	}
	
}
