package com.audghks33.mapper;

import java.util.List;

import com.audghks33.domain.BoardVO;
import com.audghks33.domain.Criteria;

public interface BoardMapper {

	/* @Select("select * from tbl_board where bno>0") */
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long Bno);

	public int delete(Long bno);
	
	public int update(BoardVO board);
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
}
