package test.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.spring.mvc.entity.BoardFileEntity;

public interface BoardFileHJPARepository extends JpaRepository<BoardFileEntity, Integer>{

}
