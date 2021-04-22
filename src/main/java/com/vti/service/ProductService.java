package com.vti.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vti.entity.Products;
import com.vti.repository.IProductsRepository;
import com.vti.service.Interface.IProductService;

@Service
public class ProductService implements IProductService{
	@Autowired
	IProductsRepository productsRepository;

	@Override
	public List<Products> getAllProducts() {
		return productsRepository.findAll();
	}
	
	
}
