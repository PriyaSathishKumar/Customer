package com.Customer;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.Customer.CustomerEntity")
@EnableJpaRepositories("com.Customer.CustomerRepository")
@EnableConfigurationProperties
public class CustomerMS {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(CustomerMS.class, args);
	}

}
