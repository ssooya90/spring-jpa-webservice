package com.ssooya.webservice.web;

import com.ssooya.webservice.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// RestController -> json을 반환하는 컨트롤러 (기존 RequestBody를 추가하던 것을 생략할 수 있음)
@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello(){
		return "hello";
	}

	@GetMapping("hello/dto")
	public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){

		return new HelloResponseDto(name, amount);

	}
}
