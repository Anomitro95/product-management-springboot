package com.appcraft.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.appcraft.dao.IProductRepository;
import com.appcraft.model.Products;

@Controller
public class ProductController {
	
	@Autowired
	IProductRepository productRepository;
	
	@RequestMapping(value="/addProduct", method= RequestMethod.POST)
	public String saveProduct(@RequestParam("productCode") String productCode,
							 @RequestParam("size") String size,@RequestParam("stock")String stock, ModelMap model) {
		Products product = new Products();
		product.setProductCode(productCode);
		product.setSize(size);
		product.setStock(stock);
		productRepository.save(product);
		//model.addAttribute("message", "Product added");
		return "index";
	}
	
	@RequestMapping(value="/productDetail")
	public String showProduct(ModelMap model) {
		List<Products> productList= productRepository.findAll();
		productList=productList.stream().distinct().collect(Collectors.toList());
		Set<String> productCodeList= new TreeSet<String>();
		for(Products product:productList) {
			productCodeList.add(product.getProductCode());
		}
		model.addAttribute("productCodeList", productCodeList);
		return "productDetail";
	}
	
	@RequestMapping(value="/size/{productCode}")
	public ModelAndView showSize(@PathVariable("productCode")String productCode, ModelMap model) {
		List<Products> productList=productRepository.findAllByCode(productCode);
		List<String> productSizeList= new ArrayList<String>();
		int flag=0;
		for(Products product: productList) {
			if(product.getStock().equals("1")) {
				flag=1;
				productSizeList.add(product.getSize());
			}
				
		}
		Map<String, Integer> frequencyMap = new HashMap<>();
	
		for (String s: productSizeList) {
			Integer count = frequencyMap.get(s);
			if (count == null) 
				count = 0;
			
			frequencyMap.put(s, count+1);
		}
		
		model.addAttribute("flag", flag);
		if(flag==0)
		model.addAttribute("message", "Product sold out");
			else
			model.put("myMap", frequencyMap);
		
		return new ModelAndView("productDetail", model);

	}
	
}
