package org.mindtree.employeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableTransactionManagement

@EnableSwagger2
@EnableCaching
public class ApplicationStart extends SpringBootServletInitializer {
	
	public static void main(String[] args) throws Exception {
	SpringApplication.run(ApplicationStart.class, args);
	}
	
	/*
	public CacheManager cacheManager()
	{
		 ConcurrentMapCacheManager cacheManager=new ConcurrentMapCacheManager("employee");
		return cacheManager;
	}*/
	@Bean
	public Docket docket() 
	{
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("org.mindtree.employeemanagement.web.api"))
				.paths(PathSelectors.any()).build();
	}
	@Override
	protected SpringApplicationBuilder configure( SpringApplicationBuilder builder) {
		
		return builder.sources(ApplicationStart.class);
	} 
}
