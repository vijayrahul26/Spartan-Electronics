
package com.niit.userdao;

import java.util.List;

import com.niit.model.Supplier;

public interface SupplierDAO {

	public List<Supplier> findAllSuppliers();
	public Supplier findSupplierById(int SupplierId);
	public Supplier findSupplierByName(String SupplierName);
	public boolean addSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(int SupplierId);
	
}