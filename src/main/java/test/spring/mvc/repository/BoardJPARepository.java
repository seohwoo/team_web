package test.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import test.spring.mvc.bean.BoardDTO;
import test.spring.mvc.entity.BoardEntity;
import test.spring.mvc.entity.TestEntity;

public interface BoardJPARepository extends JpaRepository<BoardEntity, Integer> {
	// 쿼리문 직접 짤 때 nativeQuery = true 쓰는거 필수
	@Query(value="select max(num) from freeboard", nativeQuery = true)
	public int findMaxNum();
	
	@Transactional // 추가, 수정, 삭제에는 필수로 써야함
	@Modifying // 똑같이 필수
	@Query(value="update freeboard set re_step=re_step+1 where ref=:ref and re_step > :re_step", nativeQuery = true)
	public void writeUpdate(@Param("ref") int ref, 
							@Param("re_step") int re_step);
	
	@Transactional
	@Modifying
	@Query(value="update freeboard set readcount=readcount+1 where num=:num", nativeQuery = true)
	public void readCount(@Param("num") int num);
	
	@Transactional
	@Modifying
	@Query(value="update freeboard set "
			+ "writer=:#{#dto.writer}, "
			+ "email=:#{#dto.email}, "
			+ "subject=:#{#dto.subject}, "
			+ "content=:#{#dto.content}"
			+ "where num=:#{#dto.num}", nativeQuery = true)
	public void updateNum(@Param("dto") BoardDTO dto);
}
