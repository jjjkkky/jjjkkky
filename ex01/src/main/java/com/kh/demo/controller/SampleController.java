package com.kh.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sample/*")
public class SampleController {
	@GetMapping("")
	public String empty() {
		System.out.println("=================== ===================");
		return "a";
	}
	
	@RequestMapping("basic")
	public void voidvoidvoidvoid() {
		System.out.println("==========basic==========");
	}
	
	@GetMapping("basic1")
	public void basicGet(int age) {
		System.out.println("==========GET 방식으로 호출==========");
		System.out.println("age : " + age);
	}
	
	@PostMapping("basic1")
	public void basicPost(int age) {
		System.out.println("==========POST 방식으로 호출==========");
		System.out.println("age : " + age);
	}
	
	@GetMapping("test05")
	public void test05() {
		String str = null;
		str.charAt(10);
	}
}
