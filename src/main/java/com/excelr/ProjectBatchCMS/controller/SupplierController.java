package com.excelr.ProjectBatchCMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.excelr.ProjectBatchCMS.entity.Customer;
import com.excelr.ProjectBatchCMS.entity.Supplier;
import com.excelr.ProjectBatchCMS.service.SupplierService;

@Controller
public class SupplierController {
	
	@Autowired
	SupplierService supplierService;
	
	@RequestMapping("/registerSupplier")
	public String registerSupplier(Model model)
	{
		Supplier s=new Supplier();
		model.addAttribute("supplier", s);
		return "supplier-form";
	}
	
	@PostMapping("/addSupplierDataFromFE")
	public String addSupplier(@ModelAttribute Supplier supplier)
	{
		supplierService.addSupplier(supplier);
		return "redirect:/suppliers";
	}
	
	@RequestMapping("/suppliers")
	public String getAllCustomers(Model model)
	{
		List<Supplier> suppliers= supplierService.getAllSuppliers();
		model.addAttribute("suppliers", suppliers);
		return "supplier-list";
	}
	
	
	@RequestMapping("/updatesupplierform/{id}")
	public String updateSupplierForm(@PathVariable("id") int sno, Model model)
	{
		Supplier supplier=supplierService.getSingleSupplier(sno);
		model.addAttribute("supplier", supplier);
		return "supplier-update-form";
	}
	
	@PostMapping("/updatesupplier/{id}")
	public String updateSupplier(@PathVariable("id") int sno,@ModelAttribute Supplier supplier)
	{
		supplierService.updateSupplier(sno,supplier);
		return "redirect:/suppliers";
	}

	@RequestMapping("/deleteSingleSupplier/{id}")
	public String deleteSingleSupplier(@PathVariable("id") int sno)
	{
		supplierService.deleteSingleSupplier(sno);
		return "redirect:/suppliers";
	}
}
