package test.spring.mvc.bean;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.spring.mvc.entity.GradeEntity;

@Data
@NoArgsConstructor
public class GradeDTO {
	
	private int status;
	private String statusname;
	
	@Builder
	public GradeDTO(int status, String statusname) {
		super();
		this.status = status;
		this.statusname = statusname;
	}
	
	public GradeEntity toGradeEntity() {
		return GradeEntity.builder()
				.status(this.status)
				.statusname(this.statusname)
				.build();
	}
	
	
}
