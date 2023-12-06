package test.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.spring.mvc.entity.BoardEntity;
import test.spring.mvc.entity.BoardFileEntity;

public interface BoardFileJPARepository extends JpaRepository<BoardFileEntity, Integer> {

}
