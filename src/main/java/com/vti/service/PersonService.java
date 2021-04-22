package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.vti.entity.Person;
import com.vti.repository.IPersonRepository;
import com.vti.service.Interface.IPersonService;

@Service
@Component
public class PersonService implements IPersonService {
	@Autowired
	private IPersonRepository personRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<Person>  getAllUsers() {
		return personRepository.findAll();
	}

	@Override
	public void creatPerson(Person person) {
		person.setPassword(passwordEncoder.encode(person.getPassword()));
		personRepository.save(person);
	}

	@Override
	public Person findByUserName(String userName) {
		return personRepository.findByUserName(userName);
	}

	@Override
	public void resetPasswordByUerName(String userName) {
	Person person = personRepository.findByUserName(userName);
	person.setPassword(passwordEncoder.encode("123456"));
	personRepository.save(person);
	}

	@Override
	public void resetPasswordByUserId(int userId) {
		Person person = personRepository.findByUserId(userId);
		person.setPassword(passwordEncoder.encode("123456"));
		personRepository.save(person);
	}

	@Override
	public void updatePasswordByUserName(String userName, String oldPassword, String newPassword) {
		Person person = personRepository.findByUserName(userName);
		boolean resault = passwordEncoder.matches(oldPassword, person.getPassword());
		if (resault = true) {
			person.setPassword(passwordEncoder.encode(newPassword));
			personRepository.save(person);
		}
	}
}
