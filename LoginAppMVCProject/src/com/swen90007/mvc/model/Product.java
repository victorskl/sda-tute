package com.swen90007.mvc.model;

public class Product {

    private String name;
    private String type;
    private int price;

    public Product(String name, String type, int price) {
	super();
	this.name = name;
	this.type = type;
	this.price = price;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public int getPrice() {
	return price;
    }

    public void setPrice(int price) {
	this.price = price;
    }

}
