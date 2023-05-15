package com.project.stock_trading_userholding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.stock_trading_userholding.entity.UserHoldings;
import com.project.stock_trading_userholding.entity.HoldingsId;

import java.util.*;

public interface UserHoldingsRepository extends JpaRepository<UserHoldings, HoldingsId> {

	public List<UserHoldings> findAllByUserId(int id);
	
	@Query("select sum(u.currentPrice * u.quantity ) from UserHoldings u where u.userId =:ID")
	public Optional<Integer> findTotalCurrentValueQuery(@Param("ID")  int id);
	
	@Query("select sum(u.buyPrice * u.quantity ) from UserHoldings u where u.userId =:ID")
	public Optional<Integer> findTotalInvestmentQuery(@Param("ID")  int id);
	
	@Query("select sum((u.currentPrice - u.buyPrice) * u.quantity ) from UserHoldings u where u.userId =:ID")
	public Optional<Integer> findProfitLossQuery(@Param("ID")  int id);
	
	@Query("update UserHoldings u SET u.quantity =:qty + u.quantity, u.buyPrice =:price + u.buyPrice where u.userId =:ID and u.companyId =:CID")
	public int updateUserHoldingsQuery(@Param("qty") int quantity, @Param("price") int price, @Param("ID")  int id, @Param("CID") int cid);
}