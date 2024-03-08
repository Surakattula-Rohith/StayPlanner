package com.stackroute.customerservice;

import com.stackroute.customerservice.filter.CustomerFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@CrossOrigin("*")
public class CustomerServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerServiceApplication.class, args);
	}
//	@Bean
//	public FilterRegistrationBean getBean(){
//		FilterRegistrationBean bean=new FilterRegistrationBean<>();
//		bean.setFilter(new CustomerFilter());
//		bean.addUrlPatterns("/Customer/*");
//		return bean;
	//}
}
