package com.project.stock_trading_company.service;

import java.util.List;
import com.project.stock_trading_company.entity.Company;

public interface CompanyService {
	
	public List<Company> getAllCompanies();
	public String insertCompany(Company company);

}
