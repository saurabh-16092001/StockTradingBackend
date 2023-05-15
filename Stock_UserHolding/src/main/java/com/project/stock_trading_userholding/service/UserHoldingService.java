package com.project.stock_trading_userholding.service;

import java.util.List;

import com.project.stock_trading_userholding.entity.UserHoldings;

public interface UserHoldingService {
	
	public List<UserHoldings> getUserHoldings(int id);
	public String insertHoldings (UserHoldings holdingsObj);
	public String updateHoldings (UserHoldings holdingsObj);
	public int findCurrentValue(int id);
	public int findTotalInvestment(int id);
	public int findProfitLoss(int id);

}
