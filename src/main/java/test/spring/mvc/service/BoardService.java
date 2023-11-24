package test.spring.mvc.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;

import test.spring.mvc.bean.BoardDTO;

public interface BoardService {
	public int count();

	public void list(int pageNum, Model model);

	public void create(BoardDTO dto);




}

