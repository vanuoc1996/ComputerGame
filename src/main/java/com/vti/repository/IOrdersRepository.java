package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vti.entity.Orders;

@Repository
public interface IOrdersRepository extends JpaRepository<Orders, Integer> {

}
