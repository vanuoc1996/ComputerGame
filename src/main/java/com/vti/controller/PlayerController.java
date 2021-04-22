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
import com.vti.dto.PlayerCreatDTO;
import com.vti.entity.Player;
import com.vti.pageSetup.Paging;
import com.vti.pageSetup.Sorting;
import com.vti.service.Interface.IPlayerService;
import com.vti.view.FilterPlayer;
import com.vti.view.ViewPlayer;

@RestController
@Component
@RequestMapping(value = "api/v1/persons/players")
@CrossOrigin(origins = "*")
@Validated
public class PlayerController {
	@Autowired
	private IPlayerService playerService;

	@GetMapping
	public ResponseEntity<?> GetAllPlayers() {
		List<Player> entity = playerService.getAllPlayers();
		return new ResponseEntity<List<Player>>(entity, HttpStatus.OK);
	}

	@GetMapping(path = { "/detail" })
	public ResponseEntity<?> viewDetailPlayer(String name, FilterPlayer filter, Paging paging, Sorting sorting) {
		List<ViewPlayer> entity = playerService.viewDetailPlayer(name, filter, paging, sorting);
		return new ResponseEntity<List<ViewPlayer>>(entity, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createCustomer(@RequestBody PlayerCreatDTO player) {
		playerService.creatPlayer(player);
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<?> inputMoney(@RequestParam String name, @RequestParam int money) {
		playerService.inputMoney(name, money);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@PutMapping(value = "/updatePassword")
	public ResponseEntity<?> updatePasswordByUserName(@RequestParam String userName,@RequestParam String oldPassword,@RequestParam String newPassword) {
		playerService.updatePasswordByUserName(userName, oldPassword, newPassword);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}
}
