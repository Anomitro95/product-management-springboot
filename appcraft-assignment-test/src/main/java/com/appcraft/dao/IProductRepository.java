package com.appcraft.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcraft.model.Products;

@Repository
public interface IProductRepository extends JpaRepository<Products, Integer>{
	
	
	public List<Products> findAllByCode(String productCode);

}
