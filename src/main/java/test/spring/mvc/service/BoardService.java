package test.spring.mvc.service;

import java.util.ArrayList;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import test.spring.mvc.bean.BoardDTO;

public interface BoardService {
	public int listCount();
	public void showList(int pageNum, Model model);
	public void create(BoardDTO dto);
	public int fileUpload(ArrayList<MultipartFile> files);
	public BoardDTO readContent(int num);
	public BoardDTO update(int num);
	public int updateArticle(BoardDTO dto);
	public int deleteArticle(int num, String passwd);
}
