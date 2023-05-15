package com.project.stock_trading_userholding.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.TypedQuery;

import com.project.stock_trading_userholding.entity.HoldingsId;
import com.project.stock_trading_userholding.entity.UserHoldings;
import com.project.stock_trading_userholding.repository.UserHoldingsRepository;
import com.project.stock_trading_userholding.service.UserHoldingService;



@RestController
@RequestMapping("/holdings")
public class UserHoldingsController {
	
	@Autowired
	UserHoldingsRepository userHoldingsRepo;
	
	@Autowired
	UserHoldingService userHoldingService;
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping (path="/getUserHoldings/{id}")
	public List<UserHoldings> getUserHoldings(@PathVariable int id) {
		return userHoldingService.getUserHoldings(id);
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping (path="/insertHoldings")
	public String insertHoldings (@RequestBody UserHoldings holdingsObj) {
		return userHoldingService.insertHoldings(holdingsObj);
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping (path="/updateHoldings")
	public String updateHoldings (@RequestBody UserHoldings holdingsObj) {
		return userHoldingService.updateHoldings(holdingsObj);
	}

	@CrossOrigin("http://localhost:4200")
	@GetMapping (path="/findCurrentValue/{id}") 
	public int findCurrentValue(@PathVariable int id) {
		return userHoldingService.findCurrentValue(id);
	}

	@CrossOrigin("http://localhost:4200")
	@GetMapping (path="/findTotalInvestment/{id}") 
	public int findTotalInvestment(@PathVariable int id) {
		return userHoldingService.findTotalInvestment(id);
	}

	@CrossOrigin("http://localhost:4200")
	@GetMapping (path="/findProfitLoss/{id}") 
	public int findProfitLoss(@PathVariable int id) {
		return userHoldingService.findProfitLoss(id);
	}

}
