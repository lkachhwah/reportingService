package com.mybank.reportingservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.mybank.reportingservice.db.mapper")
@Slf4j
@EnableSwagger2
public class ReportingserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportingserviceApplication.class, args);
		log.info("**********Started application***********");
	}

	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.mybank.reportingservice")).build();
	   }
}
