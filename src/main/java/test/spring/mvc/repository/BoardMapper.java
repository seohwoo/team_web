package test.spring.mvc.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import test.spring.mvc.bean.BoardDTO;
import test.spring.mvc.bean.FreeBoardFileDTO;

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
	public int fileInsert(	@Param("boardnum") int boardnum,
							@Param("filename") String filename);
	public List<FreeBoardFileDTO> findImg(int boardnum);
	public void deleteImg(int boardnum);
	public List<BoardDTO> findAllRef(int ref);
}
