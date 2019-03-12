package com.wonwoo.wonwooblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // Message 전송
public class SpringBootBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBlogApplication.class, args);
	}

	// @RequestMapping("/hello")
	@GetMapping // @RequestMapping("/") 와 같은가 ?????
	public String hello() {
		return "hello";
	}

}
