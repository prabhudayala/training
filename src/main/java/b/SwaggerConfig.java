package b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Autowired
	StudentService studentService;
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
		.select().apis(RequestHandlerSelectors.basePackage("b"))
		.paths(PathSelectors.any()).build().apiInfo(metaData());
	}
	private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot REST API",
                "Spring Boot REST API for Online Store",
                "1.0",
                "Terms of service",
                new Contact("Prabhudayal Acharya", "https://springframework.guru/about/", "prabhudayal.acharya@mindtree.com"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;

    }
	@RestController @RequestMapping("/EmpMgt") 
	@Api(value="onlinestore", description="Operations pertaining to products in Online Store") 
	public class ProductController { 
		
	}
	
}