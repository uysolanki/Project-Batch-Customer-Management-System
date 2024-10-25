package com.excelr.ProjectBatchCMS.service;

import java.util.List;

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

	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	public Customer getSingleCustomer(int cno) {
		return customerRepo.findById(cno).get();
	}

	public void deleteSingleCustomer(int cno) {
		customerRepo.deleteById(cno);
		
	}

	public void updateCustomer(int cno, Customer newcust) {
		Customer dbcustomer=customerRepo.findById(cno).get();
		dbcustomer.setEmail(newcust.getEmail());
		dbcustomer.setFirstname(newcust.getFirstname());
		dbcustomer.setLastname(newcust.getLastname());
		dbcustomer.setPhone(newcust.getPhone());
		customerRepo.save(dbcustomer);
	}

}
