package test.spring.mvc.repository;

import java.util.HashMap;
import java.util.List;

import test.spring.mvc.bean.BoardDTO;

public interface BoardMapper {
	public int listCount();
	public List<BoardDTO> showList(HashMap<String, Integer> map);
	public int maxNum();
	public void writeUpdate(BoardDTO dto);
	public void writeInsert(BoardDTO dto);
}
