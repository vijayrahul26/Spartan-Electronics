package com.niit.userdaoimpltest;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.config.DBConfig;
import com.niit.model.Supplier;
import com.niit.userdao.SupplierDAO;

import junit.framework.TestCase;

public class SupplierDAOImpltest extends TestCase 
{
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	
	public void testFindAllSuppliers() 
	{
		List<Supplier> supplierList=supplierDAO.findAllSuppliers();
		assertNotNull(supplierList);
	}

	public void testFindSupplierById() 
	{
		Supplier supplier1=supplierDAO.findSupplierById(1);
		assertNotNull(supplier1);
		int expectedId=1;
		int actualId=supplier1.getSupplierId();
		assertTrue(expectedId==actualId);
	}

	public void testFindSupplierByName()
	{
		Supplier supplier2=supplierDAO.findSupplierByName("vijay");
		assertNotNull(supplier2);
		String expectedName="vijay";
		String actualName=supplier2.getSupplierName();
		assertTrue(expectedName.equals(actualName));
	}

	public void testAddSupplier()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierId(282);
		supplier.setSupplierName("SRL");
		supplier.setSupplierAddress("Chennai");
		supplier.setSupplierMobileNumber("89754");
		supplier.setSupplierEmail("srt@gmail.com");
		assertEquals(true,supplierDAO.addSupplier(supplier));
	}

	public void testUpdateSupplier()
	{
		Supplier supplier3=supplierDAO.findSupplierById(281);
		supplier3.setSupplierMobileNumber("8903151688");
		supplierDAO.updateSupplier(supplier3);
		assertTrue(supplier3.getSupplierMobileNumber()=="8903151688");
	}

	public void testDeleteSupplier()
	{
		Supplier supplier4=supplierDAO.findSupplierById(3);
		assertEquals(true,supplierDAO.deleteSupplier(supplier4.getSupplierId()));
	}

}
