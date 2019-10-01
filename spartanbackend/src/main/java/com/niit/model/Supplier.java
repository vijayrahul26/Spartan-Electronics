package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Supplier
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int supplierId;
	String supplierName;
	String supplierMobileNumber;
	String supplierAddress;
	String supplierEmail;
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierMobileNumber() {
		return supplierMobileNumber;
	}
	public void setSupplierMobileNumber(String supplierMobileNumber) {
		this.supplierMobileNumber = supplierMobileNumber;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public String getSupplierEmail() {
		return supplierEmail;
	}
	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}
}
	