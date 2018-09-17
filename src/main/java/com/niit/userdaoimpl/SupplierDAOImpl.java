package com.niit.userdaoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.model.Supplier;
import com.niit.userdao.SupplierDAO;
@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO
{
	@Autowired
	SessionFactory sessionFactory;

	public List<Supplier> findAllSuppliers() {
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	public Supplier findSupplierById(int SupplierId) {
		return (Supplier)sessionFactory.getCurrentSession().createQuery("from Supplier where SupplierId="+SupplierId).uniqueResult();
	}

	public Supplier findSupplierByName(String SupplierName) {
		return (Supplier)sessionFactory.getCurrentSession().createQuery("from Supplier where SupplierName='"+SupplierName+"'").uniqueResult();
	}

	public boolean addSupplier(Supplier supplier) {
		sessionFactory.getCurrentSession().save(supplier);
		return true;
	}

	public boolean updateSupplier(Supplier supplier) {
		sessionFactory.getCurrentSession().update(supplier);
		return true;
	}

	public boolean deleteSupplier(int supplierId) {
		sessionFactory.getCurrentSession().delete(findSupplierById(supplierId));
		return true;
	}

}



