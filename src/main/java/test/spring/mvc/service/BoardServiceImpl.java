package test.spring.mvc.service;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import test.spring.mvc.bean.BoardDTO;
import test.spring.mvc.bean.BoardFileDTO;
import test.spring.mvc.bean.FreeBoardFileDTO;
import test.spring.mvc.entity.BoardEntity;
import test.spring.mvc.entity.BoardFileEntity;
import test.spring.mvc.repository.BoardFileHJPARepository;
import test.spring.mvc.repository.BoardJPARepository;
import test.spring.mvc.repository.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardJPARepository boardJPA;
	
	@Autowired
	private BoardFileHJPARepository boardFileJPA;

	@Override
	public int listCount() {
		return (int) boardJPA.count();
	}

	@Override
	public void showList(int pageNum, Model model) {
		int pageSize = 10;
		int cnt = listCount();
		List<BoardDTO> list = Collections.EMPTY_LIST;	// Collections.EMPTY_LIST : 빈 리스트
		if(cnt > 0) {
			Sort sort = Sort.by(Sort.Order.desc("ref"), Sort.Order.asc("reStep"));
			Page<BoardEntity> page = boardJPA.findAll(PageRequest.of(pageNum-1, pageSize, sort));
			List<BoardEntity> entityList = page.getContent();
			list = new ArrayList<BoardDTO>();
			for (BoardEntity boardEntity : entityList) {
				BoardDTO dto = boardEntity.toBoardDTO();
				list.add(dto);
			}
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
		int number = boardJPA.findMaxNum()+1;
		if(dto.getNum() != 0) {
			boardJPA.writeUpdate(dto.getRef(), dto.getRe_step());
			dto.setRe_step(dto.getRe_step()+1);
			dto.setRe_level(dto.getRe_level()+1);
		}else {
			dto.setRe_step(number);
		}
		dto.setReg_date(new Timestamp(System.currentTimeMillis()));
		dto.setNum(0);
		boardJPA.save(dto.toBoardEntity());
	}

	@Override
	public BoardDTO readContent(int num) {
		boardJPA.readCount(num);
		return boardJPA.findById(num).get().toBoardDTO();
	}

	@Override
	public BoardDTO update(int num) {
		return boardJPA.findById(num).get().toBoardDTO();
	}

	@Override
	public int updateArticle(BoardDTO dto) {
		int check = 0;
		if(boardJPA.findById(dto.getNum()).get().toBoardDTO().getPasswd().equals(dto.getPasswd())) {
			boardJPA.updateNum(dto);
			check++;
		}
		return check;
	}

	@Override
	public int deleteArticle(int num, String passwd) {
		int check = 0;
		if(boardJPA.findById(num).get().toBoardDTO().getPasswd().equals(passwd)) {
			boardJPA.deleteById(num);
			boardFileJPA.deleteByFreeboardnum(num);
			check++;
		}
		return check;
	}

	@Override
	public int fileUpload(ArrayList<MultipartFile> files, String path) {
		int result = 0;
		int boardnum = boardJPA.findMaxNum();
		for (int i = 1; i <= files.size(); i++) {
			MultipartFile file = files.get(i-1);
			String filename = file.getOriginalFilename();
			BoardFileDTO dto = new BoardFileDTO();
			if(!filename.equals("")) {
				String ext = filename.substring(filename.lastIndexOf("."));
				filename = "file_"+boardnum+"_"+i+ext;
				File copy = new File(path+filename);
				dto.setFreeboardnum(boardnum);
				dto.setFilename(filename);
				boardFileJPA.save(dto.toBoardFileEntity());
				result++;
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
	public List<BoardFileDTO> findImg(int freeboardnum) {
		List<BoardFileEntity> entityList = boardFileJPA.findByFreeboardnum(freeboardnum); 
		List<BoardFileDTO> list = null;
		if(entityList.size() >0) {
			list = new ArrayList<BoardFileDTO>();
			for (BoardFileEntity entity : entityList) {
				BoardFileDTO dto = entity.toBoardFileDTO();
				list.add(dto);
			}
		}
		return list;
	}

	@Override
	public List<BoardDTO> findAllRef(int ref) {
		return null;
	}

	
}
