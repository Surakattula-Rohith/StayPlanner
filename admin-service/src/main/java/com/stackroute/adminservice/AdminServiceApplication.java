package com.stackroute.adminservice;

import com.stackroute.adminservice.filter.AdminFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
@EnableDiscoveryClient
@CrossOrigin("*")
public class AdminServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);

//		@Bean
//		public FilterRegistrationBean getBean(){
//			FilterRegistrationBean bean=new FilterRegistrationBean<>();
//			bean.setFilter(new AdminFilter());
//			bean.addUrlPatterns("/Admin/*");
//			return bean;
//		}
	}



}
