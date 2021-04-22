package com.vti.service.Interface;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.vti.entity.Products;
	
@Service
@Component
public interface IProductService {
	List<Products> getAllProducts();
}
