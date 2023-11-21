package test.spring.mvc.bean;

import java.util.Date;
import lombok.Data;

// @Data 하면 set, get 자동으로 만들어져있음 ( 클래스 열어보면 나옴 )
@Data
public class SampleDTO {
	private String name;
	private int number;
	private Date day;
}

