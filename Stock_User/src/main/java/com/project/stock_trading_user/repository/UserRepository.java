package com.project.stock_trading_user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.project.stock_trading_user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("select u.accountBalance from User u where u.id =:ID")
	public Optional<Integer> findUserFundQuery(@Param("ID")  int id);

}
 