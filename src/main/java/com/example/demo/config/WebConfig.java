package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	// WebMvcConfigurer의 메서드를 오버라이딩하여 원하는 기능을 추가/커스터마이즈할 수 있음

	   @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	            //.allowedOrigins("http://172.16.54.57:3000")
	        	.allowedOrigins("http://192.168.0.72:3000")
	        	//.allowedOrigins("http://192.168.76.205:3000")
	            .allowedMethods("GET", "POST", "PUT", "DELETE")
	            .allowedHeaders("*")
	            .allowCredentials(true);
	    }
}
