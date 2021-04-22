package com.vti.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vti.dto.PersonCreatDTO;
import com.vti.entity.Person;
import com.vti.service.Interface.IPersonService;

@RestController
@Component
@RequestMapping(value = "api/v1/persons")
@CrossOrigin(origins = "*")
@Validated
public class PersonController {
	@Autowired
	private IPersonService personService;

	@GetMapping
	public ResponseEntity<?> GetAllPerson() {
		List<Person> entity = personService.getAllUsers();
		return new ResponseEntity<List<Person>>(entity, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createPerson(@RequestBody PersonCreatDTO personDTO) {
		personService.creatPerson(personDTO.toEntity());
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<?> resetPasswordByUerName(@RequestParam String userName) {
		personService.resetPasswordByUerName(userName);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> resetPasswordByUserId(@RequestParam int userId) {
		personService.resetPasswordByUserId(userId);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}
}
