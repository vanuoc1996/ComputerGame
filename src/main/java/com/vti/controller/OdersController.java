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

import com.vti.dto.OrdersCreatDTO;
import com.vti.dto.PlayerCreatDTO;
import com.vti.entity.Orders;
import com.vti.service.Interface.IOrdersService;

@RestController
@Component
@RequestMapping(value = "api/v1/orders")
@CrossOrigin(origins = "*")
@Validated
public class OdersController {
	@Autowired
	IOrdersService oderService;

	@GetMapping
	public ResponseEntity<?> getAllOrders() {
		List<Orders> entity = oderService.getAllOrders();
		return new ResponseEntity<List<Orders>>(entity, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<?> createCustomer(@RequestBody OrdersCreatDTO ordersDTO) {
		oderService.creatOrder(ordersDTO);
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	@PutMapping(path = "/pay")
	public ResponseEntity<?> payForOrder(@RequestParam() int orderId) {
		oderService.payForOrder(orderId);
		return new ResponseEntity<String>("Pay successfully!", HttpStatus.OK);
	}

}
