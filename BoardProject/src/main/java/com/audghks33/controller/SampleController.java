package com.audghks33.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.audghks33.domain.SampleDTO;
import com.audghks33.domain.SampleDTOList;
import com.audghks33.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@RequestMapping("")
	public void basic() {
		log.info("TETSSTSTSTESET");
	}
	
	@RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get....................");
	}
	
	@GetMapping
	public void basicGet2() {
		log.info("basic get2222222....................");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("dto "+dto);
		
		return "ex01";
		//http://localhost:8080/sample/ex01?age=777&name=ffff
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("Sname") String name, @RequestParam("Sage") int age) {
		log.info("name "+name);
		log.info("age "+age);
		
		return "ex02";
		//http://localhost:8080/sample/ex02?Sage=777&Sname=ffff
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		log.info("ids: "+ids);
		
		return "ex02List";
		//http://localhost:8080/sample/ex02List?ids=aaa,aa,a
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("ids: "+ Arrays.toString(ids));
		
		return "ex02Array";
		//http://localhost:8080/sample/ex02Array?ids=bbb,bb,b
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list dtos: "+list);
		
		return "ex02Bean";
		//http://localhost:8080/sample/ex02Bean?list%5B0%5D.name=aaa&list%5B2%5D.name=bbb
		//[ %5B ] %5D
	}

	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) { SimpleDateFormat
	 * dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 * binder.registerCustomEditor(java.util.Date.class, new
	 * CustomDateEditor(dateFormat, false)); }
	 * TodoDTO에 @DateTimeFormat(pattern= "yyyy/MM/dd") 추가하면 불필요
	 */
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo: "+ todo);
		return "ex03";
		//http://localhost:8080/sample/ex03?dueDate=2018-01-01&title=ffff
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, int page) {
		log.info("dto: "+ dto);
		log.info("page:" + page);
		return "/sample/ex04";
		//http://localhost:8080/sample/ex04?name=aaa&age=11&page=2
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		//body에 태워보냄?
		log.info("/ex06...............");
		SampleDTO dto =new SampleDTO();
		dto.setAge(111);
		dto.setName("미스터홍");
		
		return dto;
		//http://localhost:8080/sample/ex06
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		//responseEntity는 HttpHeaders 객체 전달로 원하는 헤더 메세지 가공가능
		log.info("/ex07.............");
		
		//{"name": "홍길동"}
		String msg = "{\"name\": \"홍길동\"}";
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type","application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header,HttpStatus.OK);
		//http://localhost:8080/sample/ex07
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUPload.................");
		//http://localhost:8080/sample/exUpload
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file -> {log.info("...................");
		log.info("name: " + file.getOriginalFilename());
		log.info("size:" +file.getSize());
			
			
		});
	}
}
