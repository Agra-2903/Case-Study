package com.hotel.staffinventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StaffinventoryserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffinventoryserviceApplication.class, args);
	}

}
