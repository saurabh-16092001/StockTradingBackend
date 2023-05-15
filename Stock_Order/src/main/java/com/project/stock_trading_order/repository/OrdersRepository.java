package com.project.stock_trading_order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.stock_trading_order.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{

	public List<Orders> findAllByUserId(int id);
	
}