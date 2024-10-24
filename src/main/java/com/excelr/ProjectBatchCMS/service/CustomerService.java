package com.excelr.ProjectBatchCMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.ProjectBatchCMS.entity.Customer;
import com.excelr.ProjectBatchCMS.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepo;
	
	public void addCustomer(Customer c1) {
		customerRepo.save(c1);
	}

}
