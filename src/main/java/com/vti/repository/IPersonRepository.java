package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vti.entity.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {
	Person findByUserName(String userName);
	
	Person findByUserId(int userId);
}
