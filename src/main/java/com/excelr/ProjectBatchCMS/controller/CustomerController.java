package com.excelr.ProjectBatchCMS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.ProjectBatchCMS.entity.Customer;
import com.excelr.ProjectBatchCMS.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/virat")  //localhost:8089r
	public String rcb()
	{
		return "Welcome to RCB Fan Page";
	}
	
	@RequestMapping("/dhoni")  //localhost:8089/virat
	public String csk()
	{
		return "Welcome to CSK Fan Page";
	}
	
	@RequestMapping("/")  //localhost:8089/virat
	public String ipl()
	{
		return "Welcome to IPL";
	}
	
	@RequestMapping("/getCustomer")  //localhost:8089/virat
	public Customer getCustomer()
	{
		Customer c1=new Customer();
		c1.setCid(18);
		c1.setEmail("virat@gmail.com");
		c1.setFirstname("Virat");
		c1.setGender("male");
		c1.setLastname("Kohli");
		c1.setPhone("9890111222");
		return c1;
	}
	
	@RequestMapping("/getAllCustomers")  //localhost:8089/virat
	public List<Customer> getAllCustomers()
	{
		Customer c1=new Customer();
		c1.setCid(18);
		c1.setEmail("virat@gmail.com");
		c1.setFirstname("Virat");
		c1.setGender("male");
		c1.setLastname("Kohli");
		c1.setPhone("9890111222");
		
		Customer c2=new Customer();
		c2.setCid(45);
		c2.setEmail("rohit@gmail.com");
		c2.setFirstname("Rohit");
		c2.setGender("male");
		c2.setLastname("Sharma");
		c2.setPhone("9890111333");
		
		Customer c3=new Customer();
		c3.setCid(1);
		c3.setEmail("rahul@gmail.com");
		c3.setFirstname("Lokesh");
		c3.setGender("male");
		c3.setLastname("Rahul");
		c3.setPhone("9890111444");
		
		List<Customer> customers=new ArrayList();
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		
		return customers;
	}
	
	@RequestMapping("/addCustomer")
	public String addCustomer()
	{
		Customer c1=new Customer();
		c1.setCid(18);
		c1.setEmail("virat@gmail.com");
		c1.setFirstname("Virat");
		c1.setGender("male");
		c1.setLastname("Kohli");
		c1.setPhone("9890111222");
		
		customerService.addCustomer(c1);
		return "Customer Added Successfully";
	}

}
