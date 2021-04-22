package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.Products;
@Repository
public interface IProductsRepository extends JpaRepository<Products, Integer>{

}
