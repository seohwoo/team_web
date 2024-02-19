package test.spring.mvc.bean;

import java.util.Date;
import lombok.Data;

@Data
public class SampleDTO {
	private String name;
	private int number;
	private Date day;
}
