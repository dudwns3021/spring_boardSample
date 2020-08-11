package org.sample.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.sample.domain.Criteria;
import org.sample.domain.ReplyPageDTO;
import org.sample.domain.ReplyVO;

public interface ReplyService {

	public int register(ReplyVO vo);
	public ReplyVO get(Long rno);
	public int modify(ReplyVO vo);
	public int remove(Long rno);
	public List<ReplyVO> getList(Criteria cri, Long bno);
	
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);
	public int getCountByBno(Long bno);
	public ReplyPageDTO getListPage(Criteria cri, Long bno);
}
