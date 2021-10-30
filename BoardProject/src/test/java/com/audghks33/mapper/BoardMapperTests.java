package com.audghks33.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.audghks33.domain.BoardVO;
import com.audghks33.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	/*
	 * @Test public void testGetList() { mapper.getList().forEach(board ->
	 * log.info(board)); }
	 */
	
	/*
	 * @Test public void testInsert() { BoardVO board = new BoardVO();
	 * board.setTitle("테스트 인서트 새작글"); board.setContent("테스트 인서트 새작내용");
	 * board.setWriter("테스트 인서트 글작성자");
	 * 
	 * mapper.insert(board);
	 * 
	 * log.info(board); }
	 */
	/*
	 * @Test public void testInsertSelectKey() { BoardVO board = new BoardVO();
	 * board.setContent("테스트 셀렉키 새내용"); board.setTitle("테스트 셀렉키 새제목");
	 * board.setWriter("테스트 셀렉키 글쓴사람");
	 * 
	 * mapper.insertSelectKey(board);
	 * 
	 * log.info(board); }
	 * 
	 * @Test public void testRead() { BoardVO board = mapper.read(5L);
	 * 
	 * log.info(board); }
	 * 
	 * @Test public void testDelete() {
	 * 
	 * log.info("Delete count:  " + mapper.delete(4L)); }
	 * 
	 * @Test public void testUpdate() { BoardVO board = new BoardVO();
	 * board.setContent("변경된 내용"); board.setTitle("변경된 제목");
	 * board.setWriter("변경된 작가"); board.setBno(5L);
	 * 
	 * log.info("update count: " + mapper.update(board));
	 * 
	 * }
	 */
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		cri.setAmount(10);
		cri.setPageNum(3);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
	}
	
}
