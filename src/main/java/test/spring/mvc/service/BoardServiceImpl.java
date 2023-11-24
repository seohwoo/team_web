package test.spring.mvc.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import test.spring.mvc.bean.BoardDTO;
import test.spring.mvc.bean.MemberDTO;
import test.spring.mvc.repository.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	@Autowired
	private HashMap<String, Integer> boardMap;

	@Override
	public int listCount() {
		return mapper.listCount();
	}

	@Override
	public void showList(int pageNum, Model model) {
		int pageSize = 10;
		int start = (pageNum -1) * pageSize +1;
		int end = pageNum * pageSize;
		int cnt = mapper.listCount();
		List<BoardDTO> list = Collections.EMPTY_LIST;	// Collections.EMPTY_LIST : 빈 리스트
		if(cnt > 0) {
			boardMap.put("end", end);
			boardMap.put("start", start);
			list = mapper.showList(boardMap);
		}
		//	model에 담았다면, Model을 리턴받을 필요가 없다.
		model.addAttribute("userList", list);
		model.addAttribute("userCnt", cnt);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNum", pageNum);
		
		//page
		int pageCnt = cnt / pageSize + (cnt % pageSize == 0 ? 0 : 1);
		int pageBlock = 10;
		int startPage = (int)(pageNum/10)*10+1;
		int endPage = startPage + pageBlock -1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		model.addAttribute("pageCnt", pageCnt);
		model.addAttribute("pageBlock", pageBlock);
		model.addAttribute("startPage", startPage);
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
			dto.setRe_step(number);
		}
		mapper.writeInsert(dto);
	}
}
