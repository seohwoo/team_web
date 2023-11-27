package test.spring.mvc.repository;

import java.util.HashMap;
import java.util.List;

import test.spring.mvc.bean.BoardDTO;

public interface BoardMapper {
	public int count();
	
	public List<BoardDTO> list(HashMap map);

	public int maxNum();
	
	public void writeUpdate(BoardDTO dto);
	
	public void writeInsert(BoardDTO dto);
	
	public void updateCountUp(int num);
	
	public BoardDTO readNum(int num);
	
	public String readPasswd(int num);
	
	public int updateNum(BoardDTO dto);
	
	public int deleteNum(int num);
}
