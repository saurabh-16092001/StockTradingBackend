package com.project.stock_trading_company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.stock_trading_company.entity.Company;
import com.project.stock_trading_company.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	CompanyRepository companyRepo;

	public List<Company> getAllCompanies() {
		List<Company> companyListing = companyRepo.findAll();
		return companyListing;
	}
	
	public String insertCompany(@RequestBody Company company) {
		System.out.println("Received data : " + company);
		companyRepo.save(company);
		return "Record inserted successfully...";
	}
	
}
