package com.vti.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vti.entity.Products;
import com.vti.service.Interface.IProductService;

@RestController
@Component
@RequestMapping(value = "api/v1/products")
@CrossOrigin(origins = "*")
@Validated
public class ProductController {
	@Autowired
	IProductService productService;

	@GetMapping
	public ResponseEntity<?> getAllProducts() {
		List<Products> entity = productService.getAllProducts();
		return new ResponseEntity<List<Products>>(entity, HttpStatus.OK);
	}
}
