package test.spring.mvc.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import test.spring.mvc.bean.BoardDTO;

public interface BoardMapper {
	public int listCount();
	public List<BoardDTO> showList(HashMap<String, Integer> map);
	public int maxNum();
	public void writeUpdate(BoardDTO dto);
	public void writeInsert(BoardDTO dto);
	public void updateCountUp(int num);
	public BoardDTO readNum(int num);
	public int updateNum(BoardDTO dto);
	public String readPasswd(int num);
	public int deleteNum(int num);
	
	public int fileInsert(@Param("freeboardnum") int freeboardnum, 		
						  @Param("fileName") String fileName);
	// TEST
	public List<String> fileUpdate(int freeboardnum); 

	
	public String test(int num);
	
	public void fileDelete(int num);
}
