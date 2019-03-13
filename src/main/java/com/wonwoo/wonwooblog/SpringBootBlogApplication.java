package com.wonwoo.wonwooblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;
// import org.thymeleaf.dialect.springdata.SpringDataDialect;

@SpringBootApplication
@RestController // Message 전송
@EntityScan(basePackageClasses = {SpringBootBlogApplication.class, Jsr310JpaConverters.class})
public class SpringBootBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBlogApplication.class, args);
	}

	// @RequestMapping("/hello")
	@GetMapping // @RequestMapping("/") 와 같은가 ?????
	public String hello() {
		return "hello";
	}

	// @Bean
	// public SpringDataDialect springDataDialect() {
	// 	return new SpringDataDialect();
	// }

}
