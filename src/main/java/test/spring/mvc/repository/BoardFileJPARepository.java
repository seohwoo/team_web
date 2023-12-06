package test.spring.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import test.spring.mvc.entity.BoardEntity;
import test.spring.mvc.entity.BoardFileEntity;

public interface BoardFileJPARepository extends JpaRepository<BoardFileEntity, Integer> {

	public List<BoardFileEntity> findByFreeboardnum(@Param("freeboardnum") int freeboardnum);
	
	@Transactional
	public void deleteByFreeboardnum(@Param("freeboardnum") int freeboardnum);
}
