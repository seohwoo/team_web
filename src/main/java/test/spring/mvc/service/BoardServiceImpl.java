package test.spring.mvc.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import test.spring.mvc.bean.BoardDTO;
import test.spring.mvc.repository.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	@Autowired
	private HashMap boardMap;

	@Override
	public int count() {
		return mapper.count();
	}

	@Override
	public void list(int pageNum, Model model) {
		int pageSize = 10;
		int startRow = (pageNum -1) * pageSize +1;
		int endRow = pageNum * pageSize;
		int count = mapper.count();
		// Collections.EMPTY_LIST; -> 현재 리스트는 비어있는 리스트다
		List<BoardDTO> list = Collections.EMPTY_LIST; 
		
		if(count > 0) {
			boardMap.put("start", startRow);
			boardMap.put("end", endRow);
			list = mapper.list(boardMap);
		}
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pageSize", pageSize);
		
		//page
		int pageCount = count / pageSize + ( count % pageSize == 0 ? 0 : 1);
		int startPage = (int)(pageNum/10)*10+1;
		int pageBlock=10;
		int endPage = startPage + pageBlock-1;
		if (endPage > pageCount) {
			endPage = pageCount;
		}
		
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("startPage", startPage);
		model.addAttribute("pageBlock", pageBlock);
		model.addAttribute("endPage", endPage);
		
	}

	@Override
	public void create(BoardDTO dto) {
		int number = mapper.maxNum()+1;
		if(dto.getNum() != 0) {
			mapper.writeUpdate(dto);
			dto.setRe_step(dto.getRe_step()+1);
			dto.setRe_level(dto.getRe_level()+1);
		}else {
			dto.setRef(number);
		}
		mapper.writeInsert(dto);
	}
}

