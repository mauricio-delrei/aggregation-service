package com.uk.xyzassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.uk.xyzassessment.client")
public class BackendServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendServicesApplication.class, args);
	}

}
