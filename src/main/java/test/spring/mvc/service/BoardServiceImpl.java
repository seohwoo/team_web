package test.spring.mvc.service;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
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
import test.spring.mvc.bean.MemberDTO;
import test.spring.mvc.entity.BoardEntity;
import test.spring.mvc.entity.BoardFileEntity;
import test.spring.mvc.repository.BoardFileJPARepository;
import test.spring.mvc.repository.BoardJPARepository;
import test.spring.mvc.repository.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardJPARepository boardJPA;
	
	@Autowired
	private BoardFileJPARepository boardFileJPA;

	@Override
	public int listCount() {
		return (int)boardJPA.count();
	}

	@Override
	public void showList(int pageNum, Model model) {
		int pageSize = 10;
		int cnt = listCount();
		List<BoardDTO> list = Collections.EMPTY_LIST;	// Collections.EMPTY_LIST : 빈 리스트
		if(cnt > 0) {
			Sort sort = Sort.by(Sort.Order.desc("ref") , Sort.Order.asc("reStep"));
			
			Page<BoardEntity> page = boardJPA.findAll(PageRequest.of(pageNum-1, pageSize, sort));
			List<BoardEntity> entityList = page.getContent();
			list = new ArrayList<>();
			
			for(BoardEntity be : entityList) {
				BoardDTO dto = be.toBoardDTO();
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
		String dbpw = boardJPA.findById(dto.getNum()).get().toBoardDTO().getPasswd();
		int check = 0;
		if(dbpw.equals(dto.getPasswd())) {
			boardJPA.updateNum(dto);
			check++;
		}
		return check;
	}

	@Override
	public int deleteArticle(int num, String passwd, String path) {
		String dbpw = boardJPA.findById(num).get().toBoardDTO().getPasswd();
		int check = 0;
		if(dbpw.equals(passwd)) {
			List<BoardFileEntity> entityList = boardFileJPA.findByFreeboardnum(num);
			
			if(entityList != null) {
				for(BoardFileEntity fileDTO : entityList) {
					File f = new File(path+fileDTO.getFilename());
					if(f.isFile()) {
						f.delete();
					}
				}
			}
			boardFileJPA.deleteByFreeboardnum(num);
			boardJPA.deleteById(num);
			check++;
		}
		return check;
	}


	@Override
	public int fileUpload(ArrayList<MultipartFile> files, String path) {
		int result = 0;
		int freeboardNum = boardJPA.findMaxNum();
		
		for(int i = 0; i < files.size(); i++) {
			MultipartFile f = files.get(i);
			String fileName = f.getOriginalFilename();
			BoardFileDTO fileDTO = new BoardFileDTO();
			
			if(!fileName.equals("")) {
				String ext = fileName.substring(fileName.lastIndexOf("."));
				fileName = "file_"+freeboardNum+"_"+i+ext;
				File copy = new File(path+fileName);
				fileDTO.setFreeboardnum(freeboardNum);
				fileDTO.setFilename(fileName);
				boardFileJPA.save(fileDTO.toBoardFileEntity());
				result++;
				
				try {
					f.transferTo(copy);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public List<BoardFileDTO> fileList(int freeboardnum) {
		List<BoardFileEntity> entityList = null;
		List<BoardFileDTO> fileList = null;
		entityList = boardFileJPA.findByFreeboardnum(freeboardnum);
		
		if(entityList.size() > 0) {
			fileList = new ArrayList<>();
			
			for(BoardFileEntity bfe : entityList) {
				BoardFileDTO dto = bfe.toBoardFileDTO();
				fileList.add(dto);
			}
		}
		return fileList;
	}
}




/*
package test.spring.mvc.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import test.spring.mvc.bean.BoardDTO;
import test.spring.mvc.bean.BoardFileDTO;
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
	public int deleteArticle(int num, String passwd, String path) {
		int check = 0;
		if(mapper.readPasswd(num).equals(passwd)) {
			List<BoardFileDTO> fileList = mapper.fileList(num);
			if(fileList != null) {
				for(BoardFileDTO fileDTO : fileList) {
					File f = new File(path+fileDTO.getFilename());
					if(f.isFile()) {
						f.delete();
					}
				}
			}
			mapper.deleteFile(num);
			check = mapper.deleteNum(num);
		}
		return check;
	}


	@Override
	public int fileUpload(ArrayList<MultipartFile> files, String path) {
		int result = 0;
		int freeboardNum = mapper.maxNum();
		for(int i = 0; i < files.size(); i++) {
			MultipartFile f = files.get(i);
			String fileName = f.getOriginalFilename();
			if(!fileName.equals("")) {
				String ext = fileName.substring(fileName.lastIndexOf("."));
				fileName = "file_"+freeboardNum+"_"+i+ext;
				File copy = new File(path+fileName);
				result += mapper.fileInsert(freeboardNum, fileName);
				try {
					f.transferTo(copy);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public List<BoardFileDTO> fileList(int freeboardnum) {
		return mapper.fileList(freeboardnum);
	}
	
	
}
*/