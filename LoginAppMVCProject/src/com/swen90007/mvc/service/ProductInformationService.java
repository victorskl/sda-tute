package com.swen90007.mvc.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.swen90007.mvc.model.Product;

public class ProductInformationService {
    
    private List<Product> productList = new ArrayList<>();
    
    public ProductInformationService() {
	productList.add(new Product("Samsung OLED", "TV", 2000));
	productList.add(new Product("Samsung Curve", "TV", 3000));
	productList.add(new Product("Sony Brivia", "TV", 2000));
	productList.add(new Product("LG OLED", "TV", 1500));
	productList.add(new Product("LG 55x5", "Camera", 500));
	productList.add(new Product("Sony Powershot 5E", "Camera", 1200));
	productList.add(new Product("Samsung T553", "Camera", 200));
	productList.add(new Product("Cannon G55", "Camera", 1800));
	productList.add(new Product("Nikon D80", "Camera", 1800));
    }
    
    public List<String> getProductTypes() {
	return Arrays.asList("TV", "Camera");
    }
    
    public List<Product> getProductListByType(String type) {
	return productList.stream()
		.filter(p -> p.getType().contentEquals(type))
		.collect(Collectors.toList());
    }
    
    public Product getProduct(String productName) {
	return productList.stream()
		.filter(p -> p.getName().contentEquals(productName))
		.findAny()
		.orElse(null);
    }
}
