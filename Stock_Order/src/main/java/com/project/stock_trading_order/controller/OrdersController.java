package com.project.stock_trading_order.controller;

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

import com.project.stock_trading_order.entity.Orders;
import com.project.stock_trading_order.repository.OrdersRepository;
import com.project.stock_trading_order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrdersController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrdersRepository ordersRepo;
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping (path="/getOrders/{id}")
	public List<Orders> getOrders(@PathVariable int id) {
		return orderService.getOrders(id);
	}

	@CrossOrigin("http://localhost:4200")
	@PostMapping (path="/insertOrder")
	public String insertOrder (@RequestBody Orders ordersObj) {
		return orderService.insertOrder(ordersObj);
	}

}
