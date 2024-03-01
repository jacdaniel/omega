package com.jd.omega.web.rest;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jd.omega.dto.LexiconDTO;
import com.jd.omega.dto.SimpleDTO1;
import com.jd.omega.test.sql.TestSQL;

import jakarta.validation.Valid;

@RestController
//@AllArgsConstructor
@RequestMapping("/omega/test")
public class OmegaTest {
	
	@GetMapping("/test0")
	public void getTest0() {
		System.out.printf("ok\n");
	}
	
	@GetMapping("/test1/{id}")
	public void getTest1(@PathVariable final String id) {
		System.out.printf("id: %s\n", id);
	}
	
	@GetMapping("/test2/{arg1}/toto/{arg2}")
	public void getTest2(@PathVariable final String arg1, @PathVariable final String arg2) {
		System.out.printf("arg1: %s - arg2: %s\n", arg1, arg2);
	}
	
	@GetMapping("/test3")
	public void getTest3(/*@Valid */@RequestBody final SimpleDTO1 dto) {
		System.out.printf("arg1: %s - arg2: %s\n", dto.getFirstName(), dto.getName());
	}
	
	@GetMapping("/test4")
	// @ResponseBody
	public void getTest4(@RequestParam(name = "id") String id_, @RequestParam(name = "body") String body_) { 
	    System.out.printf("id: %s - body: %s\n",  id_, body_);
	}
	
	// ==================================
	@PostMapping("/test10")
	public void postTest10(@Valid @RequestBody SimpleDTO1 dto) {
		System.out.printf("arg1: %s - arg2: %s\n",  dto.getFirstName(), dto.getName());
	}
	
	
	@PostMapping("/test11")
	public SimpleDTO1 postTest11(@Validated @RequestBody SimpleDTO1 dto) {
		SimpleDTO1 dtoOut = new SimpleDTO1();
		dtoOut.setFirstName(dto.getFirstName() + "_out");
		dtoOut.setName(dto.getName() + "_out");
		dtoOut.setAge(dto.getAge() + 3300);
		return dtoOut;
	}
	
	@GetMapping("/sql")
	public void getTestSQL()
	{
		TestSQL.test01();
		System.out.println("end");
	}
	

}
