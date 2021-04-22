package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vti.entity.Computer;

@Repository
public interface IComputerRepository extends JpaRepository<Computer, Integer> {

}
