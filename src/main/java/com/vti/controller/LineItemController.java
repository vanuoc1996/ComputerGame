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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.LineItemCreatDTO;
import com.vti.dto.PersonCreatDTO;
import com.vti.entity.LineItem;
import com.vti.service.Interface.ILineItemService;

@RestController
@Component
@RequestMapping(value = "api/v1/lineitem")
@CrossOrigin(origins = "*")
@Validated
public class LineItemController {
	@Autowired
	ILineItemService lineItemService;
	
	@GetMapping
	public ResponseEntity<?> getAllLineItems() {
		List<LineItem> entity = lineItemService.getAllLineItems();
		return new ResponseEntity<List<LineItem>>(entity, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<?> createPerson(@RequestBody LineItemCreatDTO lineItemdto) {
//		lineItemService.creatLineItem(lineItemdto.toEntity());
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}
}
