package com.project.stock_trading_user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.TypedQuery;

import com.project.stock_trading_user.entity.User;
import com.project.stock_trading_user.repository.UserRepository;
import com.project.stock_trading_user.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepo;
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping (path="/getUser/{id}")
	public Optional<User> getUser(@PathVariable int id){
		System.out.println("controller get");
		return userService.getUser(id);
	}
	
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getUserr")
	public String getUser1(){
		return userService.getUser1();
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping (path="/insertUser")
	public String insertUser (@RequestBody User userObj) {
		return userService.insertUser(userObj);
	}

	@CrossOrigin(origins="http://localhost:4200") //, exposedHeaders = {"Access-Control-Allow-Origin"}
	@PutMapping (path="/updateFund")
	public String updateFund (@RequestBody User user) {
		return userService.updateFund(user);
	}
	
	@CrossOrigin("http://localhost:4200")
	@PutMapping (path="/updateFundWithdraw")
	public String updateFundWithdraw (@RequestBody User user) {
		return userService.updateFundWithdraw(user);
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping (path="/getFund/{id}") 
	public int getFund(@PathVariable int id) {
		return userService.getFund(id);
	}
	
}
