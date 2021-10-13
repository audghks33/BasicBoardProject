package com.audghks33.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.audghks33.domain.BoardVO;
import com.audghks33.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		
		log.info("등록 서비스 임플   " +board);
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		
		log.info("가져오기 서비스임플 "+ bno+"번");
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		
		log.info("변경 서비스임플 "+ board);
		
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		
		log.info("삭제 서비스임플 "+ bno+ "번");
		
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		
		log.info("리스트 보기 서비스임플");
		
		return mapper.getList();
	}
	
	
}
