package test.spring.mvc.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import test.spring.mvc.bean.BoardDTO;
import test.spring.mvc.bean.FreeBoardFileDTO;
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

	@Override
	public BoardDTO readContent(int num) {
		mapper.updateCountUp(num);
		return mapper.readNum(num);
	}

	@Override
	public BoardDTO update(int num) {
		return mapper.readNum(num);
	}

	@Override
	public int updateArticle(BoardDTO dto) {
		int check = 0;
		if(mapper.readPasswd(dto.getNum()).equals(dto.getPasswd())) {
			check = mapper.updateNum(dto);
		}
		return check;
	}

	@Override
	public int deleteArticle(int num, String passwd) {
		int check = 0;
		if(mapper.readPasswd(num).equals(passwd)) {
			check = mapper.deleteNum(num);
			mapper.deleteImg(num);
		}
		return check;
	}

	@Override
	public int fileUpload(ArrayList<MultipartFile> files, String path) {
		int result = 0;
		int boardnum = mapper.maxNum();
		for (int i = 1; i <= files.size(); i++) {
			MultipartFile file = files.get(i-1);
			String filename = file.getOriginalFilename();
			if(!filename.equals("")) {
				String ext = filename.substring(filename.lastIndexOf("."));
				filename = "file_"+boardnum+"_"+i+ext;
				File copy = new File(path+filename);
				result = mapper.fileInsert(boardnum, filename);
				try {
					file.transferTo(copy);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public List<FreeBoardFileDTO> findImg(int boardnum) {
		return mapper.findImg(boardnum);
	}

	@Override
	public List<BoardDTO> findAllRef(int ref) {
		return mapper.findAllRef(ref);
	}
}
