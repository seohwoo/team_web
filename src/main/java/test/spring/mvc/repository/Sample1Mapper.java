package test.spring.mvc.repository;

import org.apache.ibatis.annotations.Insert;

public interface Sample1Mapper {
	
	@Insert("insert into tbl_sample1 values(#{data})")
	public int insertCol1(String data);
}
