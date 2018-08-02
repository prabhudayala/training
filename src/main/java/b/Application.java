package b;

import java.sql.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		
		RestTemplate restTemplate = new RestTemplate(); 
		System.out.println(System.currentTimeMillis());
		for(int i =0;i<10000;i++){
		Quote quote = restTemplate.getForObject(
				 "http://localhost:8080/EmpMgt/getAllEmpDetails", Quote.class);}
		System.out.println(System.currentTimeMillis());
		
	}
	@Bean
	public CacheManager cacheManager(){
		ConcurrentMapCacheManager cm = new ConcurrentMapCacheManager("employee");
		return cm;
		
	}
	
}
