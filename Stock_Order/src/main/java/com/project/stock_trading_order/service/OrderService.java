package com.project.stock_trading_order.service;

import java.util.List;
import com.project.stock_trading_order.entity.Orders;

public interface OrderService {
	
	public List<Orders> getOrders(int id);
	public String insertOrder (Orders ordersObj);

}
