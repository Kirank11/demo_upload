package com.app;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/sample")
public class Sample {
	
	@PostMapping("/post")
	public String postdata() {
		return "hello world";
	}
	
	@GetMapping("/get")
	public String getdata() {
		return "hello world";
	}

}
