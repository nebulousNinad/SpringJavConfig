package com.journaldev.spring.service;

import java.util.List;

import org.json.JSONException;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.model.Product;

public interface ProductService {

	
	public List<Product> listProducts() throws JSONException;
}
