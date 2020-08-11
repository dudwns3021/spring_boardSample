package org.sample.mapper;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.domain.BoardVO;
import org.sample.domain.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	@Test
	public void testGetList() {
		System.out.println("ssssss");
		mapper.getList().forEach(board -> log.info(board));
		
	}
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("new content");
		board.setContent("new content2");
		board.setWriter("newbie");
		
		mapper.insert(board);
		log.info(board);
	}
//	@Test
//	public void testInsertSelectKey() {
//		BoardVO board = new BoardVO();
//		board.setTitle("new content1 select key");
//		board.setContent("new content12 select key");
//		board.setWriter("newbie");
//		
//		mapper.insertSelectKey(board);
//		System.out.println("------------------------------------------------------");
//		log.info(board);
//	}
	@Test
	public void testRead() {
		BoardVO board = mapper.read(5L);
		log.info(board);
	}
	@Test
	public void testDelete() {
		log.info("DELETE COUNT: " + mapper.delete(3L));
	}
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(5L);
		board.setTitle("modify content");
		board.setContent("modify content2");
		board.setWriter("user00");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT: " + count);
	}
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		
		cri.setPageNum(3);
		cri.setAmount(10);
		cri.setRowNum(0);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board.getBno()));
	}
	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("»õ·Î");
		cri.setType("TC");
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
}
