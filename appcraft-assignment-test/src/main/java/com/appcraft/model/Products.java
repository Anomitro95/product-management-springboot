package com.appcraft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name ="product")
@Component
public class Products {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	
	@Column(name="Product_Code")
	private String code;
	
	@Column(name="Size")
	private String size;
	
	@Column(name="Stock")
	private String stock;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductCode() {
		return code;
	}
	public void setProductCode(String productCode) {
		this.code = productCode;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", productCode=" + code + ", size=" + size + ", stock=" + stock + "]";
	}
	

}
