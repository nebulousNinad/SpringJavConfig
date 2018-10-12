package com.journaldev.spring.service;

import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.PersonDAO;
import com.journaldev.spring.dao.ProductDAO;
import com.journaldev.spring.model.Person;
import com.journaldev.spring.model.Product;



@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productDAO;
	
	
	

	@Override
	@Transactional
	public List<Product> listProducts() throws JSONException {
		return this.productDAO.listProducts();
	}

}
