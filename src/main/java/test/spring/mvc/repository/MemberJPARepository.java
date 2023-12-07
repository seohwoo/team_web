package test.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import test.spring.mvc.bean.MemberDTO;
import test.spring.mvc.entity.BoardEntity;
import test.spring.mvc.entity.MemberEntity;

public interface MemberJPARepository extends JpaRepository<MemberEntity, String> {

	//@Query(value="select count(*) from freemember where id=:id and passwd=:passwd and status > 0", nativeQuery = true)
	//public int loginCheck(@Param("dto") MemberDTO dto);
}
