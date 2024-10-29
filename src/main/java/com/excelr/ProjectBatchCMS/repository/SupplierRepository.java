package com.excelr.ProjectBatchCMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.ProjectBatchCMS.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer>
{

}
