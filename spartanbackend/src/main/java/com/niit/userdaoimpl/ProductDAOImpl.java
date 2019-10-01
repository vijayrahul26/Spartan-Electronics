package com.niit.userdaoimpl;
import java.sql.Connection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.userdao.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
//	Connection con;
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addProduct(Product product) {
		
		sessionFactory.getCurrentSession().save(product);
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> findAllProduct() {
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
		
	}

	public Product findProductById(int ProductId) {
		return (Product)sessionFactory.getCurrentSession().createQuery("from Product where Id="+ProductId).uniqueResult();
	}

	public Product findProductByName(String ProductName) {
		return (Product)sessionFactory.getCurrentSession().createQuery("from Product where ProductName='"+ProductName+"'").uniqueResult();
	}
	public Product getProduct(int id) {
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product)session.get(Product.class, id);
		//session.get(Product.class,id) -> select * from product where id=?
		return product;
	}

	public boolean updateProduct(Product product) {
		sessionFactory.getCurrentSession().update(product);
		return true;
	}

	public boolean deleteProduct(int ProductId) {
		sessionFactory.getCurrentSession().delete(findProductById(ProductId));	
		return true;
	}

	public List<Category> findAllCategory() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}



}

