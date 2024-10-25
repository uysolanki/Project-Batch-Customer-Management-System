package com.excelr.ProjectBatchCMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.excelr.ProjectBatchCMS.entity.Customer;
import com.excelr.ProjectBatchCMS.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/virat")  //localhost:8089r
	public String rcb()
	{
		return "welcome";
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
	
//	@RequestMapping("/getAllCustomers")  //localhost:8089/virat
//	public List<Customer> getAllCustomers()
//	{
//		Customer c1=new Customer();
//		c1.setCid(18);
//		c1.setEmail("virat@gmail.com");
//		c1.setFirstname("Virat");
//		c1.setGender("male");
//		c1.setLastname("Kohli");
//		c1.setPhone("9890111222");
//		
//		Customer c2=new Customer();
//		c2.setCid(45);
//		c2.setEmail("rohit@gmail.com");
//		c2.setFirstname("Rohit");
//		c2.setGender("male");
//		c2.setLastname("Sharma");
//		c2.setPhone("9890111333");
//		
//		Customer c3=new Customer();
//		c3.setCid(1);
//		c3.setEmail("rahul@gmail.com");
//		c3.setFirstname("Lokesh");
//		c3.setGender("male");
//		c3.setLastname("Rahul");
//		c3.setPhone("9890111444");
//		
//		List<Customer> customers=new ArrayList();
//		customers.add(c1);
//		customers.add(c2);
//		customers.add(c3);
//		
//		return customers;
//	}
	
	@RequestMapping("/addCustomer")
	public String addCustomer()
	{
		Customer c1=new Customer();
		c1.setEmail("rohit@gmail.com");
		c1.setFirstname("Rohit");
		c1.setGender("male");
		c1.setLastname("Sharma");
		c1.setPhone("9890111333");
		
		customerService.addCustomer(c1);
		return "Customer Added Successfully";
	}

	@PostMapping("/addCustomerDataFromFE")
	public String addCustomer(@ModelAttribute Customer cust)
	{
		customerService.addCustomer(cust);
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String getAllCustomers(Model model)
	{
		List<Customer> customers= customerService.getAllCustomers();
		model.addAttribute("customers", customers);
		return "customer-list";
	}
	
	@GetMapping("/getSingleCustomer/{custid}")
	public Customer getSingleCustomer(@PathVariable("custid") int cno)
	{
		return customerService.getSingleCustomer(cno);
	}
	
	@RequestMapping("/deleteSingleCustomer/{id}")
	public String deleteSingleCustomer(@PathVariable("id") int cno)
	{
		customerService.deleteSingleCustomer(cno);
		return "redirect:/home";
	}
	
	@PutMapping("/updateCustomer/{custid}")
	public String updateCustomer(@PathVariable("custid") int cno, @RequestBody Customer newcust)
	{
		customerService.updateCustomer(cno,newcust);
		return "Customer Record Updated";
	}
	
	
	@RequestMapping("/registerCustomer")
	public String registerCustomer(Model model)
	{
		Customer c=new Customer();
		model.addAttribute("cust", c);
		return "customer-form";
	}
}

/*
 Create - Insert - @PostMaping  done
 Read   - Select  - @GetMapping done 
 Update - update - @PutMapping  done
 Delete - delete - @DeleteMapping done
*/
