package com.project.stock_trading_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins ="http://localhost:8989")
public class StockUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockUserApplication.class, args);
	}

}

