package com.project.stock_trading_user.service;

import java.util.Optional;

import com.project.stock_trading_user.entity.User;

public interface UserService {
	
	public Optional<User> getUser(int id);
	public String getUser1();
	public String insertUser (User userObj);
	public String updateFund (User user);
	public String updateFundWithdraw (User user);
	public int getFund(int id);
}
