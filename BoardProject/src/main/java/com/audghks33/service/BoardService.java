package com.audghks33.service;

import java.util.List;

import com.audghks33.domain.BoardVO;
import com.audghks33.domain.Criteria;

public interface BoardService {

	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long bno);
	
	/* public List<BoardVO> getList(); */
	
	public List<BoardVO> getList(Criteria cri);
}
