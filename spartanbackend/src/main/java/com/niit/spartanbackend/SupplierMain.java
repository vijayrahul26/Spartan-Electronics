package com.niit.spartanbackend;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.config.DBConfig;
import com.niit.model.Supplier;
import com.niit.userdao.SupplierDAO;

public class SupplierMain 
{
	public void supplierOut()
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		Supplier supplier=new Supplier();
	    Scanner sc = new Scanner(System.in);
			
			System.out.println("Please select a category to do the manipulation");
			System.out.println("1.Add Suppliers /n 2.Delete Suppliers /n 3.Update Suppliers /n 4.View All Suppliers /n 5.View Suppliers by ID /n 6.View Suppliers by Name");
			
			int choice = sc.nextInt();
			
			switch(choice){
			case 1:
				System.out.println("Please enter the supplier details to enter");
				System.out.println("Supplier ID:");

				supplier.setSupplierId(sc.nextInt());
				
				System.out.println("Supplier Name:");

				supplier.setSupplierName(sc.next());
				
				System.out.println("Supplier Mobile Number:");

				supplier.setSupplierMobileNumber(sc.next());
				System.out.println("Supplier Address:");

				supplier.setSupplierAddress(sc.next());
				System.out.println("Supplier MailId:");

				supplier.setSupplierEmail(sc.next());
	
				boolean result1 = supplierDAO.addSupplier(supplier);
				if(result1 == true)
				{
					System.out.println("Details has been added successfully");
				}
				break;
			case 2:
				
				List<Supplier> supplierList1 = supplierDAO.findAllSuppliers();
				for(Supplier supplier1 : supplierList1)
				{
					System.out.print("| Id:"+supplier1.getSupplierId()+"|");
					System.out.print("Name:"+supplier1.getSupplierName()+"|");
					System.out.print("Mobile Number:"+supplier1.getSupplierMobileNumber()+"|");
					System.out.print("Address:"+supplier1.getSupplierAddress()+"|");
					System.out.print("Email:"+supplier1.getSupplierEmail()+"|");
					
					System.out.println("");

				}
				System.out.println("Please enter the supplier id to be deleted from the above table");
				int SupplierId = sc.nextInt();
				boolean result = supplierDAO.deleteSupplier(SupplierId);
				if(result == true)
				{
					System.out.println("The row has been successfuly deleted");
				}
				break;
			case 3:
				List<Supplier> supplierList2 = supplierDAO.findAllSuppliers();
				for(Supplier supplier2 : supplierList2)
				{
					System.out.print("| Id:"+supplier2.getSupplierId()+"|");
					System.out.print("Name:"+supplier2.getSupplierName()+"|");
					System.out.print("Mobile Number:"+supplier2.getSupplierMobileNumber()+"|");
					System.out.print("Address:"+supplier2.getSupplierAddress()+"|");
					System.out.print("Email:"+supplier2.getSupplierEmail()+"");
					
					System.out.println("");

				}
				System.out.println("Please enter the supplier id");
				supplier.setSupplierId(sc.nextInt());
				System.out.println("Please enter the supplier details for updation");
				
				System.out.println("SupplierName:");

				supplier.setSupplierName(sc.next());
				
				System.out.println("Supplier Mobile Number:");

				supplier.setSupplierMobileNumber(sc.next());
				System.out.println("Supplier Address:");

				supplier.setSupplierAddress(sc.next());
				System.out.println("Supplier Email:");

				supplier.setSupplierEmail(sc.next());
				
				boolean result2 = supplierDAO.updateSupplier(supplier);
				if(result2 == true)
				{
					System.out.println("Details has been updated successfully");
				}
				break;
				
			case 4:
				List<Supplier> supplierList = supplierDAO.findAllSuppliers();
				for(Supplier supplier3 : supplierList)
				{
					System.out.print("| Id:"+supplier3.getSupplierId()+"|");
					System.out.print("Name:"+supplier3.getSupplierName()+"|");
					System.out.print("Mobile Number:"+supplier3.getSupplierMobileNumber()+"|");
					System.out.print("Address:"+supplier3.getSupplierAddress()+"|");
					System.out.print("Email:"+supplier3.getSupplierEmail()+"");
					
					System.out.println("");
				}
				break;
				
			case 5:
				System.out.println("Please enter the supplier id to view supplier details");
				int supplierId3 = sc.nextInt();
				Supplier supplier4 = supplierDAO.findSupplierById(supplierId3);
				System.out.print("| Id:"+supplier4.getSupplierId()+"|");
				System.out.print("Name:"+supplier4.getSupplierName()+"|");
				System.out.print("Mobile Number:"+supplier4.getSupplierMobileNumber()+"|");
				System.out.print("Address:"+supplier4.getSupplierAddress()+"|");
				System.out.print("Email:"+supplier4.getSupplierEmail()+"");
				break;
			case 6:
				System.out.println("Please enter the supplier name to view supplier details");
				String SupplierName = sc.next();
				Supplier supplier5 = supplierDAO.findSupplierByName(SupplierName);
				System.out.print("| Id:"+supplier5.getSupplierId()+"|");
				System.out.print("Name:"+supplier5.getSupplierName()+"|");
				System.out.print("Mobile Number:"+supplier5.getSupplierMobileNumber()+"|");
				System.out.print("Address:"+supplier5.getSupplierAddress()+"|");
				System.out.print("MailId:"+supplier5.getSupplierEmail()+"");
               break;
				
		 default: System.out.println("Please enter a valid input");
				
			}
			
			
			
			context.close();
			sc.close();
			
		
	}
}
