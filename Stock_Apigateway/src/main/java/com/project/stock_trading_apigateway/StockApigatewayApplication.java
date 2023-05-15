package com.project.stock_trading_apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
public class StockApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockApigatewayApplication.class, args);
	}

}
