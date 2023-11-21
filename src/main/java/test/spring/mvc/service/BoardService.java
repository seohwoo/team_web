package test.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.spring.mvc.bean.BoardDTO;
import test.spring.mvc.repository.BoardMapper;

@Service
public class BoardService {

	@Autowired
	private BoardMapper mapper;
	
	public List<BoardDTO> read(){
		return mapper.showBoard();
	}
	
	public int create(BoardDTO dto) {
		return mapper.insertBoard(dto);
	}
	
}
