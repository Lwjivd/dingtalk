package com.zhenergy.zmp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import com.zhenergy.zmp.system.local.extuser.service.base.LocalExtUserService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	@Bean
	@ConditionalOnMissingBean
	public LocalExtUserService localExtUserService() {
		return new LocalExtUserService();
	}
}