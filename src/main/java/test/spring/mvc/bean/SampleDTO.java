package test.spring.mvc.bean;

import java.util.Date;
import lombok.Data;

// @Data �ϸ� set, get �ڵ����� ����������� ( Ŭ���� ����� ���� )
@Data
public class SampleDTO {
	private String name;
	private int number;
	private Date day;
}

