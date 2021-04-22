package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.LineItem;

@Repository
public interface ILineItemRepository extends JpaRepository<LineItem, Integer>{

}
