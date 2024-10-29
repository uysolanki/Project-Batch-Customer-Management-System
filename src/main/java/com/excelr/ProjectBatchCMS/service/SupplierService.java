package com.excelr.ProjectBatchCMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.ProjectBatchCMS.entity.Customer;
import com.excelr.ProjectBatchCMS.entity.Supplier;
import com.excelr.ProjectBatchCMS.repository.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	SupplierRepository supplierRepo;
	
	public void addSupplier(Supplier supplier) {
		supplierRepo.save(supplier);
		
	}

	public List<Supplier> getAllSuppliers() {
		return supplierRepo.findAll();
	}

	public Supplier getSingleSupplier(int sno) {
		return supplierRepo.findById(sno).get();
	}

	public void updateSupplier(int sno, Supplier supplier) {
		Supplier dbsupplier=supplierRepo.findById(sno).get();
		dbsupplier.setAddress(supplier.getAddress());
		dbsupplier.setCompanyname(supplier.getCompanyname());
		dbsupplier.setSuppliercontact(supplier.getSuppliercontact());
		dbsupplier.setSupplieremail(supplier.getSupplieremail());
		supplierRepo.save(dbsupplier);
		
	}

	public void deleteSingleSupplier(int sno) {
		supplierRepo.deleteById(sno);
	}

}
