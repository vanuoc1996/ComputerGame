package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.vti.entity.Person;

@Repository
public interface IUsersRepository extends JpaRepository<Person, Integer> {

}
