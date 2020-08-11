package org.sample.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {

	private int pageNum;
	private int amount;
	private int rowNum;
	
	private String type;
	private String keyword;
	
	public Criteria() {
		this(1,10, 1);
	}
	
	public Criteria(int pageNum, int amount, int rowNum) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.rowNum = (pageNum - 1) * amount;
		
	}
	
	public int getRowNum() {
		return (pageNum - 1) * amount;
	}
	
	public String[] getTypeArr() {
		return type == null? new String[] {}: type.split("");
	}
	
	public String getListLink() {
		UriComponentsBuilder bulider = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.getPageNum())
				.queryParam("amount", this.getAmount())
				.queryParam("rowNum", this.getRowNum())
				.queryParam("type", this.getType())
				.queryParam("pageNum", this.getKeyword());
		return bulider.toUriString();
	}
}
