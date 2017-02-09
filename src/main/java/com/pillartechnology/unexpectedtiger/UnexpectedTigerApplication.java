package com.pillartechnology.unexpectedtiger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
@SpringBootConfiguration
public class UnexpectedTigerApplication {

	public static void main(String[] args) {

		SpringApplication.run(UnexpectedTigerApplication.class, args);
	}
}
