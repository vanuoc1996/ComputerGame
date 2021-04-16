package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Person;
import com.vti.service.IUserService;

@RestController
@Component
@RequestMapping(value = "api/v1/person")
@CrossOrigin(origins = "*")
@Validated
public class UsersController {
	@Autowired
	private IUserService userService;
	
	@GetMapping
	public ResponseEntity<?> GetAllPerson(){
		List<Person> entity = userService.getAllUsers();
		return new ResponseEntity<List<Person>>(entity, HttpStatus.OK);
	}

}
