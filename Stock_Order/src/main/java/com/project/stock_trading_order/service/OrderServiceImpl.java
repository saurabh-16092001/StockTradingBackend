package com.project.stock_trading_order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.stock_trading_order.entity.Orders;
import com.project.stock_trading_order.repository.OrdersRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrdersRepository ordersRepo;
	
	public List<Orders> getOrders(@PathVariable int id) {
		List<Orders> list = ordersRepo.findAllByUserId(id);
		return list;
	}

	public String insertOrder (@RequestBody Orders ordersObj) {
		System.out.println("Received data : " + ordersObj);
		ordersRepo.save(ordersObj);
		return "Record inserted successfully...";
	}

}
