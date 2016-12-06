package com.ciecc.fire;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BootApplication {
	
	@RequestMapping("/")
	String index(){
		return "Hello Spring Boot";
	}

	public static void main(String[] args) {
		//SpringApplication.run(BootApplication.class, args);  // 1
		
//		SpringApplication app = new SpringApplication(BootApplication.class);
//		app.setBannerMode(Banner.Mode.OFF);
//		app.run(args); //2
		
		new SpringApplicationBuilder(BootApplication.class)
        .bannerMode(Banner.Mode.OFF)
        .run(args);
		
		
		
	}
}
