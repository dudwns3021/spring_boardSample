package org.sample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.sample.domain.SampleVO;
import org.sample.domain.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {

	@GetMapping(value = "getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		
		return "hello";
	}
	
	@GetMapping(value = "/getSample", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112, "aaa", "bbb");
	}
	
	@GetMapping(value = "/getSample2")
	public SampleVO getSample2() {
		return new SampleVO(123, "ccc", "ddd");
	}
	
	@GetMapping(value = "/getList")
	public List<SampleVO> getList() {
		return IntStream.range(1,10).mapToObj(i -> new SampleVO(i, i + "First", i + " Last")).collect(Collectors.toList());
	}
	
	@GetMapping(value = "/getMap")
	public Map<String, SampleVO> getMap() {
		Map<String, SampleVO> map = new HashMap<>();
		map.put("First", new SampleVO(111, "eee", "fff"));
		
		return map;
	}
	
	@GetMapping(value = "/check", params = { "height", "weight" })
	public ResponseEntity<SampleVO> check(Double height, Double weight) {
		SampleVO vo = new SampleVO(0, "" + height, "" + weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if (height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getpath(@PathVariable("cat") String cat, @PathVariable("pid") Integer pid) {
		return new String[] {"category: " + cat, "productid: " + pid};
	}
	@GetMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert.....ticekt" + ticket);
		
		return ticket;
	}
}
