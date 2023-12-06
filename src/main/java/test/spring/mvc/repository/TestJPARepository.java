package test.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.spring.mvc.entity.TestEntity;

public interface TestJPARepository extends JpaRepository<TestEntity, String> {

}
