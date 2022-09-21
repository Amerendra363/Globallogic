package com.globallogic.creditcardpayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient
public class CreditcardpaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditcardpaymentApplication.class, args);
	}

}
