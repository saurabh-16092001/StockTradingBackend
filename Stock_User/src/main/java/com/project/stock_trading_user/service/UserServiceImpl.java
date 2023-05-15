package com.project.stock_trading_user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.stock_trading_user.entity.User;
import com.project.stock_trading_user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public Optional<User> getUser(@PathVariable int id){
		System.out.println("service get");
		return userRepo.findById(id);
	}
	
	@Override
	public String getUser1(){
		return "yyes";
	}
	
	public String insertUser (@RequestBody User userObj) {
		System.out.println("Received data : " + userObj);
		userRepo.save(userObj);
		return "Record inserted successfully...";
	}
	
	public String updateFund (@RequestBody User user) {
		System.out.println("Received data : " + user);
		
		Optional<User> obj = userRepo.findById(user.getId());
		
		if(obj.isPresent()) {
			User updatedUser = obj.get();
			
			updatedUser.setAccountBalance(updatedUser.getAccountBalance() + user.getAccountBalance());
			
			userRepo.save(updatedUser);
			return "Record Updated successfully...";
		}
		return "User not found!!!";
	}
	
	
	public String updateFundWithdraw (@RequestBody User user) {
		System.out.println("Received data : " + user);
		
		Optional<User> obj = userRepo.findById(user.getId());
		
		if(obj.isPresent()) {
			User updatedUser = obj.get();
			
			updatedUser.setAccountBalance(updatedUser.getAccountBalance() - user.getAccountBalance());
			
			userRepo.save(updatedUser);
			return "Record Updated successfully...";
		}
		return "User not found!!!";
	}
	
	
	public int getFund(@PathVariable int id) {
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
		System.out.println(userRepo.findUserFundQuery(id));
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
		Optional<Integer> res = userRepo.findUserFundQuery(id);
		return res.isPresent() ? res.get() : 0;
	}

}

