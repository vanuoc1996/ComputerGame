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
import com.vti.entity.PlayTime;
import com.vti.service.Interface.IPlayTimeService;

@RestController
@Component
@RequestMapping(value = "api/v1/playtime")
@CrossOrigin(origins = "*")
@Validated
public class PlayTimeController {
	@Autowired
	IPlayTimeService playTimeService;
	
	@GetMapping
	public ResponseEntity<?> getAllPlayTime() {
		List<PlayTime> entity = playTimeService.getAllPlayTime();
		return new ResponseEntity<List<PlayTime>>(entity, HttpStatus.OK);
	}
}
