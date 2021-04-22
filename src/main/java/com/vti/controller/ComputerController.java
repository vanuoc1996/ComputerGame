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
import com.vti.entity.Computer;
import com.vti.service.Interface.IComputerService;

@RestController
@Component
@RequestMapping(value = "api/v1/computers")
@CrossOrigin(origins = "*")
@Validated
public class ComputerController {
	@Autowired
	IComputerService computerService;

	@GetMapping
	public ResponseEntity<?> getAllComputers() {
		List<Computer> entity = computerService.getAllComputers();
		return new ResponseEntity<List<Computer>>(entity, HttpStatus.OK);
	}
}
