package com.project.stock_trading_company.controller;

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

import com.project.stock_trading_company.entity.Company;
import com.project.stock_trading_company.repository.CompanyRepository;
import com.project.stock_trading_company.service.CompanyService;



@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	CompanyRepository companyRepo;
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping (path="/getAllCompanies")
	public List<Company> getAllCompanies() {
		return companyService.getAllCompanies();
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping (path="/insertCompany")
	public String insertCompany(@RequestBody Company company) {
		return companyService.insertCompany(company);
	}

}
