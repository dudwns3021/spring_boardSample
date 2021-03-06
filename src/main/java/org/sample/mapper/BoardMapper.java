package org.sample.mapper;

import java.util.List;

import org.sample.domain.BoardVO;
import org.sample.domain.Criteria;

public interface BoardMapper {

	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public void insert(BoardVO board);
	//public void insertSelectKey(BoardVO board);
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	public int update(BoardVO board);
	
	public int getTotalCount(Criteria cri);
	
}
