package test.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.spring.mvc.entity.MemberEntity;

public interface MemberJPARepository extends JpaRepository<MemberEntity, String>{
	
}
