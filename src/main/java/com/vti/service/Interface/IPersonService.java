package com.vti.service.Interface;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.vti.entity.Person;

@Service
@Component
public interface IPersonService {
	List<Person> getAllUsers();

	void creatPerson(Person person);
	
	Person findByUserName(String userName);
	
	void resetPasswordByUerName(String userName);
	
	void resetPasswordByUserId(int userId);
	
	void updatePasswordByUserName(String userName, String oldPassword, String newPassword);
}
