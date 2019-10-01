package com.niit.spartanbackend;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.config.DBConfig;
import com.niit.userdao.ProductDAO;

import com.niit.model.Product;

public class ProductMain {
	
	public void productOut()
	{
		System.out.println("Product");
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		  
	   
	    Product product= new Product();
		
	    
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please select a category to do the manipulation");
		System.out.println("1.Add Product /n 2.Delete Product /n 3.Update product /n 4.View All products/n 5.View products by ID /n 6.View products by Name");
		
		int choice = sc.nextInt();
		
		switch(choice){
		case 1:
			System.out.println("Please Enter the product details to enter");
		/*	System.out.println("Product ID:");

			product.setProductid(sc.nextInt());*/
			
			System.out.println("Product Name:");

		product.setProductName(sc.next());
			
			System.out.println("Product Description");

			product.setProductDescription(sc.next());
			System.out.println("Product Size");

			product.setProductSize(sc.nextInt());
			System.out.println("Product Quantity");

			product.setProductQuantity(sc.nextInt());
			System.out.println("Product cost");
			
			product.setProductPrice(sc.nextDouble());
			
			
			boolean result1 = productDAO.addProduct(product);
			if(result1 == true)
			{
				System.out.println("Details has been added successfully");
			}
			break;
		case 2:
			
			List<Product> productList1 = productDAO.findAllProduct();
			for(Product product1 : productList1)
			{
				System.out.print("|Product Id:"+product1.getId()+"|");
				System.out.print("Product Name:"+product1.getProductName()+"|");
				System.out.print("Product Description:"+product1.getProductDescription()+"|");
				System.out.print("Product Size:"+product1.getProductSize()+"|");
				System.out.print("Product Quantity:"+product1.getProductQuantity()+"");
				System.out.print("Product Cost:"+product1.getProductPrice()+"");
				
	

			}
			System.out.println("Please enter the ProductId to be deleted from the above Table");
			int ProductId = sc.nextInt();
			boolean result = productDAO.deleteProduct(ProductId);
			if(result == true)
			{
				System.out.println("The row has been successfuly deleted");
			}
			break;
		case 3:
			List<Product> productList2 = productDAO.findAllProduct();
			for(Product product2: productList2)
			{
				System.out.print("|Product Id:"+product2.getId()+"|");
				System.out.print("Product Name:"+product2.getProductName()+"|");
				System.out.print("Product Description:"+product2.getProductDescription()+"|");
				System.out.print("Product Size:"+product2.getProductSize()+"|");
				System.out.print("Product Quantity:"+product2.getProductQuantity()+"");
				System.out.print("Product Cost:"+product2.getProductPrice()+"");

			}
			System.out.println("Please Enter the productId");
			product.setId(sc.nextInt());
			System.out.println("Please Enter the product details for updation");
			
			System.out.println("ProductName:");

			product.setProductName(sc.next());
			
			System.out.println("Product Description:");

			product.setProductDescription(sc.next());
			System.out.println("Product Size:");

			product.setProductSize(sc.nextInt());
			System.out.println("Product Quantity:");

			product.setProductQuantity(sc.nextInt());
			System.out.println("Product Price");
		
			product.setProductPrice(sc.nextDouble());
			
			
			boolean result2 = productDAO.updateProduct(product);
			if(result2 == true)
			{
				System.out.println("Details has been updated successfully");
			}
			break;
			
		case 4:
			List<Product> productList = productDAO.findAllProduct();
			for(Product product3 : productList)
			{
				System.out.print("|Product Id:"+product3.getId()+"|");
				System.out.print("Product Name:"+product3.getProductName()+"|");
				System.out.print("Product Description:"+product3.getProductDescription()+"|");
				System.out.print("Product Size:"+product3.getProductSize()+"|");
				System.out.print("Product Quantity:"+product3.getProductQuantity()+"");
				System.out.print("Product Cost:"+product3.getProductPrice()+"");


			}
			break;
			
		case 5:
			System.out.println("Please enter the ProductId to view product Details");
			int ProductId3 = sc.nextInt();
			Product product4 = productDAO.findProductById(ProductId3);
			System.out.print("|Product Id:"+product4.getId()+"|");
			System.out.print("Product Name:"+product4.getProductName()+"|");
			System.out.print("Product Description:"+product4.getProductDescription()+"|");
			System.out.print("Product Size:"+product4.getProductSize()+"|");
			System.out.print("Product Quantity:"+product4.getProductQuantity()+"");
			System.out.print("Product Cost:"+product4.getProductPrice()+"");
			break;
		case 6:
			System.out.println("Please enter the ProductName to view Product Details");
			String ProductName = sc.next();
			Product product5 = productDAO.findProductByName(ProductName);
			System.out.print("|Product Id:"+product5.getId()+"|");
			System.out.print("Product Name:"+product5.getProductName()+"|");
			System.out.print("Product Description:"+product5.getProductDescription()+"|");
			System.out.print("Product Size:"+product5.getProductSize()+"|");
			System.out.print("Product Quantity:"+product5.getProductQuantity()+"");
			System.out.print("Product Cost:"+product5.getProductPrice()+"");
			break;
			
	 default: System.out.println("Please enter a valid input");
			
		}
		
		
		context.close();
		sc.close();
		
	}

}