package com.sparknetworks.backend;

import static com.sparknetworks.backend.utils.Const.COMPONENT_SCAN_PATH;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(COMPONENT_SCAN_PATH)
public class SparknetworksFiltermatchesBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SparknetworksFiltermatchesBackendApplication.class, args);
	}

}
