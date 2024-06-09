package com.greatming.greatmingtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import org.springframework.context.annotation.ComponentScan;
// @ComponentScan(basePackages = "com.greatming")	// 扫描指定包下的bean等，默认是该注解所在的类的包，已在SpringBootApplication注解中集成
@SpringBootApplication
public class GreatmingtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreatmingtestApplication.class, args);
	}

}
