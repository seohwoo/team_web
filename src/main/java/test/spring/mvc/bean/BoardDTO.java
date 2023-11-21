package test.spring.mvc.bean;

import lombok.Data;

@Data
public class BoardDTO {
	private int num;
	private String writer;
	private String title;
	private String content;
	private String reg;
	private String save;
	private int count;
}
