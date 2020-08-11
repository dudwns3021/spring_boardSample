package org.sample.service;

import static org.junit.Assert.assertNotNull;

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
public class BoardServiceTests {

	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	@Test
	public void testExist() {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		log.info("service: " + service);
		assertNotNull(service);
	}
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("new new content");
		board.setContent("new new content2");
		board.setWriter("newbie");
		
		service.register(board);
		log.info("number: " + board.getBno());
	}
	@Test
	public void testGetList() {
		
//		service.getList().forEach(board -> log.info(board));
		service.getList(new Criteria(2, 10, 1)).forEach(board -> log.info(board));
	}
	@Test
	public void testGet() {
		log.info(service.get(1L));
	}
	@Test
	public void testDelete() {
		log.info("Remove Result: " + service.remove(2L));
	}
	@Test
	public void testUpdate() {
		BoardVO board = service.get(1L);
		if (board == null) {
			return;
		}
		board.setTitle("modify title");
		log.info("Modify Result: " + service.modify(board));
	}
}
