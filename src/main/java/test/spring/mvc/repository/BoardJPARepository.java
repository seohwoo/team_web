package test.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.spring.mvc.entity.BoardEntity;

public interface BoardJPARepository extends JpaRepository<BoardEntity, Integer>{

}
