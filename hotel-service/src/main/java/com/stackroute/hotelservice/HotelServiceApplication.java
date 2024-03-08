package com.stackroute.hotelservice;

import com.stackroute.hotelservice.filter.Filter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@CrossOrigin("*")
public class HotelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelServiceApplication.class, args);
	}
//		@Bean
//	    public FilterRegistrationBean getBean(){
//		FilterRegistrationBean bean = new FilterRegistrationBean();
//		bean.setFilter(new Filter());
//		bean.addUrlPatterns("/api/v1/*");
//		return bean;
//	}
@Bean
public WebMvcConfigurer corsConfigurer()
{
	return new WebMvcConfigurer() {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
		}
	};
}


}
