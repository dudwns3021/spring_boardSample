package org.sample.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.domain.Criteria;
import org.sample.domain.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	private Long[] bnoArr = { 10L, 20L, 30L, 40L, 50L} ;
	
	@Test
	public void testCreate () {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO vo = new ReplyVO();
			
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("Test" + i);
			vo.setReplyer("replyer" + i);
			
			mapper.insert(vo);
		});
	}
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Test
	public void testMapper() {
		log.info("mapper : " + mapper);
	}
	@Test
	public void testRead() {
		Long targetRno = 65576L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		log.info("vo : " + vo);
	}
	
	@Test
	public void testDelete() {
		Long targetRno = 1L;
		mapper.delete(targetRno);
	}
	@Test
	public void testUpdate() {
		Long targetRno = 65626L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		vo.setReply("Update Reply ");
		int count = mapper.update(vo);
		
		log.info("UPDATE COUNT: " + count);
	}
	
	@Test
	public void testList() {
		try {
			Criteria cri = new Criteria();
			List<ReplyVO> replies = mapper.getListWithPaging(cri,  bnoArr[1]);
			log.info("---------------------------------");
			replies.forEach(reply -> log.info(reply));
		} catch (Exception e) {
			// TODO: handle exception
			log.error("error : ", e);
		}
		
	}
	@Test
	public void testList2() {
		Criteria cri = new Criteria(0, 10, 2);
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 3145745L);
		replies.forEach(reply -> log.info(reply));
	}
	
}
