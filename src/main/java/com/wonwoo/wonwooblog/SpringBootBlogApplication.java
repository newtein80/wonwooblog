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
// @RestController // Message 전송
@EntityScan(basePackageClasses = {SpringBootBlogApplication.class, Jsr310JpaConverters.class})
public class SpringBootBlogApplication {

	// sql을 resources 아래의 import.sql 파일을 만들면 서버를 실행할 때 해당 sql이 자동으로 실행 된다.

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBlogApplication.class, args);
	}

	// // @RequestMapping("/hello")
	// @GetMapping // @RequestMapping("/") 와 같은가 ?????
	// public String hello() {
	// 	return "hello";
	// }

	/**
	 * Bean 을 다른 클래스로 빼서 helper 클래스를 만들어서 관리하는 방법 ?????
	 */
	// @Bean
    // public SpringDataDialect springDataDialect() {
    //     return new SpringDataDialect();
    // }

}
