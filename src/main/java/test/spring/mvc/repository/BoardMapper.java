package test.spring.mvc.repository;

import java.util.List;

import test.spring.mvc.bean.BoardDTO;

public interface BoardMapper {

	public List<BoardDTO> showBoard();
	public int insertBoard(BoardDTO dto);
}
