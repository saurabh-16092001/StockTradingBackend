package com.project.stock_trading_company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.stock_trading_company.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{

}