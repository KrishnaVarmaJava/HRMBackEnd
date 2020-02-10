package com.myHRM.HRMtool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class HrMtoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrMtoolApplication.class, args);
	}
}
