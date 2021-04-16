package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.vti.entity.Person;
import com.vti.repository.IUsersRepository;

@Service
@Component
public class UsersService implements IUserService {
	@Autowired
	private IUsersRepository repository;

	@Override
	public List<Person>  getAllUsers() {
		return repository.findAll();
	}

}
