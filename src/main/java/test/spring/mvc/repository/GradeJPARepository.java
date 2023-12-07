package test.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.spring.mvc.entity.GradeEntity;

public interface GradeJPARepository extends JpaRepository<GradeEntity, Integer>{

}
