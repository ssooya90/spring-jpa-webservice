package com.ssooya.webservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication // 스프링부트의 자동설정., 스프링 Bean 읽기와 생성 모두 자동화
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
