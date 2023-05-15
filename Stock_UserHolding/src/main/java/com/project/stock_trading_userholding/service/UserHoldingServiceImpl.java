package com.project.stock_trading_userholding.service;


import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.stock_trading_userholding.entity.HoldingsId;
import com.project.stock_trading_userholding.entity.UserHoldings;
import com.project.stock_trading_userholding.repository.UserHoldingsRepository;

@Service
public class UserHoldingServiceImpl implements UserHoldingService {
	
	
	@Autowired
	UserHoldingsRepository userHoldingsRepo;

	public List<UserHoldings> getUserHoldings(@PathVariable int id) {
		List<UserHoldings> list = userHoldingsRepo.findAllByUserId(id);
		return list;
	}
	
	public String insertHoldings (@RequestBody UserHoldings holdingsObj) {
		System.out.println("Received data : " + holdingsObj);
		
		HoldingsId hid = new HoldingsId(holdingsObj.getUserId(), holdingsObj.getCompanyId());
		Optional<UserHoldings> obj = userHoldingsRepo.findById(hid);
		
		if(obj.isPresent()) {
			UserHoldings updatedHolding = obj.get();
			
			updatedHolding.setQuantity(updatedHolding.getQuantity() + holdingsObj.getQuantity());
			updatedHolding.setBuyPrice(holdingsObj.getBuyPrice());
			updatedHolding.setCurrentPrice(holdingsObj.getCurrentPrice());
			
			userHoldingsRepo.save(updatedHolding);
			return "Record Updated successfully...";
		}
		userHoldingsRepo.save(holdingsObj);
		return "Record inserted successfully...";
	}
	
	public String updateHoldings (@RequestBody UserHoldings holdingsObj) {
		System.out.println("Received data : " + holdingsObj);
		
		HoldingsId hid = new HoldingsId(holdingsObj.getUserId(), holdingsObj.getCompanyId());
		Optional<UserHoldings> obj = userHoldingsRepo.findById(hid);
		
		if(obj.isPresent()) {
			UserHoldings updatedHolding = obj.get();
			
			updatedHolding.setQuantity(updatedHolding.getQuantity() - holdingsObj.getQuantity());
			updatedHolding.setBuyPrice(holdingsObj.getBuyPrice());
			updatedHolding.setCurrentPrice(holdingsObj.getCurrentPrice());
			
			userHoldingsRepo.save(updatedHolding);
			return "Record Updated successfully...";
		}
		userHoldingsRepo.save(holdingsObj);
		return "Record inserted successfully...";
	}

	public int findCurrentValue(@PathVariable int id) {
		Optional<Integer> res = userHoldingsRepo.findTotalCurrentValueQuery(id);
		return res.isPresent() ? res.get() : 0;
	}
 
	public int findTotalInvestment(@PathVariable int id) {
		Optional<Integer> res = userHoldingsRepo.findTotalInvestmentQuery(id);
		return res.isPresent() ? res.get() : 0;
	}

	public int findProfitLoss(@PathVariable int id) {
		Optional<Integer> res = userHoldingsRepo.findProfitLossQuery(id);
		return res.isPresent() ? res.get() : 0;
	}

}
