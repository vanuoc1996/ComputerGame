package com.vti.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.vti.entity.Person;

@Service
@Component
public interface IUserService {
	List<Person> getAllUsers();
}
