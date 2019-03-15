package com.wonwoo.wonwooblog;

import java.util.concurrent.TimeUnit;

import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
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
@EnableCaching // https://jeong-pro.tistory.com/170
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
	
	/**
	 * blog.category라는 키에 1분동안 캐시를 한다고 지정해줬다.
	 * Duration 에는 ONE_DAY, ONE_HOUR, THIRTY_MINUTES, TEN_MINUTES 기타 등등 여러가지의 시간이 있기는 하지만 거기에 없는 시간이 있다면 만들면 된다.
	 */
	@Bean
	public JCacheManagerCustomizer cacheManagerCustomizer() {
		return cm -> cm.createCache("blog.category", initConfiguration(TEN_SECONDS));
	}

	public static final Duration TEN_SECONDS = new Duration(TimeUnit.SECONDS, 10);

	private MutableConfiguration<Object, Object> initConfiguration(Duration duration) {
		return new MutableConfiguration<>()
			.setStatisticsEnabled(true)
			.setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(duration));
	}

}
