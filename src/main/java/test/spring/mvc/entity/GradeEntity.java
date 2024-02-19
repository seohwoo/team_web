package test.spring.mvc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.spring.mvc.bean.GradeDTO;

@Data
@NoArgsConstructor
@Entity
@Table(name="grade")
public class GradeEntity {
	
	@Id
	private int status;
	private String statusname;
	
	@Builder
	public GradeEntity(int status, String statusname) {
		super();
		this.status = status;
		this.statusname = statusname;
	}
	
	public GradeDTO toGradeDTO() {
		return GradeDTO.builder()
				.status(this.status)
				.statusname(this.statusname)
				.build();
	}

}
