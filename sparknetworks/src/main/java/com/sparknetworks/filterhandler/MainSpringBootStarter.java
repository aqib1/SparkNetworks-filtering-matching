package com.sparknetworks.filterhandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MainSpringBootStarter {

	public static void main(String[] args) {
		  SpringApplication.run(MainSpringBootStarter.class, args);
	}

}
