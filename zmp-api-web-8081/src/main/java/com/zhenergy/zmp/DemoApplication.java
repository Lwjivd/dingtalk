package com.zhenergy.zmp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {
	
    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DemoApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
        LOGGER.info("Ding Talk API Started...");
    }
    
    @Bean
    public CorsFilter corsFilter() {
    	UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
    	CorsConfiguration config = new CorsConfiguration();
    	config.addAllowedOrigin("*");
    	config.addAllowedHeader("*");
    	config.addAllowedMethod("*");
		configSource.registerCorsConfiguration("/**", config);
		return new CorsFilter(configSource);
    }
    
    @Bean
	@ConditionalOnMissingBean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
