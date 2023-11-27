package test.spring.mvc.service;

import org.springframework.ui.Model;

import test.spring.mvc.bean.BoardDTO;

public interface BoardService {
	public int listCount();
	public void showList(int pageNum, Model model);
	public void create(BoardDTO dto);
	public BoardDTO readContent(int num);
	public BoardDTO update(int num);
	public int updateArticle(BoardDTO dto);
	public int deleteArticle(int num, String passwd);
}
